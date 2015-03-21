package by.jum.texteditor.listener.filelistener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CloseListener implements ActionListener {
    private JTabbedPane tabbedPane;

    public CloseListener(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tabbedPane.remove(tabbedPane.getSelectedIndex());
    }
}
