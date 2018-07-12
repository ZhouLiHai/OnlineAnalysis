package WaitAndNotifyExample;

import java.util.List;

public class Producer implements Runnable {
    private final List<Integer> tasks;
    private final Integer MAX_CAPACITY;

    public Producer(List<Integer> tasks, Integer MAX_CAPACITY) {
        this.tasks = tasks;
        this.MAX_CAPACITY = MAX_CAPACITY;
    }

    public void run() {
        int counter = 0;
        while (true) {
            try {
                product(counter++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void product(int counter) throws InterruptedException{
        synchronized (tasks) {
            while (tasks.size() == MAX_CAPACITY) {
                System.out.println("task queue is full: " + tasks.size());
                tasks.wait();
            }
            Thread.sleep(1000);
            tasks.add(counter);
            System.out.println("Product: " + counter);
            tasks.notifyAll();
        }
    }
}
