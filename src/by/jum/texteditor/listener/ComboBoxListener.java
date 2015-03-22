package by.jum.texteditor.listener;

import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxListener implements ActionListener {
    public ComboBoxListener(JTabbedPane tabbedPane) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox comboBox = (JComboBox) e.getSource();
        String nameStyle = String.valueOf(comboBox.getSelectedItem());
    }
}
