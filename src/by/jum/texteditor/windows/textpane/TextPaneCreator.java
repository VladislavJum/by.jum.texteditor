package by.jum.texteditor.windows.textpane;

import by.jum.texteditor.listener.FocusTextPaneListener;

import javax.swing.border.LineBorder;

public class TextPaneCreator {

    public TextPane createMyTextPane() {
        TextPane myTextPane = new TextPane();
        myTextPane.setBorder(LineBorder.createBlackLineBorder());
        myTextPane.addMouseListener(new FocusTextPaneListener(myTextPane));
        //tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), "fg");
        return myTextPane;
    }
}
