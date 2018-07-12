package ExecutorExample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultiTasksExecutor {
    public static void main(String[] args) {
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(10);
        RejectedExecutionHandler handler = new RejectedExecutionHandlerImpl();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,3,10,TimeUnit.SECONDS, workQueue, handler);

        executor.prestartAllCoreThreads();

        List<Runnable> taskGroup = new ArrayList<Runnable>();
        taskGroup.add(new TaskOne());
        taskGroup.add(new TaskThree());
        taskGroup.add(new TaskTwo());
        taskGroup.add(new TaskTwo());

        workQueue.add(new MultiRunnable(taskGroup));
    }
}


class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(r.toString() + ": I'm been rejected!");
    }
}