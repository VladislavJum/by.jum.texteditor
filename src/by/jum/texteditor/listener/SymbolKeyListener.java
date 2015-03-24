package by.jum.texteditor.listener;

import by.jum.texteditor.mainwindow.TextPane;
import by.jum.texteditor.symbol.SymbolCreator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class SymbolKeyListener implements KeyListener {
    private TextPane myTextPane;
    private String symbolString = "";
    private SymbolCreator mySymbolCreator;

    public SymbolKeyListener(TextPane myTextPane) {
        this.myTextPane = myTextPane;
        mySymbolCreator = new SymbolCreator(myTextPane);


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
           // new Draw(myTextPane, stringSymbolList, symbolList);
            /*caretPositionY1 -= 20;
            caretPositionY2 -= 20;
            repaint();*/
        } else if (keyCode == KeyEvent.VK_DOWN) {
            System.out.println("Down");
           /* caretPositionY1 += 20;
            caretPositionY2 += 20;
            repaint();*/
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            System.out.println("Right");
           /* caretPositionX1 += 10;
            caretPositionX2 += 10;
            repaint();*/
        } else if (keyCode == KeyEvent.VK_LEFT) {
            System.out.println("Left");
            /*caretPositionX1 -= 10;
            caretPositionX2 -= 10;
            repaint();*/
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
