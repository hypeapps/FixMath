package pl.hypeapp.fixmath;;


import android.util.Log;

public class Logic {

    private int UpLine;
    private int DownLine;
    private String[] FirstLineAnswer;
    private String[] SecondLineAnswer;
    private String[] ThirdLineAnswer;
    private String[] FourLineAnswer;
    private String[] FiveLineAnswer;
    public String[] timeLineAnswer;
    private int helper = 0;

    private boolean isUpLineSet = false;

    public Logic(){}

    public Logic(String LineAnswer[]){
        this.timeLineAnswer = LineAnswer;
    }

    public Logic(int upLine, String firstLineAnswer[]){
        this.UpLine = upLine;
        this.FirstLineAnswer = firstLineAnswer;
    }
    public Logic(int upLine, String firstLineAnswer[], String secondLineAnswer[]){
        this(upLine,firstLineAnswer);
        this.SecondLineAnswer = secondLineAnswer;

    }
    public Logic(int upLine, String firstLineAnswer[], String secondLineAnswer[], String thirdLineAnswer[]){
        this(upLine, firstLineAnswer, secondLineAnswer);
        this.ThirdLineAnswer = thirdLineAnswer;
    }
    public Logic(int upLine, String firstLineAnswer[], String secondLineAnswer[],String thirdLineAnswer[], String fourLineAnswer[]){
        this(upLine, firstLineAnswer, secondLineAnswer, thirdLineAnswer);
        this.FourLineAnswer = fourLineAnswer;
    }
    public Logic(int upLine, String firstLineAnswer[], String secondLineAnswer[], String thirdLineAnswer[], String fourLineAnswer[],
                 String fiveLineAnswer[]){
        this(upLine, firstLineAnswer, secondLineAnswer, thirdLineAnswer, fourLineAnswer);
        this.FiveLineAnswer = fiveLineAnswer;
    }

    public void setLogic(int UpLine, int numberLine, String answers[]){

            this.UpLine = UpLine;

        switch (numberLine){
            case 1:
                this.FirstLineAnswer = answers;

                break;
            case 2:
                this.SecondLineAnswer = answers;

                break;
            case 3:
                this.ThirdLineAnswer = answers;

                break;
            case 4:
                this.FourLineAnswer = answers;

                break;
            case 5:
                this.FiveLineAnswer = answers;

                break;
        }
    }

    public boolean checkFirstLine(Keyboard keyboard){

        for (int i = 0; i < FirstLineAnswer.length; i++){
            if (FirstLineAnswer[i].equals(keyboard.clickTab[1][i])){
                helper++;
                Log.e("LOGIC", " FIRSTLINE LOOP" + i + " HELPER W LOOP: " + helper);
            }
        }

        if(helper == FirstLineAnswer.length){
            Log.e("LOGIC", " JESTEM FIRSTLINE /helper " + helper);
            helper = 0;
            return true;
        }
        helper = 0;
        return false;
    }

    public boolean checkSecondLine(Keyboard keyboard){

        for (int i = 0; i < SecondLineAnswer.length; i++){
            if (SecondLineAnswer[i].equals(keyboard.clickTab[2][i])){
                helper++;
                Log.e("LOGIC", " SECONDLINE LOOP" + i + "helper: " + helper);

            }
        }

        if(helper == SecondLineAnswer.length){
            Log.e("LOGIC", " JESTEM SECONDLINE /helper " + helper);
            helper = 0;
            return true;
        }
        helper = 0;
        return false;
    }

    public boolean checkThirdLine(Keyboard keyboard){
        for (int i = 0; i < ThirdLineAnswer.length ; i++){
            if (ThirdLineAnswer[i].equals(keyboard.clickTab[3][i])){
                helper++;
                Log.e("LOGIC", " THIRDLINE LOOP " + i + " helper: " + helper);

            }
        }

        if(helper == ThirdLineAnswer.length){
            Log.e("LOGIC", " JESTEM THIRDLINE /helper " + helper);
            helper = 0;
            return true;
        }
        helper = 0;
        return false;
    }

    public boolean checkFourLine(Keyboard keyboard){

        for (int i = 0; i < FourLineAnswer.length; i++){
            if (FourLineAnswer[i].equals(keyboard.clickTab[4][i])){
                helper++;
                Log.e("LOGIC", " 4 LOOP" + i + "helper: " + helper);

            }
        }

        if(helper == FourLineAnswer.length){
            Log.e("LOGIC", " JESTEM 4 /helper " + helper);
            helper = 0;
            return true;
        }
        helper = 0;
        return false;
    }

    public boolean checkFiveLine(Keyboard keyboard){

        for (int i = 0; i < FiveLineAnswer.length; i++){
            if (FiveLineAnswer[i].equals(keyboard.clickTab[5][i])){
                helper++;
                Log.e("LOGIC", " 5 LOOP" + i + "helper: " + helper);

            }
        }

        if(helper == FiveLineAnswer.length){
            Log.e("LOGIC", " JESTEM 5 /helper " + helper);
            helper = 0;
            return true;
        }
        helper = 0;
        return false;
    }

    public boolean checkTimeLine(TimeKeyboard keyboard){
        for (int i = 0; i < this.timeLineAnswer.length; i++){
            if (this.timeLineAnswer[i].equals(keyboard.TimeTab[i])){
                helper++;
                Log.e("LOGIC", " 5 LOOP" + i + "helper: " + helper);

            }
        }

        if(helper == this.timeLineAnswer.length){
            Log.e("LOGIC", " JESTEM 5 /helper " + helper);
            helper = 0;
            return true;
        }
        helper = 0;
        return false;
    }

}
