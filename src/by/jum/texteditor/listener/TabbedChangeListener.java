package by.jum.texteditor.listener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by Vlad on 12.03.2015.
 */
public class TabbedChangeListener implements ChangeListener {
    private JTabbedPane tabbedPane;

    public TabbedChangeListener(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }

    @Override
    public
    void stateChanged(ChangeEvent e) {
        //System.out.println(tabbedPane.getSelectedComponent());
    }
}
