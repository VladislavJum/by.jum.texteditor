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

public class DeselectionListener extends MouseAdapter {
    private Set <Symbol> selectionSet;
    private TextPane myTextPane;

    public DeselectionListener(TextPane myTextPane, Set<Symbol> selectionSet) {
        this.selectionSet = selectionSet;
        this.myTextPane = myTextPane;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        myTextPane.requestFocusInWindow();
        Iterator<Symbol> itr = selectionSet.iterator();
        while (itr.hasNext()) {
            itr.next().setBackground(Color.white);
        }
        selectionSet.clear();

        Caret caret = myTextPane.getCaret();
        //позиция каретки по щелчку мышки
        Component component = myTextPane.getComponentAt(e.getPoint());
        if (component != null && component.getName() != null) {
            Symbol symbol1 = (Symbol) component;
            caret.setCaretPosition(symbol1.getSymbolPositionX1(), symbol1.getSymbolPositionY1(), symbol1.getSymbolHeight());
        }
        caret.caretEnable();


    }
}
