package by.jum.texteditor.listener;

import by.jum.texteditor.document.Document;

import javax.swing.JToggleButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoldListener implements ActionListener {
    private Document document;

    public BoldListener(Document document) {
        this.document = document;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JToggleButton toggleButton = (JToggleButton) e.getSource();

        if (toggleButton.isSelected()) {
            document.setStyleSymbol(Font.BOLD);
        } else {
            document.setStyleSymbol(Font.PLAIN);
        }
    }
}
