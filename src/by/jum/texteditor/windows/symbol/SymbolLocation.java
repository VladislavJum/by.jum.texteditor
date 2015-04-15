package by.jum.texteditor.windows.symbol;

import by.jum.texteditor.windows.Caret;
import by.jum.texteditor.windows.TextPane;

import java.awt.Graphics2D;
import java.util.List;

public class SymbolLocation {
    private String mySymbol;
    private Caret caret;
    private TextPane myTextPane;
    private Symbol symbol;
    private List<Symbol> symbolList;

    private int caretPosition = 10;
    private int stepColumn = 10;
    private int stepRow = 10;
    private int symbolWight;
    private int symbolHeight = 0;
    private int maxSymbolHeight = 0, indentHeight = 0;
    private int newStringPosition = -1;
    private int iteratorList = 0;

    public SymbolLocation(TextPane textPane, SymbolStorage symbolStorage) {
        this.myTextPane = textPane;
        symbolList = symbolStorage.getSymbolList();
        caret = textPane.getCaret();
    }

    public void setCurrentSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public void symbolLocate() {
        caret = myTextPane.getCaret();
        for (; iteratorList < symbolList.size(); iteratorList++) {
            Symbol symbol = symbolList.get(iteratorList);
            mySymbol = symbol.getSymbol();

            crossLine();

            symbolWight = getWightSymbol(symbol);
            symbolHeight = 4 + (int) symbol.getDocument().getSize2D();
            stepColumn = caretPosition;

            alignHeightDown();

            symbol.setBounds(stepColumn, stepRow + indentHeight, symbolWight, symbolHeight);
            caretPosition = stepColumn + symbolWight;

            if (symbol.equals(this.symbol) && symbol != null) {
                caret.setCaretPosition(caretPosition, stepRow + indentHeight, symbolHeight);
            }
        }

    }

    void alignHeightDown() {
        if (maxSymbolHeight < symbolHeight) {
            maxSymbolHeight = symbolHeight;
            iteratorList = newStringPosition;
            stepColumn = 10 - symbolWight;
        } else {
            indentHeight = maxSymbolHeight - symbolHeight;
        }
    }

    void crossLine() {
        if (mySymbol.equals("\n")) {
            newStringPosition = iteratorList;
           // symbolStorage.getEnterPositionList().add(newStringPosition);
            stepRow += maxSymbolHeight;
            maxSymbolHeight = symbolHeight;
            caretPosition = 10;
        }
    }

    public int getWightSymbol(Symbol symbol) {
        Graphics2D graphics2D = (Graphics2D) symbol.getGraphics();
        graphics2D.setFont(symbol.getDocument());
        return graphics2D.getFontMetrics().stringWidth(symbol.getSymbol());
    }
}
