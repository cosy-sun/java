package com.cosy.sun.jdk.newj;

import java.io.*;
import java.util.List;

public class Java9NewFunc {

    /**
     * 集合加强
     */
    public static void collectNew() {
        List<Object> objects = List.of();
        objects.forEach(System.out::println);
        List<String> sunzhenhua = List.of("sunzhenhua");
        sunzhenhua.forEach(System.out::println);
        List<String> a = List.of("a", "b", "c");
        a.forEach(System.out::println);
        List<String> copyList = List.copyOf(a);
        copyList.forEach(System.out::println);
    }

    public void interfaceNew() {
        InterfaceNewPrivateMethod interfaceNewPrivateMethod = new InterfaceNewPrivateMethodImpl();
        interfaceNewPrivateMethod.implMethod();
    }

    public static class InterfaceNewPrivateMethodImpl implements InterfaceNewPrivateMethod {

        @Override
        public void implMethod() {
            System.out.println("实现方法");
            defaultMethod();
        }
    }

    public interface InterfaceNewPrivateMethod {

        public void implMethod();

        private void privateMethod() {
            System.out.println("调用接口里面的私有方法");
        }

        default void defaultMethod() {
            System.out.println("默认方法");
            privateMethod();
        }
    }

    /**
     * io增强
     * @throws IOException
     */
    public void enhanceIo() throws IOException {
        InputStream stream = new BufferedInputStream(new FileInputStream(new File("/opt/file.txt")));
        // 读取剩余所有的字节
        byte[] bytes = stream.readAllBytes();
        // 读取多少字节
        byte[] bytes1 = stream.readNBytes(100);

        FileOutputStream fileOutputStream = new FileOutputStream(new File("/"));
        // 读取inputstream中的所有字节， 写入到outputstream中
        stream.transferTo(fileOutputStream);

    }


    public void jshell() {
        // 添加jshell工具
        // 控制台中输入 jshell即可使用
        // 输入/exit关闭jshell

        // 可以用来testjava代码
    }

}
