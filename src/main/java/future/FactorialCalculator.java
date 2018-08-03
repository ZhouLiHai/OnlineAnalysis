package future;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author zhou
 */
public class FactorialCalculator implements Callable<Integer> {
    private Integer number;

    public FactorialCalculator(Integer number) {
        this.number = number;
    }

    @Override
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

        return result;
    }
}
