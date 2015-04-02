package by.jum.texteditor.listener;

import by.jum.texteditor.symbol.Symbol;
import by.jum.texteditor.windows.textpane.TextPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Set;

public class FocusTextPaneListener extends MouseAdapter {
    private TextPane myTextPane;
    private Set<Symbol> set;

    public FocusTextPaneListener(TextPane myTextPane, Set<Symbol> set) {
        this.myTextPane = myTextPane;
        this.set = set;
    }


    @Override
    public void mouseDragged(MouseEvent e) {
      //  set.clear();
        Component component = myTextPane.getComponentAt(e.getPoint());
        if (component != null && String.valueOf(component.getClass()).equals("class by.jum.texteditor.symbol.Symbol")){
            set.add((Symbol)component);
        }
        Iterator<Symbol> itr = set.iterator();
        while (itr.hasNext()) {
            itr.next().setBackground(Color.pink);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        myTextPane.requestFocusInWindow();
        System.out.println(set.size());
        Iterator<Symbol> itr = set.iterator();
        while (itr.hasNext()) {
            itr.next().setBackground(Color.white);
        }
    }
}
