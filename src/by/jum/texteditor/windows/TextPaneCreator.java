package by.jum.texteditor.windows;

import by.jum.texteditor.document.Document;
import by.jum.texteditor.listener.DeselectionListener;
import by.jum.texteditor.listener.SelectionListener;
import by.jum.texteditor.windows.symbol.Symbol;

import javax.swing.border.LineBorder;
import java.util.Set;

public class TextPaneCreator {

    public TextPane createMyTextPane(Document document) {
        TextPane textPane = new TextPane(document);
        textPane.setBorder(LineBorder.createBlackLineBorder());
        Set<Symbol> selectoinSet = textPane.getSymbolStorage().getSelectoinSet();

        textPane.addMouseMotionListener(new SelectionListener(textPane, selectoinSet));
        textPane.addMouseListener(new DeselectionListener(textPane, selectoinSet));

        //tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), "fg");
        return textPane;
    }
}
