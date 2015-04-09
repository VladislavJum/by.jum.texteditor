package by.jum.texteditor.windows;

import by.jum.texteditor.document.Document;
import by.jum.texteditor.listener.SymbolKeyListener;
import by.jum.texteditor.windows.symbol.SymbolStorage;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;

public class TextPane extends JPanel {
    private Caret caret;

    public TextPane(Document document, SymbolStorage symbolStorage) {
        setLayout(null);
        setBackground(Color.white);
        setCursor(new Cursor(Cursor.TEXT_CURSOR));
        addKeyListener(new SymbolKeyListener(this, document, symbolStorage));

        caret = new Caret();
        caret.caretBlink();
        add(caret);
    }

    public Caret getCaret() {
        return caret;
    }

}
