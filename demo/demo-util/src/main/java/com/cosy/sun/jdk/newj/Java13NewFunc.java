package com.cosy.sun.jdk.newj;

public class Java13NewFunc {

    /**
     * dynamic cds
     * 核心类在jvm之间共享， 每个jvm只加载自己的应用类
     */

    /**
     * 使用新的nioSocketimpl来替换plainSocketImpl
     * 如果要使用老的socket， 加上vm参数  -Djdk.net.usePlainSocketIimpl
     */

    /**
     * 最新switch特性， 增加了yeid关键字， 用来返回， 不返回用break；
     */
    public void switchNew() {
        String str = "";
        int b = switch (str) {
            case "1", "2" -> 1;
            case "3", "4" -> 2;
            default -> {
                yield 3;
            }
        };
        System.out.println(b);
    }

    /**
     * 直接复制字符串， 换行不在做转义
     */

    public void defineStr() {
        String str = """
-Xms128m
-Xmx1024m
-XX:ReservedCodeCacheSize=512m
-XX:+UseG1GC
-XX:SoftRefLRUPolicyMSPerMB=50
-XX:CICompilerCount=2
-XX:+HeapDumpOnOutOfMemoryError
-XX:-OmitStackTraceInFastThrow
-XX:+IgnoreUnrecognizedVMOptions
-XX:CompileCommand=exclude,com/intellij/openapi/vfs/impl/FilePartNodeRoot,trieDescend
-ea
-Dsun.io.useCanonCaches=false
-Dsun.java2d.metal=true
-Djbr.catch.SIGABRT=true
-Djdk.http.auth.tunneling.disabledSchemes=""
-Djdk.attach.allowAttachSelf=true
-Djdk.module.illegalAccess.silent=true
-Dkotlinx.coroutines.debug=off
-Dsun.tools.attach.tmp.only=true
-Dawt.lock.fair=true
                """;

        String str1 = "-Xms128m\n" +
                "-Xmx1024m\n" +
                "-XX:ReservedCodeCacheSize=512m\n" +
                "-XX:+UseG1GC\n" +
                "-XX:SoftRefLRUPolicyMSPerMB=50\n" +
                "-XX:CICompilerCount=2\n" +
                "-XX:+HeapDumpOnOutOfMemoryError\n" +
                "-XX:-OmitStackTraceInFastThrow\n" +
                "-XX:+IgnoreUnrecognizedVMOptions\n" +
                "-XX:CompileCommand=exclude,com/intellij/openapi/vfs/impl/FilePartNodeRoot,trieDescend\n" +
                "-ea\n" +
                "-Dsun.io.useCanonCaches=false\n" +
                "-Dsun.java2d.metal=true\n" +
                "-Djbr.catch.SIGABRT=true\n" +
                "-Djdk.http.auth.tunneling.disabledSchemes=\"\"\n" +
                "-Djdk.attach.allowAttachSelf=true\n" +
                "-Djdk.module.illegalAccess.silent=true\n" +
                "-Dkotlinx.coroutines.debug=off\n" +
                "-Dsun.tools.attach.tmp.only=true\n" +
                "-Dawt.lock.fair=true";
    }

}
