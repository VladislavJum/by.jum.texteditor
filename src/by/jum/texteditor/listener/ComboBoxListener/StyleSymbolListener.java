package by.jum.texteditor.listener.ComboBoxListener;

import by.jum.texteditor.mainwindow.TextPane;

import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StyleSymbolListener implements ActionListener {
    private JTabbedPane tabbedPane;

    public StyleSymbolListener(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox comboBox = (JComboBox) e.getSource();
        String nameStyle = String.valueOf(comboBox.getSelectedItem());

        TextPane myTextPane = (TextPane)tabbedPane.getSelectedComponent();
        myTextPane.setNameStyleSymbol(nameStyle);
        myTextPane.requestFocusInWindow();
    }
}
