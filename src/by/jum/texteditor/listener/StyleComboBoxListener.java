package by.jum.texteditor.listener;

import by.jum.texteditor.document.Document;
import by.jum.texteditor.windows.TextPane;
import by.jum.texteditor.windows.symbol.SelectionSymbol;
import by.jum.texteditor.windows.symbol.SymbolStorage;

import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StyleComboBoxListener implements ActionListener {
    private JTabbedPane tabbedPane;
    private Document document;
    private SymbolStorage symbolStorage;

    public StyleComboBoxListener(JTabbedPane tabbedPane, Document document) {
        this.tabbedPane = tabbedPane;
        this.document = document;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox comboBox = (JComboBox) e.getSource();
        String nameStyle = String.valueOf(comboBox.getSelectedItem());

        TextPane textPane = (TextPane) tabbedPane.getSelectedComponent();
        textPane.requestFocusInWindow();

        symbolStorage = textPane.getSymbolStorage();

        document.setNameStyleSymbol(nameStyle);
        new SelectionSymbol(symbolStorage, document, textPane);
    }
}
