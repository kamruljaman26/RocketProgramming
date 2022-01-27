
package firstname_lastname_part4;

import java.util.Random;

public class MyThread implements Runnable{

    // should have 3 instant variable
    private int hours;
    private int minutes;
    private int second;

    // default constructor
    public MyThread(int hours, int minutes, int second) {
        this.hours = hours;
        this.minutes = minutes;
        this.second = second;
    }

    @Override
    public void run() {
        try {
            int time = CalculateTime.timeSinceMidnight(hours,minutes,second);
            System.out.println("Time Since Midnight: "+time+"s");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Error in MyThread");
        }
    }
}
