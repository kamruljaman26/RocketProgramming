package firstname_lastname_part4;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FirstName_lastName_Part4 {

    // The main method creates the runnable tasks of type MyThread and the threadpool.
    public static void main(String[] args) {
        
        final int MAX_T = 2;
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);

        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            // here we set random value for get time since midnight
            MyThread thread = new MyThread(random.nextInt(24), random.nextInt(60), 60);
            pool.execute(thread);
        }

        pool.shutdown();
    }
}
