package ExecutorExample;

import java.util.List;

public class MultiRunnable implements Runnable {
    private final List<Runnable> tasks;

    MultiRunnable( List<Runnable> tasks) {
        this.tasks = tasks;
    }

    public void run() {
        for (Runnable task: tasks) {
            new Thread(task).start();
        }
    }
}
