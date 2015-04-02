package by.jum.texteditor.listener;

import by.jum.texteditor.document.Document;
import by.jum.texteditor.symbol.SymbolCreator;
import by.jum.texteditor.windows.textpane.TextPane;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class SymbolKeyListener implements KeyListener {
    private TextPane myTextPane;
    private String symbolString = "";
    private SymbolCreator mySymbolCreator;
    private Document document;

    public SymbolKeyListener(TextPane myTextPane, Document document) {
        this.myTextPane = myTextPane;
        this.document = document;
        mySymbolCreator = new SymbolCreator(myTextPane, document);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        symbolString = String.valueOf(e.getKeyChar());
        mySymbolCreator.createSymbol(symbolString);

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP) {
            System.out.println("Up");
        } else if (keyCode == KeyEvent.VK_DOWN) {
            System.out.println("Down");
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            System.out.println("Right");
        } else if (keyCode == KeyEvent.VK_LEFT) {
            System.out.println("Left");
        } else if (keyCode == KeyEvent.VK_DELETE) {
            System.out.println("Delete");
        } else if (keyCode == KeyEvent.VK_BACK_SPACE) {
            System.out.println("BackSpace");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
