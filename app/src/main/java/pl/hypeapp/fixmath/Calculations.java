package pl.hypeapp.fixmath;

import java.util.ArrayList;


public class Calculations {
    public int[] Blank;
    public ArrayList<String> SymbolList;
    public final ArrayList<String> VariableList;
    public String Result;
    public int WhichLine;
    public int SymbolsCount;
    public int VariablesCount;
    public int WhichColumnStart;


    public Calculations(int whichLine, int whichColumStart, String variables[], String symbols[], String result)
    {
        this.SymbolList = new ArrayList<>();
        this.VariableList = new ArrayList<>();
        this.VariablesCount = variables.length;
        AddVariable(variables);
        //Variable store symbols count
        this.SymbolsCount = symbols.length;
        AddSymbol(symbols);
        this.WhichColumnStart = whichColumStart;
        this.Result = result;
        this.WhichLine = whichLine;
    }

    public Calculations( int whichColumStart, String variables[], String symbols[], String result)
    {
        this.SymbolList = new ArrayList<>();
        this.VariableList = new ArrayList<>();
        this.VariablesCount = variables.length;
        AddVariable(variables);
        //Variable store symbols count
        this.SymbolsCount = symbols.length;
        AddSymbol(symbols);
        this.WhichColumnStart = whichColumStart;
        this.Result = result;

    }



    //How many blanks we need
    public void SetBlank(int blank) {
        this.Blank = new int[blank];
    }

    public int[] GetBlank() {
        return this.Blank;
    }

    //Adding Symbols to arraylist
    public void AddSymbol(String symbols[]) {
        int symbolsCount = symbols.length;
        for (int i = 0; i < symbolsCount; i++) {
            SymbolList.add(symbols[i]);
        }
    }

    public void AddVariable(String variables[]) {
        int symbolsCount = variables.length;
        for (int i = 0; i < symbolsCount; i++) {
            VariableList.add(variables[i]);
        }
    }
    //Getting Symbols from arraylist
    public String GetSymbol(int indexSymbol) {
        return this.SymbolList.get(indexSymbol);
    }


}

