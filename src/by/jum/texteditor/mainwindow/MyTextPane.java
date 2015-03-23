package by.jum.texteditor.mainwindow;

import by.jum.texteditor.listener.MyKeyListener;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

public class MyTextPane extends JPanel {
    private Caret caret;
    private Font font;
    private int caretPositionX1, caretPositionX2, caretPositionY1, caretPositionY2;
    private String nameStyle = "Calibri";
    private int style = Font.PLAIN, size = 24;

    public MyTextPane() {
        font = new Font(nameStyle, style, size);
        caretPositionX1 = 10;
        caretPositionY1 = 5;
        caretPositionY2 = 20;
        setLayout(null);
        setBackground(Color.white);
        setCursor(new Cursor(Cursor.TEXT_CURSOR));
        addKeyListener(new MyKeyListener(this));

        caret = new Caret();
        caret.myTimer();
        add(caret);
    }

    public Caret getCaret() {
        return caret;
    }

    public Font getMyFont(){
        return font;
    }

    public void setNameStyleSymbol(String nameStyle){
        this.nameStyle = nameStyle;
        this.font = new Font(nameStyle, style, size);
    }

    public void setStyleSymbol(int style){
        this.style = style;
        this.font = new Font(nameStyle, style, size);
    }

    public void setSizeSymbol(int size){
        this.size = size;
        this.font = new Font(nameStyle, style, size);
    }

}
