package by.jum.texteditor.windows.symbol;

import by.jum.texteditor.document.Document;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Symbol extends JPanel {
    private String mySymbol;
    private Font font;
    private int symbolPositionY1;
    private int symbolPositionX1;
    private int symbolHeight;
    private int symbolWidth;

    public Symbol(String mySymbol, Document document) {
        this.mySymbol = mySymbol;
        this.font = document.getMyFont();
        //setBorder(BorderFactory.createLineBorder(Color.RED));
        setBackground(Color.white);
        setName("S");
        font = document.getMyFont();
    }

    public void setFont(Font newFont) {
        font = newFont;
        repaint();
    }

    public Font getDocument(){
        return font;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setPaint(Color.blue);
        graphics2D.setFont(font);
        graphics2D.drawString(mySymbol, 0, font.getSize2D() - 2);
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        symbolPositionY1 = y;
        symbolPositionX1 = x;
        symbolHeight = height;
        symbolWidth = width;
    }

    public int getSymbolPositionY1(){
        return symbolPositionY1;
    }

    public int getSymbolPositionX1(){
        return symbolPositionX1;
    }

    public int getSymbolHeight(){
        return symbolHeight;
    }

    public int getSymbolWidth(){
        return symbolWidth;
    }

    public String getSymbol(){
        return mySymbol;
    }

}
