package pl.hypeapp.fixmath;

import android.util.Log;

public class Keyboard extends PlayActivity{
    public String[][] clickTab;
    public int helperInt;

    public Keyboard(){

        clickTab = new String[6][6];
        for (int i = 0; i <= 5; i++){
            for (int z = 0; z <= 5; z++){
                clickTab[i][z] = "";
            }
        }

    }

    public String GetString(int string, int textViewX, int textViewY){
        Log.e("aa", "weszlo");
        String helper = clickTab[textViewX][textViewY];
        helperInt = helper.length();

        if(string == 10){
            if (helperInt > 0){
                Log.e("BACKSPACE", "HOPH" + clickTab[textViewX][textViewY]);
                clickTab[textViewX][textViewY] = clickTab[textViewX][textViewY].substring(0, helperInt - 1);
                Log.e("BACKSPACE", "HOPH" + clickTab[textViewX][textViewY]);
                helper = clickTab[textViewX][textViewY];
                helperInt = helper.length();
                Log.e("helperint", ""+ helperInt);
                return clickTab[textViewX][textViewY];
            }else{
                helper = clickTab[textViewX][textViewY];
                helperInt = helper.length();
                Log.e("helperint1", ""+ helperInt);
                return clickTab[textViewX][textViewY];
            }
        }


        if(helperInt == 3){
            return clickTab[textViewX][textViewY];
        }else
        {
            clickTab[textViewX][textViewY] += string;
            Log.e("drumdrum", "" +  helperInt + " " + clickTab[textViewX][textViewY]);
            return clickTab[textViewX][textViewY];
        }



    }

}
