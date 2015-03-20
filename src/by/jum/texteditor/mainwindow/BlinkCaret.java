package by.jum.texteditor.mainwindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

/**
 * Created by Vlad on 20.03.2015.
 */
public class BlinkCaret {
    private boolean boolVisible;
    private JPanel myTextPane;

    public BlinkCaret(JPanel myTextPane) {
        this.myTextPane = myTextPane;
    }

    void myTimer() {
        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!boolVisible) {
                    boolVisible = true;
                    myTextPane.repaint();
                } else {
                    boolVisible = false;
                    myTextPane.repaint();
                }
            }
        });
        timer.start();
    }

    void paintCaret(Graphics2D graphics2D, int caretPositionX1, int caretPositionY1, int caretPositionX2, int caretPositionY2){
        if (boolVisible) return;
        Line2D caret = new Line2D.Double(caretPositionX1, caretPositionY1, caretPositionX2, caretPositionY2);
        graphics2D.draw(caret);
    }
}
