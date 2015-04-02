package by.jum.texteditor.listener;

import by.jum.texteditor.symbol.Symbol;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Vlad on 03.04.2015.
 */
public class AListener extends MouseAdapter {
    Set <Symbol> set;

    public AListener(Set<Symbol> set) {
        this.set = set;
    }



    @Override
    public void mousePressed(MouseEvent e) {
        //myTextPane.requestFocusInWindow();
        Iterator<Symbol> itr = set.iterator();
        while (itr.hasNext()) {
            itr.next().setBackground(Color.white);
        }
        set.clear();
    }
}
