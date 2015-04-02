package by.jum.texteditor.windows.textpane;

import by.jum.texteditor.document.Document;
import by.jum.texteditor.listener.AListener;
import by.jum.texteditor.listener.FocusTextPaneListener;
import by.jum.texteditor.symbol.Symbol;

import javax.swing.border.LineBorder;
import java.util.LinkedHashSet;
import java.util.Set;

public class TextPaneCreator {

    public TextPane createMyTextPane(Document document) {
        TextPane myTextPane = new TextPane(document);
        myTextPane.setBorder(LineBorder.createBlackLineBorder());
        Set<Symbol> set = new LinkedHashSet<Symbol>();
        myTextPane.addMouseMotionListener(new FocusTextPaneListener(myTextPane, set));
        myTextPane.addMouseListener(new AListener(set));

        //tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), "fg");
        return myTextPane;
    }
}
