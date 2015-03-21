package by.jum.texteditor.mainwindow;

import by.jum.texteditor.listener.MyKeyListener;

import javax.swing.*;
import java.awt.*;

public class MyTextPane extends JPanel {
    private Caret caret;
    private int caretPositionX1, caretPositionX2, caretPositionY1, caretPositionY2;

    public MyTextPane() {
        caretPositionX1 = 10;
        caretPositionY1 = 5;
        caretPositionY2 = 20;
        setLayout(null);
        setBackground(Color.white);
        setCursor(new Cursor(Cursor.TEXT_CURSOR));
        addKeyListener(new MyKeyListener(this, caret));

        caret = new Caret();
        caret.myTimer();
        add(caret);
    }

}
