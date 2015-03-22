package by.jum.texteditor.document;

public class CreateDocument {
    private String name;
    private int style;
    private int size;

    public CreateDocument(int style) {
        this.style = style;
    }


    public CreateDocument(String name) {

        this.name = name;
    }

    MyFont createDoc() {
        MyFont myFont = new MyFont(name, style, size);
        return myFont;
    }


}
