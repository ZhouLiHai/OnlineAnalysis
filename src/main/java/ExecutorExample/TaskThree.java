package ExecutorExample;

public class TaskThree implements Runnable {
    public void run() {
        while (true) {
            System.out.println("run task three.");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
