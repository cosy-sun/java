package com.cosy.sun.algorithm.leetcode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class _交替打印数字 {

    private int n;
    private Semaphore odd = new Semaphore(1);
    private Semaphore even = new Semaphore(0);

    public _交替打印数字(int n) {
        this.n = n;
    }

    public void printOdd() {
        for (int i=1; i<=n; i+=2) {
            try {
                odd.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("奇数" + i);
            even.release();
        }
    }

    public void printEven() {
        for(int i=2; i<=n; i+=2) {
            try {
                even.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("偶数" + i);
            odd.release();
        }
    }

    public static void main(String[] args){
        _交替打印数字 printNum = new _交替打印数字(100);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            printNum.printOdd();
        });
        executorService.submit(() -> {
            printNum.printEven();
        });
        executorService.shutdown();
    }

}
