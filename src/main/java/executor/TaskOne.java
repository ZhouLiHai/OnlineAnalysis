package executor;

/**
 * @author zhou
 */
public class TaskOne implements Runnable {
	private String name;

	public TaskOne(String name) {
		this.name = name;
	}

	@Override
    public void run() {
        while (true) {
            System.out.println("run task " + this.name);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
