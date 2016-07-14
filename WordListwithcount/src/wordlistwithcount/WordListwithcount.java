/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordlistwithcount;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author sapriya
 */
public class WordListwithcount {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try (BufferedReader br = new BufferedReader(new FileReader("prideandprejudice")))
		{
                    String line;
                    Map<String,Integer> wordMap = new HashMap<>();
                    while ((line = br.readLine()) != null) {
                        String[] wordArray = line.split("\\W+");
                        for(String w : wordArray){
                        if(wordMap.containsKey(w)){
                        wordMap.put(w, wordMap.get(w) + 1);
                        }else{
                        wordMap.put(w,1);
                        }
                        }
                    }
	         //Print out the HashMap
                    Iterator iterator = wordMap.keySet().iterator();
  
                    while (iterator.hasNext()) {
                       String key = iterator.next().toString();
                       String value = wordMap.get(key).toString();
                       System.out.println("Word "+key + " occurs " + value + " times");
                    }


		} catch (IOException e) {
			e.printStackTrace();//Which exception to throw could be made more specific
		} 
    }
    
}
