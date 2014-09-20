/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.observer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author f212
 */
public class Histograma extends JPanel implements Observer{
    
    Conjunto c;
    public Histograma(Conjunto c){
        this.c = c;
        super.setBounds(0, 0, 400, 400);
        super.setMinimumSize(new Dimension(400,400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        boolean controlColor = false;
        int x = 10;
        for (int line:c.getX()) {
            if (controlColor) 
                g.setColor(Color.GREEN);
            else 
                g.setColor(Color.RED);
            controlColor =! controlColor;
            g.drawLine(x, 300, x, line);
            x +=5;
        }

    }
     
    public static void main(String[] args) {
        JFrame f = new JFrame("Histograma");
        f.getContentPane().add(new Histograma(new Conjunto()));
        f.pack();
        f.setVisible(true);
    }

    
    
}
