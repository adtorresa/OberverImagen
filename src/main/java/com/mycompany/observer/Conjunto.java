/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.observer;

import java.util.Observable;
import java.util.Random;
import java.util.logging.Level;


/**
 *
 * @author f212
 */
public class Conjunto extends Observable{
    int x[];
    
    public Conjunto() {
        x = new int[50];
        Random r = new Random();
        for (int i = 0; i < x.length; i++) {
            x[i] =  r.nextInt(100);
        }
        ordenarBurbuja();
    }

    public int[] getX() {
        return x;
    }

    private void ordenarBurbuja() {
        Boolean b = true;
        int k, j, aux;
        for(k=0;k<x.length-1;k++)
             for(j=0;j<x.length-k-1;j++)
                  if(x[j+1]>x[j]){
                     aux=x[j+1];
                     x[j+1]=x[j];
                     x[j]=aux;
                     this.setChanged();
                     this.notifyObservers(aux);
                  }
                  synchronized(b){
                    try {
                        b.wait(5);
                    } catch (InterruptedException ex) {
                        java.util.logging.Logger.getLogger(Conjunto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     
                  }

    }
    
    int[] getX(){
        return x;
    }
}
