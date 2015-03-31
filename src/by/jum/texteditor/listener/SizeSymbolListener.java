package by.jum.texteditor.listener;

import by.jum.texteditor.windows.textpane.TextPane;

import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SizeSymbolListener implements ActionListener {
    private JTabbedPane tabbedPane;

    public SizeSymbolListener(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox comboBox = (JComboBox) e.getSource();
        int newSize = (Integer) comboBox.getSelectedItem();

        TextPane myTextPane = (TextPane) tabbedPane.getSelectedComponent();

        int oldSize = myTextPane.getSizeSymbol();

        if(newSize > oldSize ){



        }
        myTextPane.setSizeSymbol(newSize);
        //new StringRepaint()
    }
}
