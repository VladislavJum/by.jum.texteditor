package by.jum.texteditor.Symbol;

import by.jum.texteditor.mainwindow.MyTextPane;

import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Symbol extends JComponent{
    private String mySymbol;
    private MyTextPane myTextPane;
    private Graphics2D graphics2D;
    private int symbolWight;

    public Symbol(String mySymbol, MyTextPane myTextPane) {
        this.mySymbol = mySymbol;
        this.myTextPane = myTextPane;


        //setBorder(BorderFactory.createLineBorder(Color.RED));
    }


    @Override
    protected void paintComponent(Graphics g) {
        graphics2D = (Graphics2D) g;
        graphics2D.setPaint(Color.blue);
        graphics2D.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        graphics2D.drawString(mySymbol, 0, 30);

       // System.out.println(symbolWight);
       // setBounds(20,10,4+symbolWight, a+4);
      //  System.out.println(s);
    }


    public int getSymbolWigth(){
        return symbolWight;
    }
}
