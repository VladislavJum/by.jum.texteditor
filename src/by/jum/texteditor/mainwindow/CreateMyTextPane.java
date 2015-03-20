package by.jum.texteditor.mainwindow;

import by.jum.texteditor.listener.FocusMyTextPaneListener;

import javax.swing.border.LineBorder;


public class CreateMyTextPane {

    public MyTextPane createMyTextPane() {
        MyTextPane myTextPane = new MyTextPane();
        myTextPane.setBorder(LineBorder.createBlackLineBorder());
        myTextPane.addMouseListener(new FocusMyTextPaneListener(myTextPane));
        //tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), "fg");
        return myTextPane;
    }
}
