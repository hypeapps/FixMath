package pl.hypeapp.fixmath;;


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
