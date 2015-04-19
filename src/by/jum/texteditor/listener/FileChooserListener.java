package by.jum.texteditor.listener;

import by.jum.texteditor.TXTFile;
import by.jum.texteditor.XMLFile;
import by.jum.texteditor.document.Document;
import by.jum.texteditor.windows.TextPane;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by Vlad on 13.04.2015.
 */
public class FileChooserListener implements ActionListener {
    private JFileChooser jFileChooser;
    private Document document;
    private JButton button;
    private JTabbedPane tabbedPane;
    private TextPane textPane;
    private JFrame frame;


    public FileChooserListener(Document document, JButton button, JTabbedPane tabbedPane, JFrame frame) {
        this.document = document;
        this.button = button;
        this.tabbedPane = tabbedPane;
        this.frame = frame;
        jFileChooser = new JFileChooser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jFileChooser.setCurrentDirectory(new File("E:\\MyTestFiles"));
        int result = jFileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            if (jFileChooser.getSelectedFile().getName().contains(".xml")) {
                button.doClick();
                textPane = (TextPane) tabbedPane.getSelectedComponent();
                new XMLFile(jFileChooser.getSelectedFile().getPath(), tabbedPane, frame).readFile(document);
            } else if (jFileChooser.getSelectedFile().getName().contains(".txt")) {
                try {
                    new TXTFile(jFileChooser.getSelectedFile().getPath(), tabbedPane, frame).readFile();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

    }

}

