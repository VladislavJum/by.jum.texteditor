package by.jum.texteditor.windows.textpane;

import by.jum.texteditor.listener.SymbolKeyListener;
import by.jum.texteditor.windows.Caret;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

public class TextPane extends JPanel {
    private Caret caret;
    private Font font;
    private String nameStyle = "Calibri";
    private int style = Font.PLAIN, size = 24;

    public TextPane() {
        font = new Font(nameStyle, style, size);
        setLayout(null);
        setBackground(Color.white);
        setCursor(new Cursor(Cursor.TEXT_CURSOR));
        addKeyListener(new SymbolKeyListener(this));

        caret = new Caret();
        caret.caretBlink();
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
        this.requestFocusInWindow();
    }

    public void setStyleSymbol(int style){
        this.style = style;
        this.font = new Font(nameStyle, style, size);
        this.requestFocusInWindow();
    }

    public void setSizeSymbol(int size){
        this.size = size;
        this.font = new Font(nameStyle, style, size);
        this.requestFocusInWindow();
    }

    public int getSizeSymbol(){
        return size;
    }

}
