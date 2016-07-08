/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrenheittocelsiusconversion;
import java.util.Scanner;
/**
 *
 * @author SAPRIYA
 */
public class FahrenheittoCelsiusConversion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Step 1: Prompt user to enter the Fahrenheit temperature
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the temperature in Fahrenheit for conversion to Celcius");
        while (!userInput.hasNextInt()){
            System.out.println("Farenheit temperature needs to be numeric only");
            userInput.next();
        }
        //Step 2: Read the temperature from the console input 
        String line = userInput.next();
        //Step 3: Covert the text that was enetred into double value stored in a variable
        double temperatureF = Double.valueOf(line);
        //Step 4: Perform the conversion and store the resulting temperature into a variable
        double temperatureC =  5 * (temperatureF - 32)/9;
        //step 5: Print out the Celcius temperature
        System.out.println("The temperature "+temperatureF+"F is equvalent to "+Math.round(temperatureC*100.0)/100.0+"C");
        
        
    }
    
}
