package pl.hypeapp.fixmath;

import android.content.Context;
import android.content.SharedPreferences;


import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;


public class MyProgress {
    private static MyProgress ourInstance = new MyProgress();

    public static MyProgress getInstance() {
        return ourInstance;
    }

    private MyProgress() {
    }

    public void updateProgress(GoogleApiClient googleApiClient, Context context){
        SharedPreferences myProgressAchievement = context.getSharedPreferences("ACHIEVEMENTS", context.MODE_PRIVATE);
        SharedPreferences myProgressScore = context.getSharedPreferences("SCORE", context.MODE_PRIVATE);
        if (googleApiClient != null && googleApiClient.isConnected()) {
            //UPDATE SCORE
            if (myProgressScore.getInt("BEST_SCORE_INT" + 60, 0) > 0) {
                Games.Leaderboards.submitScore(googleApiClient, context.getString(R.string.one_minute),
                        myProgressScore.getInt("BEST_SCORE_INT" + 60, 0));
                if(myProgressScore.getInt("BEST_SCORE_INT" + 60, 0) >= 26000){
                    Games.Achievements.unlock(googleApiClient, context.getString(R.string.time_attack1));
                }
            }
            if(myProgressScore.getInt("BEST_SCORE_INT" + 180, 0) > 0){
                Games.Leaderboards.submitScore(googleApiClient, context.getString(R.string.three_minutes),
                        myProgressScore.getInt("BEST_SCORE_INT" + 180, 0));
                if(myProgressScore.getInt("BEST_SCORE_INT" + 180, 0) >= 140000) {
                    Games.Achievements.unlock(googleApiClient, context.getString(R.string.time_attack2));
                }
            }
            if(myProgressScore.getInt("BEST_SCORE_INT" + 300, 0) > 0){
                Games.Leaderboards.submitScore(googleApiClient, context.getString(R.string.five_minutes),
                        myProgressScore.getInt("BEST_SCORE_INT" + 300, 0));
                if(myProgressScore.getInt("BEST_SCORE_INT" + 300, 0) >= 240000) {
                    Games.Achievements.unlock(googleApiClient, context.getString(R.string.time_attack3));
                }
            }

            //UPDATE ACHIEVEMENTS

            for(int i = 1; i <= 5;i++){
                if(isUnlockedAchievement(myProgressAchievement, i)){
                    String achievement = "arcade" + i;
                    Games.Achievements.unlock(googleApiClient, context.getString(context.getResources().getIdentifier(achievement, "string",
                            context.getPackageName())));
                }
            }



        }
    }

    private boolean isUnlockedAchievement(SharedPreferences myProgressAchievement, int i) {
        return myProgressAchievement.getBoolean("arcade" + i, false);
    }

    public void unlockAchievement(Context context, int levelNumber){
        SharedPreferences myProgressScore = context.getSharedPreferences("ACHIEVEMENTS", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = myProgressScore.edit();
        switch(levelNumber){
            case 1:
                editor.putBoolean("arcade1" , true);
                editor.commit();
                break;
            case 5:
                editor.putBoolean("arcade2" , true);
                editor.commit();
                break;
            case 15:
                editor.putBoolean("arcade3" , true);
                editor.commit();
                break;
            case 30:
                editor.putBoolean("arcade4" , true);
                editor.commit();
                break;
            case 60:
                editor.putBoolean("arcade5" , true);
                editor.commit();
                break;
        }
    }

    public void saveScore(GoogleApiClient googleApiClient, Context context, int score, int LADERBOARD_ID){
        SharedPreferences myProgressScore = context.getSharedPreferences("SCOREGP", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = myProgressScore.edit();
        editor.putInt("" + LADERBOARD_ID, score);
        editor.commit();
    }

    public void levelPassed(int level, Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("LVL", Context.MODE_PRIVATE);
        int levelCountIncremented = sharedPreferences.getInt("LEVEL_COUNT", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(!sharedPreferences.getBoolean("level" + level, false)) {
            editor.putBoolean("level" + level, true);
            editor.putInt("LEVEL_COUNT", ++levelCountIncremented);
            editor.commit();
        }
    }


}
