package by.jum.texteditor;

import by.jum.texteditor.mainwindow.MainWindow;

import javax.swing.SwingUtilities;

public class Runner {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }
}
