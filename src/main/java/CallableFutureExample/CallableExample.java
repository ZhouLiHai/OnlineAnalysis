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

        // 生成新任务，并将任务提交给线程池使用。
        for (int i = 0; i < 4; i++) {
            FactorialCalculator factorialCalculator = new FactorialCalculator(random.nextInt(10));
            Future<Integer> result = executor.submit(factorialCalculator);
            resultList.add(result);
        }

        System.out.println("waiting line.");

        for (Future<Integer> result: resultList) {
            try {

            	// 这一段就是为了验证result.get是阻塞的，直到线程运算结果返回才继续运行。
            	System.out.println("b result.get()");
				result.get();
				System.out.println("a result.get()");

				// 获取线程计算的结果，因为result.get()是阻塞的，因此result.isDone()的返回值一定是true。
                System.out.println("Future result is: " + result.get() + " and state is: " + result.isDone());
            } catch (InterruptedException | ExecutionException e) {
                e.fillInStackTrace();
            }
        }

        // 关闭线程池
        executor.shutdown();
    }
}
