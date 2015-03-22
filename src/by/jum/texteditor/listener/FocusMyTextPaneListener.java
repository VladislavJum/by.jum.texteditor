package by.jum.texteditor.listener;

import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FocusMyTextPaneListener implements MouseListener {
    private JPanel panel;

    public FocusMyTextPaneListener(JPanel panel) {
        this.panel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        panel.requestFocusInWindow();

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
