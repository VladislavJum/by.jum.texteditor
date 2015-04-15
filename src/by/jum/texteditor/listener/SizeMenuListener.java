package by.jum.texteditor.listener;

import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SizeMenuListener implements ActionListener{
    private JComboBox comboBox;
    private int size;

    public SizeMenuListener(JComboBox comboBox, int size) {
        this.comboBox = comboBox;
        this.size = size;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        comboBox.setSelectedItem(size);
    }
}



