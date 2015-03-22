package by.jum.texteditor.document;

import java.awt.Font;

public class MyFont {

    private Font font;

    public MyFont(String name, int style, int size) {
        font = new Font(name, style, size);
    }

    public Font getFont() {
        return font;
    }
}
