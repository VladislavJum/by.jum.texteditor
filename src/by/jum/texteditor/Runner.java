package by.jum.texteditor;
import by.jum.texteditor.mainwindow.MainWindow;

import javax.swing.*;

/**
 * Created by Vlad on 23.02.2015.
 */
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
