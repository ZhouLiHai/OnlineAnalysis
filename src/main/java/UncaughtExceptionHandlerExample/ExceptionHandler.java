package UncaughtExceptionHandlerExample;

public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("A exception is captured.");
        System.out.println(e.getClass().getName() + e.getMessage());
        e.printStackTrace(System.out);
        System.out.println("Thread state " + t.getState());
        new Thread(t).start();
    }
}
