package by.jum.texteditor.windows.textpane;

import by.jum.texteditor.document.Document;
import by.jum.texteditor.listener.SymbolKeyListener;
import by.jum.texteditor.windows.Caret;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;

public class TextPane extends JPanel {
    private Caret caret;

    public TextPane(Document document) {
        setLayout(null);
        setBackground(Color.white);
        setCursor(new Cursor(Cursor.TEXT_CURSOR));
        addKeyListener(new SymbolKeyListener(this, document));

        caret = new Caret();
        caret.caretBlink();
        add(caret);
    }

    public Caret getCaret() {
        return caret;
    }

}
