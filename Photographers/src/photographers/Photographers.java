/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package photographers;

/**
 *
 * @author sapriya
 */
interface Photographer{

    public void prepareScene();
    public String takePhotograph();  
}

class Camera implements Photographer{
    
    @Override
    public void prepareScene(){
        System.out.println("Camera: Hey kids! smile for the photograph");
    }
    
    @Override
    public String takePhotograph(){    
        return "Lot of big smiles you guys, loved it!";
    }
}

class TrafficCamera implements Photographer{
    
    public void prepareScene(){
        System.out.println("Traffic Camera: Need to capture the rule breakers!");
    }
    
    @Override
    public String takePhotograph(){    
        return "Car MH0718 broke the red light - Captured";
    }
}

class SecurityCamera implements Photographer{
    
    @Override
    public void prepareScene(){
    System.out.println("Security Camera: Active");
    }
    
    @Override
    public String takePhotograph(){    
        return "That guy left his bag in the elevator! Issue warning in 10 minutes";
    }
}

public class Photographers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Photographer[] obj = {
            new Camera(),
            new TrafficCamera(),
            new SecurityCamera()
        };
        for (int i=0;i<obj.length;i++){
        System.out.println("Prepare Scene: ");obj[i].prepareScene();
        System.out.println("Take Photograph: " + obj[i].takePhotograph());
        }
    }
    
}
