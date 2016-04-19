package pl.hypeapp.fixmath;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.example.games.basegameutils.BaseGameActivity;
import com.google.example.games.basegameutils.BaseGameUtils;

public class ChooseTimeChallenge extends BaseGameActivity implements GoogleApiClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks{
    private final int
            ONE_MINUTE = 60,
            THREE_MINUTES = 180,
            FIVE_MINTUES = 300;

    private static int RC_SIGN_IN = 9001;

    private boolean mResolvingConnectionFailure = false;
    private boolean mAutoStartSignInFlow = true;
    private boolean mSignInClicked = false;
    private boolean mExplicitSignOut;
    public GoogleApiClient mGoogleApiClient;
    SFXManager sfxManager;

    ImageUtil imageUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_time_challenge);

        ImageView background = (ImageView)findViewById(R.id.choose_time_background_image);
        imageUtil = (ImageUtil)getApplication();
        imageUtil.setImageFirst(background, R.drawable.level_background);

        SharedPreferences scorePref = getSharedPreferences("SCORE", MODE_PRIVATE);


        TextView oneMinuteBestScore = (TextView) findViewById(R.id.score1);
        TextView threeMinuteBestScore = (TextView) findViewById(R.id.score3);
        TextView fiveMinuteBestScore = (TextView) findViewById(R.id.score5);

        oneMinuteBestScore.setText(scorePref.getString("BEST_SCORE_STRING" + ONE_MINUTE, "0"));
        threeMinuteBestScore.setText(scorePref.getString("BEST_SCORE_STRING" + THREE_MINUTES, "0"));
        fiveMinuteBestScore.setText(scorePref.getString("BEST_SCORE_STRING" + FIVE_MINTUES, "0"));

        getGameHelper().setConnectOnStart(false);
        mGoogleApiClient = getApiClient();
        mGoogleApiClient.registerConnectionCallbacks(this);
        mGoogleApiClient.registerConnectionFailedListener(this);

        SharedPreferences soundsPref = getSharedPreferences("SOUNDS", MODE_PRIVATE);
        sfxManager = new SFXManager(this, soundsPref.getBoolean("ISMUTE", false));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        imageUtil.unbindDrawables(findViewById(R.id.choose_time_layout));
        System.gc();
    }


    public void backToMenu(View view){
        Intent i = new Intent(ChooseTimeChallenge.this, MenuActivity.class);
        startActivity(i);
        sfxManager.KeyboardClickPlay(true);
        finish();
    }

    public void FiveMinChallenge(View view) {
        Intent i = new Intent(ChooseTimeChallenge.this, TimeAttackActivity.class);
        i.putExtra("challenge", FIVE_MINTUES);
        sfxManager.SameLineFigureClickPlay();
        startActivity(i);
        finish();
    }

    public void ThreeMinChallenge(View view) {
        Intent i = new Intent(ChooseTimeChallenge.this, TimeAttackActivity.class);
        i.putExtra("challenge", THREE_MINUTES);
        sfxManager.SameLineFigureClickPlay();
        startActivity(i);
        finish();
    }

    public void OneMinChallenge(View view) {
        Intent i = new Intent(ChooseTimeChallenge.this, TimeAttackActivity.class);
        i.putExtra("challenge", ONE_MINUTE);
        sfxManager.SameLineFigureClickPlay();
        startActivity(i);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(ChooseTimeChallenge.this, MenuActivity.class);
        startActivity(i);
        finish();
    }

    public void openLeaderboard(View view) {
        sfxManager.KeyboardClickPlay(true);
        SharedPreferences sharedPref = getSharedPreferences("LOGGING", MODE_PRIVATE);
        if(!sharedPref.getBoolean("SIGN_STATUS", true)) {
            mSignInClicked = true;
            mGoogleApiClient.connect();
        }else{
            mSignInClicked = true;
            mGoogleApiClient.connect();
            startActivityForResult(
            Games.Leaderboards.getAllLeaderboardsIntent(mGoogleApiClient), 1);
        }




    }

    @Override
    public void onSignInFailed() {

    }

    @Override
    public void onSignInSucceeded() {

    }

    @Override
    public void onConnected(Bundle bundle) {
        SharedPreferences scorePref = getSharedPreferences("LOGGING", MODE_PRIVATE);
        SharedPreferences.Editor editor = scorePref.edit();
        editor.putBoolean("SIGN_STATUS", true);
        editor.commit();
    }

    @Override
    public void onConnectionSuspended(int i) {
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPref = getSharedPreferences("LOGGING", MODE_PRIVATE);
        if(sharedPref.getBoolean("SIGN_STATUS", true)){
            mGoogleApiClient.connect();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mGoogleApiClient.disconnect();
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
                    mGoogleApiClient, connectionResult,
                    RC_SIGN_IN, getString(R.string.signin_other_error))) {
                mResolvingConnectionFailure = false;
            }
        }




    }

    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent intent) {
        if (requestCode == RC_SIGN_IN) {
            mSignInClicked = false;
            mResolvingConnectionFailure = false;
            if (resultCode == RESULT_OK) {
                mGoogleApiClient.connect();
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


            }
        }


    }
}
