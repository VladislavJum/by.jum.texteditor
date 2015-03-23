package by.jum.texteditor.listener;

import by.jum.texteditor.mainwindow.MyTextPane;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FocusMyTextPaneListener implements MouseListener {
    private MyTextPane myTextPane;

    public FocusMyTextPaneListener(MyTextPane myTextPane) {
        this.myTextPane = myTextPane;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        myTextPane.requestFocusInWindow();

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
