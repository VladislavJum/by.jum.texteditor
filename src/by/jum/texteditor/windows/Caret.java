package by.jum.texteditor.windows;

import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

public class Caret extends JComponent {
    private int caretPositionX1 = 10;
    private int caretPositionY1 = 5;
    private int caretPositionY2 = 20;
    private boolean boolVisible;
    private Timer timer;

    public Caret() {
        setBounds(10, 10, 3, caretPositionY2);
        //setBorder(BorderFactory.createLineBorder(Color.BLUE));
    }

    public void setCaretPosition(int caretPositionX1, int caretPositionY1, int caretPositionY2) {
        this.caretPositionY2 = caretPositionY2;
        this.caretPositionX1 = caretPositionX1;
        this.caretPositionY1 = caretPositionY1;
        setBounds(caretPositionX1, caretPositionY1, 3, caretPositionY2);
    }

    public int getCaretPositionX1() {
        return caretPositionX1;
    }

    public int getCaretPositionY1() {
        return caretPositionY1;
    }

    public int getCaretPositionY2() {
        return caretPositionY2;
    }


    public void caretBlink() {

        timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolVisible = !boolVisible;
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (boolVisible) return;
        Graphics2D graphics2D = (Graphics2D) g;
        Line2D caret = new Line2D.Double(1, 0, 1, caretPositionY2);
        graphics2D.draw(caret);
    }

    public void caretDisable() {
        boolVisible = true;
        timer.stop();
        repaint();
    }

    public void caretEnable() {
        timer.start();
    }

}
