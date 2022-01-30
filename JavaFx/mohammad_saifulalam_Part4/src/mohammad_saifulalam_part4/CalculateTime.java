package mohammad_saifulalam_part4;

import java.util.concurrent.locks.ReentrantLock;

public class CalculateTime {

    private static int hours;
    private static int min;
    private static int sec;

    public CalculateTime(int hours, int min, int sec) {
        CalculateTime.hours = hours;
        CalculateTime.min = min;
        CalculateTime.sec = sec;
    }

    // todo, handle ReentrantLock with exception for
    // this method
    public static Integer timeSinceMidnight(int h, int m, int s) {
        ReentrantLock lock = new ReentrantLock();
        try {
            lock.lock();
            //Do some work
            hours = (h * 3600);
            min = (m * 60);
            sec = (s);
            return hours + min + sec;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        // if something going wrong
        return null;
    }
}
