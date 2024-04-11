package com.cosy.sun.jdk.algorithm.leetcode;

import java.util.concurrent.Semaphore;

/**
 * 现有函数 printNumber 可以用一个整数参数调用，并输出该整数到控制台。
 *
 * 例如，调用 printNumber(7) 将会输出 7 到控制台。
 * 给你类 ZeroEvenOdd 的一个实例，该类中有三个函数：zero、even 和 odd 。ZeroEvenOdd 的相同实例将会传递给三个不同线程：
 *
 * 线程 A：调用 zero() ，只输出 0
 * 线程 B：调用 even() ，只输出偶数
 * 线程 C：调用 odd() ，只输出奇数
 * 修改给出的类，以输出序列 "010203040506..." ，其中序列的长度必须为 2n 。
 *
 * 实现 ZeroEvenOdd 类：
 *
 * ZeroEvenOdd(int n) 用数字 n 初始化对象，表示需要输出的数。
 * void zero(printNumber) 调用 printNumber 以输出一个 0 。
 * void even(printNumber) 调用printNumber 以输出偶数。
 * void odd(printNumber) 调用 printNumber 以输出奇数。
 *
 */
public class LC1116 {

    public static void main(String[] args) {
        LC1116 lc1116 = new LC1116(100);


        new Thread(()->{
            try {
                lc1116.zero();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                lc1116.even();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                lc1116.odd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    private int n;

    private Semaphore zero = new Semaphore(1);
    private Semaphore even = new Semaphore(0);
    private Semaphore odd = new Semaphore(0);
    LC1116(int n) {
        this. n = n;
    }

    public void zero() throws Exception {
        for(int i = 1; i<= n ;i++) {
            zero.acquire();
            printNum(0);
            if(i % 2 == 1) {
                odd.release();
            } else {
                even.release();
            }
        }
    }

    public void even() throws Exception {
        for(int i = 2; i<= n; i +=2) {
                even.acquire();
                printNum(i);
                zero.release();
        }
    }

    public void odd() throws Exception {
        for(int i =1; i<= n; i +=2) {
                odd.acquire();
                printNum(i);
                zero.release();
        }
    }

    public void printNum(int n) {
        System.out.println(n);
    }

}
