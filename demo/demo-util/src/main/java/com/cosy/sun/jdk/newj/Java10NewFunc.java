package com.cosy.sun.jdk.newj;

import java.util.ArrayList;

public class Java10NewFunc {

    /**
     * var 类型推断
     */
    public void varFunc() {
        var thread = new Thread(() -> {
            System.out.println("线程");
        });
        thread.start();

        var list = new ArrayList<>();
        list.add("sun");
        list.add("zhen");
        list.forEach(System.out::println);

        // 只支持有初始化的对象
//        var str = null;
        // var 不支持符合变量
//        var i = 1, j = 2;
        for (var i = 0; i < 10; i++) {

        }
        for (var lis : list) {
            System.out.println(lis);
        }
    }

    // TODO 线程本地握手没有很明白， 后面在研究
    public void threadLocalHandleShake() {

    }

    /**
     * gc改进和内存管理
     */



}
