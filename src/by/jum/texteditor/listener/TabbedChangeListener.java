package by.jum.texteditor.listener;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TabbedChangeListener implements ChangeListener {
    private JTabbedPane tabbedPane;

    public TabbedChangeListener(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        //System.out.println(tabbedPane.getSelectedComponent());
    }
}
