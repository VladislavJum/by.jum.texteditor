package by.jum.texteditor.listener;

import by.jum.texteditor.mainwindow.MyTextPane;

import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vlad on 23.03.2015.
 */
public class SizeComboboxListener implements ActionListener{
    private JTabbedPane tabbedPane;

    public SizeComboboxListener(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox comboBox = (JComboBox) e.getSource();
        int size = (Integer)comboBox.getSelectedItem();

        MyTextPane myTextPane = (MyTextPane)tabbedPane.getSelectedComponent();
        myTextPane.setSizeSymbol(size);
        myTextPane.requestFocusInWindow();
    }
}
