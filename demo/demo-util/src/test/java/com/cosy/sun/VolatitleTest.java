package com.cosy.sun;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatitleTest {


    public static volatile AtomicInteger race = new AtomicInteger();

    public static void increase() {
        race.incrementAndGet();
    }

    private static final int THREADS_COUNT = 10;

    @Test
    public void test() {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(race);
    }

}
