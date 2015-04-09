package by.jum.texteditor.windows.symbol;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class SymbolStorage {
    private Set<Symbol> selectoinSet = new LinkedHashSet<Symbol>();
    private List<Symbol> symbolList = new ArrayList<Symbol>();
    private List<Symbol> symbolCopyList = new ArrayList<Symbol>();
    private List<Symbol> copySymbolList = new ArrayList<Symbol>();


    public void clearAll() {
        symbolList.clear();
        selectoinSet.clear();
        symbolCopyList.clear();
    }

    public Set getSelectoinSet() {
        return selectoinSet;
    }

    public List<Symbol> getSymbolList() {
        return symbolList;
    }

    public List<Symbol> getSymbolCopyList(){
        return symbolCopyList;
    }


}
