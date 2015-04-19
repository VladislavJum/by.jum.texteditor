package by.jum.texteditor.windows.symbol;

import by.jum.texteditor.windows.Caret;
import by.jum.texteditor.windows.TextPane;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.List;

public class SymbolLocation {
    private String mySymbol;
    private JFrame frame;
    private Caret caret;
    private TextPane textPane;
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
    private int size = 200;

    public SymbolLocation(TextPane textPane, SymbolStorage symbolStorage, JFrame frame) {
        this.textPane = textPane;
        this.frame = frame;
        symbolList = symbolStorage.getSymbolList();
        caret = textPane.getCaret();
    }


    public void setCurrentSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public void symbolLocate() {
        caret = textPane.getCaret();
        for (; iteratorList < symbolList.size(); iteratorList++) {
            Symbol symbol = symbolList.get(iteratorList);
            mySymbol = symbol.getSymbol();

            crossLine();

            symbolWight = getWightSymbol(symbol);
            symbolHeight = 4 + (int) symbol.getDocument().getSize2D();
            stepColumn = caretPosition;

            if (caretPosition > frame.getSize().width - 50) {
                caretPosition = 10;
                stepRow += maxSymbolHeight;
                stepColumn = 10;
                size += maxSymbolHeight;
                textPane.setPreferredSize(new Dimension(0, size));
                textPane.updateUI();
            }

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
            size += maxSymbolHeight;
            textPane.setPreferredSize(new Dimension(0, size));
            newStringPosition = iteratorList;
            // symbolStorage.getEnterPositionList().add(newStringPosition);
            stepRow += maxSymbolHeight;
            maxSymbolHeight = symbolHeight;
            caretPosition = 10;
            textPane.updateUI();
        }
    }

    public int getWightSymbol(Symbol symbol) {
        Graphics2D graphics2D = (Graphics2D) symbol.getGraphics();
        graphics2D.setFont(symbol.getDocument());
        return graphics2D.getFontMetrics().stringWidth(symbol.getSymbol());
    }
}
