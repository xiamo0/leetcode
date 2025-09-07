package concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * https://leetcode.cn/problems/fizz-buzz-multithreaded/description/?envType=problem-list-v2&envId=concurrency
 * <p>
 * 交替打印字符串
 * 编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
 * <p>
 * 如果这个数字可以被 3 整除，输出 "fizz"。
 * 如果这个数字可以被 5 整除，输出 "buzz"。
 * 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
 * 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。
 * <p>
 * 假设有这么一个类：
 * <p>
 * class FizzBuzz {
 * public FizzBuzz(int n) { ... }               // constructor
 * public void fizz(printFizz) { ... }          // only output "fizz"
 * public void buzz(printBuzz) { ... }          // only output "buzz"
 * public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
 * public void number(printNumber) { ... }      // only output the numbers
 * }
 * 请你实现一个有四个线程的多线程版  FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用：
 * <p>
 * 线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。
 * 线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。
 * 线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。
 * 线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 本题已经提供了打印字符串的相关方法，如 printFizz() 等，具体方法名请参考答题模板中的注释部分。
 */
public class FizzBuzzMultithreaded {

    public static void main(String[] args) {
        FizzBuzzMultithreaded fizzBuzzMultithreaded = new FizzBuzzMultithreaded();
        FizzBuzz fizzBuzz = fizzBuzzMultithreaded.new FizzBuzz(15);
        Thread threadA = new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.print("fizz, "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread threadB = new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.print("buzz, "));
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        });
        Thread threadC = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.print("fizzbuzz, "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread threadD = new Thread(() -> {
            try {
                fizzBuzz.number((number) -> System.out.print(number + ", "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }

    class FizzBuzz {
        private int n;
        private int current = 1;
        private ReentrantLock lock = new ReentrantLock();

        public FizzBuzz(int n) {
            this.n = n;
        }

        public void fizz(Runnable printFizz) throws InterruptedException {
//线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。

            while (current <= n) {
                lock.lock();
                try {
                    if (current > n) {
                        break;
                    }
                    if (current % 3 == 0 && current % 5 != 0) {
                        System.out.println("fizz =" + current);
                        printFizz.run();
                        current++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
//线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。
            while (current <= n) {
                lock.lock();
                try {
                    if (current > n) {
                        break;
                    }
                    if (current % 5 == 0 && current % 3 != 0) {
                        printBuzz.run();
                        current++;

                    }
                } finally {
                    lock.unlock();
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
//线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。
            while (current <= n) {
                lock.lock();
                try {
                    if (current > n) {
                        break;
                    }
                    if (current % 3 == 0 && current % 5 == 0) {
                        printFizzBuzz.run();
                        current++;
                        System.out.println("current= "+current);
                    }
                } finally {
                    lock.unlock();
                }
            }
        }

        public void number(IntConsumer printNumber) throws InterruptedException {

            while (current <= n) {
                lock.lock();
                try {
                    if (current > n) {
                        break;
                    }
                    if (current % 3 != 0 && current % 5 != 0) {
                        printNumber.accept(current);
                        current++;
                    }
                } finally {
                    lock.unlock();
                }
            }

        }
    }

}


