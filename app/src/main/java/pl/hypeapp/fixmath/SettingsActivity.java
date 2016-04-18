package pl.hypeapp.fixmath;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.example.games.basegameutils.BaseGameActivity;
import com.google.example.games.basegameutils.BaseGameUtils;


public class SettingsActivity extends BaseGameActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener{

    private boolean signStatusGoogleGames;
    private GoogleApiClient mGoogleApi;

    private static int RC_SIGN_IN = 9002;

    private boolean mResolvingConnectionFailure = false;
    private boolean mAutoStartSignInFlow = true;
    private boolean mSignInClicked = false;
    TextView LogInText;
    Switch toggle;
    SFXManager sfxManager;
    MyProgress myProgress;
    ImageUtil imageUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ImageView background = (ImageView) findViewById(R.id.setting_background_image);
        imageUtil = (ImageUtil)getApplication();
        imageUtil.setImageFirst(background, R.drawable.time_attack_background_normal);

        mGoogleApi = getApiClient();
        mGoogleApi.registerConnectionCallbacks(this);
        mGoogleApi.registerConnectionFailedListener(this);
        getGameHelper().setConnectOnStart(false);



        SharedPreferences sharedPref = getSharedPreferences("LOGGING", MODE_PRIVATE);
        this.signStatusGoogleGames = sharedPref.getBoolean("SIGN_STATUS", true);

        LogInText = (TextView) findViewById(R.id.signInText);

        if(signStatusGoogleGames) {
            LogInText.setText("GOOGLE PLAY GAMES LOG OUT");
        }else {
            LogInText.setText("GOOGLE PLAY GAMES LOG IN");
        }

        toggle = (Switch) findViewById(R.id.sounds);
        final SharedPreferences sharedPreferences = getSharedPreferences("SOUNDS", MODE_PRIVATE);
        Log.e("isCheck SP", " " + sharedPreferences.getBoolean("ISMUTE", false));
        if(!sharedPreferences.getBoolean("ISMUTE", false)){
            toggle.setChecked(true);
        }else{
            toggle.setChecked(false);
        }


        sfxManager = new SFXManager(this, sharedPreferences.getBoolean("ISMUTE", false));
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.e("isCheck1 out", " " + isChecked);
                if (isChecked) {
                    Log.e("isCheck 1in", " " + isChecked);
                    editor.putBoolean("ISMUTE", false);
                    editor.commit();


                } else {
                    Log.e("isCheck 2in", " " + isChecked);
                    editor.putBoolean("ISMUTE", true);
                    editor.commit();

                }
                Log.e("isCheck SP", " " + sharedPreferences.getBoolean("ISMUTE", false));
            }
        });
        myProgress = MyProgress.getInstance();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        imageUtil.unbindDrawables(findViewById(R.id.settings_layout));
        System.gc();
    }

    public void backToMenu(View view) {
        sfxManager.KeyboardClickPlay(true);
        Intent i = new Intent(SettingsActivity.this, MenuActivity.class);
        startActivity(i);
        finish();
    }

    public void signinGoogleGames(View view) {
        sfxManager.KeyboardClickPlay(true);
        if(signStatusGoogleGames){

            signOut();

            SharedPreferences scorePref = getSharedPreferences("LOGGING", MODE_PRIVATE);
            SharedPreferences.Editor editor = scorePref.edit();
            editor.putBoolean("SIGN_STATUS", false);
            signStatusGoogleGames = false;
            editor.commit();

            LogInText.setText("GOOGLE PLAY GAMES LOG IN");

        }else{
            mSignInClicked = true;
            mGoogleApi.connect();
        }
    }

    public void resetGame(View view){
        SharedPreferences prefs = getSharedPreferences("LVL", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.commit();
        sfxManager.KeyboardClickPlay(true);
    }



    @Override
    public void onConnected(Bundle bundle) {

        LogInText.setText("GOOGLE PLAY GAMES LOG OUT");

        SharedPreferences scorePref = getSharedPreferences("LOGGING", MODE_PRIVATE);
        SharedPreferences.Editor editor = scorePref.edit();
        editor.putBoolean("SIGN_STATUS", true);
        editor.commit();

        signStatusGoogleGames = true;
        myProgress.updateProgress(mGoogleApi, this);

    }

    @Override
    public void onConnectionSuspended(int i) {
        mGoogleApi.connect();
    }


    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        if (mResolvingConnectionFailure) {
            // Already resolving
            return;
        }

        // If the sign in button was clicked or if auto sign-in is enabled,
        // launch the sign-in flow
        if (mSignInClicked || mAutoStartSignInFlow) {
            mAutoStartSignInFlow = false;
            mSignInClicked = false;
            mResolvingConnectionFailure = true;

            // Attempt to resolve the connection failure using BaseGameUtils.
            // The R.string.signin_other_error value should reference a generic
            // error string in your strings.xml file, such as "There was
            // an issue with sign in, please try again later."
            if (!BaseGameUtils.resolveConnectionFailure(this,
                    mGoogleApi, connectionResult,
                    RC_SIGN_IN, getString(R.string.signin_other_error))) {
                mResolvingConnectionFailure = false;
            }
        }

        Log.e("GoogleApi", "onConnectionFailed");
    }

    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent intent) {
        if (requestCode == RC_SIGN_IN) {
            mSignInClicked = false;
            mResolvingConnectionFailure = false;
            if (resultCode == RESULT_OK) {
                mGoogleApi.connect();
            } else {
                // Bring up an error dialog to alert the user that sign-in
                // failed. The R.string.signin_failure should reference an error
                // string in your strings.xml file that tells the user they
                // could not be signed in, such as "Unable to sign in."
                BaseGameUtils.showActivityResultError(this,
                        requestCode, resultCode, R.string.signin_failure);

                SharedPreferences scorePref = getSharedPreferences("LOGGING", MODE_PRIVATE);
                SharedPreferences.Editor editor = scorePref.edit();
                editor.putBoolean("SIGN_STATUS", false);
                editor.commit();

                Log.e("GoogleApi", "onActivityResult");
            }
        }

        Log.e("googleApi", "onActvityResult2");
    }


    @Override
    protected void onStop() {
        super.onStop();
        mGoogleApi.disconnect();
        Log.e("googleApi", "onStop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(signStatusGoogleGames){
            mGoogleApi.connect();
        }
    }

    @Override
    public void onSignInFailed() {

    }

    @Override
    public void onSignInSucceeded() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(SettingsActivity.this, MenuActivity.class);
        startActivity(i);
        finish();
    }

    public void setOnCheckedChangeListener(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("SOUNDS", MODE_PRIVATE);
        sfxManager = new SFXManager(this, sharedPreferences.getBoolean("ISMUTE", false));
    }
}
