package by.jum.texteditor.listener;

import by.jum.texteditor.windows.Caret;
import by.jum.texteditor.windows.TextPane;
import by.jum.texteditor.windows.symbol.Symbol;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Set;

public class SelectionListener extends MouseAdapter {
    private TextPane myTextPane;
    private Set<Symbol> selectionSet;
    private Symbol symbol;
    private Symbol symbol1;

    public SelectionListener(TextPane myTextPane, Set<Symbol> selectionSet) {
        this.myTextPane = myTextPane;
        this.selectionSet = selectionSet;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Component component = myTextPane.getComponentAt(e.getPoint());
        if (component != null && component.getName() != null) {
            selectionSet.add((Symbol) component);
            Iterator<Symbol> itr = selectionSet.iterator();
            if (itr.hasNext()) {
                symbol1 = itr.next();
                symbol1.setBackground(Color.PINK);
            }
            while (itr.hasNext()) {
                symbol = itr.next();
                symbol.setBackground(Color.pink);
            }
            caretPosition();
            myTextPane.getCaret().caretDisable();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    void caretPosition() {
        Caret caret = myTextPane.getCaret();
        if(symbol != null) {
            if (symbol1.getSymbolPositionX1() < symbol.getSymbolPositionX1()) {
                caret.setCaretPosition(symbol.getSymbolPositionX1() + symbol.getSymbolWidth(),
                        symbol.getSymbolPositionY1(), symbol.getSymbolHeight());
            } else {
                caret.setCaretPosition(symbol.getSymbolPositionX1(),
                        symbol.getSymbolPositionY1(), symbol.getSymbolHeight());
            }
        }
    }
}