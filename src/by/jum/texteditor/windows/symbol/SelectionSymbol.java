package by.jum.texteditor.windows.symbol;

import by.jum.texteditor.document.Document;
import by.jum.texteditor.windows.Caret;
import by.jum.texteditor.windows.TextPane;

import java.awt.Component;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Vlad on 03.04.2015.
 */
public class SelectionSymbol {
    public SelectionSymbol(SymbolStorage symbolStorage, Document document, TextPane myTextPane) {

        Set<Symbol> selectoinSet = symbolStorage.getSelectoinSet();
        if (!selectoinSet.isEmpty()) {
            Iterator<Symbol> itr = selectoinSet.iterator();
            while (itr.hasNext()) {
                itr.next().setFont(document.getMyFont());
            }

            new SymbolLocation(myTextPane, symbolStorage).symbolLocate();

            //перемещение каретки при изменении стилей
            Caret caret = myTextPane.getCaret();
            Component component = myTextPane.getComponentAt(caret.getCaretPositionX1() + 4,
                    caret.getCaretPositionY1() + caret.getCaretPositionY2() - 1);
            if (component.getName() != null) {
                Symbol symbol = (Symbol) component;
                caret.setCaretPosition(symbol.getSymbolPositionX1(),
                        symbol.getSymbolPositionY1(), symbol.getSymbolHeight());
            }

            }
    }
}
