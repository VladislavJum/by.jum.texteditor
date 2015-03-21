package by.jum.texteditor.mainwindow;

import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

/**
 * Created by Vlad on 20.03.2015.
 */
public class Caret extends JComponent {
    private boolean boolVisible;
    int caretPositionX1, caretPositionY1, caretPositionY2;

    public Caret() {
        caretPositionX1 = 10;
        caretPositionY1 = 5;
        caretPositionY2 = 20;

        setBounds(10, 10, 5, caretPositionY2);
       // setBorder(BorderFactory.createLineBorder(Color.BLUE));
    }

    void setCaretPosition(int caretPositionX1, int caretPositionY1, int caretPositionY2){
        setBounds(caretPositionX1, caretPositionY1, 5, caretPositionY2);

    }
    void myTimer() {

        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!boolVisible) {
                    boolVisible = true;
                    repaint();
                } else {
                    boolVisible = false;
                    repaint();
                }
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (boolVisible) return;
        Graphics2D graphics2D = (Graphics2D) g;
        Line2D caret = new Line2D.Double(2, 0, 2, caretPositionY2);
        graphics2D.draw(caret);
    }

}
