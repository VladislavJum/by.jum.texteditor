package by.jum.texteditor.listener;

import by.jum.texteditor.Draw;
import by.jum.texteditor.mainwindow.Caret;
import by.jum.texteditor.mainwindow.MyTextPane;
import by.jum.texteditor.symbol.Symbol;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;


public class MyKeyListener implements KeyListener {
    private MyTextPane myTextPane;
    private String mySymbol = "";
    private int step = 10, symbolWight, symbolHeight;
    private List<String> stringSymbolList = new ArrayList<String>();
    private List<Symbol> symbolList = new ArrayList<Symbol>();

    public MyKeyListener(MyTextPane myTextPane) {
        this.myTextPane = myTextPane;

    }

    @Override
    public void keyTyped(KeyEvent e) {
        mySymbol = String.valueOf(e.getKeyChar());
        stringSymbolList.add(mySymbol);


        Font font = myTextPane.getMyFont();
        Caret caret = myTextPane.getCaret();

        // MyFont myFont = new MyFont(font.getFontName(), font.getStyle(), font.getSize());

        Symbol symbol = new Symbol(mySymbol, font);
        symbolList.add(symbol);


        myTextPane.add(symbol);

        Graphics2D graphics2D = (Graphics2D) symbol.getGraphics();
        graphics2D.setFont(font);

        symbolWight = graphics2D.getFontMetrics().stringWidth(mySymbol);
        symbolHeight = 4 + (int) font.getSize2D();

        symbol.setBounds(step, 10, symbolWight, symbolHeight);

        step += (symbolWight);

        caret.setCaretPosition(step, 10, symbolHeight);
        caret.getCaretPositionX();

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP) {
            System.out.println("Up");
            new Draw(myTextPane, stringSymbolList, symbolList);
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
