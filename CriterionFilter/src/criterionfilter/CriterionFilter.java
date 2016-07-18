/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criterionfilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author sapriya
 */

interface StringCriterion {
boolean test(String s);
}

class Threshold implements StringCriterion{
    int tVal;
    
    Threshold(int threasholdVal){
    this.tVal = threasholdVal;
    }

    @Override
    public boolean test(String ls){
        return (ls.length() > this.tVal);
    }
}

class FirstLetterAM implements StringCriterion{
 @Override
    public boolean test(String ls){
        return (ls.startsWith("A")||ls.startsWith("M")||ls.startsWith("a")||ls.startsWith("m")); //Could be improved -- For later
    }
}

class UppercaseLetter implements StringCriterion{
 @Override
    public boolean test(String ls){
            String test = ls.toLowerCase();
        return(!ls.equals(test));
    }
}

public class CriterionFilter{
    
// GeneralFilter 1
    
//    public static List<String> getLongStrings(List<String> ls, int thresholdVal){
//    List<String> resultList = new ArrayList<String>();
//    for(String val : ls){
//    if(val.length() >= thresholdVal)
//        resultList.add(val);
//    }
//    return resultList;
//    }
// END
   
    
    public static List<String> stringFilter(List<String> ls, StringCriterion sc){
    List<String> resultList = new ArrayList<String>();
    for(String val : ls){
    if(sc.test(val))
        resultList.add(val);
    }
    return resultList;
    }
    
    public static void main(String[] args) {
        
// GeneralFilter 1
        List<String> lst = new ArrayList<>();
       List<String> ls = Arrays.asList(
        "Fred", "Jim", "William", "susannah", "Lucy", "Orinoco", "Arthur"
      );
//      List<String> longStrings = getLongStrings(ls,6);
//      assert longStrings.size() == 3;
//      assert longStrings.get(0).equals("William");
//      assert longStrings.get(0).equals("Susannah");
//      assert longStrings.get(0).equals("Orinoco");
// END
        StringCriterion[] sc = {new Threshold(6),new FirstLetterAM(),new UppercaseLetter() };
        for(int s=0;s<sc.length;s++){
        System.out.println(stringFilter(ls,sc[s]));
        }
    }
}