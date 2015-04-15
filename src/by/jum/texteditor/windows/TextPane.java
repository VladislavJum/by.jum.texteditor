package by.jum.texteditor.windows;

import by.jum.texteditor.document.Document;
import by.jum.texteditor.listener.SymbolKeyListener;
import by.jum.texteditor.windows.symbol.SymbolStorage;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

public class TextPane extends JPanel {
    private Caret caret;
    private SymbolStorage symbolStorage;
    public TextPane(Document document) {
        symbolStorage = new SymbolStorage();
        setLayout(null);
        setBackground(Color.white);
        setCursor(new Cursor(Cursor.TEXT_CURSOR));
        addKeyListener(new SymbolKeyListener(this, document));

        setPreferredSize(new Dimension(20,20));
        caret = new Caret();
        caret.caretBlink();
        add(caret);
    }

    public Caret getCaret() {
        return caret;
    }
    public SymbolStorage getSymbolStorage(){
        return symbolStorage;
    }
}
