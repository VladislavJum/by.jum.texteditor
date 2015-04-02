package by.jum.texteditor.listener;

import by.jum.texteditor.document.Document;
import by.jum.texteditor.windows.textpane.TextPane;

import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SizeSymbolListener implements ActionListener {
    private JTabbedPane tabbedPane;
    private Document document;

    public SizeSymbolListener(JTabbedPane tabbedPane, Document document) {
        this.tabbedPane = tabbedPane;
        this.document = document;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox comboBox = (JComboBox) e.getSource();
        int newSize = (Integer) comboBox.getSelectedItem();

        TextPane myTextPane = (TextPane) tabbedPane.getSelectedComponent();
        document.setSizeSymbol(newSize);
        myTextPane.requestFocusInWindow();
        //new StringRepaint()
    }
}
