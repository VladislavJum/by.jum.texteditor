package by.jum.texteditor.listener;

import by.jum.texteditor.document.Document;
import by.jum.texteditor.windows.symbol.SymbolStorage;
import by.jum.texteditor.windows.TextPane;
import by.jum.texteditor.windows.TextPaneCreator;

import javax.swing.JTabbedPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewFileListener implements ActionListener {
    private JTabbedPane tabbedPane;
    private Document document;
    private SymbolStorage symbolStorage;

    public NewFileListener(JTabbedPane tabbedPane, Document document, SymbolStorage symbolStorage) {
        this.tabbedPane = tabbedPane;
        this.document = document;
        this.symbolStorage = symbolStorage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TextPaneCreator textPanel = new TextPaneCreator();
        TextPane textPane = textPanel.createMyTextPane(document, symbolStorage);

        tabbedPane.add("untitled", textPane);
        tabbedPane.setSelectedComponent(textPane);
        tabbedPane.getSelectedComponent().requestFocusInWindow();
    }
}
