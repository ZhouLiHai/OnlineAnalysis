package ExecutorExample;

import java.sql.Time;

public class TaskOne implements Runnable {
    public void run() {
        while (true) {
            System.out.println("run task one.");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
