/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author SAPRIYA
 */



public class Weather {

    /**
     * @param args the command line arguments
     * @throws java.lang.Throwable
     */
    public static void main(String[] args) throws Throwable {    
    BufferedReader br = Files.newBufferedReader(
        Paths.get("weather.csvx"));
    Reading[] readings = new Reading[12];
    for (int i = 0; i < readings.length; i++) {
        readings[i] = new Reading(br.readLine());
        System.out.println(readings[i].getTime()+" was "+readings[i].rateTemperature());
    }
    // remaining code here
}
}


 