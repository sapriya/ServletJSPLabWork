/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlingexceptions;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author SAPRIYA
 */
public class HandlingExceptions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
    	OutputStream outStream = null;
        InputStream inStream = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter input filename");
        String inputFile = sc.next();
        System.out.println("Enter output filename");
        String outputFile = sc.next();
        while(true){
            try {
                inStream = new FileInputStream(inputFile);
                outStream = new FileOutputStream(outputFile);
                break;
            } catch (IOException e){
                if(e.getMessage().contains(inputFile.replace("/","\\"))){
                    System.out.println("Enter valid inputFile name");
                    inputFile = sc.next();
                }
                if(e.getMessage().contains(outputFile.replace("/","\\"))){ //Ignored the case where user enters // or \\ 
                    System.out.println("Enter valid outputFile name");
                    outputFile = sc.next();
                }
            }
       }//End while
        
        //Copy content
       byte[] buffer = new byte[1024];
 
    	    int length;
        try {
            while ((length = inStream.read(buffer)) > 0){
                outStream.write(buffer, 0, length);
            }
            if (inStream != null)inStream.close();
    	    if (outStream != null)outStream.close();
        } catch (IOException ex) {
//            Logger.getLogger(HandlingExceptions.class.getName()).log(Level.SEVERE, null, ex);
        }
   }//End main
}//End class