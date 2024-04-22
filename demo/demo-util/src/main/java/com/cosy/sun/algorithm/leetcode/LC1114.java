package com.cosy.sun.algorithm.leetcode;

import java.util.concurrent.Semaphore;

/**
 * 给你一个类：
 * <p>
 * public class Foo {
 *   public void first() { print("first"); }
 *   public void second() { print("second"); }
 *   public void third() { print("third"); }
 * }
 * 三个不同的线程 A、B、C 将会共用一个 Foo 实例。
 * <p>
 * 线程 A 将会调用 first() 方法
 * 线程 B 将会调用 second() 方法
 * 线程 C 将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 * <p>
 * 提示：
 * <p>
 * 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
 * 你看到的输入格式主要是为了确保测试的全面性。
 */
public class LC1114 {

    private Semaphore semaphore01 = new Semaphore(0);
    private Semaphore semaphore02 = new Semaphore(0);


    public static void main(String[] args) {
        LC1114 LC1114 = new LC1114();
        Runnable run2 = () -> {
            try {
                LC1114.second(() -> {
                    System.out.println("second");
                });

            }catch (Exception e) {
                e.printStackTrace();
            }
        };
        Runnable run1 = () -> {
            LC1114.first(() -> {
                System.out.println("first");
            });
        };

        Runnable run3 = () -> {
            try {
                LC1114.third(() -> {
                    System.out.println("third");
                });

            }catch (Exception e) {
                e.printStackTrace();
            }
        };
        new Thread(run1).start();
        new Thread(run2).start();
        new Thread(run3).start();
    }


    public void first(Runnable run) {
        run.run();
        semaphore01.release();
    }

    public void second(Runnable run) throws InterruptedException {
        semaphore01.acquire();
        run.run();
        semaphore02.release();
    }

    public void third(Runnable run) throws InterruptedException {
        semaphore02.acquire();
        run.run();
    }


}
