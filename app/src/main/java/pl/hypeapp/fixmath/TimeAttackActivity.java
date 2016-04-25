package pl.hypeapp.fixmath;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.example.games.basegameutils.BaseGameActivity;
import com.google.example.games.basegameutils.BaseGameUtils;
import com.nineoldandroids.animation.Animator;
import com.plattysoft.leonids.ParticleSystem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class TimeAttackActivity extends BaseGameActivity implements GoogleApiClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks{


    private int minutes, seconds, time;
    private int ActualSeconds;
    private boolean isKeyboardOpen = false;
    private boolean isPausedGame = false;
    private boolean isTimerStarted, isCounting;
    private Calculations calculations;
    private Level level;
    private int passedLinesIndexer = 0;
    private int allPassedLines = 0;
    public static int timeChallenge;

    private int correctFigureIndex = 0;
    private int clickedFigureID;
    private TimeKeyboard keyboard;
    private View Pointer;
    private boolean isClicked;
    private ArrayList<TextView> TextViews = new ArrayList<TextView>();

    private Logic logic;
    private int TextViewIndex;

    public TextView multiplerView, popUpScoreView;
    private int score = 0;
    private int multipler = 0;
    private int countSeconds = 3;

    ArrayList<Integer> levelsList = new ArrayList<>();

    Timer timer;

    static TextView secondsLeftView,minutesLeftView;

    private static int RC_SIGN_IN = 9001;

    private boolean mResolvingConnectionFailure = false;
    private boolean mAutoStartSignInFlow = true;
    private boolean mSignInClicked = false;
    private boolean mExplicitSignOut;
    boolean isShowInterstialOnClose = false;
    public GoogleApiClient mGoogleApiClient;
    SFXManager sfxManager;
    MyProgress myProgress;
    BitmapManager bitmapManager;
    String actualBacgroundId = null;

    ImageUtil imagesUtils;

    InterstitialAd  intersitialAdOnRepeat,  intersitialAdOnClosed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_attack_layout);
        secondsLeftView = (TextView) findViewById(R.id.seconds);
        minutesLeftView = (TextView) findViewById(R.id.minutes);

        this.multiplerView = (TextView) findViewById(R.id.multiplerView);
        this.popUpScoreView = (TextView) findViewById(R.id.scorePopUp);

        View allCalc = findViewById(R.id.t_line1);
        setClickableRecursive(allCalc, false);

        SharedPreferences sharedPref = getSharedPreferences("SOUNDS", MODE_PRIVATE);
        sfxManager = new SFXManager(this, sharedPref.getBoolean("ISMUTE", false));


        keyboard = new TimeKeyboard(this, sfxManager);
        setResetKeyboard();


        Intent intentChoose = getIntent();
        timeChallenge = intentChoose.getIntExtra("challenge", 300);


        countToStart();
        isCounting = true;

        getGameHelper().setConnectOnStart(false);
        mGoogleApiClient = getApiClient();
        mGoogleApiClient.registerConnectionCallbacks(this);
        mGoogleApiClient.registerConnectionFailedListener(this);


        myProgress = MyProgress.getInstance();
        bitmapManager = BitmapManager.getInstance();

        imagesUtils = (ImageUtil)getApplication();

        setupIntersitialAds();



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unbindDrawables(findViewById(R.id.time_attack_layout));
        System.gc();
    }

    private void unbindDrawables(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback(null);
        }
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                unbindDrawables(((ViewGroup) view).getChildAt(i));

            }
            ((ViewGroup) view).removeAllViews();
        }
    }



    void setupIntersitialAds(){

            AdRequest adRequest = new AdRequest.Builder()
                    .build();

            intersitialAdOnRepeat = new InterstitialAd(this);
            intersitialAdOnRepeat.setAdUnitId(getString(R.string.adID));
            intersitialAdOnRepeat.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    repeatGame();
                }
            });
            intersitialAdOnRepeat.loadAd(adRequest);

            intersitialAdOnClosed = new InterstitialAd(this);
            intersitialAdOnClosed.setAdUnitId(getString(R.string.adID));
            intersitialAdOnClosed.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    Intent i = new Intent(TimeAttackActivity.this, ChooseTimeChallenge.class);
                    startActivity(i);
                    finish();
                }
            });
            intersitialAdOnClosed.loadAd(adRequest);

    }

    void repeatGame(){
        Intent x = new Intent(TimeAttackActivity.this, TimeAttackActivity.class);
        x.putExtra("challenge", timeChallenge);
        startActivity(x);
        finish();
    }

    boolean showIntersitialAdOnClose(InterstitialAd intersitialAdOnClose, boolean isShowInterstialOnClose){
            if(isShowInterstialOnClose) {
                if (intersitialAdOnClose.isLoaded()) {
                    intersitialAdOnClose.show();
                    return true;
                } else {
                    return false;
                }
            }else {
                return false;
            }
    }

    boolean showIntersitialAdOnNextLevel(InterstitialAd intersitialAdOnClose){
        if (intersitialAdOnClose.isLoaded()) {
            intersitialAdOnClose.show();
            return true;
        } else {
            return false;
        }
    }


    private void setVisibilityComponents(boolean isEndWindow, boolean visible) {
        View timerView = findViewById(R.id.timerLayout);
        View backBtn = findViewById(R.id.time_attack_back);
        View tLine = findViewById(R.id.t_line1);
        View correctFigures = findViewById(R.id.correctFigures);
        ImageView backLine = (ImageView) findViewById(R.id.back_line);
        View textScoreView = findViewById(R.id.textScoreView);
        View scoreView = findViewById(R.id.scoreView);
        View multiplerView = findViewById(R.id.multiplerView);
        View playPauseBtn = findViewById(R.id.play_pause_btn);



        if (isEndWindow) {
            if (visible) {
                backBtn.setVisibility(View.VISIBLE);
            } else {
                backBtn.setVisibility(View.INVISIBLE);
            }
        }

        if(visible){
            timerView.setVisibility(View.VISIBLE);
            tLine.setVisibility(View.VISIBLE);
            correctFigures.setVisibility(View.VISIBLE);
            backLine.setVisibility(View.VISIBLE);
            backLine.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                    R.drawable.aaas, backLine.getWidth(), backLine.getHeight()));
            textScoreView.setVisibility(View.VISIBLE);
            multiplerView.setVisibility(View.VISIBLE);
            scoreView.setVisibility(View.VISIBLE);
            backBtn.setVisibility(View.VISIBLE);
            playPauseBtn.setVisibility(View.VISIBLE);
        }else{
            timerView.setVisibility(View.INVISIBLE);
            tLine.setVisibility(View.INVISIBLE);
            correctFigures.setVisibility(View.INVISIBLE);
            backLine.setVisibility(View.INVISIBLE);
            textScoreView.setVisibility(View.INVISIBLE);
            scoreView.setVisibility(View.INVISIBLE);
            multiplerView.setVisibility(View.INVISIBLE);
            backBtn.setVisibility(View.INVISIBLE);
            playPauseBtn.setVisibility(View.INVISIBLE);
        }

    }


    private void setEndScoreWindow(){
        isShowInterstialOnClose = true;
        SharedPreferences scorePref = getSharedPreferences("SCORE", 0);
        SharedPreferences.Editor editor = scorePref.edit();
        int bestScore = scorePref.getInt("BEST_SCORE_INT" + timeChallenge, 0);
        String bestScoreString = scorePref.getString("BEST_SCORE_STRING" + timeChallenge, "0");
        TextView yourScoreView = (TextView) findViewById(R.id.your_score);
        TextView bestScoreView = (TextView) findViewById(R.id.best_score);
        TextView scoreView = (TextView) findViewById(R.id.scoreView);

        ImageView backgroundView = (ImageView) findViewById(R.id.time_attack_background);
        imagesUtils.setImageSecond(backgroundView, R.drawable.time_attack_background_normal);
        YoYo.with(Techniques.ZoomIn)
                .duration(500)
                .playOn(backgroundView);


        if(this.score > bestScore){
            editor.putInt("BEST_SCORE_INT" + timeChallenge, this.score);
            editor.putString("BEST_SCORE_STRING" + timeChallenge, scoreView.getText().toString());
            editor.commit();
            yourScoreView.setText(scoreView.getText().toString());
            bestScoreView.setText(scoreView.getText().toString());


            myProgress.updateProgress(mGoogleApiClient, this);
        }else{
            yourScoreView.setText(scoreView.getText().toString());
            bestScoreView.setText(bestScoreString);
        }

        RelativeLayout windowLayout = (RelativeLayout) findViewById(R.id.complete_timeattack_level);
        windowLayout.setVisibility(View.VISIBLE);
        YoYo.with(Techniques.SlideInDown).playOn(windowLayout);

        if(this.isKeyboardOpen){
            KeyboardClose();
        }

        setVisibilityComponents(true, false);

    }

    private void countToStart(){
        final Timer Counter = new Timer();
        final TextView counterView = (TextView) findViewById(R.id.counterView);

        sfxManager.TimerSfxPlay(true);

        Counter.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {


                        countSeconds--;
                        counterView.setText("" + countSeconds);
                        YoYo.with(Techniques.TakingOff)
                                .duration(900)
                                .playOn(counterView);

                        if (countSeconds == -1) {
                            Counter.cancel();
                            counterView.setVisibility(View.INVISIBLE);
                            sfxManager.TimerSfxPlay(false);
                            //TU POPRAWIC
                            startTimer(timeChallenge);

                            setNewLevel();
                            setVisibilityComponents(false, true);
                            setBackgroundColor();
                            setNewCalculationsAndLogic(passedLinesIndexer);
                            setCorrectFrameFigures();
                            isCounting = false;
                        }
                    }
                });
            }
        }, 1000, 1000);
    }

    private void setNewCalculationsAndLogic(int passedLines) {
        calculations = new Calculations(
                level.GetColumnStart(passedLines),
                level.GetVariables(passedLines),
                level.GetSymbols(passedLines),
                level.GetResult(passedLines));
        fillCalculationLine(calculations);
        setClickAbleBlanks(calculations, level.GetFigures(passedLines));
        logic = new Logic(level.GetVariables(passedLines));

    }

    private void checkLine() throws InterruptedException {
        final View line = findViewById(R.id.t_line1);
        ImageView pauseBtn = (ImageView) findViewById(R.id.play_pause_btn);
        Handler handlerReset = new Handler();
        Handler handlerSetNewLevel = new Handler();
        Handler handlerBackground = new Handler();

        if (this.logic.checkTimeLine(keyboard)) {
            KeyboardClose();
            sfxManager.CorrectLinePlay();
            setClickableRecursive(line, false);
            handlerReset.postDelayed(new Runnable() {
                public void run() {
                    resetCalculation();
                }
            }, 1000);


            this.passedLinesIndexer++;
            this.correctFigureIndex++;
            this.multipler++;

            pauseBtn.setClickable(false);

            if (this.passedLinesIndexer == level.GetHowManyLines()) {
                addCorrectFigure();
                popUpLevelCorrectScoreAnimation();
                this.passedLinesIndexer = 0;
                this.correctFigureIndex = 0;
                this.isShowInterstialOnClose = true;
                handlerSetNewLevel.postDelayed(new Runnable() {
                    public void run() {
                        resetCorrectFigures();
                        setNewLevel();
                        setCorrectFrameFigures();
                    }
                }, 1000);


                addScore(true);
            } else {
                addCorrectFigure();
                addScore(false);
            }



            handlerBackground.postDelayed(new Runnable() {
                public void run() {
                    ImageView rl = (ImageView) findViewById(R.id.time_attack_layoutView);
                    ImageView rl1 = (ImageView) findViewById(R.id.time_attack_background);
                    int idBackground = (Integer) rl1.getTag();
                    rl.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                            idBackground , rl1.getWidth(),rl1.getHeight()));
                    setBackgroundColor();
                    setNewCalculationsAndLogic(passedLinesIndexer);
                    restoreCorrectLineAnimation();
                }
            }, 1000);




            YoYo.with(Techniques.ZoomOut)
                    .delay(500)
                    .withListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            YoYo.with(Techniques.ZoomIn)
                                    .playOn(line);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    })
                    .playOn(line);


            correctLevelAnimation();



        }


    }

    private void correctLevelAnimation() {
            ImageView backLine = (ImageView) findViewById(R.id.back_line);
            backLine.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                R.drawable.correct , backLine.getWidth(), backLine.getHeight()));
            YoYo.with(Techniques.ZoomIn)
                    .duration(300)
                    .playOn(backLine);
    }

    private void restoreCorrectLineAnimation(){
        ImageView backLine = (ImageView) findViewById(R.id.back_line);
        backLine.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                R.drawable.aaas, backLine.getWidth(), backLine.getHeight()));
        YoYo.with(Techniques.ZoomIn)
                .duration(500)
                .playOn(backLine);
    }

    private void resetCalculation() {
        TextView calcElement;
        ImageView calcElementIV;
        //FIGURY
        for (int i = 0; i <= 4; i++) {
            String TextViewId = "t_var" + i;
            int ID = getResources().getIdentifier(TextViewId, "id", getPackageName());
            calcElement = (TextView) findViewById(ID);
            calcElement.setVisibility(View.GONE);
            calcElement.setTag("");
            calcElement.setText("");

            String ImageViewId = "t_var_ImageView_" + i;
            int ivID = getResources().getIdentifier(ImageViewId, "id", getPackageName());
            calcElementIV = (ImageView) findViewById(ivID);
            calcElementIV.refreshDrawableState();
            calcElementIV.setVisibility(View.GONE);

        }
        //SYMBOLE
        for (int i = 0; i <= 3; i++) {
            String TextViewId = "t_symbol" + i;
            int ID = getResources().getIdentifier(TextViewId, "id", getPackageName());
            calcElement = (TextView) findViewById(ID);
            calcElement.setVisibility(View.GONE);
            calcElement.setText("");

        }


        keyboard = new TimeKeyboard(this, sfxManager);
    }

    private void resetCorrectFigures() {
        TextView correctFigure;
        ImageView correctFigureIW;
        for (int i = 1; i <= 5; i++) {
            String TextViewID = "correctFigure_" + i;
            int correctFigureID = getResources().getIdentifier(TextViewID, "id", getPackageName());
            correctFigure = (TextView) findViewById(correctFigureID);
            correctFigure.setVisibility(View.GONE);
            correctFigure.setBackgroundResource(0);
            correctFigure.setText("");
        }

        for (int i = 1; i <= 5; i++) {
            String ImageViewID = "t_correct_f" + i;
            int correctFigureID = getResources().getIdentifier(ImageViewID, "id", getPackageName());
            correctFigureIW = (ImageView) findViewById(correctFigureID);
            correctFigureIW.setVisibility(View.GONE);
            correctFigureIW.setBackgroundResource(0);
        }


        YoYo.with(Techniques.ZoomIn)
                .playOn(findViewById(R.id.correctFigures));
    }

    public void addScore(boolean isLevelPassed) {
        final TextView scoreView = (TextView) findViewById(R.id.scoreView);
        int scoreAdded;

        if (isLevelPassed) {
            this.score += 1000 * multipler;
            this.score += 5000;
            scoreAdded = 1000 * multipler;
        } else {
            this.score += 1000 * multipler;
            scoreAdded = 1000 * multipler;
        }

        if (String.valueOf(this.score).length() == 4) {
            scoreView.setText(String.valueOf(this.score).substring(0, 1) + ".000");
        } else if (String.valueOf(this.score).length() == 5) {
            scoreView.setText(String.valueOf(this.score).substring(0, 2) + ".000");
        } else if (String.valueOf(this.score).length() == 6) {
            scoreView.setText(String.valueOf(this.score).substring(0, 3) + ".000");
        } else {
            scoreView.setText(String.valueOf(this.score));
        }

        YoYo.with(Techniques.Pulse)
                .duration(700)
                .withListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        scoreView.setTextColor(Color.parseColor("#000000"));
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        scoreView.setTextColor(Color.parseColor("#FFFFFF"));
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                })
                .playOn(scoreView);

        if (this.multipler > 1) {
            this.multiplerView.setText(String.valueOf(this.multipler) + "x");
            YoYo.with(Techniques.FlipInX)
                    .duration(600)
                    .playOn(this.multiplerView);
        }

        popUpScoreAnimation(scoreAdded);
    }

    private void popUpScoreAnimation(final int score) {
        this.popUpScoreView.setText(String.valueOf(score));
        YoYo.with(Techniques.TakingOff)
                .duration(3500)
                .playOn(this.popUpScoreView);
    }

    private void popUpLevelCorrectScoreAnimation(){
        TextView scorePopUp = (TextView) findViewById(R.id.level_correct_scorePopUp);
        scorePopUp.setText("5000");
        YoYo.with(Techniques.TakingOff)
                .duration(3200)
                .playOn(scorePopUp);

    }

    private void setNewLevel() {
        int level = 0;
        Random randomizer = new Random();

        if(levelsList.size() <= 2){
            do{

                level = randomizer.nextInt(15);
                level += 1;


            }while(levelsList.contains(level));

            levelsList.add(level);
        }else if(levelsList.size() > 2){

            do{

                level = randomizer.nextInt(60);
                level += 1;


            }while(levelsList.contains(level));

            levelsList.add(level);
        }

        this.level = new Level(level);
        setNewCalculationsAndLogic(this.passedLinesIndexer = 0);
    }

    private void addCorrectFigure() {


        TextView correctFigureTextView = null;
        ImageView correctFigureImageView;
        switch (passedLinesIndexer) {
            case 1:
                correctFigureTextView = (TextView) findViewById(R.id.correctFigure_1);
                correctFigureTextView.setText(level.GetResultTexts(passedLinesIndexer - 1));
                break;
            case 2:
                correctFigureTextView = (TextView) findViewById(R.id.correctFigure_2);
                correctFigureTextView.setText(level.GetResultTexts(passedLinesIndexer - 1));
                break;
            case 3:
                correctFigureTextView = (TextView) findViewById(R.id.correctFigure_3);
                correctFigureTextView.setText(level.GetResultTexts(passedLinesIndexer - 1));
                break;
            case 4:
                correctFigureTextView = (TextView) findViewById(R.id.correctFigure_4);
                correctFigureTextView.setText(level.GetResultTexts(passedLinesIndexer - 1));
                break;
            case 5:
                correctFigureTextView = (TextView) findViewById(R.id.correctFigure_5);
                correctFigureTextView.setText(level.GetResultTexts(passedLinesIndexer - 1));
                break;
        }

        if(correctFigureTextView != null) {
            correctFigureImageView = (ImageView) findViewById((Integer) correctFigureTextView.getTag());
            correctFigureImageView.setVisibility(View.GONE);
            setCorrectFigure(correctFigureImageView);
        }


    }

    private void setCorrectFrameFigures() {
        ImageView correctFigure;
        TextView correctFigureTextView;
        int correctFigures = this.level.CorrectFigures.size();

        for (int i = 0, x = 1; i < correctFigures; i++, x++) {
            String TextViewID = "correctFigure_" + x;
            int correctFigureTextViewID = getResources().getIdentifier(TextViewID, "id", getPackageName());
            String ImageViewID = "t_correct_f" + x;
            int correctFigureImageViewID = getResources().getIdentifier(ImageViewID, "id", getPackageName());

            correctFigureTextView = (TextView) findViewById(correctFigureTextViewID);
            correctFigureTextView.setVisibility(View.VISIBLE);
            correctFigureTextView.setTag(correctFigureImageViewID);

            correctFigure = (ImageView) findViewById(correctFigureImageViewID);
            correctFigure.setVisibility(View.VISIBLE);
            correctFigure.setTag(correctFigureTextViewID);
            setCorrectFrameFigure(correctFigure, i);

        }



    }

    private void setCorrectFrameFigure(ImageView correctFrameFigure, int index) {
        TextView correctFrameTextView = (TextView) findViewById(R.id.correctFigure_1);
        int correctFrameFigureWidth = correctFrameTextView.getLayoutParams().width;
        int correctFrameFigureHeight = correctFrameTextView.getLayoutParams().height;

        if (level.GetTimeAttackCorrectFigures(index).equals("k")) {
            correctFrameFigure.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                    R.drawable.kwadrat_ramka, correctFrameFigureWidth, correctFrameFigureHeight));
        } else if (level.GetTimeAttackCorrectFigures(index).equals("o")) {
            correctFrameFigure.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                    R.drawable.okrag_ramka, correctFrameFigureWidth, correctFrameFigureHeight));
        } else if (level.GetTimeAttackCorrectFigures(index).equals("r")) {
            correctFrameFigure.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                    R.drawable.romb_ramka, correctFrameFigureWidth, correctFrameFigureHeight));
        } else if (level.GetTimeAttackCorrectFigures(index).equals("s")) {
            correctFrameFigure.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                    R.drawable.skat_ramka, correctFrameFigureWidth, correctFrameFigureHeight));
        } else if (level.GetTimeAttackCorrectFigures(index).equals("rf")) {
            correctFrameFigure.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                    R.drawable.romb_f_ramka, correctFrameFigureWidth, correctFrameFigureHeight));
        } else if (level.GetTimeAttackCorrectFigures(index).equals("oz")) {
            correctFrameFigure.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                    R.drawable.okrag_ramka, correctFrameFigureWidth, correctFrameFigureHeight));
        } else if (level.GetTimeAttackCorrectFigures(index).equals("ok")) {
            correctFrameFigure.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                    R.drawable.okat_ramka, correctFrameFigureWidth, correctFrameFigureHeight));
        } else if (level.GetTimeAttackCorrectFigures(index).equals("q")) {
            correctFrameFigure.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                    R.drawable.question_ramka, correctFrameFigureWidth, correctFrameFigureHeight));
        }else if (level.GetTimeAttackCorrectFigures(index).equals("kf")) {
            correctFrameFigure.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                    R.drawable.kwadrat_ramka, correctFrameFigureWidth, correctFrameFigureHeight));
        }else if (level.GetTimeAttackCorrectFigures(index).equals("kb")) {
            correctFrameFigure.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                    R.drawable.kwadrat_ramka, correctFrameFigureWidth, correctFrameFigureHeight));
        }else if (level.GetTimeAttackCorrectFigures(index).equals("rg")) {
            correctFrameFigure.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                    R.drawable.romb_ramka, correctFrameFigureWidth, correctFrameFigureHeight));
        }
    }

    public void setCorrectFigure(final ImageView correctFigure) {
        TextView correctFrameTextView = (TextView) findViewById(R.id.correctFigure_1);
        int correctFrameFigureWidth = correctFrameTextView.getLayoutParams().width;
        int correctFrameFigureHeight = correctFrameTextView.getLayoutParams().height;
        correctFigure.setVisibility(View.INVISIBLE);
        if (level.GetTimeAttackCorrectFigures(passedLinesIndexer - 1).equals("k")) {
            correctFigure.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                    R.drawable.kwadrat, correctFrameFigureWidth, correctFrameFigureHeight));
        } else if (level.GetTimeAttackCorrectFigures(passedLinesIndexer - 1).equals("o")) {
            correctFigure.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                    R.drawable.okrag, correctFrameFigureWidth, correctFrameFigureHeight));
        } else if (level.GetTimeAttackCorrectFigures(passedLinesIndexer - 1).equals("r")) {
            correctFigure.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                    R.drawable.romb, correctFrameFigureWidth, correctFrameFigureHeight));
        } else if (level.GetTimeAttackCorrectFigures(passedLinesIndexer - 1).equals("s")) {
            correctFigure.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                    R.drawable.skat, correctFrameFigureWidth, correctFrameFigureHeight));
        } else if (level.GetTimeAttackCorrectFigures(passedLinesIndexer - 1).equals("rf")) {
            correctFigure.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                    R.drawable.romb_f, correctFrameFigureWidth, correctFrameFigureHeight));
        } else if (level.GetTimeAttackCorrectFigures(passedLinesIndexer - 1).equals("oz")) {
            correctFigure.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                    R.drawable.okrag_z, correctFrameFigureWidth, correctFrameFigureHeight));
        } else if (level.GetTimeAttackCorrectFigures(passedLinesIndexer - 1).equals("ok")) {
            correctFigure.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                    R.drawable.okat, correctFrameFigureWidth, correctFrameFigureHeight));
        } else if (level.GetTimeAttackCorrectFigures(passedLinesIndexer - 1).equals("q")) {
            correctFigure.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                    R.drawable.question, correctFrameFigureWidth, correctFrameFigureHeight));
        }else if (level.GetTimeAttackCorrectFigures(passedLinesIndexer - 1).equals("kf")) {
            correctFigure.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                    R.drawable.kwadrat_f, correctFrameFigureWidth, correctFrameFigureHeight));
        }else if (level.GetTimeAttackCorrectFigures(passedLinesIndexer - 1).equals("kb")) {
            correctFigure.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                    R.drawable.kwadrat_blue, correctFrameFigureWidth, correctFrameFigureHeight));
        }else if (level.GetTimeAttackCorrectFigures(passedLinesIndexer - 1).equals("rg")) {
            correctFigure.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                    R.drawable.romb_green, correctFrameFigureWidth, correctFrameFigureHeight));
        }


        YoYo.with(Techniques.ZoomIn)
                .duration(700)
                .withListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        correctFigure.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                })
                .playOn(correctFigure);

        YoYo.with(Techniques.ZoomIn)
                .duration(700)
                .playOn(findViewById((Integer) correctFigure.getTag()));


    }

    private void setClickAbleBlanks(Calculations calculations, String figures[]) {
        int variable = calculations.WhichColumnStart;
        int ID;
        TextView textView;
        ImageView imageView = (ImageView) findViewById(R.id.t_var_ImageView_0);
        int width = imageView.getLayoutParams().width;
        int height = imageView.getLayoutParams().height;

        for (int i = 0; i < calculations.VariablesCount; i++) {
            String TextViewId = "t_var" + variable;
            ID = getResources().getIdentifier(TextViewId, "id", getPackageName());

            textView = (TextView) findViewById(ID);
            TextViews.add(textView);
            textView.setClickable(true);
            textView.setVisibility(View.VISIBLE);

            String ImageViewId = "t_var_ImageView_" + variable;
            ID = getResources().getIdentifier(ImageViewId, "id", getPackageName());
            imageView = (ImageView) findViewById(ID);
            imageView.setVisibility(View.VISIBLE);

            variable++;


            if (figures[i].equals("k")) {
                imageView.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                        R.drawable.kwadrat, width, height));
                textView.setTag("k");
            } else if (figures[i].equals("o")) {
                imageView.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                        R.drawable.okrag, width, height));
                textView.setTag("o");
            } else if (figures[i].equals("r")) {
                imageView.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                        R.drawable.romb, width, height));
                textView.setTag("r");
            } else if (figures[i].equals("s")) {
                imageView.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                        R.drawable.skat, width, height));
                textView.setTag("s");
            } else if (figures[i].equals("rf")) {
                imageView.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                        R.drawable.romb_f, width, height));
                textView.setTag("rf");
            } else if (figures[i].equals("oz")) {
                imageView.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                        R.drawable.okrag_z, width, height));
                textView.setTag("oz");
            } else if (figures[i].equals("ok")) {
                imageView.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                        R.drawable.okat, width, height));
                textView.setTag("ok");
            } else if (figures[i].equals("q")) {
                imageView.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                        R.drawable.question, width, height));
                textView.setText("?");
                textView.setTag("q");
            }else  if(figures[i].equals("kf")){
                imageView.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                        R.drawable.kwadrat_f, width, height));
                textView.setTag("kf");
            }else  if(figures[i].equals("kb")){
                imageView.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                        R.drawable.kwadrat_blue, width, height));
                textView.setTag("kb");
            }else  if(figures[i].equals("rg")){
                imageView.setImageBitmap(BitmapManager.decodeSampledBitmapFromResource(getResources(),
                        R.drawable.romb_green, width, height));
                textView.setTag("rg");
            }

        }


    }

    private void fillCalculationLine(Calculations calculations) {
        int symbolID, resultID;
        TextView textView;


        for (int x = calculations.WhichColumnStart, i = 0; i < calculations.SymbolsCount; i++, x++) {
            String textViewId = "t_symbol" + x;
            symbolID = getResources().getIdentifier(textViewId, "id", getPackageName());
            textView = (TextView) findViewById(symbolID);
            textView.setText(calculations.SymbolList.get(i));
            textView.setVisibility(View.VISIBLE);
        }

        int endStart = calculations.WhichColumnStart + calculations.SymbolsCount;
        String textViewId = "t_symbol" + endStart;
        symbolID = getResources().getIdentifier(textViewId, "id", getPackageName());
        textView = (TextView) findViewById(symbolID);
        textView.setText("=");
        textView.setVisibility(View.VISIBLE);

        String resultTextViewId = "t_var" + (endStart + 1);
        resultID = getResources().getIdentifier(resultTextViewId, "id", getPackageName());
        textView = (TextView) findViewById(resultID);
        if(calculations.Result.length() >= 2){
            textView.setTextSize(24);
        }
        if(calculations.Result.length() >= 4){
            textView.setTextSize(18);
        }
        textView.setText(calculations.Result);
        textView.setVisibility(View.VISIBLE);


    }

    private void setBackgroundColor() {
        ImageView timeAttackBackground = (ImageView) findViewById(R.id.time_attack_background);

        final ImageView pauseBtn = (ImageView) findViewById(R.id.play_pause_btn);

        if (level.GetTimeAttackCorrectFigures(this.passedLinesIndexer).equals("k")) {
            timeAttackBackground.setTag(R.drawable.time_attack_background_kwadrat);
            imagesUtils.setImageSecond(timeAttackBackground, R.drawable.time_attack_background_kwadrat);

        } else if (level.GetTimeAttackCorrectFigures(this.passedLinesIndexer).equals("s")) {
            timeAttackBackground.setTag(R.drawable.time_attack_background_skat);
            imagesUtils.setImageSecond(timeAttackBackground, R.drawable.time_attack_background_skat);

        } else if (level.GetTimeAttackCorrectFigures(this.passedLinesIndexer).equals("o")) {
            timeAttackBackground.setTag(R.drawable.time_attack_background_okrag);
            imagesUtils.setImageSecond(timeAttackBackground, R.drawable.time_attack_background_okrag);

        } else if (level.GetTimeAttackCorrectFigures(this.passedLinesIndexer).equals("q")) {
            timeAttackBackground.setTag(R.drawable.time_attack_background_question);
            imagesUtils.setImageSecond(timeAttackBackground, R.drawable.time_attack_background_question);

        } else if (level.GetTimeAttackCorrectFigures(this.passedLinesIndexer).equals("oz")) {
            timeAttackBackground.setTag(R.drawable.time_attack_background_skat);
            imagesUtils.setImageSecond(timeAttackBackground, R.drawable.time_attack_background_skat);

        } else if (level.GetTimeAttackCorrectFigures(this.passedLinesIndexer).equals("r")) {
            timeAttackBackground.setTag(R.drawable.time_attack_background_romb);
            imagesUtils.setImageSecond(timeAttackBackground, R.drawable.time_attack_background_romb);

        } else if (level.GetTimeAttackCorrectFigures(this.passedLinesIndexer).equals("rf")) {
            timeAttackBackground.setTag(R.drawable.time_attack_background_romb_f);
            imagesUtils.setImageSecond(timeAttackBackground, R.drawable.time_attack_background_romb_f);

        } else if (level.GetTimeAttackCorrectFigures(this.passedLinesIndexer).equals("ok")) {
            timeAttackBackground.setTag(R.drawable.time_attack_background_okat);
            imagesUtils.setImageSecond(timeAttackBackground, R.drawable.time_attack_background_okat);

        }else if (level.GetTimeAttackCorrectFigures(this.passedLinesIndexer).equals("rg")) {
            timeAttackBackground.setTag(R.drawable.time_attack_background_romb_green);
            imagesUtils.setImageSecond(timeAttackBackground, R.drawable.time_attack_background_romb_green);

        }else if (level.GetTimeAttackCorrectFigures(this.passedLinesIndexer).equals("kb")) {
            timeAttackBackground.setTag(R.drawable.time_attack_background_kwadrat_blue);
            imagesUtils.setImageSecond(timeAttackBackground, R.drawable.time_attack_background_kwadrat_blue);

        }else if (level.GetTimeAttackCorrectFigures(this.passedLinesIndexer).equals("kf")) {
            timeAttackBackground.setTag(R.drawable.time_attack_background_kwadrat_f);
            imagesUtils.setImageSecond(timeAttackBackground, R.drawable.time_attack_background_kwadrat_f);
        }


        YoYo.with(Techniques.ZoomIn)
                .duration(500)
                .withListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                            sfxManager.NewBackgroundPlay();
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        pauseBtn.setClickable(true);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                })
                .playOn(findViewById(R.id.time_attack_background));

    }

    public void pauseGame(View view) {
        sfxManager.SameLineFigureClickPlay();
        final ImageView pauseBTn = (ImageView) findViewById(R.id.play_pause_btn);
        final TextView pauseTextView = (TextView) findViewById(R.id.pauseText);
        if(!isPausedGame){
            timer.cancel();
            isTimerStarted = false;
            timer = null;
            pauseBTn.setImageResource(R.drawable.play_btn);
            if(isKeyboardOpen) {
                KeyboardClose();
            }
            YoYo.with(Techniques.ZoomOut)
                    .duration(700)
                    .playOn(findViewById(R.id.t_line1));
            pauseTextView.setVisibility(View.VISIBLE);
            YoYo.with(Techniques.ZoomIn)
                    .duration(700)
                    .withListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            pauseBTn.setClickable(false);
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            pauseBTn.setClickable(true);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    })
                    .playOn(pauseTextView);
            setClickableRecursive(findViewById(R.id.t_keyboard), false);

            isPausedGame = true;
        }else{
            rePauseGame();
            YoYo.with(Techniques.ZoomIn)
                    .duration(700)
                    .playOn(findViewById(R.id.t_line1));

            YoYo.with(Techniques.ZoomOut)
                    .duration(700)
                    .withListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            pauseBTn.setClickable(false);
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            pauseTextView.setVisibility(View.INVISIBLE);
                            pauseBTn.setClickable(true);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    })
                    .playOn(pauseTextView);
            pauseBTn.setImageResource(R.drawable.pause_btn);
            setClickableRecursive(findViewById(R.id.t_keyboard), true);

            isPausedGame = false;
        }


    }

    private void rePauseGame(){
        timer = new Timer();
        isTimerStarted = true;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //MINUTES VIEW
                        if(minutes > 0) {
                            minutesLeftView.setText(minutes + ".");
                        }else{
                            minutesLeftView.setText("");
                        }

                        //SECONDS VIEW
                        if(seconds > 10) {
                            secondsLeftView.setText("" + (seconds - 1));
                        }else{
                            secondsLeftView.setText("0" + (seconds - 1));
                        }

                        seconds--;

                        if(seconds == 0){
                            seconds = 60;
                            minutes--;

                            if (minutes == -1) {
                                setEndScoreWindow();
                                isTimerStarted = false;
                                timer.cancel();
                            }

                        }



                    }
                });
            }
        }, 1000, 1000);




    }

    private void startTimer(int time) {
        timer = new Timer();
        minutes = time / 60;
        seconds = 60;

        minutesLeftView.setText(minutes + ".");
        secondsLeftView.setVisibility(View.VISIBLE);
        minutesLeftView.setVisibility(View.VISIBLE);



        minutes--;
        isTimerStarted = true;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //MINUTES VIEW
                        if(minutes > 0) {
                            minutesLeftView.setText(minutes + ".");
                        }else{
                            minutesLeftView.setText("");
                        }

                        //SECONDS VIEW
                        if(seconds > 10) {
                            secondsLeftView.setText("" + (seconds - 1));
                        }else{
                            secondsLeftView.setText("0" + (seconds - 1));
                        }

                        seconds--;
                        ActualSeconds = seconds;


                        if(seconds == 0){
                            seconds = 60;
                            minutes--;

                            if (minutes == -1) {
                                setEndScoreWindow();
                                isTimerStarted = false;
                                timer.cancel();
                            }

                        }



                    }
                });
            }
        }, 1000, 1000);


    }

    public void FigureClick(View view) {
        isClicked = true;
        clickedFigureID = view.getId();



        //FIGURE ANIMATION
        YoYo.with(Techniques.RubberBand)
                .duration(500)
                .playOn(findViewById(clickedFigureID));

        //KEYBOARD
        RelativeLayout keyboardView = (RelativeLayout) findViewById(R.id.t_keyboard);
        View keyboardViewID = findViewById(R.id.t_keyboard);
        setClickableRecursive(keyboardViewID, true);

        RelativeLayout.LayoutParams keyboardParams = (RelativeLayout.LayoutParams) keyboardView.getLayoutParams();

        //RESET KEYBOARD
        keyboardParams.addRule(RelativeLayout.BELOW);
        keyboardParams.addRule(RelativeLayout.ABOVE);
        keyboardView.setLayoutParams(keyboardParams);


        setVisibleKeyboard();

        //COLOR KEYBOARD
        setKeyboardView(view);


        int ID, on;
        for (int i = 0; i <= 4; i++) {
            String TextViewId = "t_var" + i;
            ID = getResources().getIdentifier(TextViewId, "id", getPackageName());
            TextView xt = (TextView) findViewById(ID);
            on = xt.getId();
            if (clickedFigureID == on) {

                TextViewIndex = i;

            }
        }


    }

    private void setKeyboardView(View clickedFigureID) {

        RelativeLayout keyboardLayout = (RelativeLayout) findViewById(R.id.t_keyboard);
        TextView figureColor = (TextView) findViewById(R.id.t_color_figure);


        for (int i = 0; i <= 10; i++) {
            switch (i) {
                case 0:
                    //kwadrat - color
                    if (clickedFigureID.getTag().equals("k")) {
                        //keyboard COLOR
                        keyboardLayout.setBackgroundResource(R.color.kwadrat_kolor);
                        //POINTER COLOR
                        setKeyboardPointerView(clickedFigureID, i);
                    }
                    break;
                case 1:
                    //romb_f - color
                    if (clickedFigureID.getTag().equals("rf")) {
                        //KEYBOARD COLOR
                        keyboardLayout.setBackgroundResource(R.color.rombf_kolor);
                        //POINTER COLOR
                        setKeyboardPointerView(clickedFigureID, i);
                    }
                    break;
                case 2:
                    //okrag - color
                    if (clickedFigureID.getTag().equals("o")) {
                        //KEYBOARD COLOR
                        keyboardLayout.setBackgroundResource(R.color.okrag_kolor);
                        //POINTER COLOR
                        setKeyboardPointerView(clickedFigureID, i);
                    }
                    break;
                case 3:
                    //romb - color
                    if (clickedFigureID.getTag().equals("r")) {
                        //KEYBOARD COLOR
                        keyboardLayout.setBackgroundResource(R.color.romb_kolor);
                        //POINTER COLOR
                        setKeyboardPointerView(clickedFigureID, i);
                    }
                    break;
                case 4:
                    //skat - color
                    if (clickedFigureID.getTag().equals("s")) {
                        //KEYBOARD COLOR
                        keyboardLayout.setBackgroundResource(R.color.skat_kolor);
                        //POINTER COLOR
                        setKeyboardPointerView(clickedFigureID, i);
                    }
                    break;
                case 5:
                    //okat - color
                    if (clickedFigureID.getTag().equals("ok")) {
                        //KEYBOARD COLOR
                        keyboardLayout.setBackgroundResource(R.color.okat_kolor);
                        //POINTER COLOR
                        setKeyboardPointerView(clickedFigureID, i);
                    }
                    break;
                case 6:
                    //okrag_z - color
                    if (clickedFigureID.getTag().equals("oz")) {
                        //KEYBOARD COLOR
                        keyboardLayout.setBackgroundResource(R.color.okrag_z_kolor);
                        //POINTER COLOR
                        setKeyboardPointerView(clickedFigureID, i);
                    }
                    break;
                case 7:
                    //okrag_z - color
                    if (clickedFigureID.getTag().equals("q")) {
                        //KEYBOARD COLOR
                        keyboardLayout.setBackgroundResource(R.color.question_kolor);
                        //POINTER COLOR
                        setKeyboardPointerView(clickedFigureID, i);
                    }
                    break;
                case 8:
                    //okrag_z - color
                    if (clickedFigureID.getTag().equals("rg")) {
                        //KEYBOARD COLOR
                        keyboardLayout.setBackgroundResource(R.color.romb_green_kolor);
                        //POINTER COLOR
                        setKeyboardPointerView(clickedFigureID, i);
                    }
                    break;
                case 9:
                    //okrag_z - color
                    if (clickedFigureID.getTag().equals("kb")) {
                        //KEYBOARD COLOR
                        keyboardLayout.setBackgroundResource(R.color.kwadrat_blue_kolor);
                        //POINTER COLOR
                        setKeyboardPointerView(clickedFigureID, i);
                    }
                    break;
                case 10:
                    //okrag_z - color
                    if (clickedFigureID.getTag().equals("kf")) {
                        //KEYBOARD COLOR
                        keyboardLayout.setBackgroundResource(R.color.kwadrat_f_kolor);
                        //POINTER COLOR
                        setKeyboardPointerView(clickedFigureID, i);
                    }
                    break;
            }

        }

        //KEYBOARD ANIMATION

        if (!isKeyboardOpen) {
            sfxManager.NewLineFigureClickPlay();
            YoYo.with(Techniques.FlipInX)
                    .duration(500)
                    .playOn(findViewById(R.id.t_keyboard));
        } else {
            sfxManager.SameLineFigureClickPlay();
            YoYo.with(Techniques.Pulse)
                    .duration(500)
                    .playOn(findViewById(R.id.t_keyboard));
        }
        isKeyboardOpen = true;
    }

    private void setKeyboardPointerView(View clickOn, int pointerFigure) {

        int parentKeyboard = ((View) clickOn.getParent()).getId();
        View pointer;
        RelativeLayout keyboardLayout = (RelativeLayout) findViewById(R.id.t_keyboard);
        RelativeLayout.LayoutParams keyboardParams = (RelativeLayout.LayoutParams) keyboardLayout.getLayoutParams();
        RelativeLayout.LayoutParams pointerParams;

        pointer = findViewById(R.id.t_pointer);
        pointer.setVisibility(View.INVISIBLE);


        //SETTING POINTER

        pointer.setVisibility(View.VISIBLE);
        this.Pointer = pointer;

        //Pointer settings
        pointerParams = (RelativeLayout.LayoutParams) pointer.getLayoutParams();
        pointerParams.addRule(RelativeLayout.ALIGN_RIGHT, clickedFigureID);
        pointerParams.addRule(RelativeLayout.ALIGN_LEFT, clickedFigureID);
        pointerParams.addRule(RelativeLayout.BELOW, clickedFigureID);
        pointer.setLayoutParams(pointerParams);

        //Keyboard settings
        keyboardParams.addRule(RelativeLayout.BELOW, parentKeyboard);
        keyboardLayout.setLayoutParams(keyboardParams);


        switch (pointerFigure) {
            case 0:
                pointer.setBackgroundResource(R.drawable.pointer_kwadrat);
                break;
            case 1:
                pointer.setBackgroundResource(R.drawable.pointer_rombf);
                break;
            case 2:
                pointer.setBackgroundResource(R.drawable.pointer_okrag);
                break;
            case 3:
                pointer.setBackgroundResource(R.drawable.pointer_romb);
                break;
            case 4:
                pointer.setBackgroundResource(R.drawable.pointer_skat);
                break;
            case 5:
                pointer.setBackgroundResource(R.drawable.pointer_okat);
                break;
            case 6:
                pointer.setBackgroundResource(R.drawable.pointer_skat);
                break;
            case 7:
                pointer.setBackgroundResource(R.drawable.pointer_question);
                break;
            case 8:
                pointer.setBackgroundResource(R.drawable.pointer_romb_green);
                break;
            case 9:
                pointer.setBackgroundResource(R.drawable.pointer_kwadrat_blue);
                break;
            case 10:
                pointer.setBackgroundResource(R.drawable.pointer_kwadrat_f);
                break;

        }


        OpenPointerAnimation();
    }

    public void setClickableRecursive(View view, boolean isClickable) {
        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            for (int i = 0; i < group.getChildCount(); i++) {
                setClickableRecursive(group.getChildAt(i), isClickable);
            }
        } else {
            view.setClickable(isClickable);
        }
    }

    public void WriteBlankAnimation(View animBlank) {
        YoYo.with(Techniques.RubberBand)
                .duration(500)
                .playOn(findViewById(animBlank.getId()));


        sfxManager.KeyboardClickPlay(true);

        new ParticleSystem(this, 5, R.drawable.star_white, 800)
                .setScaleRange(0.7f, 1.3f)
                .setSpeedRange(0.1f, 0.25f)
                .setRotationSpeedRange(90, 180)
                .setFadeOut(200, new AccelerateInterpolator())
                .oneShot(animBlank, 100);
    }

    public void BackspaceBlankAnimation(View animBlank) {
        sfxManager.KeyboardBackspacePlay();
        YoYo.with(Techniques.Swing)
                .duration(800)
                .playOn(findViewById(animBlank.getId()));
    }

    public void ErrorKeyAnimation() {
        YoYo.with(Techniques.Shake)
                .duration(400)
                .playOn(findViewById(R.id.t_keyboard));
    }

    private void setResetKeyboard() {
        RelativeLayout keyobardLayout = (RelativeLayout) findViewById(R.id.t_keyboard);
        keyobardLayout.setVisibility(View.INVISIBLE);
    }

    private void setVisibleKeyboard() {
        RelativeLayout keyboardView = (RelativeLayout) findViewById(R.id.t_keyboard);
        keyboardView.setVisibility(View.VISIBLE);
    }

    public void OpenPointerAnimation() {
        if(Pointer != null) {
            ImageView pointer = (ImageView) findViewById(Pointer.getId());
            YoYo.with(Techniques.FlipInX)
                    .duration(500)
                    .playOn(pointer);
        }
    }

    private void closePointerAnimation() {
        if(Pointer != null) {
            ImageView pointer = (ImageView) findViewById(Pointer.getId());
            YoYo.with(Techniques.ZoomOut)
                .duration(200)
                .playOn(pointer);
        }
    }

    public void TKeyClick(View keyClick) {
        if (isClicked) {
            int keyClickID = keyClick.getId();
            TextView textView = (TextView) findViewById(clickedFigureID);
            int[] ID = new int[12];



            for (int i = 0; i <= 11; i++) {
                String TextViewId = "tk" + i;
                ID[i] = getResources().getIdentifier(TextViewId, "id", getPackageName());
                String txt = textView.getText().toString();
                if (keyClickID == ID[i]) {
                    if (i <= 9) {

                        if (i == 0) {
                            if (txt.equals("")) {
                                ErrorKeyAnimation();
                                sfxManager.KeyboardErrorPlay();
                                return;
                            }
                        }


//                        textView.setText("" + keyboard.GetString(i, TextViewIndex));

                        if (keyboard.helperInt > 2) {
                            ErrorKeyAnimation();
                            sfxManager.KeyboardErrorPlay();
                        } else {
                            keyboard.PrintNumbersInFigures(i, textView);
                            sfxManager.KeyboardClickPlay(true);
//                            WriteBlankAnimation(textView);
                        }

//                        if (keyboard.helperInt < 2) {
//                            textView.setTextSize(30);
//                        } else if (keyboard.helperInt == 2) {
//                            textView.setTextSize(19);
//                        }



                    } else if (i == 10) {

                        if (!txt.equals("")) {
                            BackspaceBlankAnimation(textView);
                        }
//                        textView.setText("" + keyboard.GetString(i, TextViewIndex));
                        keyboard.BackSpaceNumbersInFigures(textView);
                        sfxManager.KeyboardBackspacePlay();


//                        if (keyboard.helperInt == 2) {
//                            textView.setTextSize(30);
//                        } else if (keyboard.helperInt > 2) {
//                            textView.setTextSize(30);
//                        }
                    }

                }
            }
        }

        try {
            checkLine();
        }catch (Exception e){}
    }

    public void KeyboardClose(View view) {
        View keyboardView = findViewById(R.id.t_keyboard);
        setClickableRecursive(keyboardView, false);
        YoYo.with(Techniques.ZoomOut)
                .duration(400)
                .playOn(keyboardView);
        closePointerAnimation();
        isKeyboardOpen = false;

        sfxManager.KeybordClosePlay();

    }

    public void KeyboardClose() {
        View keyboardView = findViewById(R.id.t_keyboard);
        setClickableRecursive(keyboardView, false);
        YoYo.with(Techniques.ZoomOut)
                .duration(400)
                .playOn(keyboardView);
        closePointerAnimation();
        isKeyboardOpen = false;



    }


    public void restartLevel(View view) {
        sfxManager.KeyboardClickPlay(true);
        if(!showIntersitialAdOnNextLevel(intersitialAdOnRepeat)){
            repeatGame();
        }

    }

    public void backToChallengeMenu(View view) {
        sfxManager.KeyboardClickPlay(true);

        if(!showIntersitialAdOnClose(intersitialAdOnClosed, isShowInterstialOnClose)) {
            Intent i = new Intent(TimeAttackActivity.this, ChooseTimeChallenge.class);
            startActivity(i);
            finish();
        }

        if(isTimerStarted) {
            timer.cancel();
        }
        timer = null;
    }

    @Override
    public void onBackPressed() {
        if(isKeyboardOpen){
            KeyboardClose();
        }else {
            if(!isCounting) {

                if(!showIntersitialAdOnClose(intersitialAdOnClosed, isShowInterstialOnClose)) {
                    Intent i = new Intent(TimeAttackActivity.this, ChooseTimeChallenge.class);
                    startActivity(i);
                    finish();
                }

                if (isTimerStarted) {
                    timer.cancel();
                }
                timer = null;
            }
        }
    }


    public void leaderboradOpen(View view) {
        sfxManager.KeyboardClickPlay(true);
        SharedPreferences sharedPref = getSharedPreferences("LOGGING", MODE_PRIVATE);
        if(!sharedPref.getBoolean("SIGN_STATUS", true)) {
            mSignInClicked = true;
            mGoogleApiClient.connect();
        }else{
            mSignInClicked = true;
            mGoogleApiClient.connect();
            switch(timeChallenge){
                case 300:
                    startActivityForResult(Games.Leaderboards.getLeaderboardIntent(mGoogleApiClient,
                            getString(R.string.five_minutes)), 5);
                    break;
                case 180:
                    startActivityForResult(Games.Leaderboards.getLeaderboardIntent(mGoogleApiClient,
                            getString(R.string.three_minutes)), 3);
                    break;
                case 60:
                    startActivityForResult(Games.Leaderboards.getLeaderboardIntent(mGoogleApiClient,
                            getString(R.string.one_minute)), 1);
                    break;
            }
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
        myProgress.updateProgress(mGoogleApiClient, this);
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
