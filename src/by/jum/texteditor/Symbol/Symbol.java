package by.jum.texteditor.Symbol;

import by.jum.texteditor.mainwindow.MyTextPane;

import javax.swing.*;
import java.awt.*;

public class Symbol extends JComponent{
    private String mySymbol;
    private MyTextPane myTextPane;

    public Symbol(String mySymbol, MyTextPane myTextPane) {
        this.myTextPane = myTextPane;
        this.mySymbol = mySymbol;
        myTextPane.setLayout(null);
       // setPreferredSize(new Dimension(10, 30));
        //setSize(new Dimension(10,60));
       // setLayout(new FlowLayout());
        myTextPane.add(this);
      //  myTextPane.updateUI();
       // setBorder(BorderFactory.createLineBorder(Color.RED));
    }




    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setPaint(Color.blue);
        graphics2D.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        graphics2D.drawString(mySymbol, 2, 10);
    }
}
