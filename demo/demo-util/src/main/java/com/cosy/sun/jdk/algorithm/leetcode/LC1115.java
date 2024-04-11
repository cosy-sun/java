package com.cosy.sun.jdk.algorithm.leetcode;

import java.util.concurrent.Semaphore;

/**
 * 给你一个类：
 * <p>
 * class FooBar {
 * public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 * }
 * <p>
 * public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 * }
 * }
 * 两个不同的线程将会共用一个 FooBar 实例：
 * <p>
 * 线程 A 将会调用 foo() 方法，而
 * 线程 B 将会调用 bar() 方法
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 */
public class LC1115 {

    private Semaphore semaphore01 = new Semaphore(1);
    private Semaphore semaphore02 = new Semaphore(0);

    private int n = 100;

    volatile boolean flag = false;

    public static void main(String[] args) {
        LC1115 LC1115 = new LC1115();
        Thread thread = new Thread(() -> {
            LC1115.foo(() -> {
                System.out.print("foo");
            });
        });
        Thread bar = new Thread(() -> {
            LC1115.bar(() -> {
                System.out.println("bar");
            });
        });
        thread.start();
        bar.start();
    }

    public void foo(Runnable runnable) {
        try {
            for (int i = 0; i < n; i++) {
                semaphore01.acquire();
                runnable.run();
                semaphore02.release();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void bar(Runnable runnable) {
        try {
            for (int i = 0; i < n; i++) {
                semaphore02.acquire();
                runnable.run();
                semaphore01.release();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
