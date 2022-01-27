package firstname_lastname_part4;

public class CalculateTime {

    private static int hour;
    private static int minutes;
    private static int seconds;

    public static void timeSinceMidnight(int h, int m, int s) {

        hour = (h * 3600);
        minutes = (m * 60);
        seconds = (s);

        int result = hour + minutes + seconds;

        for (int i = 1; i < 100; i++) {

            System.out.println("Secounds Science Midnight  " + result);

        }

    }

}
