package pl.hypeapp.fixmath;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.example.games.basegameutils.BaseGameUtils;



import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;



public class MenuActivity extends FragmentActivity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    ViewPager viewPager;

    private static int RC_SIGN_IN = 9001;

    private boolean mResolvingConnectionFailure = false;
    private boolean mAutoStartSignInFlow = true;
    private boolean mSignInClicked = false;
    private boolean mExplicitSignOut;
    public GoogleApiClient mGoogleApiClient;
    ImageView googlePlayBtn;

    static SFXManager sfxManager;
    private MyProgress myProgress;
    ImageUtil imageUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        imageUtil = (ImageUtil) getApplication();
        ImageView backgroundImage = (ImageView) findViewById(R.id.menu_background_image);
        imageUtil.setImageSecond(backgroundImage, R.drawable.menu_background);


        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(Games.API).addScope(Games.SCOPE_GAMES)
                .addApi(AppIndex.API).build();


        SharedPreferences sharedPref = getSharedPreferences("LOGGING", MODE_PRIVATE);
        mExplicitSignOut = sharedPref.getBoolean("SIGN_STATUS", true);

        googlePlayBtn = (ImageView) findViewById(R.id.sign_in_gp);
        if(mExplicitSignOut) {
            ImageView googlePlayBtn = (ImageView) findViewById(R.id.sign_in_gp);
            googlePlayBtn.setImageResource(R.drawable.play_button_loggin);
        }else{
            googlePlayBtn.setImageResource(R.drawable.play_button_to_loggin);
        }
        sharedPref = getSharedPreferences("SOUNDS", MODE_PRIVATE);

        sfxManager = new SFXManager(this, sharedPref.getBoolean("ISMUTE", false));

        ImageView v = (ImageView) findViewById(R.id.imageDot1);
        v.setImageResource(R.drawable.yellow_dot);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                manageDotToPage(position);
                manageTextAnimationToPage(position);
                sfxManager.NewLineFigureClickPlay();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setAdapter(pagerAdapter);

        myProgress = MyProgress.getInstance();


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


        googlePlayBtn.setVisibility(View.VISIBLE);

    }

    @Override
    public void onConnected(Bundle bundle) {

        googlePlayBtn.setImageResource(R.drawable.play_button_loggin);
        SharedPreferences scorePref = getSharedPreferences("LOGGING", MODE_PRIVATE);
        SharedPreferences.Editor editor = scorePref.edit();
        editor.putBoolean("SIGN_STATUS", true);
        editor.commit();
        myProgress.updateProgress(mGoogleApiClient, this);


    }

    @Override
    public void onConnectionSuspended(int i) {
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mExplicitSignOut) {
            mGoogleApiClient.connect();
            googlePlayBtn.setImageResource(R.drawable.play_button_loggin);
        } else {
            googlePlayBtn.setImageResource(R.drawable.play_button_to_loggin);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mGoogleApiClient.disconnect();

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



    void manageDotToPage(int actualPage){
        switch (actualPage) {
            case 0:
                ImageView v = (ImageView) findViewById(R.id.imageDot1);
                v.setImageResource(R.drawable.yellow_dot);
                YoYo.with(Techniques.Landing)
                        .duration(1000)
                        .playOn(v);
                v = (ImageView) findViewById(R.id.imageDot2);
                v.setImageResource(R.drawable.gray_dot);
                v = (ImageView) findViewById(R.id.imageDot3);
                v.setImageResource(R.drawable.gray_dot);
                v = (ImageView) findViewById(R.id.imageDot4);
                v.setImageResource(R.drawable.gray_dot);
                break;
            case 1:
                v = (ImageView) findViewById(R.id.imageDot1);
                v.setImageResource(R.drawable.gray_dot);
                v = (ImageView) findViewById(R.id.imageDot2);
                v.setImageResource(R.drawable.yellow_dot);
                YoYo.with(Techniques.Landing)
                        .duration(1000)
                        .playOn(v);
                v = (ImageView) findViewById(R.id.imageDot3);
                v.setImageResource(R.drawable.gray_dot);
                v = (ImageView) findViewById(R.id.imageDot4);
                v.setImageResource(R.drawable.gray_dot);
                break;
            case 2:
                v = (ImageView) findViewById(R.id.imageDot1);
                v.setImageResource(R.drawable.gray_dot);
                v = (ImageView) findViewById(R.id.imageDot2);
                v.setImageResource(R.drawable.gray_dot);
                v = (ImageView) findViewById(R.id.imageDot3);
                v.setImageResource(R.drawable.yellow_dot);
                YoYo.with(Techniques.Landing)
                        .duration(1000)
                        .playOn(v);
                v = (ImageView) findViewById(R.id.imageDot4);
                v.setImageResource(R.drawable.gray_dot);
                break;
            case 3:
                v = (ImageView) findViewById(R.id.imageDot1);
                v.setImageResource(R.drawable.gray_dot);
                v = (ImageView) findViewById(R.id.imageDot2);
                v.setImageResource(R.drawable.gray_dot);
                v = (ImageView) findViewById(R.id.imageDot3);
                v.setImageResource(R.drawable.gray_dot);
                v = (ImageView) findViewById(R.id.imageDot4);
                v.setImageResource(R.drawable.yellow_dot);
                YoYo.with(Techniques.Landing)
                        .duration(1000)
                        .playOn(v);
                break;
        }
    }

    void manageTextAnimationToPage(int actualPage){

        switch (actualPage) {
            case 0:
                TextView v = (TextView) findViewById(R.id.arcade);
                YoYo.with(Techniques.Landing)
                        .duration(1000)
                        .playOn(v);
                break;
            case 1:
                v = (TextView) findViewById(R.id.time_attack);
                YoYo.with(Techniques.Landing)
                        .duration(1000)
                        .playOn(v);
                break;
            case 2:
                v = (TextView) findViewById(R.id.achivements_text);
                YoYo.with(Techniques.Landing)
                        .duration(1000)
                        .playOn(v);
                break;
            case 3:
                v = (TextView) findViewById(R.id.settings_text);
                YoYo.with(Techniques.Landing)
                        .duration(1000)
                        .playOn(v);
                break;
        }
    }

    public void openLevels(View view) {
        Intent i = new Intent(MenuActivity.this, LevelMenuActivity.class);
        startActivity(i);
        sfxManager.KeyboardClickPlay(true);
        finish();
    }

    public void openChallengeTimeChoose(View view){
        Intent i = new Intent(MenuActivity.this, ChooseTimeChallenge.class);
        startActivity(i);
        sfxManager.KeyboardClickPlay(true);
        finish();
    }


    public void signIn(View view) {
        SharedPreferences sharedPref = getSharedPreferences("LOGGING", MODE_PRIVATE);
        if(!sharedPref.getBoolean("SIGN_STATUS", true)) {
            mSignInClicked = true;
            sfxManager.KeyboardClickPlay(true);
            mGoogleApiClient.connect();
        }else{
            Intent intent = new Intent();
            //Clear the activity so the back button returns to your app
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            //Manually specify the package and activity name
            intent.setComponent(new ComponentName("com.google.android.play.games", "com.google.android.gms.games.ui.destination.main.MainActivity"));
            //Not really needed as default happens if you don't specify it.
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            //You must specify the current players user. It ensures that Google Play Games is logged in as the same person.
            intent.putExtra("com.google.android.gms.games.ACCOUNT_KEY", Games.Players.getCurrentPlayerId(mGoogleApiClient));
            intent.putExtra("com.google.android.gms.games.SCREEN", 1050); //"Magic" number from the source code for the about page
            intent.putExtra("com.google.android.gms.games.GAME", Games.GamesMetadata.getCurrentGame(mGoogleApiClient));
            startActivity(intent);
        }
    }


    public void openSettings(View view) {
        Intent i = new Intent(MenuActivity.this, SettingsActivity.class);
        startActivity(i);
        sfxManager.KeyboardClickPlay(true);
        finish();

    }

    public void openAchivementsList(View view) {
        sfxManager.KeyboardClickPlay(true);
        SharedPreferences sharedPref = getSharedPreferences("LOGGING", MODE_PRIVATE);
        if(!sharedPref.getBoolean("SIGN_STATUS", true)) {
            mSignInClicked = true;
            mGoogleApiClient.connect();
        }else{
            startActivityForResult(Games.Achievements.getAchievementsIntent(mGoogleApiClient), 1);
        }
    }

    public void share(View view) {

        sfxManager.KeyboardClickPlay(true);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "Hey checkout  ");
        startActivity(Intent.createChooser(intent, "Share"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        imageUtil.unbindDrawables(findViewById(R.id.menu_layout));
        System.gc();
    }
}


