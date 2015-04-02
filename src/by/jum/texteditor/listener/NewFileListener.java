package by.jum.texteditor.listener;

import by.jum.texteditor.document.Document;
import by.jum.texteditor.windows.textpane.TextPane;
import by.jum.texteditor.windows.textpane.TextPaneCreator;

import javax.swing.JTabbedPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewFileListener implements ActionListener {
    private JTabbedPane tabbedPane;
    private Document document;

    public NewFileListener(JTabbedPane tabbedPane, Document document) {
        this.tabbedPane = tabbedPane;
        this.document = document;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TextPaneCreator textPanel = new TextPaneCreator();
        TextPane myTextPane = textPanel.createMyTextPane(document);

        tabbedPane.add("untitled", myTextPane);
        tabbedPane.setSelectedComponent(myTextPane);
        tabbedPane.getSelectedComponent().requestFocusInWindow();
    }
}
