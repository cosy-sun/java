package com.cosy.sun.jdk.morethread;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SimpleDateFormatTest {

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(20);
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            
            executorService.execute(() -> {
                try {
                    semaphore.acquire(1);
                    LocalDate.parse("20241010", FORMATTER);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
                semaphore.release();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println("都转换成功了");
    }

}
