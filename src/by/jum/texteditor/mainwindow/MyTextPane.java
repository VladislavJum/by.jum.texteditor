package by.jum.texteditor.mainwindow;

import by.jum.texteditor.listener.MyKeyListener;

import javax.swing.*;
import java.awt.*;

public class MyTextPane extends JPanel {
    private String text = "";
    private Graphics2D graphics2D;
    private BlinkCaret blinkCaret;
    private int caretPositionX1, caretPositionX2, caretPositionY1, caretPositionY2;

    public MyTextPane() {
        caretPositionX1 = 10;
        caretPositionX2 = 10;
        caretPositionY1 = 5;
        caretPositionY2 = 25;
        //setPreferredSize(new Dimension(2000,2000));
        //JScrollPane jScrollPane = new JScrollPane(this);
        //jScrollPane.setPreferredSize(new Dimension(20, 20));
        //  jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        setCursor(new Cursor(2));
        addKeyListener(new MyKeyListener(this));

        blinkCaret = new BlinkCaret(this);
        blinkCaret.myTimer();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        graphics2D = (Graphics2D) g;
       /* graphics2D.setPaint(Color.WHITE);
        graphics2D.fillRect(0, 0, getWidth(), getHeight());
        graphics2D.setPaint(Color.BLACK);

        //   g2d.setPaint(Color.BLACK);
        int y = 20, step = 20;
        String[] lines = text.split("\n");

        for (String line : lines) {
            graphics2D.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            graphics2D.drawString(line, 10, 20);
            y += step;
        }
*/
           blinkCaret.paintCaret(graphics2D, caretPositionX1, caretPositionY1, caretPositionX2, caretPositionY2);
    }



}
