//package com.cosy.sun.jdk.newj;
//
//import jdk.incubator.concurrent.StructuredTaskScope;
//
//import java.util.concurrent.Callable;
//import java.util.concurrent.Future;
//
//public class Java19NewFunc {
//
//    /**
//     * 虚拟线程
//     *
//     * 结构化并发
//     *
//     * 外部函数和内存api  java.lang.foreign包中
//     *
//     * 向量api， 目前位于jdk.incubator.vector， 在java16新功能中
//     */
//
//    public void foreign() {
//
//    }
//
//    /**
//     * 结构化并发
//     */
//    public void structConcurrenty() throws Exception {
//        try (StructuredTaskScope scope = new StructuredTaskScope.ShutdownOnFailure() ) {
//            Callable callable1 = () -> {
//                return "abc";
//            };
//            Future fork = scope.fork(callable1);
//            Callable callable = () -> {
//                return "123";
//            };
//            Future fork1 = scope.fork(callable);
//            scope.join();
//            Object o = fork.get();
//            Object o1 = fork1.get();
//            System.out.println(o);
//            System.out.println(o1);
//        }
//    }
//
//}
