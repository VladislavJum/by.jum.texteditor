package by.jum.texteditor.listener;

import by.jum.texteditor.document.Document;
import by.jum.texteditor.windows.symbol.SelectionSymbol;
import by.jum.texteditor.windows.symbol.SymbolStorage;
import by.jum.texteditor.windows.TextPane;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItalicListener implements ActionListener {
    private Document document;
    private JTabbedPane tabbedPane;
    private SymbolStorage symbolStorage;
    private JFrame frame;

    public ItalicListener(Document document, JTabbedPane tabbedPane, JFrame frame) {
        this.document = document;
        this.tabbedPane = tabbedPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JToggleButton toggleButton = (JToggleButton) e.getSource();

        TextPane myTextPane = (TextPane) tabbedPane.getSelectedComponent();
        myTextPane.requestFocusInWindow();
        symbolStorage = myTextPane.getSymbolStorage();

        if (toggleButton.isSelected()) {
            document.setStyleSymbol(Font.ITALIC);
        } else {
            document.setStyleSymbol(Font.PLAIN);
        }

        new SelectionSymbol(symbolStorage, document, myTextPane, frame);
    }
}
