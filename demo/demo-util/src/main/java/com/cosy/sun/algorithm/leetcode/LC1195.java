package com.cosy.sun.algorithm.leetcode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
 *
 * 如果这个数字可以被 3 整除，输出 "fizz"。
 * 如果这个数字可以被 5 整除，输出 "buzz"。
 * 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
 * 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。
 *
 * 假设有这么一个类：
 *
 * class FizzBuzz {
 *   public FizzBuzz(int n) { ... }               // constructor
 *   public void fizz(printFizz) { ... }          // only output "fizz"
 *   public void buzz(printBuzz) { ... }          // only output "buzz"
 *   public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
 *   public void number(printNumber) { ... }      // only output the numbers
 * }
 * 请你实现一个有四个线程的多线程版  FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用：
 *
 * 线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。
 * 线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。
 * 线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。
 * 线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。
 *
 */
public class LC1195 {

    public static void main(String[] args) {
        LC1195 lc1195 = new LC1195(100);
        new Thread(() -> {
            lc1195.fizz();
        }).start();

        new Thread(() -> {
            lc1195.buzz();
        }).start();
        new Thread(() -> {
            lc1195.number();
        }).start();
        new Thread(() -> {
            lc1195.fizzBuzz();
        }).start();

    }

    private int n;


    LC1195(int n) {
        this.n = n;
    }

    private CyclicBarrier cyc = new CyclicBarrier(4);

    public void fizz() {
        for(int i = 1; i<= n; i++) {
            if(i % 3 == 0 && i % 5 != 0) {
                System.out.println("fizz");
            }
            try {
                cyc.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void buzz() {
        for(int i = 1; i<= n; i++) {
            if(i % 5 == 0 && i %3 != 0) {
                System.out.println("buzz");
            }
            try {
                cyc.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void fizzBuzz() {
        for(int i = 1; i<= n; i++) {
            if(i % 5 == 0 && i % 3 == 0) {
                System.out.println("fizzBuzz");
            }
            try {
                cyc.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void number() {
        for(int i = 1; i<= n; i++) {
            if(i % 5 != 0 && i % 3 != 0) {
                System.out.println(i);
            }
            try {
                cyc.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }


}
