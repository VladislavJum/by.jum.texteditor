package by.jum.texteditor.listener;

import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StyleMenuListener implements ActionListener {
    private JComboBox comboBox;
    private String name;

    public StyleMenuListener(JComboBox comboBox, String name) {
        this.comboBox = comboBox;
        this.name = name;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        comboBox.setSelectedItem(name);
    }
}
