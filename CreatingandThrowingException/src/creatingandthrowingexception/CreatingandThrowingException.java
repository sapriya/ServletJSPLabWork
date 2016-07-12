/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creatingandthrowingexception;

import java.util.Scanner;

/**
 *
 * @author SAPRIYA
 */
class BadMonth extends Exception{
    //Custom Message
    public BadMonth(){
      System.out.println("Please enter a correct Month");
    }
}

class BadDay extends Exception{
    //Custom message
    public BadDay(){
        System.out.println("Please enter a correct day for this Month");
    }
}

enum months{
    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMPBER, OCTOBER, NOVEMBER, DECEMBER
}


public class CreatingandThrowingException {

    /**
     * @param args the command line arguments
     */
    
    static int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};
    public static void convert(String month, int day) throws BadDay, BadMonth{
        try {
            months.valueOf(month);
        } catch(Exception e){
            throw new BadMonth();
        }
        
        //Validate Date
        int pos = months.valueOf(month).ordinal();
        if(day > monthDays[pos]){
            throw new BadDay();
        }else if (day < 1){
            throw new BadDay();
        }else{
        System.out.println("Valid");
        }
    }
    
    public static void main(String[] args) throws BadDay,BadMonth{
       
       
       Scanner getInput = new Scanner(System.in);
        while(true){
            System.out.println("Please enter the month or type in quit");
            String userInputMonth = getInput.next(); //Ignoring other exceptions -- Assumption user input is in correct format (example: User would not type in a String as input value)
            if("quit".equalsIgnoreCase(userInputMonth)){
                break;
            }
            
            System.out.println("Please enter a day");
            int userInputDay = Integer.parseInt(getInput.next()); //Ignoring other exceptions -- Assumption user input is in correct format (example: User would not type in a String as input value)
            try {
                convert(userInputMonth.toUpperCase(),userInputDay);
            }catch (Exception e){
            System.out.println("Exception: " + e);
            }
        }// End while
    }//End main
}//end class
