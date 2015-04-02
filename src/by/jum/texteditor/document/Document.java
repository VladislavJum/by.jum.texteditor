package by.jum.texteditor.document;

import java.awt.Font;

public class Document {
    private String nameStyle = "Calibri";
    private int style = Font.PLAIN, size = 24;

    private Font font;

    public Document() {
        font = new Font(nameStyle, style, size);
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

    public void setMyFont(Font font){
        this.font = font;
    }

    public int getSizeSymbol(){
        return size;
    }
}
