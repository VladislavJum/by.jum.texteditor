package by.jum.texteditor;

import by.jum.texteditor.document.Document;
import by.jum.texteditor.windows.TextPane;
import by.jum.texteditor.windows.symbol.Symbol;
import by.jum.texteditor.windows.symbol.SymbolLocation;
import by.jum.texteditor.windows.symbol.SymbolStorage;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by Vlad on 16.04.2015.
 */
public class TXTFile {
    private SymbolStorage symbolStorage;
    private List<Symbol> list;
    private String nameFile;
    private TextPane textPane;
    private Document document;
    private BufferedReader bufferedReader;
    private JFrame frame;

    public TXTFile(String nameFile, JTabbedPane tabbedPane, JFrame frame) {
        this.nameFile = nameFile;
        this.frame = frame;
        textPane = (TextPane) tabbedPane.getSelectedComponent();
        symbolStorage = textPane.getSymbolStorage();
        list = symbolStorage.getSymbolList();
        document = new Document();
    }

    public void readFile() throws IOException {
        bufferedReader = new BufferedReader(new FileReader(nameFile));
        while (bufferedReader.ready()) {
            String ss = String.valueOf((char) bufferedReader.read());
            Symbol symbol = new Symbol(ss, document);
            textPane.add(symbol);
            list.add(symbol);
        }
        new SymbolLocation(textPane, symbolStorage, frame).symbolLocate();
    }
}
