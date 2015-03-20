package by.jum.texteditor.mainwindow;

import by.jum.texteditor.listener.TabbedChangeListener;
import by.jum.texteditor.listener.filelistener.CloseListener;
import by.jum.texteditor.listener.filelistener.NewFileListener;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;


public class MainWindow {
    private JFrame mainWindow;
    private JComboBox comboBox;
    private JTabbedPane tabbedPane;

    public MainWindow() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        mainWindow = new JFrame("My Text Editor");
        mainWindow.setSize(600, 600);
        mainWindow.setLayout(new BorderLayout());
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setLocationRelativeTo(null);

        comboBox = new JComboBox(new String[]{"Times New Roman", "Calibri"});
        comboBox.setEditable(true);

        tabbedPane = new JTabbedPane();
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        tabbedPane.addChangeListener(new TabbedChangeListener(tabbedPane));

        mainWindow.add(tabbedPane, BorderLayout.CENTER);

        createItem();
        createToolBar();

        mainWindow.setVisible(true);
       // comboBox.addActionListener(new ComboBoxListener(tabbedPane));
    }

    void createItem() {
        JMenuBar mainMenu = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");

        fileMenu.setMnemonic(KeyEvent.VK_F);
        editMenu.setMnemonic(KeyEvent.VK_E);

        JMenuItem newFileItem = new JMenuItem("New File", KeyEvent.VK_N);
        JMenuItem openFileItem = new JMenuItem("Open File...", KeyEvent.VK_O);
        JMenuItem saveFileItem = new JMenuItem("Save", KeyEvent.VK_S);
        JMenuItem saveAsFileItem = new JMenuItem("Save As...", KeyEvent.VK_A);
        JMenuItem closeFileItem = new JMenuItem("Close File");
        JMenuItem exitFileItem = new JMenuItem("Exit", KeyEvent.VK_E);

        JMenuItem copyEditItem = new JMenuItem("Copy", KeyEvent.VK_C);
        JMenuItem cutEditItem = new JMenuItem("Cut", KeyEvent.VK_X);
        JMenuItem pasteEditItem = new JMenuItem("Paste", KeyEvent.VK_V);

        ImageIcon openFileIcon = new ImageIcon("src\\by\\jum\\texteditor\\icons\\open.png");
        ImageIcon copyIcon = new ImageIcon("src\\by\\jum\\texteditor\\icons\\copy.png");
        ImageIcon cutIcon = new ImageIcon("src\\by\\jum\\texteditor\\icons\\cut.png");
        ImageIcon pasteIcon = new ImageIcon("src\\by\\jum\\texteditor\\icons\\paste.png");

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
        JToolBar toolBar = new JToolBar("Instruments");
        toolBar.setBackground(new Color(186, 186, 186));
        toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));

        JToggleButton boldButton = new JToggleButton(new ImageIcon("src\\by\\jum\\texteditor\\icons\\Formatting (Bold).png"));
        JToggleButton italicButton = new JToggleButton(new ImageIcon("src\\by\\jum\\texteditor\\icons\\Formatting (Italic).png"));
        JButton saveButton = new JButton(new ImageIcon("src\\by\\jum\\texteditor/icons\\save.png"));
        JButton openFileButton = new JButton(new ImageIcon("src\\by\\jum\\texteditor\\icons\\open.png"));
        JButton newFileButton = new JButton(new ImageIcon("src\\by\\jum\\texteditor\\icons\\new.png"));

        boldButton.setActionCommand("Bold");
        italicButton.setActionCommand("Italic");
        saveButton.setActionCommand("Save");
        openFileButton.setActionCommand("Open File");
        newFileButton.setActionCommand("New File");

        toolBar.add(newFileButton);
        toolBar.add(openFileButton);
        toolBar.add(saveButton);
        toolBar.add(boldButton);
        toolBar.add(italicButton);

        Choice choice = new Choice();
        choice.add("sd");
        choice.add("sd1");
        choice.add("sd2");

        toolBar.add(comboBox);
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
