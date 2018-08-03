package executor;

/**
 * @author zhou
 */
public class TaskThree implements Runnable {
	@Override
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
