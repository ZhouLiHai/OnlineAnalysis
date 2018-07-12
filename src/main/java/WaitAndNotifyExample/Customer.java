package WaitAndNotifyExample;

import java.util.List;

public class Customer implements Runnable {
    private final List<Integer> tasks;

    public Customer(List<Integer> tasks) {
        this.tasks = tasks;
    }

    public void run() {
        while (true)
        {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void consume() throws InterruptedException {
        synchronized (tasks) {
            while (tasks.isEmpty()) {
                System.out.println("Queue is empty: " + tasks.size());
                tasks.wait();
            }

            Thread.sleep(1000);
            int i = (Integer) tasks.remove(0);
            System.out.println("Consumer: " + i);
            tasks.notifyAll();
        }
    }
}
