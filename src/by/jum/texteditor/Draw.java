package by.jum.texteditor;

import by.jum.texteditor.mainwindow.Caret;
import by.jum.texteditor.mainwindow.MyTextPane;
import by.jum.texteditor.symbol.Symbol;

import java.awt.Font;
import java.awt.Graphics2D;
import java.util.List;

/**
 * Created by Vlad on 23.03.2015.
 */
public class Draw {
    private String mySymbol = "";
    private int step = 10, symbolWight, symbolHeight;

    public Draw(MyTextPane myTextPane, List<String> stringSymbolList, List<Symbol> symbolList) {
        Caret caret = new Caret();
        caret.myTimer();
        //myTextPane.add(caret);

        for(int iteratorList = 0; iteratorList < stringSymbolList.size(); iteratorList++ ){
            mySymbol = stringSymbolList.get(iteratorList);
            Symbol symbol = symbolList.get(iteratorList);

            Font font = symbol.getMyFont();

            Graphics2D graphics2D = (Graphics2D) symbol.getGraphics();
            graphics2D.setFont(font);

            symbolWight = graphics2D.getFontMetrics().stringWidth(mySymbol);
            symbolHeight = 4 + (int) font.getSize2D();

            symbol.setBounds(step, 10, symbolWight, symbolHeight);
            step += (symbolWight);
           // caret.setCaretPosition(step, 10, symbolHeight);
        }

    }
}
