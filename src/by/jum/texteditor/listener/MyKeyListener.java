package by.jum.texteditor.listener;

import by.jum.texteditor.Symbol.Symbol;
import by.jum.texteditor.mainwindow.MyTextPane;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Vlad on 17.03.2015.
 */
public class MyKeyListener implements KeyListener {
    private MyTextPane myTextPane;
    private String text = "";
    private int x = 20;

    public MyKeyListener(MyTextPane myTextPane) {
        this.myTextPane = myTextPane;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        text += e.getKeyChar();
        Symbol symbol = new Symbol(String.valueOf(e.getKeyChar()), myTextPane);
        symbol.setBounds(x,20,10,20);
        x+=8;
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
