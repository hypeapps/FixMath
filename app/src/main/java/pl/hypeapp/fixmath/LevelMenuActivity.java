package pl.hypeapp.fixmath;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class LevelMenuActivity extends AppCompatActivity {

    ViewPager viewPager;
    SFXManager sfxManager;
    ImageUtil imageUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_menu);

        SharedPreferences sharedPref = getSharedPreferences("SOUNDS", MODE_PRIVATE);
        sfxManager = new SFXManager(this, sharedPref.getBoolean("ISMUTE", false));

        ImageView background = (ImageView) findViewById(R.id.level_menu_background_image);
        imageUtil = (ImageUtil)getApplication();
        imageUtil.setImageFirst(background, R.drawable.level_background);

        ImageView v = (ImageView) findViewById(R.id.dot_level_1);
        v.setImageResource(R.drawable.yellow_dot);
        viewPager = (ViewPager) findViewById(R.id.viewPagerLevel);
        pl.hypeapp.fixmath.LevelPagerAdapter pagerAdapter = new pl.hypeapp.fixmath.LevelPagerAdapter(getSupportFragmentManager());
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                sfxManager.NewLineFigureClickPlay();
                manageDotToPage(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setAdapter(pagerAdapter);

        setLevelCountTextView();

    }

    void setLevelCountTextView(){
        SharedPreferences sharedPreferences = getSharedPreferences("LVL", MODE_PRIVATE);
        String levelCompleteNumber = String.valueOf(sharedPreferences.getInt("LEVEL_COUNT", 0));
        TextView textView = (TextView) findViewById(R.id.level_count_text_view);
        textView.setText(levelCompleteNumber + "/60");
    }

    void manageDotToPage(int actualPage){
        switch (actualPage) {
            case 0:
                ImageView v = (ImageView) findViewById(R.id.dot_level_1);
                v.setImageResource(R.drawable.yellow_dot);
                YoYo.with(Techniques.Landing)
                        .duration(1000)
                        .playOn(v);
                v = (ImageView) findViewById(R.id.dot_level_2);
                v.setImageResource(R.drawable.gray_dot);
                v = (ImageView) findViewById(R.id.dot_level_3);
                v.setImageResource(R.drawable.gray_dot);
                v = (ImageView) findViewById(R.id.dot_level_4);
                v.setImageResource(R.drawable.gray_dot);
                break;
            case 1:
                v = (ImageView) findViewById(R.id.dot_level_1);
                v.setImageResource(R.drawable.gray_dot);
                v = (ImageView) findViewById(R.id.dot_level_2);
                v.setImageResource(R.drawable.yellow_dot);
                YoYo.with(Techniques.Landing)
                        .duration(1000)
                        .playOn(v);
                v = (ImageView) findViewById(R.id.dot_level_3);
                v.setImageResource(R.drawable.gray_dot);
                v = (ImageView) findViewById(R.id.dot_level_4);
                v.setImageResource(R.drawable.gray_dot);
                break;
            case 2:
                v = (ImageView) findViewById(R.id.dot_level_1);
                v.setImageResource(R.drawable.gray_dot);
                v = (ImageView) findViewById(R.id.dot_level_2);
                v.setImageResource(R.drawable.gray_dot);
                v = (ImageView) findViewById(R.id.dot_level_3);
                v.setImageResource(R.drawable.yellow_dot);
                YoYo.with(Techniques.Landing)
                        .duration(1000)
                        .playOn(v);
                v = (ImageView) findViewById(R.id.dot_level_4);
                v.setImageResource(R.drawable.gray_dot);
                break;
            case 3:
                v = (ImageView) findViewById(R.id.dot_level_1);
                v.setImageResource(R.drawable.gray_dot);
                v = (ImageView) findViewById(R.id.dot_level_2);
                v.setImageResource(R.drawable.gray_dot);
                v = (ImageView) findViewById(R.id.dot_level_3);
                v.setImageResource(R.drawable.gray_dot);
                v = (ImageView) findViewById(R.id.dot_level_4);
                v.setImageResource(R.drawable.yellow_dot);
                YoYo.with(Techniques.Landing)
                        .duration(1000)
                        .playOn(v);
                break;

        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        imageUtil.unbindDrawables(findViewById(R.id.level_menu_layout));
        System.gc();
    }

    public void bckMenu(View view) {
        sfxManager.KeyboardClickPlay(true);
        Intent i = new Intent(LevelMenuActivity.this, MenuActivity.class);
        startActivity(i);
        finish();
    }

    public void playLevel(View view) {
        sfxManager.KeyboardClickPlay(true);
        String tag = (String) view.getTag();
        int tagInt = Integer.parseInt(tag);
        Intent i;
        Log.e("TAG", tag);

        if(tagInt == 1) {
            i = new Intent(LevelMenuActivity.this, TutorialActivity.class);
        }else{
            i = new Intent(LevelMenuActivity.this, PlayActivity.class);
        }
        i.putExtra("LEVEL", tagInt);
        startActivity(i);
        finish();



    }

    public void setLevelsViews(){
        SharedPreferences sharedPreferences = getSharedPreferences("LVL", MODE_PRIVATE);
        TextView levelView;
        int levels = sharedPreferences.getInt("LEVEL_COUNT", 0);

        if(levels == 0){
            levelView = (TextView) findViewById(R.id.level1);
            levelView.setBackgroundResource(R.drawable.level_button);
            levelView.setClickable(true);
        }else {
            for (int i = 1; i <= levels + 3; i++) {
                if (sharedPreferences.getBoolean("level" + i, false)) {
                    String id = "level" + i;
                    int resourceId = getResources().getIdentifier(id, "id", getPackageName());
                    levelView = (TextView) findViewById(resourceId);
                    levelView.setBackgroundResource(R.drawable.levelcorrect_button);
                    levelView.setClickable(true);
                } else {
                    String id = "level" + i;
                    int resourceId = getResources().getIdentifier(id, "id", getPackageName());
                    levelView = (TextView) findViewById(resourceId);
                    levelView.setBackgroundResource(R.drawable.level_button);
                    levelView.setClickable(true);
                }
            }
        }


    }



    @Override
    public void onBackPressed() {
        Intent i = new Intent(LevelMenuActivity.this, MenuActivity.class);
        startActivity(i);
        finish();
    }
}
