/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericclothing;

import java.awt.Color;
import java.lang.reflect.Field;

/**
 *
 * @author sapriya
 */
interface Colred{
    Color getColor();
}

interface Sized{
    int getSize();
}

class Sock implements Colred, Sized{
    
    int size;
    Color color;
    
    Sock(int size, Color color){
    this.size = size;
    this.color = color;
    }
    
    public String returnString(){
    return "Sock: size: "+size+" color: " +color;
    }
    
    @Override
    public Color getColor(){
        return color;
    }
    
    @Override
    public int getSize(){
     return size;
    }
}

class Glove implements Colred, Sized{
    
    int size;
    Color color;
    
    Glove(int size, Color color){
    this.size = size;
    this.color = color;
    }
    
    public String returnString(){
    return "Glove: size: "+size+" color: " +color;
    }

    @Override
    public Color getColor(){
        return color;
    }
    
    @Override
    public int getSize(){
       return size;
    }
}

class ClothingPair<T>{

    T pair1,pair2;
    ClothingPair(T p1, T p2){
     this.pair1 = p1;
      this.pair2 = p2;
    }
    
    public boolean isMatched(){
        //Assumption: The objects created will be classified either as Glove or Sock
    if(pair1.getClass().getName().equals(pair2.getClass().getName())){
        return true;
    }else{
        return false;
    }
    }
}


public class GenericClothing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Glove g1 = new Glove(8,Color.BLUE);
        Glove g2 = new Glove(8,Color.BLUE);
        Sock s1 = new Sock(8,Color.BLUE);
        Sock s2 = new Sock(9,Color.BLUE);
        ClothingPair[] pairs = {
            new ClothingPair(g1,g2),
            new ClothingPair(s1,s2),
            new ClothingPair(s1,g2)
        };
        for(int p=0;p<pairs.length;p++){
        System.out.println(pairs[p].isMatched());
        }
    }
    
}
