
package firstname_lastname_part4;

import java.util.Random;

public class MyThread implements Runnable{
        
    

    @Override
    public void run() {
        
        Random random = new Random();
        
        int randomhour,randommunite,randomsec;
        randomhour=random.nextInt();
        randommunite = random.nextInt();
        randomsec = random.nextInt();
        
        CalculateTime.timeSinceMidnight(randomhour,randomsec,randommunite);
     
    }
    
}
