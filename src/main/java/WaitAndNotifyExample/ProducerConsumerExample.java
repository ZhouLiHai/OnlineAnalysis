package WaitAndNotifyExample;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        List<Integer> tasks = new ArrayList<Integer>();
        int MAX_CAPACITY = 5;

        Thread tProducer = new Thread(new Producer(tasks, MAX_CAPACITY));
        Thread tConsumer = new Thread(new Customer(tasks));

        tConsumer.start();
        tProducer.start();
    }
}
