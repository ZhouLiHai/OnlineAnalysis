package executor;

/**
 * @author zhou
 */
public class TaskTwo implements Runnable {
	@Override
    public void run() {
        while (true) {
            System.out.println("run task two.");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
