/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordlist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

/**
 *
 * @author sapriya
 */
public class WordList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("prideandprejudice")))
		{
                    String line;
                    HashSet<String> wordList = new HashSet<String>();
                    while ((line = br.readLine()) != null) {
                        String[] wordArray = line.split("\\W+");
                        for(String w : wordArray){
                        wordList.add(w.toLowerCase());
                        }
                    }
	         for(String wrd:wordList){
                 System.out.println(wrd);
                 }

		} catch (IOException e) {
			e.printStackTrace();//Which exception to throw could be made more specific
		} 
    }
    
}
