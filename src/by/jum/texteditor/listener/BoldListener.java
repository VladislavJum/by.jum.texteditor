package by.jum.texteditor.listener;

import by.jum.texteditor.windows.textpane.TextPane;

import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoldListener implements ActionListener {
    private JTabbedPane tabbedPane;

    public BoldListener(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JToggleButton toggleButton = (JToggleButton) e.getSource();
        TextPane myTextPane = (TextPane) tabbedPane.getSelectedComponent();

        if (toggleButton.isSelected()) {
            myTextPane.setStyleSymbol(Font.BOLD);
        } else {
            myTextPane.setStyleSymbol(Font.PLAIN);
        }
    }
}
