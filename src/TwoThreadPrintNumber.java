import java.util.concurrent.atomic.AtomicInteger;

public class TwoThreadPrintNumber {

    public static void printNumber(AtomicInteger num) {
        System.out.println(Thread.currentThread().getName() + " " + num.getAndAdd(1));
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger num = new AtomicInteger();
        final int[] tag = {0};

        Thread r1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (num) {
                        try {

                            if (tag[0] == 0) {
                                num.wait();
                            } else {
                                printNumber(num);
                                tag[0] = 0;
                                num.notifyAll();

                            }
                            if (num.get() > 100) {
                                break;
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        Thread r2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (num) {
                        try {

                            if (tag[0] == 0) {
                                printNumber(num);
                                tag[0] = 1;
                                num.notifyAll();
                            } else {
                                num.wait();
                            }
                            if (num.get() > 100) {
                                break;
                            }

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        r1.start();
        r2.start();

        r1.join();
        r2.join();
        System.out.println("over");


    }
}
