package by.jum.texteditor.listener;

import by.jum.texteditor.constants.MenuName;
import by.jum.texteditor.document.Document;
import by.jum.texteditor.windows.TextPane;
import by.jum.texteditor.windows.symbol.Symbol;
import by.jum.texteditor.windows.symbol.SymbolCreator;
import by.jum.texteditor.windows.symbol.SymbolStorage;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CopyCutPasteListener implements ActionListener {
    private SymbolStorage symbolStorage;
    private TextPane textPane;
    private Document document;
    private JTabbedPane tabbedPane;
    private JFrame frame;

    public CopyCutPasteListener(JTabbedPane tabbedPane, Document document, JFrame frame) {
        this.document = document;
        this.tabbedPane = tabbedPane;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textPane = (TextPane) tabbedPane.getSelectedComponent();
        symbolStorage = textPane.getSymbolStorage();
        Set<Symbol> symbolSet = symbolStorage.getSelectoinSet();
        List<Symbol> copySymbolList = symbolStorage.getSymbolCopyList();

        if (e.getActionCommand().equals(MenuName.COPY)) {
            copySymbolList.clear();
            Iterator<Symbol> iterator = symbolSet.iterator();
            while (iterator.hasNext()) {
                copySymbolList.add(iterator.next());
                textPane.requestFocusInWindow();
            }
        } else {
            SymbolCreator symbolCreator = new SymbolCreator(textPane, document, symbolStorage, frame);
            for (Symbol symbol : copySymbolList) {
                symbolCreator.createSymbol(symbol.getSymbol());
                textPane.requestFocusInWindow();
            }
        }
    }
}
