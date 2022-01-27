package firstname_lastname_part4;

public class FirstName_lastName_Part4 {

    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        thread.start();

    }

}
