package pl.hypeapp.fixmath;



import java.util.ArrayList;




public class Level {

    private int NumberLevel;
    private int UpLine;
    private int DownLine;
    private ArrayList<String[]> Variables= new ArrayList<>();
    private ArrayList<String[]> Symbols = new ArrayList<>();
    private ArrayList<String> Result = new ArrayList<>();
    private ArrayList<Integer> ColumnStart = new ArrayList<>();
    private ArrayList<Integer> LineStart= new ArrayList<>();
    private ArrayList<String[]> Figures = new ArrayList<>();
    public ArrayList<String> CorrectFigures = new ArrayList<>();
    private ArrayList<String> ResultTexts = new ArrayList<>();
    public int HowManyLines;



    char divCh = '\u00F7', multCh = '\u00D7';
    String divideCh = String.valueOf(divCh),
            multiplerCh = String.valueOf(multCh);


    public Level(int numberLevel){

        this.Variables= new ArrayList<>();
        this.Symbols = new ArrayList<>();
        this.Result = new ArrayList<>();
        this.ColumnStart = new ArrayList<>();
        this.LineStart = new ArrayList<>();
        this.Figures = new ArrayList<>();

        this.NumberLevel = numberLevel;
        switch (numberLevel){
            case 1:
                Level1();
                break;
            case 2:
                Level2();
                break;
            case 3:
                Level3();
                break;
            case 4:
                Level4();
                break;
            case 5:
                Level5();
                break;
            case 6:
                Level6();
                break;
            case 7:
                Level7();
                break;
            case 8:
                Level8();
                break;
            case 9:
                Level9();
                break;
            case 10:
                Level10();
                break;
            case 11:
                Level11();
                break;
            case 12:
                Level12();
                break;
            case 13:
                Level13();
                break;
            case 14:
                Level14();
                break;
            case 15:
                Level15();
                break;
            case 16:
                Level16();
                break;
            case 17:
                Level17();
                break;
            case 18:
                Level18();
                break;
            case 19:
                Level19();
                break;
            case 20:
                Level20();
                break;
            case 21:
                Level21();
                break;
            case 22:
                Level22();
                break;
            case 23:
                Level23();
                break;
            case 24:
                Level24();
                break;
            case 25:
                Level25();
                break;
            case 26:
                Level26();
                break;
            case 27:
                Level27();
                break;
            case 28:
                Level28();
                break;
            case 29:
                Level29();
                break;
            case 30:
                Level30();
                break;
            case 31:
                Level31();
                break;
            case 32:
                Level32();
                break;


        }
    }

    public int GetNumberLevel(){
        return this.NumberLevel;
    }

    public String[] GetVariables(int lineNumber){
        return this.Variables.get(lineNumber);
    }

    public String[] GetSymbols(int lineNumber){
        return this.Symbols.get(lineNumber);
    }

    public String GetResult(int lineNumber){
        return this.Result.get(lineNumber);
    }

    public int GetColumnStart(int lineNumber){
        return this.ColumnStart.get(lineNumber);
    }

    public int GetLineStart(int lineNumber){
        return this.LineStart.get(lineNumber);
    }

    public String[] GetFigures(int lineNumber){
        return this.Figures.get(lineNumber);
    }

    public int GetUpLine(){
        return this.UpLine;
    }

    public int GetDownLine(){
        return this.DownLine;
    }

    public String GetTimeAttackCorrectFigures(int lineNumber){
        return this.CorrectFigures.get(lineNumber);
    }

    public String GetResultTexts(int lineNumber){
        return this.ResultTexts.get(lineNumber);
    }

    public int GetHowManyLines(){
        return this.HowManyLines;
    }


    private void Level1(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        //  2+2=4

        this.Variables.add(new String[]{"2", "2"});
        this.Result.add("4");
        this.Symbols.add(new String[] {"+"});
        this.Figures.add(new String[] {"k", "k"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("k");
        this.ResultTexts.add("2");


        //  3+3=6

        this.Variables.add(new String[]{"3", "3"});
        this.Result.add("6");
        this.Symbols.add(new String[] {"+" });
        this.Figures.add(new String[] {"o", "o",});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("o");
        this.ResultTexts.add("3");

        //  2+3=5

        this.Variables.add(new String[]{"2", "3", "5"});
        this.Result.add("");
        this.Symbols.add(new String[] {"+"});
        this.Figures.add(new String[] {"k", "o", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("5");
        this.CorrectFigures.add("q");

    }

    private void Level2(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        //  5+5=10

        this.Variables.add(new String[]{"5", "5"});
        this.Result.add("10");
        this.Symbols.add(new String[] {"+"});
        this.Figures.add(new String[] {"oz", "oz"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("oz");
        this.ResultTexts.add("5");


        //  5+5+10=20

        this.Variables.add(new String[]{"5", "5", "10"});
        this.Result.add("20");
        this.Symbols.add(new String[] {"+", "+"});
        this.Figures.add(new String[] {"oz", "oz", "r"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("r");
        this.ResultTexts.add("10");

        //  2+3=5

        this.Variables.add(new String[]{"5", "10", "15"});
        this.Result.add("");
        this.Symbols.add(new String[] {"+"});
        this.Figures.add(new String[] {"oz", "r", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("15");
        this.CorrectFigures.add("q");

    }

    private void Level3(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        //  1+1=2

        this.Variables.add(new String[]{"1", "1"});
        this.Result.add("2");
        this.Symbols.add(new String[] {"+"});
        this.Figures.add(new String[] {"ok", "ok"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("ok");
        this.ResultTexts.add("1");


        //  2+2=4

        this.Variables.add(new String[]{"2", "2"});
        this.Result.add("4");
        this.Symbols.add(new String[] {"+"});
        this.Figures.add(new String[] {"s", "s"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("s");
        this.ResultTexts.add("2");

        //  2-1=1

        this.Variables.add(new String[]{"2", "1", "1"});
        this.Result.add("");
        this.Symbols.add(new String[] {"-"});
        this.Figures.add(new String[] {"s", "ok", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("1");
        this.CorrectFigures.add("q");

    }

    private void Level4(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        //  2+2+2=6

        this.Variables.add(new String[]{"2", "2", "2"});
        this.Result.add("6");
        this.Symbols.add(new String[] {"+","+"});
        this.Figures.add(new String[] {"o", "o", "o"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("o");
        this.ResultTexts.add("2");


        //2*2+3=7

        this.Variables.add(new String[]{"2", "2", "3"});
        this.Result.add("7");
        this.Symbols.add(new String[] {multiplerCh, "+"});
        this.Figures.add(new String[] {"o", "o", "rf"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("rf");
        this.ResultTexts.add("3");

        //  2+3+3=8

        this.Variables.add(new String[]{"2", "3", "3", "8"});
        this.Result.add("");
        this.Symbols.add(new String[] {"+","+"});
        this.Figures.add(new String[] {"o", "rf","rf", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("8");
        this.CorrectFigures.add("q");

    }

    private void Level5(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        //  3*3=9

        this.Variables.add(new String[]{"3", "3"});
        this.Result.add("9");
        this.Symbols.add(new String[] {multiplerCh});
        this.Figures.add(new String[] {"oz", "oz"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("oz");
        this.ResultTexts.add("3");


        //3+2=5

        this.Variables.add(new String[]{"3", "2"});
        this.Result.add("5");
        this.Symbols.add(new String[] { "+"});
        this.Figures.add(new String[] {"oz", "ok"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("ok");
        this.ResultTexts.add("2");

        //  3+2+2=7

        this.Variables.add(new String[]{"3", "2", "2", "7"});
        this.Result.add("");
        this.Symbols.add(new String[] {"+","+"});
        this.Figures.add(new String[] {"oz", "ok", "ok", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("7");
        this.CorrectFigures.add("q");

    }

    private void Level6(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        //  1+1+1=3

        this.Variables.add(new String[]{"1", "1", "1"});
        this.Result.add("3");
        this.Symbols.add(new String[] {"+","+"});
        this.Figures.add(new String[] {"k", "k", "k"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("k");
        this.ResultTexts.add("1");


        //1+3+3=7

        this.Variables.add(new String[]{"1", "3", "3"});
        this.Result.add("7");
        this.Symbols.add(new String[] {"+", "+"});
        this.Figures.add(new String[] {"k", "r", "r"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("r");
        this.ResultTexts.add("3");

        //  1x3x3=9

        this.Variables.add(new String[]{"1", "3", "3", "9"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh,multiplerCh});
        this.Figures.add(new String[] {"k", "r","r", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("9");
        this.CorrectFigures.add("q");

    }

    private void Level7(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        //  4+4=8

        this.Variables.add(new String[]{"4", "4"});
        this.Result.add("8");
        this.Symbols.add(new String[] {"+"});
        this.Figures.add(new String[] {"kf", "kf", "kf"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("kf");
        this.ResultTexts.add("4");


        //4+3x3=13

        this.Variables.add(new String[]{"4", "3", "3"});
        this.Result.add("13");
        this.Symbols.add(new String[] {"+", multiplerCh});
        this.Figures.add(new String[] {"kf", "rg", "rg"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("rg");
        this.ResultTexts.add("3");

        //  4x3-4=8

        this.Variables.add(new String[]{"4", "3", "4", "8"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh,"-"});
        this.Figures.add(new String[] {"kf", "rg","kf", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("8");
        this.CorrectFigures.add("q");

    }

    private void Level8(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        //  6+6+6=18

        this.Variables.add(new String[]{"6", "6", "6"});
        this.Result.add("18");
        this.Symbols.add(new String[] {"+", "+"});
        this.Figures.add(new String[] {"r", "r", "r"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("r");
        this.ResultTexts.add("6");


        //6+6+2+2=16

        this.Variables.add(new String[]{"6", "6", "2", "2"});
        this.Result.add("16");
        this.Symbols.add(new String[] {"+", "+", "+"});
        this.Figures.add(new String[] {"r", "r", "rf", "rf"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("rf");
        this.ResultTexts.add("2");

        //  6+6x2=18

        this.Variables.add(new String[]{"6", "2", "6", "18"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh, "+"});
        this.Figures.add(new String[] {"r", "r","rf", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("18");
        this.CorrectFigures.add("q");

    }

    private void Level9(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        //  7+7=14

        this.Variables.add(new String[]{"7", "7"});
        this.Result.add("14");
        this.Symbols.add(new String[] {"+"});
        this.Figures.add(new String[] {"kb", "kb"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("kb");
        this.ResultTexts.add("7");


        //7+7+3x3=23

        this.Variables.add(new String[]{"7", "7", "3", "3"});
        this.Result.add("23");
        this.Symbols.add(new String[] {"+","+", multiplerCh});
        this.Figures.add(new String[] {"kb", "kb", "s", "s"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("s");
        this.ResultTexts.add("3");

        //  3+7+3=13

        this.Variables.add(new String[]{"3", "7", "3", "13"});
        this.Result.add("");
        this.Symbols.add(new String[] {"+","+"});
        this.Figures.add(new String[] {"s", "kb","s", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("13");
        this.CorrectFigures.add("q");

    }

    private void Level10(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        //  9+9=18

        this.Variables.add(new String[]{"9", "9"});
        this.Result.add("18");
        this.Symbols.add(new String[] {"+"});
        this.Figures.add(new String[] {"ok", "ok"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("ok");
        this.ResultTexts.add("9");


        // 9+9+3=21

        this.Variables.add(new String[]{"9", "9", "3"});
        this.Result.add("21");
        this.Symbols.add(new String[] {"+","+"});
        this.Figures.add(new String[] {"ok", "ok", "o", "o"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("o");
        this.ResultTexts.add("3");

        //  9x3=27

        this.Variables.add(new String[]{"9", "3", "27"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh});
        this.Figures.add(new String[] {"ok", "o", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("27");
        this.CorrectFigures.add("q");

    }

    private void Level11(){
        this.HowManyLines = 4;
        this.UpLine = 1;
        this.DownLine = 4;

        //  8+8+8=24

        this.Variables.add(new String[]{"8", "8", "8"});
        this.Result.add("24");
        this.Symbols.add(new String[] {"+", "+" });
        this.Figures.add(new String[] {"rf", "rf", "rf"});
        this.ColumnStart.add(0);
        this.LineStart.add(1);

        this.CorrectFigures.add("rf");
        this.ResultTexts.add("8");

        //  8+8+8+8=32

        this.Variables.add(new String[]{"8", "8", "8", "8"});
        this.Result.add("32");
        this.Symbols.add(new String[] {"+", "+","+" });
        this.Figures.add(new String[] {"rf", "rf", "rf", "rf"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("rf");
        this.ResultTexts.add("8");

        //  8+4+4=16

        this.Variables.add(new String[]{"8", "4", "4"});
        this.Result.add("16");
        this.Symbols.add(new String[] {"+", "+"});
        this.Figures.add(new String[] {"rf", "s", "s"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("s");
        this.ResultTexts.add("4");


        // 4+8+4=16


        this.Variables.add(new String[]{"4", "8", "4", "16"});
        this.Result.add("");
        this.Symbols.add(new String[] {"+", "+"});
        this.Figures.add(new String[] {"s", "rf", "s", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);


        this.ResultTexts.add("16");
        this.CorrectFigures.add("q");

    }

    private void Level12(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        //  2x2x2=8

        this.Variables.add(new String[]{"2", "2", "2"});
        this.Result.add("8");
        this.Symbols.add(new String[] {multiplerCh, multiplerCh });
        this.Figures.add(new String[] {"k", "k", "k"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        //2x3x3=8
        this.CorrectFigures.add("k");
        this.ResultTexts.add("2");

        this.Variables.add(new String[]{"2", "3", "3"});
        this.Result.add("18");
        this.Symbols.add(new String[] {multiplerCh, multiplerCh });
        this.Figures.add(new String[] {"k", "s", "s"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        //2+3=5
        this.CorrectFigures.add("s");
        this.ResultTexts.add("3");

        this.Variables.add(new String[]{"2", "3", "5"});
        this.Result.add("");
        this.Symbols.add(new String[] {"+"});
        this.Figures.add(new String[] {"k", "s" , "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("5");
        this.CorrectFigures.add("q");

    }

    private void Level13(){
        this.HowManyLines = 4;
        this.UpLine = 1;
        this.DownLine = 4;

        //  5+5+5-5=15

        this.Variables.add(new String[]{"5", "5", "5","5"});
        this.Result.add("15");
        this.Symbols.add(new String[] {"+", "+" ,"-"});
        this.Figures.add(new String[] {"oz", "oz", "oz","oz"});
        this.ColumnStart.add(0);
        this.LineStart.add(1);

        this.CorrectFigures.add("oz");
        this.ResultTexts.add("5");

        //  5+5+5-3=12

        this.Variables.add(new String[]{"5", "5", "5", "3"});
        this.Result.add("12");
        this.Symbols.add(new String[] {"+", "+", "-" });
        this.Figures.add(new String[] {"oz", "oz", "oz", "kf"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("kf");
        this.ResultTexts.add("3");

        //  3+3+3-5=4

        this.Variables.add(new String[]{"3", "3", "3","5"});
        this.Result.add("4");
        this.Symbols.add(new String[] {"+", "+","-"});
        this.Figures.add(new String[] {"kf", "kf", "kf", "oz"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("kf");
        this.ResultTexts.add("3");


        // 5-3=2


        this.Variables.add(new String[]{"5", "3", "2"});
        this.Result.add("");
        this.Symbols.add(new String[] {"-"});
        this.Figures.add(new String[] {"oz", "kf", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);


        this.ResultTexts.add("2");
        this.CorrectFigures.add("q");

    }

    private void Level14(){
        this.HowManyLines = 4;
        this.UpLine = 1;
        this.DownLine = 4;

        //  4+4+4=12

        this.Variables.add(new String[]{"4", "4", "4"});
        this.Result.add("12");
        this.Symbols.add(new String[] {"+", "+" });
        this.Figures.add(new String[] {"r", "r", "r"});
        this.ColumnStart.add(0);
        this.LineStart.add(1);

        this.CorrectFigures.add("r");
        this.ResultTexts.add("4");

        //  2x2x2+4

        this.Variables.add(new String[]{"2", "2", "2", "4"});
        this.Result.add("12");
        this.Symbols.add(new String[] {multiplerCh, multiplerCh, "+" });
        this.Figures.add(new String[] {"k", "k", "k", "r"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("k");
        this.ResultTexts.add("2");

        //  4+3x3=13

        this.Variables.add(new String[]{"4", "3", "3"});
        this.Result.add("13");
        this.Symbols.add(new String[] {"+", multiplerCh});
        this.Figures.add(new String[] {"r", "s", "s",});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("s");
        this.ResultTexts.add("3");


        // 4+2+3=9


        this.Variables.add(new String[]{"4", "2", "3","9"});
        this.Result.add("");
        this.Symbols.add(new String[] {"+","+"});
        this.Figures.add(new String[] {"r", "k", "s", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);


        this.ResultTexts.add("9");
        this.CorrectFigures.add("q");

    }

    private void Level15(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        //  7+7+7=21

        this.Variables.add(new String[]{"7", "7", "7"});
        this.Result.add("21");
        this.Symbols.add(new String[] {"+", "+" });
        this.Figures.add(new String[] {"kb", "kb", "kb"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        //4+4+4+7=19
        this.CorrectFigures.add("kb");
        this.ResultTexts.add("7");

        this.Variables.add(new String[]{"7", "4", "4", "4"});
        this.Result.add("19");
        this.Symbols.add(new String[] {"+", "+", "+" });
        this.Figures.add(new String[] {"kb", "rg", "rg", "rg"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        //7x4=28
        this.CorrectFigures.add("rg");
        this.ResultTexts.add("4");

        this.Variables.add(new String[]{"7", "4", "28"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh});
        this.Figures.add(new String[] {"kb", "rg" , "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("28");
        this.CorrectFigures.add("q");

    }

    private void Level16(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        //  3-3+3+3=6

        this.Variables.add(new String[]{"3", "3", "3", "3"});
        this.Result.add("6");
        this.Symbols.add(new String[] {"-", "+", "+"});
        this.Figures.add(new String[] {"k", "k", "k", "k"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("k");
        this.ResultTexts.add("3");


        // 2-2+2+2=4

        this.Variables.add(new String[]{"2", "2", "2" , "2"});
        this.Result.add("4");
        this.Symbols.add(new String[] {"-", "+", "+"});
        this.Figures.add(new String[] {"kf", "kf", "kf", "kf"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("kf");
        this.ResultTexts.add("2");

        //  3-2+3+2=6

        this.Variables.add(new String[]{"3", "2", "3", "2" , "6"});
        this.Result.add("");
        this.Symbols.add(new String[] {"-", "+" , "+"});
        this.Figures.add(new String[] {"k", "kf", "k", "kf", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("6");
        this.CorrectFigures.add("q");

    }

    private void Level17(){
        this.HowManyLines = 4;
        this.UpLine = 1;
        this.DownLine = 4;

        //  3x3x3=27

        this.Variables.add(new String[]{"3", "3", "3"});
        this.Result.add("27");
        this.Symbols.add(new String[] {multiplerCh, multiplerCh });
        this.Figures.add(new String[] {"k", "k", "k"});
        this.ColumnStart.add(0);
        this.LineStart.add(1);

        //  2x2x2x3=24

        this.CorrectFigures.add("k");
        this.ResultTexts.add("3");

        this.Variables.add(new String[]{"2", "2", "2", "3"});
        this.Result.add("24");
        this.Symbols.add(new String[] {multiplerCh, multiplerCh, multiplerCh });
        this.Figures.add(new String[] {"s", "s", "s", "k"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        //  3x2x4x4=96

        this.CorrectFigures.add("s");
        this.ResultTexts.add("2");

        this.Variables.add(new String[]{"3", "2", "4", "4"});
        this.Result.add("96");
        this.Symbols.add(new String[] {multiplerCh, multiplerCh, multiplerCh });
        this.Figures.add(new String[] {"k", "s", "o", "o"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        // 4+3x2=10

        this.CorrectFigures.add("o");
        this.ResultTexts.add("4");

        this.Variables.add(new String[]{"4", "3", "2","10"});
        this.Result.add("");
        this.Symbols.add(new String[] {"+", multiplerCh });
        this.Figures.add(new String[] {"o", "k", "s", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);


        this.ResultTexts.add("10");
        this.CorrectFigures.add("q");

    }

    private void Level18(){
        this.HowManyLines = 4;
        this.UpLine = 1;
        this.DownLine = 4;

        //  5x5-5=20

        this.Variables.add(new String[]{"5", "5", "5"});
        this.Result.add("20");
        this.Symbols.add(new String[] {multiplerCh , "-" });
        this.Figures.add(new String[] {"o", "o", "o"});
        this.ColumnStart.add(0);
        this.LineStart.add(1);

        this.CorrectFigures.add("o");
        this.ResultTexts.add("5");

        //  5/5+5=6

        this.Variables.add(new String[]{"5", "5", "5"});
        this.Result.add("6");
        this.Symbols.add(new String[] {divideCh, "+" });
        this.Figures.add(new String[] {"o", "o", "o"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("o");
        this.ResultTexts.add("5");

        //  5x4+4=24

        this.Variables.add(new String[]{"5", "4", "4"});
        this.Result.add("24");
        this.Symbols.add(new String[] {multiplerCh, "+"});
        this.Figures.add(new String[] {"o", "s", "s"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("s");
        this.ResultTexts.add("4");


        // 5x4/4=5


        this.Variables.add(new String[]{"5", "4", "4","5"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh,divideCh});
        this.Figures.add(new String[] {"o", "s", "s", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);


        this.ResultTexts.add("5");
        this.CorrectFigures.add("q");

    }

    private void Level19(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        //  4x4+4=20

        this.Variables.add(new String[]{"4", "4", "4"});
        this.Result.add("20");
        this.Symbols.add(new String[] {multiplerCh, "+"});
        this.Figures.add(new String[] {"rf", "rf", "rf"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("rf");
        this.ResultTexts.add("4");


        // 20+20+4=44

        this.Variables.add(new String[]{"20", "20", "4" });
        this.Result.add("44");
        this.Symbols.add(new String[] {"+", "+"});
        this.Figures.add(new String[] {"oz", "oz", "rf"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("oz");
        this.ResultTexts.add("20");

        //  20x4=80

        this.Variables.add(new String[]{"20" , "4", "80"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh});
        this.Figures.add(new String[] {"oz", "rf", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("80");
        this.CorrectFigures.add("q");

    }

    private void Level20(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        //  2*2+2*2=8

        this.Variables.add(new String[]{"2", "2", "2","2"});
        this.Result.add("8");
        this.Symbols.add(new String[] {multiplerCh, "+", multiplerCh});
        this.Figures.add(new String[] {"ok", "ok", "ok", "ok"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("ok");
        this.ResultTexts.add("2");


        // 2*2+3*3=13

        this.Variables.add(new String[]{"2", "2", "3", "3"});
        this.Result.add("13");
        this.Symbols.add(new String[] {multiplerCh, "+", multiplerCh});
        this.Figures.add(new String[] {"ok", "ok", "r", "r"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("r");
        this.ResultTexts.add("3");

        //  3x2+3x2=12

        this.Variables.add(new String[]{"3" , "2", "3", "2", "12"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh,"+", multiplerCh});
        this.Figures.add(new String[] {"r", "ok", "r", "ok", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("12");
        this.CorrectFigures.add("q");

    }

    private void Level21(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        //  9x9=81
        this.Variables.add(new String[]{"9", "9"});
        this.Result.add("81");
        this.Symbols.add(new String[] {multiplerCh});
        this.Figures.add(new String[] {"kf", "kf"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("kf");
        this.ResultTexts.add("9");


        // 9x9/3=27

        this.Variables.add(new String[]{"9", "9", "3"});
        this.Result.add("27");
        this.Symbols.add(new String[] {multiplerCh, divideCh});
        this.Figures.add(new String[] {"kf", "kf", "o"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("o");
        this.ResultTexts.add("3");

        //  9x3x3+3=84

        this.Variables.add(new String[]{"9" , "3", "3", "3", "84"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh, multiplerCh, "+"});
        this.Figures.add(new String[] {"kf", "o", "o", "o", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("84");
        this.CorrectFigures.add("q");

    }

    private void Level22(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        //  5/5+5=6
        this.Variables.add(new String[]{"5", "5", "5"});
        this.Result.add("6");
        this.Symbols.add(new String[] {divideCh,"+"});
        this.Figures.add(new String[] {"oz", "oz", "oz"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("oz");
        this.ResultTexts.add("5");


        // 10/5+5=7

        this.Variables.add(new String[]{"10", "5", "5"});
        this.Result.add("7");
        this.Symbols.add(new String[] {divideCh, "+"});
        this.Figures.add(new String[] {"rf", "oz", "oz"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("rf");
        this.ResultTexts.add("10");

        //  10x5+10=60

        this.Variables.add(new String[]{"10" , "5", "10", "60"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh, "+"});
        this.Figures.add(new String[] {"rf", "oz", "rf", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("60");
        this.CorrectFigures.add("q");

    }

    private void Level23(){
        this.HowManyLines = 4;
        this.UpLine = 1;
        this.DownLine = 4;

        //  2*2*2=8
        this.Variables.add(new String[]{"2", "2", "2"});
        this.Result.add("8");
        this.Symbols.add(new String[] {multiplerCh,multiplerCh});
        this.Figures.add(new String[] {"rg", "rg", "rg"});

        this.ColumnStart.add(0);
        this.LineStart.add(1);

        this.CorrectFigures.add("rg");
        this.ResultTexts.add("2");

        /// 2x2x2x2=16

        this.Variables.add(new String[]{"2", "2", "2", "2"});
        this.Result.add("16");
        this.Symbols.add(new String[] {multiplerCh,multiplerCh, multiplerCh});
        this.Figures.add(new String[] {"rg", "rg", "rg", "rg"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("rg");
        this.ResultTexts.add("2");

        //  2x7+7=21

        this.Variables.add(new String[]{"2", "7", "7"});
        this.Result.add("21");
        this.Symbols.add(new String[] {multiplerCh, "+"});
        this.Figures.add(new String[] {"rg", "oz", "oz"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("oz");
        this.ResultTexts.add("7");


        // 7*2/2=7


        this.Variables.add(new String[]{"7", "2", "2","7"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh,divideCh});
        this.Figures.add(new String[] {"oz", "rg", "rg", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);


        this.ResultTexts.add("7");
        this.CorrectFigures.add("q");

    }

    private void Level24(){
        this.HowManyLines = 4;
        this.UpLine = 1;
        this.DownLine = 4;

        //  5+5+5+5=20

        this.Variables.add(new String[]{"5", "5", "5", "5"});
        this.Result.add("20");
        this.Symbols.add(new String[] {"+" ,"+", "+"});
        this.Figures.add(new String[] {"o", "o", "o", "o"});

        this.ColumnStart.add(0);
        this.LineStart.add(1);

        this.CorrectFigures.add("o");
        this.ResultTexts.add("5");

        /// 5+7+7=19

        this.Variables.add(new String[]{"5", "7", "7"});
        this.Result.add("19");
        this.Symbols.add(new String[] {"+", "+"});
        this.Figures.add(new String[] {"o", "oz", "oz"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("oz");
        this.ResultTexts.add("7");

        //  7x5+10=45

        this.Variables.add(new String[]{"7","5","10"});
        this.Result.add("45");
        this.Symbols.add(new String[] {multiplerCh, "+"});
        this.Figures.add(new String[] {"oz", "o", "ok",});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("ok");
        this.ResultTexts.add("10");


        // 10/5+7=9


        this.Variables.add(new String[]{"10", "5", "7","9"});
        this.Result.add("");
        this.Symbols.add(new String[] {divideCh, "+"});
        this.Figures.add(new String[] {"ok", "o", "oz", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);


        this.ResultTexts.add("9");
        this.CorrectFigures.add("q");

    }

    private void Level25(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        //  3x3/3=3
        this.Variables.add(new String[]{"3", "3", "3"});
        this.Result.add("3");
        this.Symbols.add(new String[] {multiplerCh, divideCh});
        this.Figures.add(new String[] {"rf","rf","rf"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("rf");
        this.ResultTexts.add("3");


        // 3+15+15=33

        this.Variables.add(new String[]{"3", "15", "15"});
        this.Result.add("33");
        this.Symbols.add(new String[] {"+", "+"});
        this.Figures.add(new String[] {"rf", "r", "r"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("r");
        this.ResultTexts.add("15");

        //  15/3=5

        this.Variables.add(new String[]{"15" , "3", "5"});
        this.Result.add("");
        this.Symbols.add(new String[] {divideCh});
        this.Figures.add(new String[] {"r", "rf", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("5");
        this.CorrectFigures.add("q");

    }

    private void Level26(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        //  10+10+10=30
        this.Variables.add(new String[]{"10", "10", "10"});
        this.Result.add("30");
        this.Symbols.add(new String[] {"+","+"});
        this.Figures.add(new String[] {"k","k","k"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("k");
        this.ResultTexts.add("10");


        // 7*10+10

        this.Variables.add(new String[]{"7", "10", "10"});
        this.Result.add("80");
        this.Symbols.add(new String[] { multiplerCh, "+"});
        this.Figures.add(new String[] {"rg", "k", "k"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("rg");
        this.ResultTexts.add("7");

        //  10x7/10=7

        this.Variables.add(new String[]{"10" , "7", "10", "7"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh,divideCh});
        this.Figures.add(new String[] {"k", "rg","k", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("7");
        this.CorrectFigures.add("q");

    }

    private void Level27(){
        this.HowManyLines = 4;
        this.UpLine = 1;
        this.DownLine = 4;

        //  7x7-7=42

        this.Variables.add(new String[]{"7", "7", "7"});
        this.Result.add("42");
        this.Symbols.add(new String[] {multiplerCh , "-" });
        this.Figures.add(new String[] {"kf", "kf", "kf"});
        this.ColumnStart.add(0);
        this.LineStart.add(1);

        this.CorrectFigures.add("kf");
        this.ResultTexts.add("7");

        //  8x8-8=56

        this.Variables.add(new String[]{"8", "8", "8"});
        this.Result.add("56");
        this.Symbols.add(new String[] {multiplerCh, "-" });
        this.Figures.add(new String[] {"rf", "rf", "rf"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("rf");
        this.ResultTexts.add("8");

        //  9x9-9

        this.Variables.add(new String[]{"9", "9", "9"});
        this.Result.add("72");
        this.Symbols.add(new String[] {multiplerCh, "-"});
        this.Figures.add(new String[] {"o", "o", "o"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("o");
        this.ResultTexts.add("9");


        // 7x8-9=47


        this.Variables.add(new String[]{"7", "8", "9","47"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh,"-"});
        this.Figures.add(new String[] {"kf", "rf", "o", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);


        this.ResultTexts.add("47");
        this.CorrectFigures.add("q");

    }

    private void Level28(){
        this.HowManyLines = 4;
        this.UpLine = 1;
        this.DownLine = 4;

        //  5x5/5=5
        this.Variables.add(new String[]{"5", "5", "5"});
        this.Result.add("5");
        this.Symbols.add(new String[] {multiplerCh, divideCh});
        this.Figures.add(new String[] {"rg", "rg","rg"});
        this.ColumnStart.add(0);
        this.LineStart.add(1);

        this.CorrectFigures.add("rg");
        this.ResultTexts.add("5");


        // 2x5/5=2

        this.Variables.add(new String[]{"2", "5", "5"});
        this.Result.add("2");
        this.Symbols.add(new String[] {multiplerCh, divideCh});
        this.Figures.add(new String[] {"r", "rg", "rg"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("r");
        this.ResultTexts.add("2");

        //  3x3+5x2=19

        this.Variables.add(new String[]{"3" , "3", "5", "2"});
        this.Result.add("19");
        this.Symbols.add(new String[] {multiplerCh, "+", multiplerCh});
        this.Figures.add(new String[] {"k", "k", "rg", "r"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.ResultTexts.add("3");
        this.CorrectFigures.add("k");

        //  3x2+5x5=31

        this.Variables.add(new String[]{"3" , "2", "5", "5", "31"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh, "+", multiplerCh});
        this.Figures.add(new String[] {"k", "r", "rg", "rg" , "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("31");
        this.CorrectFigures.add("q");

    }

    private void Level29(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        //  4x4+4+4=24

        this.Variables.add(new String[]{"4", "4", "4", "4"});
        this.Result.add("24");
        this.Symbols.add(new String[] {multiplerCh,"+","+"});
        this.Figures.add(new String[] {"oz","oz","oz", "oz"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("oz");
        this.ResultTexts.add("4");


        // 4x10/10=4

        this.Variables.add(new String[]{"4", "10", "10"});
        this.Result.add("4");
        this.Symbols.add(new String[] { multiplerCh, divideCh});
        this.Figures.add(new String[] {"oz", "kb", "kb"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("kb");
        this.ResultTexts.add("10");

        //  10x4+4*4=56

        this.Variables.add(new String[]{"10" , "4", "4", "4","56"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh,"+",multiplerCh});
        this.Figures.add(new String[] {"kb", "oz", "oz","oz", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("56");
        this.CorrectFigures.add("q");

    }

    private void Level30(){
        this.HowManyLines = 4;
        this.UpLine = 1;
        this.DownLine = 4;

        //  4x4+4x4=32
        this.Variables.add(new String[]{"4", "4", "4", "4"});
        this.Result.add("32");
        this.Symbols.add(new String[] {multiplerCh, "+", multiplerCh});
        this.Figures.add(new String[] {"r", "r","r", "r"});
        this.ColumnStart.add(0);
        this.LineStart.add(1);

        this.CorrectFigures.add("r");
        this.ResultTexts.add("4");


        // 4x4/2x2=4

        this.Variables.add(new String[]{"4", "4", "2","2"});
        this.Result.add("4");
        this.Symbols.add(new String[] {multiplerCh, divideCh,multiplerCh});
        this.Figures.add(new String[] {"r", "r", "rf", "rf"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("rf");
        this.ResultTexts.add("2");

        //  4x4/2-8=0

        this.Variables.add(new String[]{"4" , "4", "2", "8"});
        this.Result.add("0");
        this.Symbols.add(new String[] {multiplerCh, divideCh, "-"});
        this.Figures.add(new String[] {"r", "r", "rf", "oz"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.ResultTexts.add("8");
        this.CorrectFigures.add("oz");

        //  8-2+4=10

        this.Variables.add(new String[]{"8" , "2", "4", "10"});
        this.Result.add("");
        this.Symbols.add(new String[] {"-", "+"});
        this.Figures.add(new String[] {"oz", "rf", "r", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("10");
        this.CorrectFigures.add("q");

    }

    private void Level31(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        // 11+11=22
        this.Variables.add(new String[]{"11", "11"});
        this.Result.add("22");
        this.Symbols.add(new String[] {"+"});
        this.Figures.add(new String[] {"kf", "kf"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("kf");
        this.ResultTexts.add("11");


        // 11+11+11=33

        this.Variables.add(new String[]{"11", "11", "11"});
        this.Result.add("33");
        this.Symbols.add(new String[] { "+", "+"});
        this.Figures.add(new String[] {"kf", "kf", "kf"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("kf");
        this.ResultTexts.add("11");

        //  11+11x11=132

        this.Variables.add(new String[]{"11" , "11", "11", "132"});
        this.Result.add("");
        this.Symbols.add(new String[] {"+",multiplerCh});
        this.Figures.add(new String[] {"kf", "kf","kf", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("132");
        this.CorrectFigures.add("q");

    }

    private void Level32(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        // 3x3+3+3=15
        this.Variables.add(new String[]{"3", "3", "3", "3"});
        this.Result.add("15");
        this.Symbols.add(new String[] {multiplerCh,"+","+"});
        this.Figures.add(new String[] {"s", "s", "s", "s"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("s");
        this.ResultTexts.add("3");


        // 15+3+3+3=24

        this.Variables.add(new String[]{"15", "3", "3", "3"});
        this.Result.add("24");
        this.Symbols.add(new String[] {"+", "+", "+"});
        this.Figures.add(new String[] {"rg", "s", "s", "s"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("rg");
        this.ResultTexts.add("15");

        //  15+3+15=33

        this.Variables.add(new String[]{"15" , "3", "15", "33"});
        this.Result.add("");
        this.Symbols.add(new String[] {"+", "+"});
        this.Figures.add(new String[] {"rg", "s","rg", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("33");
        this.CorrectFigures.add("q");

    }

    private void Level33(){
        this.HowManyLines = 4;
        this.UpLine = 1;
        this.DownLine = 4;

        //  20+20+20+20=80

        this.Variables.add(new String[]{"20", "20", "20", "20"});
        this.Result.add("80");
        this.Symbols.add(new String[] {"+","+","+" });
        this.Figures.add(new String[] {"o", "o", "o", "o"});
        this.ColumnStart.add(0);
        this.LineStart.add(1);

        //  30+30+30+30=120

        this.CorrectFigures.add("o");
        this.ResultTexts.add("20");

        this.Variables.add(new String[]{"30", "30", "30", "30"});
        this.Result.add("120");
        this.Symbols.add(new String[] {"+","+","+" });
        this.Figures.add(new String[] {"s", "s", "s", "s"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        //  50+50+50+50=200

        this.CorrectFigures.add("s");
        this.ResultTexts.add("30");

        this.Variables.add(new String[]{"50", "50", "50", "50"});
        this.Result.add("200");
        this.Symbols.add(new String[] {"+","+","+"});
        this.Figures.add(new String[] {"kb", "kb", "kb", "kb"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        // 20+30+50=100

        this.CorrectFigures.add("kb");
        this.ResultTexts.add("50");

        this.Variables.add(new String[]{"20", "30", "50","100"});
        this.Result.add("");
        this.Symbols.add(new String[] {"+","+","+" });
        this.Figures.add(new String[] {"o", "s", "kb", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);


        this.ResultTexts.add("100");
        this.CorrectFigures.add("q");

    }

    private void Level34(){
        this.HowManyLines = 4;
        this.UpLine = 1;
        this.DownLine = 4;

        //  7x7=49
        this.Variables.add(new String[]{"7", "7"});
        this.Result.add("49");
        this.Symbols.add(new String[] {multiplerCh});
        this.Figures.add(new String[] {"r", "r"});
        this.ColumnStart.add(0);
        this.LineStart.add(1);

        this.CorrectFigures.add("r");
        this.ResultTexts.add("7");


        // 7x7+5+5+5=64

        this.Variables.add(new String[]{"7", "7", "5","5","5"});
        this.Result.add("64");
        this.Symbols.add(new String[] {multiplerCh,"+","+","+"});
        this.Figures.add(new String[] {"r", "r", "k", "k", "k"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("k");
        this.ResultTexts.add("5");

        //  5+5+5+85=100

        this.Variables.add(new String[]{"5" , "5", "5", "85"});
        this.Result.add("100");
        this.Symbols.add(new String[] {"+","+","+"});
        this.Figures.add(new String[] {"k", "k", "k", "oz"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.ResultTexts.add("85");
        this.CorrectFigures.add("oz");

        //  85/5+7=24

        this.Variables.add(new String[]{"85" , "5", "7", "24"});
        this.Result.add("");
        this.Symbols.add(new String[] {divideCh, "+"});
        this.Figures.add(new String[] {"oz", "k", "r", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("24");
        this.CorrectFigures.add("q");

    }

    private void Level35(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        // 10/10+10=11
        this.Variables.add(new String[]{"10", "10", "10"});
        this.Result.add("11");
        this.Symbols.add(new String[] {divideCh,"+"});
        this.Figures.add(new String[] {"kf", "kf", "kf"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("kf");
        this.ResultTexts.add("10");


        // 10+10/2=15

        this.Variables.add(new String[]{"10", "10", "2"});
        this.Result.add("15");
        this.Symbols.add(new String[] {"+", divideCh});
        this.Figures.add(new String[] {"kf", "kf", "oz"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("oz");
        this.ResultTexts.add("2");

        //  10x10/10/2=5

        this.Variables.add(new String[]{"10" , "10", "10", "2", "5"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh, divideCh,divideCh});
        this.Figures.add(new String[] {"kf", "kf","kf", "oz", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("5");
        this.CorrectFigures.add("q");

    }

    private void Level36(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        // 4x4x4=54
        this.Variables.add(new String[]{"4", "4", "4"});
        this.Result.add("54");
        this.Symbols.add(new String[] {multiplerCh,multiplerCh});
        this.Figures.add(new String[] {"rf", "rf", "rf"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("rf");
        this.ResultTexts.add("4");


        // 5x5x5=125

        this.Variables.add(new String[]{"5", "5", "5"});
        this.Result.add("125");
        this.Symbols.add(new String[] {multiplerCh,multiplerCh});
        this.Figures.add(new String[] {"rg", "rg", "rg"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("rg");
        this.ResultTexts.add("5");

        //  5/5+4=5

        this.Variables.add(new String[]{"5" , "5", "4" , "5"});
        this.Result.add("");
        this.Symbols.add(new String[] {divideCh, "+"});
        this.Figures.add(new String[] {"rg", "rg", "rf", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("5");
        this.CorrectFigures.add("q");

    }

    private void Level37(){
        this.HowManyLines = 4;
        this.UpLine = 1;
        this.DownLine = 4;

        //  9x9=81
        this.Variables.add(new String[]{"9", "9"});
        this.Result.add("81");
        this.Symbols.add(new String[] {multiplerCh});
        this.Figures.add(new String[] {"s", "s"});
        this.ColumnStart.add(0);
        this.LineStart.add(1);

        this.CorrectFigures.add("s");
        this.ResultTexts.add("9");


        // 9x9+10+9=100

        this.Variables.add(new String[]{"9", "9", "10","9"});
        this.Result.add("100");
        this.Symbols.add(new String[] {multiplerCh,"+","+"});
        this.Figures.add(new String[] {"s", "s", "kf", "s"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("kf");
        this.ResultTexts.add("10");

        //  10x10=100

        this.Variables.add(new String[]{"10", "10"});
        this.Result.add("100");
        this.Symbols.add(new String[] {multiplerCh});
        this.Figures.add(new String[] {"kf", "kf"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.ResultTexts.add("10");
        this.CorrectFigures.add("kf");

        //  10x9+10=100

        this.Variables.add(new String[]{"10" , "9", "10", "100"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh, "+"});
        this.Figures.add(new String[] {"kf", "s", "kf", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("100");
        this.CorrectFigures.add("q");

    }

    private void Level38(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        // 6+6x6=42
        this.Variables.add(new String[]{"6", "6", "6"});
        this.Result.add("42");
        this.Symbols.add(new String[] {"+",multiplerCh});
        this.Figures.add(new String[] {"oz", "oz", "oz"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("oz");
        this.ResultTexts.add("6");


        // 6x6+36=72

        this.Variables.add(new String[]{"6", "6", "36"});
        this.Result.add("72");
        this.Symbols.add(new String[] {multiplerCh,"+"});
        this.Figures.add(new String[] {"oz", "oz", "rg"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("rg");
        this.ResultTexts.add("36");

        //  6x6/36+6=7

        this.Variables.add(new String[]{"6" , "6", "36" , "6","7"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh,divideCh, "+"});
        this.Figures.add(new String[] {"oz", "oz", "rg","oz", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("7");
        this.CorrectFigures.add("q");

    }

    private void Level39(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        // 10x10+10x10=20
        this.Variables.add(new String[]{"10", "10", "10", "10"});
        this.Result.add("20");
        this.Symbols.add(new String[] {multiplerCh,"+",multiplerCh});
        this.Figures.add(new String[] {"k", "k", "k", "k"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("k");
        this.ResultTexts.add("10");


        // 10x10x2=200

        this.Variables.add(new String[]{"10", "10", "2"});
        this.Result.add("200");
        this.Symbols.add(new String[] {multiplerCh,multiplerCh});
        this.Figures.add(new String[] {"k", "k", "o"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("o");
        this.ResultTexts.add("2");

        //  10x10/2=50

        this.Variables.add(new String[]{"10" , "10", "2" , "50"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh,divideCh});
        this.Figures.add(new String[] {"k", "k", "o", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("50");
        this.CorrectFigures.add("q");

    }

    private void Level40(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        // 12+12+12=36
        this.Variables.add(new String[]{"12", "12", "12"});
        this.Result.add("36");
        this.Symbols.add(new String[] {"+","+"});
        this.Figures.add(new String[] {"kb", "kb", "kb"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("kb");
        this.ResultTexts.add("12");


        // 13+13+12=38

        this.Variables.add(new String[]{"13", "13", "12"});
        this.Result.add("38");
        this.Symbols.add(new String[] {"+","+"});
        this.Figures.add(new String[] {"ok", "ok", "kb"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("ok");
        this.ResultTexts.add("13");

        //  13x12=106

        this.Variables.add(new String[]{"13" , "12", "106"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh});
        this.Figures.add(new String[] {"ok", "kb", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("106");
        this.CorrectFigures.add("q");

    }

    private void Level41(){
        this.HowManyLines = 4;
        this.UpLine = 1;
        this.DownLine = 4;

        //  11x11=121
        this.Variables.add(new String[]{"11", "11"});
        this.Result.add("121");
        this.Symbols.add(new String[] {multiplerCh});
        this.Figures.add(new String[] {"rg", "rg"});
        this.ColumnStart.add(0);
        this.LineStart.add(1);

        this.CorrectFigures.add("rg");
        this.ResultTexts.add("11");


        // 2x2x2x2=16

        this.Variables.add(new String[]{"2", "2", "2","2"});
        this.Result.add("16");
        this.Symbols.add(new String[] {multiplerCh, multiplerCh,multiplerCh});
        this.Figures.add(new String[] {"s", "s", "s", "s"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("s");
        this.ResultTexts.add("2");

        //  3x3x3x3=81

        this.Variables.add(new String[]{"3" , "3", "3", "3"});
        this.Result.add("81");
        this.Symbols.add(new String[] {multiplerCh, multiplerCh, multiplerCh});
        this.Figures.add(new String[] {"rf", "rf", "rf", "rf"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.ResultTexts.add("3");
        this.CorrectFigures.add("rf");

        //  2x3x11=66

        this.Variables.add(new String[]{"2" , "3", "11", "66"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh, multiplerCh});
        this.Figures.add(new String[] {"s", "rf", "rg", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("66");
        this.CorrectFigures.add("q");

    }


    private void Level42(){
        this.HowManyLines = 4;
        this.UpLine = 1;
        this.DownLine = 4;

        //  100x100=1000
        this.Variables.add(new String[]{"100", "100"});
        this.Result.add("10000");
        this.Symbols.add(new String[] {multiplerCh});
        this.Figures.add(new String[] {"k", "k"});
        this.ColumnStart.add(0);
        this.LineStart.add(1);

        this.CorrectFigures.add("k");
        this.ResultTexts.add("100");


        // 3x100=300

        this.Variables.add(new String[]{"3", "100"});
        this.Result.add("300");
        this.Symbols.add(new String[] {multiplerCh});
        this.Figures.add(new String[] {"rf", "k"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("rf");
        this.ResultTexts.add("3");

        //  12x100/3=400

        this.Variables.add(new String[]{"12" , "100", "3"});
        this.Result.add("400");
        this.Symbols.add(new String[] {multiplerCh, divideCh});
        this.Figures.add(new String[] {"oz", "k", "rf"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.ResultTexts.add("12");
        this.CorrectFigures.add("oz");

        //  3x12+100=136

        this.Variables.add(new String[]{"3" , "12", "100", "136"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh, "+"});
        this.Figures.add(new String[] {"rf", "oz", "k", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("136");
        this.CorrectFigures.add("q");

    }

    private void Level43(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        //  5x5x5/5=25
        this.Variables.add(new String[]{"5","5","5","5"});
        this.Result.add("25");
        this.Symbols.add(new String[] {multiplerCh,multiplerCh,divideCh});
        this.Figures.add(new String[] {"ok", "ok", "ok", "ok"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("ok");
        this.ResultTexts.add("5");


        // 125+5=130

        this.Variables.add(new String[]{"125", "5"});
        this.Result.add("130");
        this.Symbols.add(new String[] {"+"});
        this.Figures.add(new String[] {"kf", "ok"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("kf");
        this.ResultTexts.add("125");

        //  125x5=625

        this.Variables.add(new String[]{"125" , "5", "625"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh});
        this.Figures.add(new String[] {"kf", "ok", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("625");
        this.CorrectFigures.add("q");


    }

    private void Level44(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        //  5x5x5/5=25
        this.Variables.add(new String[]{"5","5","5","5"});
        this.Result.add("25");
        this.Symbols.add(new String[] {multiplerCh,multiplerCh,divideCh});
        this.Figures.add(new String[] {"ok", "ok", "ok", "ok"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("ok");
        this.ResultTexts.add("5");


        // 125+5=130

        this.Variables.add(new String[]{"125", "5"});
        this.Result.add("130");
        this.Symbols.add(new String[] {"+"});
        this.Figures.add(new String[] {"kf", "ok"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("kf");
        this.ResultTexts.add("125");

        //  125x5=625

        this.Variables.add(new String[]{"125" , "5", "625"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh});
        this.Figures.add(new String[] {"kf", "ok", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("625");
        this.CorrectFigures.add("q");


    }

    private void Level45(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        //  200x200 = 40 000
        this.Variables.add(new String[]{"200","200"});
        this.Result.add("40000");
        this.Symbols.add(new String[] {multiplerCh});
        this.Figures.add(new String[] {"o", "o"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("o");
        this.ResultTexts.add("200");


        // 200+800=1000

        this.Variables.add(new String[]{"200", "800"});
        this.Result.add("1000");
        this.Symbols.add(new String[] {multiplerCh});
        this.Figures.add(new String[] {"o", "oz"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("oz");
        this.ResultTexts.add("800");

        //  800-200/200=799

        this.Variables.add(new String[]{"800" , "200", "200", "799"});
        this.Result.add("");
        this.Symbols.add(new String[] {"-", divideCh});
        this.Figures.add(new String[] {"oz", "o", "o", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("799");
        this.CorrectFigures.add("q");


    }

    private void Level46(){
        this.HowManyLines = 4;
        this.UpLine = 1;
        this.DownLine = 4;

        //  16x16=256
        this.Variables.add(new String[]{"16", "16"});
        this.Result.add("256");
        this.Symbols.add(new String[] {multiplerCh});
        this.Figures.add(new String[] {"s", "s"});
        this.ColumnStart.add(0);
        this.LineStart.add(1);

        this.CorrectFigures.add("s");
        this.ResultTexts.add("16");


        // 16x16-56=200

        this.Variables.add(new String[]{"16","16", "56"});
        this.Result.add("200");
        this.Symbols.add(new String[] {multiplerCh});
        this.Figures.add(new String[] {"s","s", "kf"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("kf");
        this.ResultTexts.add("56");

        //  56+44=100

        this.Variables.add(new String[]{"56" , "44"});
        this.Result.add("100");
        this.Symbols.add(new String[] {"+"});
        this.Figures.add(new String[] {"kf", "ok"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.ResultTexts.add("44");
        this.CorrectFigures.add("ok");

        //  44x16+56=760

        this.Variables.add(new String[]{"44" , "16", "56", "760"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh, "+"});
        this.Figures.add(new String[] {"ok", "s", "kf", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("760");
        this.CorrectFigures.add("q");

    }

    private void Level47(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        //  7x7x7=343
        this.Variables.add(new String[]{"7", "7", "7"});
        this.Result.add("343");
        this.Symbols.add(new String[] {multiplerCh, multiplerCh});
        this.Figures.add(new String[] {"k", "k","k"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("k");
        this.ResultTexts.add("7");


        // 7x10=70

        this.Variables.add(new String[]{"7", "10"});
        this.Result.add("70");
        this.Symbols.add(new String[] {multiplerCh});
        this.Figures.add(new String[] {"k", "rg"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("rg");
        this.ResultTexts.add("10");

        //  10+10+10+7=37

        this.Variables.add(new String[]{"10" , "10", "10", "7", "37"});
        this.Result.add("");
        this.Symbols.add(new String[] {"+", "+", "+"});
        this.Figures.add(new String[] {"rg", "rg", "rg", "k"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("37");
        this.CorrectFigures.add("q");

    }

    private void Level48(){
        this.HowManyLines = 4;
        this.UpLine = 1;
        this.DownLine = 4;

        //  20x20=400
        this.Variables.add(new String[]{"20", "20"});
        this.Result.add("400");
        this.Symbols.add(new String[] {multiplerCh});
        this.Figures.add(new String[] {"ok", "ok"});
        this.ColumnStart.add(0);
        this.LineStart.add(1);

        this.CorrectFigures.add("ok");
        this.ResultTexts.add("20");


        // 20x10=200

        this.Variables.add(new String[]{"20", "10"});
        this.Result.add("200");
        this.Symbols.add(new String[] {multiplerCh});
        this.Figures.add(new String[] {"ok", "rf"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("rf");
        this.ResultTexts.add("10");

        //  20x10/200=1

        this.Variables.add(new String[]{"20" , "10", "200",});
        this.Result.add("1");
        this.Symbols.add(new String[] {multiplerCh, divideCh});
        this.Figures.add(new String[] {"ok", "rf", "oz"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.ResultTexts.add("200");
        this.CorrectFigures.add("oz");

        //  200x10/200=10

        this.Variables.add(new String[]{"200" , "10", "200", "10"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh, divideCh});
        this.Figures.add(new String[] {"ok", "rf", "oz","q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("10");
        this.CorrectFigures.add("q");

    }

    private void Level49(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        //  30x30=90
        this.Variables.add(new String[]{"30", "30"});
        this.Result.add("90");
        this.Symbols.add(new String[] {multiplerCh});
        this.Figures.add(new String[] {"r", "r"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("r");
        this.ResultTexts.add("30");


        // 30x3=90

        this.Variables.add(new String[]{"30", "3"});
        this.Result.add("90");
        this.Symbols.add(new String[] {multiplerCh});
        this.Figures.add(new String[] {"r", "kf"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("kf");
        this.ResultTexts.add("3");

        //  30x3+30x30=990

        this.Variables.add(new String[]{"30" , "3", "30", "30", "990"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh, "+", multiplerCh});
        this.Figures.add(new String[] {"r", "kf", "r", "r", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("990");
        this.CorrectFigures.add("q");

    }

    private void Level50(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        //  5x5x5x5=625
        this.Variables.add(new String[]{"5", "5", "5", "5"});
        this.Result.add("625");
        this.Symbols.add(new String[] {multiplerCh,multiplerCh,multiplerCh});
        this.Figures.add(new String[] {"r", "r","r","r"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("r");
        this.ResultTexts.add("5");


        // 5x3x3x3=135

        this.Variables.add(new String[]{"5", "3", "3", "3"});
        this.Result.add("135");
        this.Symbols.add(new String[] {multiplerCh, multiplerCh,multiplerCh});
        this.Figures.add(new String[] {"r", "kb", "kb","kb"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("kb");
        this.ResultTexts.add("3");

        //  5x3/5=3

        this.Variables.add(new String[]{"5" , "3", "5", "3"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh, divideCh});
        this.Figures.add(new String[] {"r", "kb", "r", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("3");
        this.CorrectFigures.add("q");

    }

    private void Level51(){
        this.HowManyLines = 4;
        this.UpLine = 1;
        this.DownLine = 4;

        //  3x3x3-3=24
        this.Variables.add(new String[]{"3", "3", "3", "3"});
        this.Result.add("24");
        this.Symbols.add(new String[] {multiplerCh,multiplerCh,"-"});
        this.Figures.add(new String[] {"r", "r","r","r"});
        this.ColumnStart.add(0);
        this.LineStart.add(1);

        this.CorrectFigures.add("r");
        this.ResultTexts.add("3");


        // 4x4x4-4=60

        this.Variables.add(new String[]{"4", "4", "4","4"});
        this.Result.add("60");
        this.Symbols.add(new String[] {multiplerCh, multiplerCh,"-"});
        this.Figures.add(new String[] {"kb", "kb", "kb", "kb"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("kb");
        this.ResultTexts.add("4");

        //  3x4-6=6

        this.Variables.add(new String[]{"3" , "4", "6"});
        this.Result.add("6");
        this.Symbols.add(new String[] {multiplerCh,"-"});
        this.Figures.add(new String[] {"r", "kb", "s"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.ResultTexts.add("6");
        this.CorrectFigures.add("s");

        //  6+6+3*4=24

        this.Variables.add(new String[]{"6" , "6", "3", "4", "24"});
        this.Result.add("");
        this.Symbols.add(new String[] {"+", "+",multiplerCh});
        this.Figures.add(new String[] {"s", "s", "r", "kb", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("24");
        this.CorrectFigures.add("q");

    }

    private void Level52(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        // 8x8x8=512
        this.Variables.add(new String[]{"8", "8", "8"});
        this.Result.add("512");
        this.Symbols.add(new String[] {multiplerCh,multiplerCh});
        this.Figures.add(new String[] {"oz", "oz", "oz"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("oz");
        this.ResultTexts.add("8");


        // 8x8x8x2=1024

        this.Variables.add(new String[]{"8", "8", "8", "2"});
        this.Result.add("1024");
        this.Symbols.add(new String[] {multiplerCh,multiplerCh,multiplerCh});
        this.Figures.add(new String[] {"oz", "oz", "oz", "k"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("k");
        this.ResultTexts.add("2");

        //  8x8/2=32

        this.Variables.add(new String[]{"8" , "8", "2" , "32"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh,divideCh});
        this.Figures.add(new String[] {"oz", "oz", "k","q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("32");
        this.CorrectFigures.add("q");

    }

    private void Level53(){
        this.HowManyLines = 5;
        this.UpLine = 1;
        this.DownLine = 5;

        //  4x4x4x4=256
        this.Variables.add(new String[]{"4", "4", "4", "4"});
        this.Result.add("256");
        this.Symbols.add(new String[] {multiplerCh,multiplerCh,multiplerCh});
        this.Figures.add(new String[] {"ok", "ok","ok","ok"});
        this.ColumnStart.add(0);
        this.LineStart.add(1);

        this.CorrectFigures.add("ok");
        this.ResultTexts.add("4");


        // 4x2/4=2

        this.Variables.add(new String[]{"4", "2", "4"});
        this.Result.add("2");
        this.Symbols.add(new String[] {multiplerCh, divideCh});
        this.Figures.add(new String[] {"kf", "k", "kf"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("k");
        this.ResultTexts.add("2");

        //  2x2x4x4=64

        this.Variables.add(new String[]{"2" , "2", "4" , "4"});
        this.Result.add("64");
        this.Symbols.add(new String[] {multiplerCh,multiplerCh,multiplerCh});
        this.Figures.add(new String[] {"k", "k", "kf", "kf"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.ResultTexts.add("2");
        this.CorrectFigures.add("k");

        //  8x8x8=512

        this.Variables.add(new String[]{"8" , "8", "8"});
        this.Result.add("512");
        this.Symbols.add(new String[] {multiplerCh,multiplerCh});
        this.Figures.add(new String[] {"ok", "ok", "ok", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("8");
        this.CorrectFigures.add("ok");

        //  8/4/2=1

        this.Variables.add(new String[]{"8" , "4", "2", "1"});
        this.Result.add("");
        this.Symbols.add(new String[] {divideCh, divideCh });
        this.Figures.add(new String[] {"ok", "kf", "k", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(5);

        this.ResultTexts.add("1");
        this.CorrectFigures.add("q");

    }

    private void Level54(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        // 6x6x6x6=1296
        this.Variables.add(new String[]{"6", "6", "6", "6"});
        this.Result.add("1296");
        this.Symbols.add(new String[] {multiplerCh,multiplerCh,multiplerCh});
        this.Figures.add(new String[] {"o", "o", "o", "o"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("o");
        this.ResultTexts.add("6");


        // 6x5=30

        this.Variables.add(new String[]{"6", "5"});
        this.Result.add("30");
        this.Symbols.add(new String[] {multiplerCh});
        this.Figures.add(new String[] {"o", "rf"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("rf");
        this.ResultTexts.add("5");

        //  6x5+6x6=216

        this.Variables.add(new String[]{"6" , "5","6","6", "216"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh,"+",multiplerCh});
        this.Figures.add(new String[] {"o", "rf", "o", "o", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("216");
        this.CorrectFigures.add("q");

    }

    private void Level55(){
        this.HowManyLines = 3;
        this.UpLine = 2;
        this.DownLine = 4;

        // 8x8=64
        this.Variables.add(new String[]{"8", "8"});
        this.Result.add("64");
        this.Symbols.add(new String[] {multiplerCh});
        this.Figures.add(new String[] {"k", "k"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("k");
        this.ResultTexts.add("8");


        // 8x8x2=128

        this.Variables.add(new String[]{"8", "8", "2"});
        this.Result.add("128");
        this.Symbols.add(new String[] {multiplerCh,multiplerCh});
        this.Figures.add(new String[] {"k", "k", "rg"});
        this.ColumnStart.add(0);
        this.LineStart.add(3);

        this.CorrectFigures.add("rg");
        this.ResultTexts.add("2");

        //  8x8+2x8=80

        this.Variables.add(new String[]{"8" , "8", "2", "8", "80"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh,"+", multiplerCh});
        this.Figures.add(new String[] {"k", "k","rg","k","q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("80");
        this.CorrectFigures.add("q");

    }
}
