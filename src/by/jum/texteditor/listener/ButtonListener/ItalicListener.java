package by.jum.texteditor.listener.ButtonListener;

import by.jum.texteditor.mainwindow.TextPane;

import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItalicListener implements ActionListener {
    private JTabbedPane tabbedPane;

    public ItalicListener(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JToggleButton toggleButton = (JToggleButton) e.getSource();
        TextPane myTextPane = (TextPane) tabbedPane.getSelectedComponent();

        if (toggleButton.isSelected()) {
            myTextPane.setStyleSymbol(Font.ITALIC);
        } else {
            myTextPane.setStyleSymbol(Font.PLAIN);
        }
        myTextPane.requestFocusInWindow();
    }
}
