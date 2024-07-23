package com.cosy.sun.jdk;

import org.junit.Test;

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
