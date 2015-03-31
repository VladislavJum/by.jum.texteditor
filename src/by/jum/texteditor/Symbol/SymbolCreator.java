package by.jum.texteditor.symbol;

import by.jum.texteditor.windows.textpane.TextPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;


public class SymbolCreator {
    private TextPane myTextPane;
    private List<String> stringSymbolList = new ArrayList<String>();
    private List<Symbol> symbolList = new ArrayList<Symbol>();
    private SymbolLocation symbolLocation;
    public SymbolCreator(TextPane myTextPane) {
        this.myTextPane = myTextPane;
        symbolLocation = new SymbolLocation(myTextPane);
    }

    public void createSymbol(String symbolString) {
        Font font = myTextPane.getMyFont();
        Symbol symbol = new Symbol(symbolString, font);

        stringSymbolList.add(symbolString);
        symbolList.add(symbol);
        myTextPane.add(symbol);

        symbolLocation.sumbolLocate(stringSymbolList, symbolList);
    }

    public List getStringSymbolList(){
        return stringSymbolList;
    }

    public List getSymbolList(){
        return symbolList;
    }
}
