package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * https://leetcode.cn/problems/building-h2o/?envType=problem-list-v2&envId=concurrency
 * H2O 生成
 * 现在有两种线程，氧 oxygen 和氢 hydrogen，你的目标是组织这两种线程来产生水分子。
 * <p>
 * 存在一个屏障（barrier）使得每个线程必须等候直到一个完整水分子能够被产生出来。
 * <p>
 * 氢和氧线程会被分别给予 releaseHydrogen 和 releaseOxygen 方法来允许它们突破屏障。
 * <p>
 * 这些线程应该三三成组突破屏障并能立即组合产生一个水分子。
 * <p>
 * 你必须保证产生一个水分子所需线程的结合必须发生在下一个水分子产生之前。
 * <p>
 * 换句话说:
 * <p>
 * 如果一个氧线程到达屏障时没有氢线程到达，它必须等候直到两个氢线程到达。
 * 如果一个氢线程到达屏障时没有其它线程到达，它必须等候直到一个氧线程和另一个氢线程到达。
 * 书写满足这些限制条件的氢、氧线程同步代码。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: water = "HOH"
 * 输出: "HHO"
 * 解释: "HOH" 和 "OHH" 依然都是有效解。
 * 示例 2:
 * <p>
 * 输入: water = "OOHHHH"
 * 输出: "HHOHHO"
 * 解释: "HOHHHO", "OHHHHO", "HHOHOH", "HOHHOH", "OHHHOH", "HHOOHH", "HOHOHH" 和 "OHHOHH" 依然都是有效解。
 */
public class BuildingH2o {

    public static void main(String[] args) throws InterruptedException {
        H2O h2O = new BuildingH2o().new H2O();
        new Thread(() -> {
            try {
                h2O.hydrogen(() -> System.out.print("H"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                h2O.hydrogen(() -> System.out.print("H"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                h2O.oxygen(() -> System.out.print("O"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
//
//        h2O.hydrogen(() -> System.out.print("H"));
//        h2O.hydrogen(() -> System.out.print("H"));
//        h2O.oxygen(() -> System.out.print("O"));


    }

    class H2O {

        int hCount = 0;
        int oCount = 0;
        CyclicBarrier hBarrier = new CyclicBarrier(2,()->{
            // reset oBarrier
            hCount=0;

        });
        CyclicBarrier oBarrier = new CyclicBarrier(1,()->{
            oCount=0;
        });


        public H2O() {

        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            if (hCount == 2) {
                try {
                    hBarrier.await();
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }
            hCount++;
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();


        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        }
    }
}
