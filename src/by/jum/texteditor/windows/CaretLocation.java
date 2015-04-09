package by.jum.texteditor.windows;

import by.jum.texteditor.windows.symbol.Symbol;

import java.awt.Component;


public class CaretLocation {
    private TextPane myTextPane;
    private Caret caret;
    private Symbol symbol;

    public CaretLocation(TextPane myTextPane) {
        this.myTextPane = myTextPane;
    }

    public Symbol leftLocation() {
        caret = myTextPane.getCaret();
        Component component = myTextPane.getComponentAt(caret.getCaretPositionX1() - 1,
                caret.getCaretPositionY1() + caret.getCaretPositionY2() - 1);
        if (component.getName() != null) {
            symbol = (Symbol) component;
            caret.setCaretPosition(caret.getCaretPositionX1() - symbol.getSymbolWidth(),
                    symbol.getSymbolPositionY1(), symbol.getSymbolHeight());
        }
        return symbol;
    }

    public void rightLocation() {
        caret = myTextPane.getCaret();
        Component component = myTextPane.getComponentAt(caret.getCaretPositionX1() + 4,
                caret.getCaretPositionY1() + caret.getCaretPositionY2() - 1);
        if (component.getName() != null) {
            symbol = (Symbol) component;
            caret.setCaretPosition(caret.getCaretPositionX1() + symbol.getSymbolWidth(),
                    symbol.getSymbolPositionY1(), symbol.getSymbolHeight());

        }
    }
}
