package pl.hypeapp.fixmath;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by PrzemekEnterprise on 06.04.2016.
 */
public class TutorialActivity extends Activity {

    ImageUtil imageUtil;

    SFXManager sfxManager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_layout);


        ImageView background = (ImageView) findViewById(R.id.tutorial_background_image);
        imageUtil = (ImageUtil) getApplication();
        imageUtil.setImageSecond(background,R.drawable.tutorial);

        SharedPreferences sharedPref = getSharedPreferences("SOUNDS", MODE_PRIVATE);
        sfxManager = new SFXManager(this, sharedPref.getBoolean("ISMUTE", false));
    }


    public void OkeyButton(View view) {
        sfxManager.KeyboardClickPlay(true);
        Intent i = new Intent(TutorialActivity.this, PlayActivity.class);
        i.putExtra("LEVEL", 1);
        startActivity(i);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        imageUtil.unbindDrawables(findViewById(R.id.tutorial_layout));
        System.gc();
    }

}
