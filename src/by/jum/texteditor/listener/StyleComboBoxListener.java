package by.jum.texteditor.listener;

import by.jum.texteditor.mainwindow.MyTextPane;

import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StyleComboBoxListener implements ActionListener {
    private JTabbedPane tabbedPane;

    public StyleComboBoxListener(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox comboBox = (JComboBox) e.getSource();
        String nameStyle = String.valueOf(comboBox.getSelectedItem());

        MyTextPane myTextPane = (MyTextPane)tabbedPane.getSelectedComponent();
        myTextPane.setNameStyleSymbol(nameStyle);
        myTextPane.requestFocusInWindow();
    }
}
