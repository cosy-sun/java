package com.cosy.sun.jdk.newj;

import java.util.concurrent.Executors;

public class Java21NewFunc {

    public static void main(String[] args) {
        virtualThread();
    }

    public static void virtualThread() {
        ThreadLocal<String> local = new ThreadLocal();
        local.set("sunzhenhua");
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal();
        inheritableThreadLocal.set("sunzhenhuaxx");
        Thread virtualThread = Thread.ofVirtual().name("虚拟线程").unstarted(() -> {
            String s = local.get();
            System.out.println("threadlocal " + s);
            System.out.println("inheritablethreadlocal " + inheritableThreadLocal.get());
            System.out.println("虚拟线程内部:" + Thread.currentThread().isVirtual());
            System.out.println("运行虚拟线程");
            System.out.println(Thread.currentThread().getName());
        });
        virtualThread.start();
        System.out.println(virtualThread.isVirtual());
        System.out.println("主线程：" + Thread.currentThread().isVirtual());
    }

    public static void threadMethodCreateVirtual() {
        Thread.startVirtualThread(() -> {
            System.out.println("xxx");
        });
        Thread.ofVirtual().start(() -> {
            System.out.println("xxx");
        });
        try (var executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            executorService.execute(() -> {
                System.out.println("xxx");
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
