package UncaughtExceptionHandlerExample;

import java.util.concurrent.ThreadPoolExecutor;

public class UncaughtExceptionHandlerExample {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());
                System.out.println(Integer.parseInt("123"));
                System.out.println(Integer.parseInt("abc"));
                System.out.println(Integer.parseInt("456"));
            }
        }).start();
    }
}
