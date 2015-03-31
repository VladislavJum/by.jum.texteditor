package by.jum.texteditor.symbol;

import by.jum.texteditor.windows.Caret;
import by.jum.texteditor.windows.textpane.TextPane;

import java.awt.Font;
import java.awt.Graphics2D;
import java.util.List;

public class SymbolLocation {
    private String mySymbol = "";
    private int stepColumn = 10, stepRow = 10, symbolWight, symbolHeight, x = 28, y = 0, newStringPosistion = 0, iteratorList = 0;
    private Caret caret;
    private TextPane myTextPane;

    public SymbolLocation(TextPane myTextPane) {
        iteratorList = newStringPosistion;
        this.myTextPane = myTextPane;
    }

    public void sumbolLocate(List<String> stringSymbolList, List<Symbol> symbolList) {
        caret = myTextPane.getCaret();
        for (; iteratorList < stringSymbolList.size(); iteratorList++) {
            mySymbol = stringSymbolList.get(iteratorList);

            crossLine();

            Symbol symbol = symbolList.get(iteratorList);
            Font font = symbol.getMyFont();
            Graphics2D graphics2D = (Graphics2D) symbol.getGraphics();
            graphics2D.setFont(font);

            symbolWight = graphics2D.getFontMetrics().stringWidth(mySymbol);
            symbolHeight = 4 + (int) font.getSize2D();
            stepColumn = caret.getCaretPositionX1();

            alignHeightDown();

            caret.setCaretPosition(stepColumn + symbolWight, stepRow + y, symbolHeight);
            symbol.setBounds(stepColumn, stepRow + y, symbolWight, symbolHeight);
        }

    }

    void alignHeightDown() {
        if (x < symbolHeight) {
            x = symbolHeight;
            iteratorList = newStringPosistion;
            stepColumn = 10 - symbolWight;
        } else {
            y = x - symbolHeight;
        }
    }

    void crossLine() {
        if (mySymbol.equals("\n")) {
            newStringPosistion = iteratorList;
            stepRow += x;
            x = symbolHeight;
            caret.setCaretPositionX1(10);
        }
    }
}
