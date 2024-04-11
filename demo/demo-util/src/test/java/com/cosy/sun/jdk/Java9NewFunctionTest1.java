package com.cosy.sun.jdk;

import com.cosy.sun.jdk.newj.Java9NewFunc;
import org.junit.jupiter.api.Test;

class Java9NewFunctionTest1 {
    Java9NewFunc java9NewFunction = new Java9NewFunc();

    @Test
    void testCollectNew() {
        Java9NewFunc.collectNew();
    }

    @Test
    void testInterfaceNew() {
        java9NewFunction.interfaceNew();
        Java9NewFunc.InterfaceNewPrivateMethod interfaceNewPrivateMethod = new Java9NewFunc.InterfaceNewPrivateMethodImpl();
        // 调用稀有方法会报错
//        interfaceNewPrivateMethod.privatemethod();
    }
}