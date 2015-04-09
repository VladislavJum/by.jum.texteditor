package by.jum.texteditor.listener;

import by.jum.texteditor.document.Document;
import by.jum.texteditor.windows.CaretLocation;
import by.jum.texteditor.windows.TextPane;
import by.jum.texteditor.windows.symbol.Symbol;
import by.jum.texteditor.windows.symbol.SymbolCreator;
import by.jum.texteditor.windows.symbol.SymbolDelete;
import by.jum.texteditor.windows.symbol.SymbolStorage;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;


public class SymbolKeyListener implements KeyListener {
    private String symbolString = "";
    private SymbolCreator mySymbolCreator;
    private CaretLocation caretLocation;
    private SymbolDelete symbolDelete;
    private TextPane textPane;
    private SymbolStorage symbolStorage;

    public SymbolKeyListener(TextPane textPane, Document document, SymbolStorage symbolStorage) {
        this.textPane = textPane;
        this.symbolStorage = symbolStorage;
        mySymbolCreator = new SymbolCreator(textPane, document, symbolStorage);
        caretLocation = new CaretLocation(textPane);
        symbolDelete = new SymbolDelete(textPane, symbolStorage);

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == '\b' || e.getKeyChar() == '\u007f') {
            return;
        }
        symbolString = String.valueOf(e.getKeyChar());
        mySymbolCreator.createSymbol(symbolString);
    }

    @Override
    public void keyPressed(KeyEvent e) {


        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                System.out.println("Up");
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("Down");
                break;
            case KeyEvent.VK_RIGHT:
                deselection();
                textPane.getCaret().caretEnable();
                caretLocation.rightLocation();
                break;
            case KeyEvent.VK_LEFT:
                deselection();
                textPane.getCaret().caretEnable();
                caretLocation.leftLocation();
                break;
            case KeyEvent.VK_DELETE:
                symbolDelete.delete();
                break;
            case KeyEvent.VK_BACK_SPACE:
                symbolDelete.backSpace();
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    void deselection() {
        Iterator<Symbol> itr = symbolStorage.getSelectoinSet().iterator();
        while (itr.hasNext()) {
            itr.next().setBackground(Color.white);
        }
        symbolStorage.getSelectoinSet().clear();
    }
}
