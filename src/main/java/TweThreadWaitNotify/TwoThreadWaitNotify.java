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
                synchronized (TwoThreadWaitNotify.class) {
                    if(number.flag) {
                        System.out.println("even" + number.start);
                        number.start++;
                        TwoThreadWaitNotify.class.notify();
                    }else {
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
                        System.out.println("odd " + number.start);
                        number.start++;
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
