package ThrottlingExample;

import java.util.concurrent.*;

public class ThrottlingExample {
    public static void main(String[] args) {
        int throttlingCount = 1;
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(50);

        CustomThreadPoolExecutor customThreadPoolExecutor = new CustomThreadPoolExecutor(10, 20, 5000, TimeUnit.MILLISECONDS, blockingQueue);
        customThreadPoolExecutor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("Rejected: " + ((DemoTask) r).getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Restart:" +  ((DemoTask) r).getName());
                executor.execute(r);
            }
        });

        customThreadPoolExecutor.prestartAllCoreThreads();
        while (true) {
            throttlingCount ++;
            customThreadPoolExecutor.execute(new DemoTask(String.valueOf(throttlingCount)));
            if (throttlingCount == 1000) {
                break;
            }
        }
    }
}
