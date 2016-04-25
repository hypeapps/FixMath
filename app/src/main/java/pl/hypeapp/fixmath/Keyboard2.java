package pl.hypeapp.fixmath;

import android.app.Activity;

import android.content.Context;

import android.view.View;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

/**
 * Created by PrzemekEnterprise on 23.04.2016.
 */
public class Keyboard2 {
    public String[][] clickTab;
    Context context;
    int upLine, downLine;
    public int helperInt;
    SFXManager sfxManager;


    public Keyboard2(Context context, int upLine, int downLine, SFXManager sfxmanager){
        this.context = context;
        this.upLine = upLine;
        this.downLine = downLine;
        this.sfxManager = sfxmanager;
        clickTab = new String[6][6];
        for (int i = 0; i <= 5; i++){
            for (int z = 0; z <= 5; z++){
                clickTab[i][z] = "";
            }
        }


    }

    public void PrintNumbersInFigures(int number, View viewClicked){
        String tag =  viewClicked.getTag().toString();
        String numberToString = Integer.toString(number);




        if(tag != null) {
            for (int i = upLine; i <= downLine; i++) {
                for (int x = 0; x <= 4; x++) {
                    String TextViewId = "var" + i + "x" + x;
                    int id = context.getResources().getIdentifier(TextViewId, "id", context.getPackageName());
                    TextView allTextContainer = (TextView) ((Activity)context).getWindow().getDecorView().findViewById(id);
                    if(allTextContainer.getTag() != null) {
                        String containerTags = allTextContainer.getTag().toString();

                        if (containerTags.equals(tag)) {

                            allTextContainer.setText(clickTab[i][x] + "" +  numberToString);
                            WritneAnim(allTextContainer);


                            if(allTextContainer.getText().length() < 2){
                                allTextContainer.setTextSize(30);
                            }else if(allTextContainer.getText().length() == 2){
                                allTextContainer.setTextSize(19);
                            }
                            clickTab[i][x] += numberToString;
                            helperInt = clickTab[i][x].length();
                        }
                    }

                }
            }
        }

    }

    public void BackspaceNumbersInFigures(TextView viewClicked){
        String tag =  viewClicked.getTag().toString();



        if(!viewClicked.getText().equals("")) {
            for (int i = upLine; i <= downLine; i++) {
                for (int x = 0; x <= 4; x++) {
                    String TextViewId = "var" + i + "x" + x;

                    int id = context.getResources().getIdentifier(TextViewId, "id", context.getPackageName());
                    TextView allTextContainer = (TextView) ((Activity)context).getWindow().getDecorView().findViewById(id);
                    if(allTextContainer.getTag() != null) {
                        String containerTags = allTextContainer.getTag().toString();

                        if (containerTags.equals(tag)) {

                            allTextContainer.setText("");
                            BackspaceAnim(allTextContainer);

                            allTextContainer.setTextSize(30);

                            clickTab[i][x] = "";
                            helperInt = clickTab[i][x].length();
                        }
                    }

                }
            }
        }else{
            YoYo.with(Techniques.Shake)
                    .duration(400)
                    .playOn(((Activity)context).getWindow().getDecorView().findViewById(R.id.keyboard));
            sfxManager.KeyboardErrorPlay();
        }

    }

    public void WritneAnim(TextView textView){
        YoYo.with(Techniques.RubberBand)
                .duration(500)
                .playOn(textView);
    }

    public void BackspaceAnim(TextView textView){
        YoYo.with(Techniques.Swing)
                .duration(500)
                .playOn(textView);
    }
}
