import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter number of seconds to start the countdown: ");
            if (scanner.hasNextInt()) { //Input must be an integer
                int seconds = scanner.nextInt();
                if (seconds > 0) { //Seconds have to positive, of course.
                    Timer timer = new Timer();
                    TimerTask timerTask = new TimerTask() { //The notebook for writing your to-do-list

                        int count = seconds; //In your brain but not on the paper yet

                        @Override //to make the Timertask method run
                        public void run() { //your to-do-list
                            System.out.println(count);
                            count--;
                            if (count < 0) {
                                System.out.println("BOOM! Time’s up! Hope you weren’t defusing a bomb...");
                                timer.cancel(); //Cancel the whole method
                            }
                        }
                    };
                    timer.scheduleAtFixedRate(timerTask, 0, 1000); //You're doing your to-do-list here //schedule( task, delay, interval)
                    break; //Breaking out of the loop when timer ends
                } else {
                    System.out.println("What? Negative seconds? Never heard of them!"); //Warning for negative seconds
                }
            }
            else {
                System.out.println("Can't read letters. Sorry!"); //Warning for using letters
                scanner.next(); //Stops program from crashing
            }
        }
    }
}