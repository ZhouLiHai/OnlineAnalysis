package CallableFutureExample;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 创建线程的最佳方式就是实现Callable接口，实际运算的内容就是计算一个数的阶乘。
 */
public class FactorialCalculator implements Callable<Integer> {
    private Integer number;

    // 初始化的时候需要知道是哪个数
    public FactorialCalculator(Integer number) {
        this.number = number;
    }

    // 计算阶乘，并且sleep 1秒模拟费时操作
    public Integer call() throws Exception{
        int result = 1;

        if (number == 0 || number == 1) {
            return 1;
        } else {
            for (int i = 2; i <= number; i++) {
                result *= i;
                TimeUnit.MILLISECONDS.sleep(1 * 1000);
            }
        }

        // 打印这句，可以看到计算结果生成的实时时间
        System.out.println("Result for number: " + number + " -> " + result);
        // Callable可以返回future作为返回值，以告知主线程运算结果
        return result;
    }
}
