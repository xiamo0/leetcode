package concurrency;

import java.util.concurrent.Semaphore;

/**
 * https://leetcode.cn/problems/print-foobar-alternately/description/?envType=problem-list-v2&envId=concurrency
 * <p>
 * 交替打印 FooBar
 * <p>
 * 给你一个类：
 * <p>
 * class FooBar {
 * public void foo() {
 * for (int i = 0; i < n; i++) {
 * print("foo");
 * }
 * }
 * <p>
 * public void bar() {
 * for (int i = 0; i < n; i++) {
 * print("bar");
 * }
 * }
 * }
 * 两个不同的线程将会共用一个 FooBar 实例：
 * <p>
 * 线程 A 将会调用 foo() 方法，而
 * 线程 B 将会调用 bar() 方法
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出："foobar"
 * 解释：这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出："foobarfoobar"
 * 解释："foobar" 将被输出两次。
 */
public class PrintFoobarAlternately {

    public static void main(String[] args) throws InterruptedException {
        FooBar fooBar = new FooBar(3);

        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    fooBar.foo(() -> System.out.print("foo"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    fooBar.bar(() -> System.out.print("bar"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
        t2.start();

    }

    static class FooBar {
        private int n;

        private Semaphore fooSemaphore = null;
        private Semaphore barSemaphore = null;

        public FooBar(int n) {
            this.n = n;
            fooSemaphore = new Semaphore(1);
            barSemaphore = new Semaphore(0);
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                fooSemaphore.acquire();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                barSemaphore.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                barSemaphore.acquire();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                fooSemaphore.release();
            }
        }
    }
}
