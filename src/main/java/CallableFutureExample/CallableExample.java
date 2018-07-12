package CallableFutureExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class CallableExample {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        List<Future<Integer>> resultList = new ArrayList<Future<Integer>>();

        Random random = new Random();

        for (int i = 0; i < 4; i++) {
            FactorialCalculator factorialCalculator = new FactorialCalculator(random.nextInt(10));
            Future<Integer> result = executor.submit(factorialCalculator);
            resultList.add(result);
        }

        for (Future<Integer> result: resultList) {
            try {
                System.out.println("Future result is: " + result.get() + " and state is: " + result.isDone());
            } catch (InterruptedException | ExecutionException e) {
                e.fillInStackTrace();
            }
        }

        executor.shutdown();
    }
}
