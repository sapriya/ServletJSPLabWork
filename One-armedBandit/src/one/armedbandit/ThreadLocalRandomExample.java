/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.armedbandit;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author SAPRIYA
 */
public class ThreadLocalRandomExample {

     public enum StateOfMachine{
        BAR, MEDAL, COIN, TRIPLE_BAR, CHERRY
    }
	public static void main(String args[]) throws InterruptedException {
              final int[] spinPos = new int[3];
                for(int i=0;i<3;i++){
			final Thread thread;
                    thread = new Thread() {
                        public void run() {
                            //for (int j = 0; j < 3; j++) {
                           int random = ThreadLocalRandom.current().nextInt(0,5);
                            int j=0;
                            spinPos[j] = random;
                            j++;
                            //}
                        }
                    };
			thread.start();
			thread.join();
                        
                }
                for (int k=0;k<3;k++){
                            if(k<spinPos.length-1)
                                System.out.print(StateOfMachine.values()[spinPos[k]]+":");
                            else
                                System.out.println(StateOfMachine.values()[spinPos[k]]);
                        }
	}
}

 



