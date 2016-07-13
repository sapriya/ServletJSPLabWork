/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methodarguments;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sapriya
 */
public class MethodArguments {

    /**
     * @param args the command line arguments
     */
    public static int addUp(int a, int b){
        System.out.println("Int executing");
        return a+b;
    }
    public static double addUp(double a, double b){
        System.out.println("Double executing");
        return a+b;
    }
    public static final HashMap hm = new HashMap();

    public static int addUp(String a, String b){
        System.out.println("String executing");
//        if(hm.containsKey(a)&&hm.containsValue(b))
        try{
            return (int) hm.get(a)+(int)hm.get(b);
        }catch(Exception e){
        System.out.println("Wrong value for string arguments. The string addUp did not execute and ran into exception");
        return -1;
        }    
    }
    public static void main(String[] args) {
        hm.put("zero",0);hm.put("one",1);hm.put("two",2);hm.put("three",3);hm.put("four",4);hm.put("five",5);hm.put("six",6);hm.put("seven",7);hm.put("eight",8);hm.put("nine",9);hm.put("ten",10);
        System.out.println(addUp(3.2, 2.2));
        System.out.println(addUp(1, 4));
        System.out.println(addUp("one", "eleven"));
        System.out.println(addUp(2, 3.5));
        //addUp(1, "three");//This wont work because it takes int and string parameters for which there is no defined method
        
    }
    
}
