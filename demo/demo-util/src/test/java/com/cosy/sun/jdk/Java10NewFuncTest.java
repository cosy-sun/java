package com.cosy.sun.jdk;

import com.cosy.sun.jdk.newj.Java10NewFunc;
import org.junit.jupiter.api.Test;

class Java10NewFuncTest {
    Java10NewFunc java10NewFunc = new Java10NewFunc();

    @Test
    void testVarFunc() {
        java10NewFunc.varFunc();
    }

    @Test
    public void testNullPoint() {
        String str = null;
        if(str.equals("")) {
            System.out.println("竟然通过了");
        }
    }
}

