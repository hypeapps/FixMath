package pl.hypeapp.fixmath;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by PrzemekEnterprise on 09.04.2016.
 */
public class ImageUtil extends Application {

    private ImageView bgimg;
    private Bitmap background; // background in the Bitmap format
    private BitmapDrawable bg; // background in the Drawable format

    private ImageView bgimg1;
    private Bitmap background1; // background in the Bitmap format
    private BitmapDrawable bg1; // background in the Drawable format



    public void loadBackground(int id) {
        background = BitmapFactory.decodeStream(getResources().openRawResource(id));
        bg = new BitmapDrawable(getResources(), background);
        bgimg.setImageDrawable(bg);
    }

    public void unloadBackground() {
        if (bgimg != null)
            bgimg.setImageDrawable(null);
        if (bg != null) {
            background.recycle();
        }
        bg = null;
    }

    public void setImageFirst(ImageView i, int sourceId) {
        unloadBackground();
        bgimg = i;
        loadBackground(sourceId);
    }

    public void loadBackgroundSecond(int id) {
        background1 = BitmapFactory.decodeStream(getResources().openRawResource(id));
        bg1 = new BitmapDrawable(getResources(), background1);
        bgimg1.setImageDrawable(bg1);
    }

    public void unloadBackgroundSecond() {
        if (bgimg1 != null)
            bgimg1.setImageDrawable(null);
        if (bg1 != null) {
            background1.recycle();
        }
        bg1 = null;
    }

    public void setImageSecond(ImageView i, int sourceId) {
        unloadBackgroundSecond();
        bgimg1 = i;
        loadBackgroundSecond(sourceId);
    }




    public void unbindDrawables(View view) {
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
}
