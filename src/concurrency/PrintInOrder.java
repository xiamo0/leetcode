package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode.cn/problems/print-in-order/?envType=problem-list-v2&envId=concurrency
 * 给你一个类：
 * <p>
 * public class Foo {
 * public void first() { print("first"); }
 * public void second() { print("second"); }
 * public void third() { print("third"); }
 * }
 * 三个不同的线程 A、B、C 将会共用一个 Foo 实例。
 * <p>
 * 线程 A 将会调用 first() 方法
 * 线程 B 将会调用 second() 方法
 * 线程 C 将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 * <p>
 * 提示：
 * <p>
 * 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
 * 你看到的输入格式主要是为了确保测试的全面性。
 */
public class PrintInOrder {


    public static void main(String[] args) throws InterruptedException {
        PrintInOrder printInOrder = new PrintInOrder();
        Foo foo = printInOrder.new Foo();
        foo.first(() -> System.out.print("first"));
        foo.second(() -> System.out.print("second"));
        foo.third(() -> System.out.print("third"));

    }

    class Foo {
        AtomicInteger atomicInteger;

        public Foo() {
            atomicInteger = new AtomicInteger(1);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            while (atomicInteger.get() != 1) {
                // wait
                TimeUnit.MILLISECONDS.sleep(1);
            }
            atomicInteger.addAndGet(1);

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            while (atomicInteger.get() != 2) {
                // wait
                TimeUnit.MILLISECONDS.sleep(1);
            }
            atomicInteger.addAndGet(1);
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
        }

        public void third(Runnable printThird) throws InterruptedException {

            while (atomicInteger.get() != 3) {
                // wait
                TimeUnit.MILLISECONDS.sleep(1);
            }
//            atomicInteger.addAndGet(1);
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}


