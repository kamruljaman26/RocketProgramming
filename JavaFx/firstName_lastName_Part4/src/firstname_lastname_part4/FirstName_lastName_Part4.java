package firstname_lastname_part4;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class FirstName_lastName_Part4 {

    public static void main(String[] args) {
        final int MAX_T = 2;
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);

        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            MyThread thread = new MyThread(random.nextInt(), random.nextInt(), 65);
            pool.execute(thread);
        }

        pool.shutdown();
    }
}
