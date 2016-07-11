/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatdayisit;
import java.util.Scanner;
/**
 *
 * @author SAPRIYA
 */
public class WhatDayIsIt {
    public static void main(String[] args) {
        Scanner getInput = new Scanner(System.in);
        while(true){
            System.out.println("Please enter the value of day(1-31) or type in quit");
            String userInput = getInput.next();
            if("quit".equalsIgnoreCase(userInput)){
                break;
            }else{
                 try {
                     int day = Integer.parseInt(userInput);
                     if(day<1 || day>31){
                     }
                     else{
                          System.out.println("Please enter the value of month (1-12)");
                //Similar to as done for day -- error check could be done for user input for month -- Skipping the code here
                int month = getInput.nextInt();
                System.out.println("Please enter year");
                int year = getInput.nextInt();
                if(month==1 || month==2){
                    month = month+12;
                    year = year-1;
                }
                int a = 13*(month+1)/5;
                int b = year/4;
                int c = (year/100) * 6;
                int d = year/400;
                int remainder = (a+b+c+d+day+year)%7;
                switch(remainder){
                    case 0: System.out.println("Saturday");
                            break;
                    case 1: System.out.println("Sunday");
                            break;
                    case 2: System.out.println("Monday");
                            break;
                    case 3: System.out.println("Tuesday");
                        break;
                    case 4: System.out.println("Wednesday");
                        break;
                    case 5: System.out.println("Thrusday");
                        break;
                    case 6: System.out.println("Friday");
                        break;
                    default:
                        System.out.println("Something went wrong");
                        break;
                }//End switch
                     }//End else
                 } catch(Exception e){
                     System.out.println("The value for day should be integer value");
                 } //End catch  
                }//End else
               
            } //End while
        }
    }


