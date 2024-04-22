package com.cosy.sun.algorithm.leetcode;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
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
 */
public class LC1117 {

    public static void main(String[] args) {
        LC1117 lc1117 = new LC1117();


        for (int i = 0; i < 100; i++) {
            Runnable runH = getRunnableH(lc1117);
            new Thread(runH).start();
        }

        for (int i = 0; i < 50; i++) {
            Runnable runO = getRunnableO(lc1117);
            new Thread(runO).start();
        }

    }

    private static Runnable getRunnableO(LC1117 lc1117) {
        return () -> {
            try {
                lc1117.oxygen();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }

    private static Runnable getRunnableH(LC1117 lc1117) {
        return () -> {
            try {

                lc1117.hydrogen();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }

    Semaphore h = new Semaphore(2);
    Semaphore o = new Semaphore(1);

    CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
        System.out.println();
        h.release(2);
        o.release(1);
    });

    public void hydrogen() throws Exception {
        h.acquire();
        System.out.print("H");
        cyclicBarrier.await();
    }

    public void oxygen() throws Exception {
        o.acquire();
        System.out.print("O");
        cyclicBarrier.await();
    }

}
