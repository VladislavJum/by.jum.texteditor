package by.jum.texteditor.windows;

import by.jum.texteditor.document.Document;
import by.jum.texteditor.listener.DeselectionListener;
import by.jum.texteditor.listener.SelectionListener;
import by.jum.texteditor.windows.symbol.Symbol;
import by.jum.texteditor.windows.symbol.SymbolStorage;

import javax.swing.border.LineBorder;
import java.util.Set;

public class TextPaneCreator {

    public TextPane createMyTextPane(Document document, SymbolStorage symbolStorage) {
        TextPane textPane = new TextPane(document, symbolStorage);
        textPane.setBorder(LineBorder.createBlackLineBorder());
       // symbolStorage.clearAll();
        Set<Symbol> selectoinSet = symbolStorage.getSelectoinSet();

        textPane.addMouseMotionListener(new SelectionListener(textPane, selectoinSet));
        textPane.addMouseListener(new DeselectionListener(textPane, selectoinSet));

        //tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), "fg");
        return textPane;
    }
}
