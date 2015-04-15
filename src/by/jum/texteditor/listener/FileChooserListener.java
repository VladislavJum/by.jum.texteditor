package by.jum.texteditor.listener;

import by.jum.texteditor.XMLFile;
import by.jum.texteditor.document.Document;
import by.jum.texteditor.windows.TextPane;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vlad on 13.04.2015.
 */
public class FileChooserListener implements ActionListener {
    private JFileChooser jFileChooser;
    private Document document;
    private JButton button;
    private JTabbedPane tabbedPane;
    private TextPane textPane;

    public FileChooserListener(Document document, JButton button, JTabbedPane tabbedPane) {
        this.document = document;
        this.button = button;
        this.tabbedPane = tabbedPane;
        jFileChooser = new JFileChooser();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int result = jFileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            button.doClick();
            textPane = (TextPane) tabbedPane.getSelectedComponent();
            new XMLFile(jFileChooser.getSelectedFile().getPath(), tabbedPane).readFile(document);
        }

    }
}

