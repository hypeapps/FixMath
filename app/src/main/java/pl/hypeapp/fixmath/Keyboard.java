package pl.hypeapp.fixmath;


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

        String helper = clickTab[textViewX][textViewY];
        helperInt = helper.length();

        if(string == 10){
            if (helperInt > 0){

                clickTab[textViewX][textViewY] = clickTab[textViewX][textViewY].substring(0, helperInt - 1);

                helper = clickTab[textViewX][textViewY];
                helperInt = helper.length();

                return clickTab[textViewX][textViewY];
            }else{
                helper = clickTab[textViewX][textViewY];
                helperInt = helper.length();
                return clickTab[textViewX][textViewY];
            }
        }


        if(helperInt == 3){
            return clickTab[textViewX][textViewY];
        }else
        {
            clickTab[textViewX][textViewY] += string;

            return clickTab[textViewX][textViewY];
        }



    }

}
