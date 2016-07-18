/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericclothing2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;

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

class GlassVase implements Sized{
    int size;
    GlassVase(int size){
    this.size = size;
    }
    
    @Override
    public int getSize(){
    return size;
    }
}

class Fabric implements Colred{
Color color;

Fabric(Color color){
this.color = color;
}

@Override
public Color getColor(){
return color;}
}
        
//Go through the concept again -- (self Note)
class ClothingPair<T extends Sized & Colred>{

    T pair1,pair2;
    ClothingPair(T p1, T p2){
     this.pair1 = p1;
      this.pair2 = p2;
    }
    
    public boolean isMatched(){
    return (pair1.getClass().getName().equals(pair2.getClass().getName()) && pair1.getSize() == pair2.getSize() && pair1.getColor().equals(pair2.getColor()));
    }
}

public class GenericClothing2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Glove g1 = new Glove(8,Color.BLUE);
        Glove g2 = new Glove(8,Color.GREEN);
        //return false
        Sock s1 = new Sock(8,Color.BLUE);
        Sock s2 = new Sock(9,Color.BLUE);
        //returns false
        Sock s3 = new Sock(9,Color.BLUE);
        Sock s4 = new Sock(9,Color.BLUE);
        //return true
        Fabric f1 = new Fabric(Color.BLUE);
        GlassVase gv1 = new GlassVase(5);
        //return false
        ClothingPair[] pairs = {
            new ClothingPair(g1,g2),//false
            new ClothingPair(s1,s2),//false
            new ClothingPair(s1,g2),//false
            new ClothingPair(s3,s4),//true
            new ClothingPair(g2,gv1)//false
        };
        for(int p=0;p<pairs.length;p++){
        System.out.println(pairs[p].isMatched());
        }
    }
    
}




