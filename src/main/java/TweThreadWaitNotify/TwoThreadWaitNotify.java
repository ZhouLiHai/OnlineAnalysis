package TweThreadWaitNotify;

public class TwoThreadWaitNotify {
    private int start = 1;
    private boolean flag = false;

    public static class EvenNumber implements Runnable {

        private TwoThreadWaitNotify number;

        public EvenNumber(TwoThreadWaitNotify number) {
            this.number = number;
        }

        @Override
        public void run() {
            while (number.start < 100) {
            	// 进入加锁区域
                synchronized (TwoThreadWaitNotify.class) {
                    if(number.flag) {
                        System.out.println("even " + number.start);
                        number.start++;
                        number.flag = !number.flag;
                        TwoThreadWaitNotify.class.notify();
                    }else {
                        try {
                        	// 如果条件不满足，则选择临时释放锁，让其它线程进入枷锁区域（例如生产者）
                            TwoThreadWaitNotify.class.wait();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static class OddNumber implements Runnable {
        private TwoThreadWaitNotify number;

        public OddNumber(TwoThreadWaitNotify number) {
            this.number = number;
        }

        @Override
        public void run() {
            while (number.start < 100) {
                synchronized (TwoThreadWaitNotify.class) {
                    if (!number.flag) {
                        System.out.println("odd  " + number.start);
                        number.start++;
						number.flag = !number.flag;
                        TwoThreadWaitNotify.class.notify();
                    } else {
                        try {
                            TwoThreadWaitNotify.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        TwoThreadWaitNotify twoThreadWaitNotify = new TwoThreadWaitNotify();

        new Thread(new OddNumber(twoThreadWaitNotify)).start();
        new Thread(new EvenNumber(twoThreadWaitNotify)).start();


    }
}
