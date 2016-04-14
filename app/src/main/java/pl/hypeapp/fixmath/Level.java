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
        this.Figures.add(new String[] {"rg", "rg", "rg"});
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
        this.Figures.add(new String[] {"o", "o", "o"});

        this.ColumnStart.add(0);
        this.LineStart.add(1);

        this.CorrectFigures.add("o");
        this.ResultTexts.add("5");

        /// 5+7+7=19

        this.Variables.add(new String[]{"5", "7", "7"});
        this.Result.add("19");
        this.Symbols.add(new String[] {"+", "+", "+"});
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
        this.Symbols.add(new String[] {multiplerCh});
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
        this.Symbols.add(new String[] {"+","+","+"});
        this.Figures.add(new String[] {"k","k","k"});
        this.ColumnStart.add(0);
        this.LineStart.add(2);

        this.CorrectFigures.add("rf");
        this.ResultTexts.add("3");


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

        this.CorrectFigures.add("s");
        this.ResultTexts.add("4");


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
        this.Figures.add(new String[] {"k", "k", "rg", "r", "q"});
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

        //  10x skonczyc

        this.Variables.add(new String[]{"10" , "7", "10", "7"});
        this.Result.add("");
        this.Symbols.add(new String[] {multiplerCh,divideCh});
        this.Figures.add(new String[] {"k", "rg","k", "q"});
        this.ColumnStart.add(0);
        this.LineStart.add(4);

        this.ResultTexts.add("7");
        this.CorrectFigures.add("q");

    }









}
