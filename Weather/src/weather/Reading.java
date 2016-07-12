/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather;

/**
 *
 * @author SAPRIYA
 */
public class Reading {
String day;
int hour;
int temp;
int windspeed;
Reading(String fromFile){
    String[] element = fromFile.split(", ");
    day = element[0];
    hour = Integer.parseInt(element[1]);
    temp = Integer.parseInt(element[2]);
    windspeed = Integer.parseInt(element[3]);
}

//Implementation Assumption: There is no varying format in the csvx file
public String rateTemperature(){
    if(temp<55){
        return "cold";
    } else if(temp<65){
        return "mild";    
    }else if(temp<80){
       return "warm";
    }else{
        return "hot";
    }
}

public String getTime(){
    if(hour == 9){
        return day+" morning";
    }else if(hour == 15){
        return day+" afternoon";
    }else{
    return day+" evening";
    }
}
}
