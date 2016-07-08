/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author SAPRIYA
 */

import java.util.Scanner;

//Operations: Get Mean / Get the largest / Get the Smallest
class BasicOps {
    public void performOperations(int[] inputArray, int n){
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    int sum = 0;
    //Loop through each value to compare and find the min/max value
    for(int v=0; v<n;v++){
            if(inputArray[v]>max){
                  max = inputArray[v];
            }
            if(inputArray[v]<min){
                min=inputArray[v];
            }
            sum = sum+inputArray[v];
    }
    float mean = sum/n;
    System.out.println ("Mean: "+ mean);
    System.out.println ("Smallest: " +min);
    System.out.println("Largest: "+max);
    }
}

public class DataAnalysis {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    System.out.println("Enter the total number of values"); 
    Scanner readInput = new Scanner(System.in);
    while(true){
    try {
            //User should enter numeric value for n
            int n = Integer.parseInt(readInput.next());
            int inputArray[] = new int[n];
            for(int v=0;v<n;v++){
                System.out.println("Enter the "+(v+1)+" value:");
                //Only integer values for array
                while(!readInput.hasNextInt()){
                    System.out.println("You need to enter numeric value");
                    readInput.next();
                }
                inputArray[v] = Integer.parseInt(readInput.next());
            }
            //Object Instantiation class BasicOps
            BasicOps obj = new BasicOps();
            obj.performOperations(inputArray,n);
            break;
        }catch (Exception e) {
            System.out.println("The value entered should be integer value");
        }
    }
    }
}
