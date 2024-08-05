package com.cosy.sun.jdk;


import org.junit.jupiter.api.Test;

public class StackOOMTest {

    @Test
    public void testStackOOM() {
        boolean oom = oom();
        System.out.println(oom);
    }

    private boolean oom() {
        int i = 0;
        return oom();
    }

}
