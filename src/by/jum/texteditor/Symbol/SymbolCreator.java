package by.jum.texteditor.symbol;

import by.jum.texteditor.mainwindow.Caret;
import by.jum.texteditor.mainwindow.TextPane;

import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vlad on 23.03.2015.
 */
public class SymbolCreator {
    private TextPane myTextPane;
    private int step = 10, symbolWight, symbolHeight;
    private List<String> stringSymbolList = new ArrayList<String>();
    private List<Symbol> symbolList = new ArrayList<Symbol>();

    public SymbolCreator(TextPane myTextPane) {
        this.myTextPane = myTextPane;
    }

    public void createSymbol(String symbolString){
        stringSymbolList.add(symbolString);

        Font font = myTextPane.getMyFont();
        Caret caret = myTextPane.getCaret();

        Symbol symbol = new Symbol(symbolString, font);
        symbolList.add(symbol);

        myTextPane.add(symbol);

        Graphics2D graphics2D = (Graphics2D) symbol.getGraphics();
        graphics2D.setFont(font);

        symbolWight = graphics2D.getFontMetrics().stringWidth(symbolString);
        symbolHeight = 4 + (int) font.getSize2D();

        symbol.setBounds(step, 10, symbolWight, symbolHeight);

        step += (symbolWight);

        caret.setCaretPosition(step, 10, symbolHeight);
        caret.getCaretPositionX();

    }
}
