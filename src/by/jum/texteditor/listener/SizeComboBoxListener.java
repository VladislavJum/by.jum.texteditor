package by.jum.texteditor.listener;

import by.jum.texteditor.document.Document;
import by.jum.texteditor.windows.symbol.SelectionSymbol;
import by.jum.texteditor.windows.symbol.SymbolStorage;
import by.jum.texteditor.windows.TextPane;

import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SizeComboBoxListener implements ActionListener {
    private JTabbedPane tabbedPane;
    private Document document;
    private SymbolStorage symbolStorage;

    public SizeComboBoxListener(JTabbedPane tabbedPane, Document document, SymbolStorage symbolStorage) {
        this.tabbedPane = tabbedPane;
        this.document = document;
        this.symbolStorage = symbolStorage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox comboBox = (JComboBox) e.getSource();
        int newSize = (Integer) comboBox.getSelectedItem();

        TextPane myTextPane = (TextPane) tabbedPane.getSelectedComponent();
        document.setSizeSymbol(newSize);
        myTextPane.requestFocusInWindow();

        new SelectionSymbol(symbolStorage, document, myTextPane);
    }
}
