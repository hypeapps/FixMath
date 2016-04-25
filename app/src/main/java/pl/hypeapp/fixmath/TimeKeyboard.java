package pl.hypeapp.fixmath;;import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;


public class TimeKeyboard {
    public String[] TimeTab;
    public int helperInt;
    Context context;
    SFXManager sfxManager;



    public TimeKeyboard(Context context, SFXManager sfxmanager){
        this.context = context;
        this.sfxManager = sfxmanager;
        TimeTab = new String[6];
        for (int i = 0; i <= 5; i++) {

            TimeTab[i] = "";

        }


    }

    public void PrintNumbersInFigures(int number, View viewClicked){
        String tag =  viewClicked.getTag().toString();

        String numberToString = Integer.toString(number);




        if(tag != null) {
                for (int x = 0; x <= 4; x++) {
                    String TextViewId = "t_var" + x ;

                    int id = context.getResources().getIdentifier(TextViewId, "id", context.getPackageName());
                    TextView allTextContainer = (TextView) ((Activity)context).getWindow().getDecorView().findViewById(id);

                    String ImageViewId = "t_var_ImageView_" + x ;

                    int IMid = context.getResources().getIdentifier(ImageViewId, "id", context.getPackageName());
                    ImageView ImageViewContainer = (ImageView) ((Activity)context).getWindow().getDecorView().findViewById(IMid);

                    if(allTextContainer.getTag() != null) {
                        String containerTags = allTextContainer.getTag().toString();

                        if (containerTags.equals(tag)) {

                            allTextContainer.setText(TimeTab[x] + "" +  numberToString);
                            WritneAnim(ImageViewContainer);


                            if(allTextContainer.getText().length() < 2){
                                allTextContainer.setTextSize(30);
                            }else if(allTextContainer.getText().length() == 2){
                                allTextContainer.setTextSize(19);
                            }
                            TimeTab[x] += numberToString;
                            helperInt = TimeTab[x].length();
                        }
                    }

                }
            }


    }

    public void BackSpaceNumbersInFigures(TextView viewClicked){
        String tag =  viewClicked.getTag().toString();

        if(!viewClicked.getText().equals("")) {
            for (int x = 0; x <= 4; x++) {
                String TextViewId = "t_var" + x ;

                int id = context.getResources().getIdentifier(TextViewId, "id", context.getPackageName());
                TextView allTextContainer = (TextView) ((Activity)context).getWindow().getDecorView().findViewById(id);



                if(allTextContainer.getTag() != null) {
                    String containerTags = allTextContainer.getTag().toString();

                    if (containerTags.equals(tag)) {

                        allTextContainer.setText("");
                        BackSpaceAnim(allTextContainer);

                        allTextContainer.setTextSize(30);

                        TimeTab[x] = "";
                        helperInt = TimeTab[x].length();
                    }
                }

            }
        }else{
            View keyboardView = ((Activity)context).getWindow().getDecorView().findViewById(R.id.t_keyboard);
            YoYo.with(Techniques.Shake)
                    .duration(400)
                    .playOn(keyboardView);
            sfxManager.KeyboardErrorPlay();
        }


    }

    public void BackSpaceAnim(TextView textView){
        YoYo.with(Techniques.Swing)
                .duration(500)
                .playOn(textView);
    }

    public void WritneAnim(ImageView textView){
        YoYo.with(Techniques.RubberBand)
                .duration(500)
                .playOn(textView);
    }

    public String GetString(int string, int indexTab) {

        String helper = TimeTab[indexTab];
        helperInt = helper.length();

        if (string == 10) {
            if (helperInt > 0) {

                TimeTab[indexTab] = TimeTab[indexTab].substring(0, helperInt - 1);
                helper = TimeTab[indexTab];
                helperInt = helper.length();

                return TimeTab[indexTab];
            } else {
                helper = TimeTab[indexTab];
                helperInt = helper.length();

                return TimeTab[indexTab];
            }
        }


        if (helperInt == 3) {
            return TimeTab[indexTab];
        } else {
            TimeTab[indexTab] += string;
            return TimeTab[indexTab];
        }

    }
}
