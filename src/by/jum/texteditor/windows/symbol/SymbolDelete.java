package by.jum.texteditor.windows.symbol;

import by.jum.texteditor.windows.Caret;
import by.jum.texteditor.windows.CaretLocation;
import by.jum.texteditor.windows.TextPane;

import java.awt.Component;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SymbolDelete {
    private TextPane textPane;
    private SymbolStorage symbolStorage;
    private Set<Symbol> selectionSet;
    private List<Symbol> symbolList;
    private Symbol firstSelectionSymbol;
    private Symbol lastSelectionSymbol;

    public SymbolDelete(TextPane textPane, SymbolStorage symbolStorage) {
        this.textPane = textPane;
        this.symbolStorage = symbolStorage;
        selectionSet = symbolStorage.getSelectoinSet();
        symbolList = symbolStorage.getSymbolList();
    }

    public void backSpace() {
        if (checkSelect()) {
            deleteSelection();
        } else {
            Caret caret = textPane.getCaret();
            if(firstSelectionSymbol != null) {
                caret.setCaretPosition(firstSelectionSymbol.getSymbolPositionX1() + firstSelectionSymbol.getSymbolWidth(),
                        firstSelectionSymbol.getSymbolPositionY1(), firstSelectionSymbol.getSymbolHeight());
                selectionSet.clear();
            }
            //удаляет один символ (нет выделения)
            Symbol symbol = new CaretLocation(textPane).leftLocation();
            if (symbol != null) {
                symbolList.remove(symbol);
                textPane.remove(symbol);
                new SymbolLocation(textPane, symbolStorage).symbolLocate();
                textPane.updateUI();
            }
            caret.caretEnable();
        }
    }

    public void delete() {
        if (checkSelect()) {
            deleteSelection();
        } else {
            Caret caret = textPane.getCaret();
            if(firstSelectionSymbol != null) {
                caret.setCaretPosition(firstSelectionSymbol.getSymbolPositionX1(),
                        firstSelectionSymbol.getSymbolPositionY1(), firstSelectionSymbol.getSymbolHeight());
                selectionSet.clear();
            }
            Component component = textPane.getComponentAt(caret.getCaretPositionX1() + 4,
                    caret.getCaretPositionY1() + caret.getCaretPositionY2() - 1);
            if (component.getName() != null) {
                Symbol symbol = (Symbol) component;
                symbolList.remove(symbol);
                textPane.remove(symbol);
                new SymbolLocation(textPane, symbolStorage).symbolLocate();
                textPane.updateUI();
            }
            caret.caretEnable();
        }

    }

    boolean checkSelect() {
        firstSelectionSymbol = lastSelectionSymbol = null;
        Iterator<Symbol> itr = selectionSet.iterator();

        if (itr.hasNext()) {
            firstSelectionSymbol = itr.next();
        }

        if (itr.hasNext()) {
            while (itr.hasNext()) {
                lastSelectionSymbol = itr.next();
            }
            return true;
        } else {
            return false;
        }
    }


    void caretPosition(Symbol symbol1) {
        Caret caret = textPane.getCaret();
        caret.setCaretPosition(symbol1.getSymbolPositionX1(), symbol1.getSymbolPositionY1(), symbol1.getSymbolHeight());
    }

    void deleteSelection() {
        Caret caret = textPane.getCaret();
        if (firstSelectionSymbol.getSymbolPositionX1() < lastSelectionSymbol.getSymbolPositionX1()) {
            caretPosition(firstSelectionSymbol);
        } else {
            caretPosition(lastSelectionSymbol);
        }

        Iterator<Symbol> itr = selectionSet.iterator();
        while (itr.hasNext()) {
            firstSelectionSymbol = itr.next();
            symbolList.remove(firstSelectionSymbol);
            textPane.remove(firstSelectionSymbol);
        }
        selectionSet.clear();

        new SymbolLocation(textPane, symbolStorage).symbolLocate();
        textPane.updateUI();
        caret.caretEnable();
    }
}

