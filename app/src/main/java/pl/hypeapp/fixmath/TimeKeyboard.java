package pl.hypeapp.fixmath;;

import android.util.Log;

public class TimeKeyboard {
    public String[] TimeTab;
    public int helperInt;

    public TimeKeyboard() {

        TimeTab = new String[6];
        for (int i = 0; i <= 5; i++) {

            TimeTab[i] = "";

        }

    }

    public String GetString(int string, int indexTab) {
        Log.e("aa", "weszlo");
        String helper = TimeTab[indexTab];
        helperInt = helper.length();

        if (string == 10) {
            if (helperInt > 0) {
//                Log.e("BACKSPACE", "HOPH" + clickTab[textViewX][textViewY]);
                TimeTab[indexTab] = TimeTab[indexTab].substring(0, helperInt - 1);
//                Log.e("BACKSPACE", "HOPH" + clickTab[textViewX][textViewY]);
                helper = TimeTab[indexTab];
                helperInt = helper.length();
                Log.e("helperint", "" + helperInt);
                return TimeTab[indexTab];
            } else {
                helper = TimeTab[indexTab];
                helperInt = helper.length();
                Log.e("helperint1", "" + helperInt);
                return TimeTab[indexTab];
            }
        }


        if (helperInt == 3) {
            return TimeTab[indexTab];
        } else {
            TimeTab[indexTab] += string;
            //Log.e("drumdrum", "" +  helperInt + " " + clickTab[textViewX][textViewY]);
            return TimeTab[indexTab];
        }

    }
}
