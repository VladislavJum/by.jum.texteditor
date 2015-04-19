package by.jum.texteditor.windows.symbol;

import by.jum.texteditor.document.Document;
import by.jum.texteditor.windows.Caret;
import by.jum.texteditor.windows.TextPane;

import javax.swing.JFrame;
import java.awt.Component;
import java.util.Iterator;
import java.util.List;

public class SymbolCreator {
    private Component component;
    private TextPane textPane;
    private SymbolStorage symbolStorage;
    private Document document;
    private Symbol symbol;
    private JFrame frame;

    public SymbolCreator(TextPane textPane, Document document, SymbolStorage symbolStorage, JFrame frame) {
        this.textPane = textPane;
        this.document = document;
        this.symbolStorage = symbolStorage;
        this.frame = frame;
    }

    public void createSymbol(String symbolString) {
        Iterator<Symbol> itr = symbolStorage.getSelectoinSet().iterator();
        while (itr.hasNext()) {
            Symbol selectionSymbol = itr.next();
            symbolStorage.getSymbolList().remove(selectionSymbol);
            textPane.remove(selectionSymbol);
        }
        textPane.updateUI();
        textPane.getCaret().caretEnable();
        symbolStorage.getSelectoinSet().clear();

        symbol = new Symbol(symbolString, document);

        addSymbol();
        SymbolLocation symbolLocation = new SymbolLocation(textPane, symbolStorage, frame);


        symbolLocation.setCurrentSymbol(symbol);
        symbolLocation.symbolLocate();


       /* symbolLocation.setCurrentSymbol(symbol);
        symbolLocation.symbolLocate();*/
    }

    void addSymbol() {
        List<Symbol> symbolList = symbolStorage.getSymbolList();
        Caret caret = textPane.getCaret();

        component = textPane.getComponentAt(caret.getCaretPositionX1() - 1,
                caret.getCaretPositionY1() + caret.getCaretPositionY2() - 1);

        if (component != null && component.getName() != null) {
            Symbol symbol1 = (Symbol) component;
            symbolList.add(symbolList.indexOf(symbol1) + 1, symbol);
        } else {
            component = textPane.getComponentAt(caret.getCaretPositionX1() + 4,
                    caret.getCaretPositionY1() + caret.getCaretPositionY2() - 1);
            if (component != null && component.getName() != null) {
                Symbol symbol1 = (Symbol) component;
                symbolList.add(symbolList.indexOf(symbol1), symbol);
            } else {
                symbolList.add(symbol);
            }
        }

        textPane.add(symbol);
    }


}
