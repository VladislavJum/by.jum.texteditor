package by.jum.texteditor.mainwindow;

import by.jum.texteditor.constants.MenuName;
import by.jum.texteditor.constants.Path;
import by.jum.texteditor.listener.SizeComboboxListener;
import by.jum.texteditor.listener.StyleComboBoxListener;
import by.jum.texteditor.listener.TabbedChangeListener;
import by.jum.texteditor.listener.filelistener.CloseListener;
import by.jum.texteditor.listener.filelistener.NewFileListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;


public class MainWindow {
    private JFrame mainWindow;
    private JComboBox<String> styleComboBox;
    private JComboBox<Integer> sizeComboBox;
    private JTabbedPane tabbedPane;

    public MainWindow() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        mainWindow = new JFrame(MenuName.TITLE);
        mainWindow.setSize(600, 600);
        mainWindow.setLayout(new BorderLayout());
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setLocationRelativeTo(null);

        styleComboBox = new JComboBox<String>(MenuName.NAME_STYLES);
        sizeComboBox = new JComboBox<Integer>(MenuName.SIZE_STYLE);
        sizeComboBox.setSelectedIndex(7);
        styleComboBox.setSelectedIndex(0);



        tabbedPane = new JTabbedPane();
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        tabbedPane.addChangeListener(new TabbedChangeListener(tabbedPane));

        mainWindow.add(tabbedPane, BorderLayout.CENTER);

        createItem();
        createToolBar();

        mainWindow.setVisible(true);
        styleComboBox.addActionListener(new StyleComboBoxListener(tabbedPane));
        sizeComboBox.addActionListener(new SizeComboboxListener(tabbedPane));
    }

    void createItem() {

        JMenuBar mainMenu = new JMenuBar();
        JMenu fileMenu = new JMenu(MenuName.FILE);
        JMenu editMenu = new JMenu(MenuName.EDIT);

        fileMenu.setMnemonic(KeyEvent.VK_F);
        editMenu.setMnemonic(KeyEvent.VK_E);

        JMenuItem newFileItem = new JMenuItem(MenuName.NEW_FILE, KeyEvent.VK_N);
        JMenuItem openFileItem = new JMenuItem(MenuName.OPEN_FILE, KeyEvent.VK_O);
        JMenuItem saveFileItem = new JMenuItem(MenuName.SAVE_FILE, KeyEvent.VK_S);
        JMenuItem saveAsFileItem = new JMenuItem(MenuName.SAVE_AS, KeyEvent.VK_A);
        JMenuItem closeFileItem = new JMenuItem(MenuName.CLOSE_FILE);
        JMenuItem exitFileItem = new JMenuItem(MenuName.EXIT, KeyEvent.VK_E);

        JMenuItem copyEditItem = new JMenuItem(MenuName.COPY, KeyEvent.VK_C);
        JMenuItem cutEditItem = new JMenuItem(MenuName.CUT, KeyEvent.VK_X);
        JMenuItem pasteEditItem = new JMenuItem(MenuName.PASTE, KeyEvent.VK_V);

        ImageIcon openFileIcon = new ImageIcon(Path.OPEN_ICON.getPath());
        ImageIcon copyIcon = new ImageIcon(Path.COPY_ICON.getPath());
        ImageIcon cutIcon = new ImageIcon(Path.CUT_ICON.getPath());
        ImageIcon pasteIcon = new ImageIcon(Path.PASTE_ICON.getPath());

        copyEditItem.setIcon(copyIcon);
        cutEditItem.setIcon(cutIcon);
        pasteEditItem.setIcon(pasteIcon);
        openFileItem.setIcon(openFileIcon);

        newFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        openFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        saveFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        saveAsFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK + InputEvent.SHIFT_MASK));
        exitFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));

        copyEditItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
        cutEditItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
        pasteEditItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));

        editMenu.add(copyEditItem);
        editMenu.add(cutEditItem);
        editMenu.add(pasteEditItem);

        fileMenu.add(newFileItem);
        fileMenu.add(openFileItem);
        fileMenu.add(saveFileItem);
        fileMenu.add(saveAsFileItem);
        fileMenu.add(closeFileItem);
        fileMenu.addSeparator();
        fileMenu.add(exitFileItem);

        mainMenu.add(fileMenu);
        mainMenu.add(editMenu);

        mainWindow.setJMenuBar(mainMenu);

       /* CopyCutPasteListener copyCutPasteListener = new CopyCutPasteListener(tabbedPane);

        copyEditItem.addActionListener(copyCutPasteListener);
        cutEditItem.addActionListener(copyCutPasteListener);
        pasteEditItem.addActionListener(copyCutPasteListener);*/
        newFileItem.addActionListener(new NewFileListener(tabbedPane));
        closeFileItem.addActionListener(new CloseListener(tabbedPane));
        exitFileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    void createToolBar() {
        JToolBar toolBar = new JToolBar();
        toolBar.setBackground(new Color(186, 186, 186));
        toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));

        JToggleButton boldButton = new JToggleButton(new ImageIcon(Path.BOLD_ICON.getPath()));
        JToggleButton italicButton = new JToggleButton(new ImageIcon(Path.ITALIC_ICON.getPath()));
        JButton saveButton = new JButton(new ImageIcon(Path.SAVE_ICON.getPath()));
        JButton openFileButton = new JButton(new ImageIcon(Path.OPEN_ICON.getPath()));
        JButton newFileButton = new JButton(new ImageIcon(Path.NEW_FILE_ICON.getPath()));

        boldButton.setActionCommand(MenuName.BOLD);
        italicButton.setActionCommand(MenuName.ITALIC);
        saveButton.setActionCommand(MenuName.SAVE_FILE);
        openFileButton.setActionCommand(MenuName.OPEN_FILE);
        newFileButton.setActionCommand(MenuName.NEW_FILE);

        toolBar.add(newFileButton);
        toolBar.add(openFileButton);
        toolBar.add(saveButton);
        toolBar.add(boldButton);
        toolBar.add(italicButton);


        Choice choice = new Choice();
        choice.add("sd");
        choice.add("sd1");
        choice.add("sd2");


        toolBar.add(sizeComboBox);
        toolBar.add(styleComboBox);
        toolBar.setFloatable(false);
        mainWindow.add(toolBar, BorderLayout.NORTH);
        mainWindow.setVisible(true);


       /* caret.addChangeListener(new AttributeListener(tabbedPane, toolBar));
        tabbedPane.addChangeListener(new TabbedPaneListener(tabbedPane, toolBar));
        boldButton.addActionListener(new BoldListener(tabbedPane));
        italicButton.addActionListener(new ItalicListener(tabbedPane));
*/
        newFileButton.addActionListener(new NewFileListener(tabbedPane));
    }

}
