import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter number of seconds to start the countdown: ");
            if (scanner.hasNextInt()) {
                int seconds = scanner.nextInt();
                if (seconds > 0) {
                    Timer timer = new Timer();
                    TimerTask timerTask = new TimerTask() {

                        int count = seconds;

                        @Override
                        public void run() {
                            System.out.println(count);
                            count--;
                            if (count < 0) {
                                System.out.println("BOOM! Time’s up! Hope you weren’t defusing a bomb...");
                                timer.cancel();
                            }
                        }
                    };
                    timer.scheduleAtFixedRate(timerTask, 0, 1000);
                    break;
                } else {
                    System.out.println("What? Negative seconds? Never heard of them!");
                }
            }
            else {
                System.out.println("Can't read letters. Sorry!");
                scanner.next();
            }
        }
    }
}