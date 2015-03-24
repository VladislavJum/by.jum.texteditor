package by.jum.texteditor.listener.filelistener;

import by.jum.texteditor.mainwindow.TextPaneCreator;
import by.jum.texteditor.mainwindow.TextPane;

import javax.swing.JTabbedPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewFileListener implements ActionListener {
    private JTabbedPane tabbedPane;

    public NewFileListener(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TextPaneCreator textPanel = new TextPaneCreator();
        TextPane myTextPane = textPanel.createMyTextPane();

        tabbedPane.add("untitled", myTextPane);
        tabbedPane.setSelectedComponent(myTextPane);
        tabbedPane.getSelectedComponent().requestFocusInWindow();
    }


}
