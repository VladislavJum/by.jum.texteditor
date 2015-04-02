package by.jum.texteditor.symbol;

import by.jum.texteditor.document.Document;
import by.jum.texteditor.windows.textpane.TextPane;

import java.util.ArrayList;
import java.util.List;


public class SymbolCreator {
    private TextPane myTextPane;
    private List<String> stringSymbolList = new ArrayList<String>();
    private List<Symbol> symbolList = new ArrayList<Symbol>();

    private SymbolLocation symbolLocation;
    private Document document;

    public SymbolCreator(TextPane myTextPane, Document document) {
        this.myTextPane = myTextPane;
        this.document = document;
        symbolLocation = new SymbolLocation(myTextPane);
    }

    public void createSymbol(String symbolString) {
        Symbol symbol = new Symbol(symbolString, document);

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
