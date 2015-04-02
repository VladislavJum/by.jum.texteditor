package by.jum.texteditor.listener;

import by.jum.texteditor.document.Document;

import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StyleSymbolListener implements ActionListener {
    private JTabbedPane tabbedPane;
    Document document;

    public StyleSymbolListener(JTabbedPane tabbedPane, Document document) {
        this.tabbedPane = tabbedPane;
        this.document = document;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox comboBox = (JComboBox) e.getSource();
        String nameStyle = String.valueOf(comboBox.getSelectedItem());

        document.setNameStyleSymbol(nameStyle);
    }
}
