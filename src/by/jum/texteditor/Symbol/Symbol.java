package by.jum.texteditor.symbol;

import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Symbol extends JComponent {
    private String mySymbol;
    private Font font;

    public Symbol(String mySymbol, Font font) {
        this.mySymbol = mySymbol;
        this.font = font;
        //setBorder(BorderFactory.createLineBorder(Color.RED));
    }


    public void setFont(Font newFont) {
        font = newFont;
        repaint();
    }

    public Font getMyFont(){
        return font;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D = (Graphics2D) g;
        graphics2D.setPaint(Color.blue);
        graphics2D.setFont(font);
        graphics2D.drawString(mySymbol, 0, font.getSize2D() - 2);
    }

}
