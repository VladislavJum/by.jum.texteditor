package by.jum.texteditor.listener;

import by.jum.texteditor.document.Document;
import by.jum.texteditor.windows.TextPane;
import by.jum.texteditor.windows.TextPaneCreator;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewFileListener implements ActionListener {
    private JTabbedPane tabbedPane;
    private Document document;
    private JFrame frame;

    public NewFileListener(JTabbedPane tabbedPane, Document document, JFrame frame) {
        this.tabbedPane = tabbedPane;
        this.document = document;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TextPaneCreator textPanel = new TextPaneCreator();
        TextPane textPane = textPanel.createMyTextPane(document, frame);
        textPane.getSymbolStorage().clearAll();

        tabbedPane.add("untitled", textPane);
        tabbedPane.setSelectedComponent(textPane);
        textPane.requestFocusInWindow();
    }
}
