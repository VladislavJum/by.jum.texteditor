package by.jum.texteditor.windows;

import by.jum.texteditor.document.Document;
import by.jum.texteditor.listener.DeselectionListener;
import by.jum.texteditor.listener.SelectionListener;
import by.jum.texteditor.windows.symbol.Symbol;
import by.jum.texteditor.windows.symbol.SymbolLocation;

import javax.swing.JFrame;
import javax.swing.border.LineBorder;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Set;

public class TextPaneCreator {

    public TextPane createMyTextPane(Document document, final JFrame frame) {
        final TextPane textPane = new TextPane(document, frame);
        textPane.setBorder(LineBorder.createBlackLineBorder());
        Set<Symbol> selectoinSet = textPane.getSymbolStorage().getSelectoinSet();

        textPane.addMouseMotionListener(new SelectionListener(textPane, selectoinSet));
        textPane.addMouseListener(new DeselectionListener(textPane, selectoinSet));

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                new SymbolLocation(textPane, textPane.getSymbolStorage(), frame).symbolLocate();
            }
        });
        return textPane;
    }
}
