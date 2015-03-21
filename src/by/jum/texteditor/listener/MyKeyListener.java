package by.jum.texteditor.listener;

import by.jum.texteditor.Symbol.Symbol;
import by.jum.texteditor.mainwindow.Caret;
import by.jum.texteditor.mainwindow.MyTextPane;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class MyKeyListener implements KeyListener {
    private MyTextPane myTextPane;
    private String mySymbol = "";
    private int y=10;

    public MyKeyListener(MyTextPane myTextPane, Caret caret) {
        this.myTextPane = myTextPane;

    }

    @Override
    public void keyTyped(KeyEvent e) {
        mySymbol = String.valueOf(e.getKeyChar());
        Symbol symbol = new Symbol(mySymbol, myTextPane);
        myTextPane.add(symbol);

        Graphics2D graphics2D = (Graphics2D) symbol.getGraphics();
        graphics2D.setFont(new Font("Times New Roman", Font.PLAIN, 30));

        int symbolWight = graphics2D.getFontMetrics().stringWidth(mySymbol);

        System.out.println(symbolWight);
        symbol.setBounds(y,10,symbolWight, 40);
        // System.out.println(y);
        y += (4+symbolWight);
        //System.out.println(e.getKeyChar());
        // myTextPane.repaint();

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP) {
            System.out.println("Up");
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
