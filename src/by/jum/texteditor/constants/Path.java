package by.jum.texteditor.constants;

public enum Path {
    OPEN_ICON("src\\by\\jum\\texteditor\\icons\\open.png"),
    SAVE_ICON("src\\by\\jum\\texteditor\\icons\\save.png"),
    NEW_FILE_ICON("src\\by\\jum\\texteditor\\icons\\new.png"),

    COPY_ICON("src\\by\\jum\\texteditor\\icons\\copy.png"),
    CUT_ICON("src\\by\\jum\\texteditor\\icons\\cut.png"),
    PASTE_ICON("src\\by\\jum\\texteditor\\icons\\paste.png"),
    BOLD_ICON("src\\by\\jum\\texteditor\\icons\\Formatting (Bold).png"),
    ITALIC_ICON("src\\by\\jum\\texteditor\\icons\\Formatting (Italic).png");


    private String path;


    Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}


