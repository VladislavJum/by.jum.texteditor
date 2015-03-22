package by.jum.texteditor.builder;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

/**
 * Created by Vlad on 22.03.2015.
 */
public class MenuBuilder implements Build<JMenu> {
    JMenu fileMenu;
    JMenu editMenu;
    JMenuItem newFileItem;
    JMenuItem openFileItem;
    JMenuItem saveFileItem;
    JMenuItem saveAsFileItem;
    JMenuItem closeFileItem;
    JMenuItem exitFileItem;
    JMenuItem copyEditItem;
    JMenuItem cutEditItem;
    JMenuItem pasteEditItem;
    private JFrame mainWindow;
    private JComboBox<String> comboBox;
    private JTabbedPane tabbedPane;
    private JMenuBar mainMenu;

    public MenuBuilder TebbedPane(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;

        return this;

    }

    public MenuBuilder MenuBar(JMenuBar mainMenu) {
        this.mainMenu = mainMenu;

        return this;
    }


    @Override
    public JMenu build() {
        return null;
    }


}
