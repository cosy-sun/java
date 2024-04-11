package com.cosy.sun.jdk.newj;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

class Java15NewFuncTest {
    Java15NewFunc java15NewFunc = new Java15NewFunc();

    @Test
    void testRecordNew() {
        java15NewFunc.recordNew();
    }

    @Test
    void testValueRange() {
        java15NewFunc.valueRange();
    }

    @Test
    public void generaterClassByte() throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get("/work/workspace/repo-git-java/demo/demo-util/build/classes/java/main/com/cosy/sun/jdk/newj/HelloImpl.class"));
        String s = Base64.getEncoder().encodeToString(bytes);
        System.out.println(s);
    }

    @Test
    public void testHiddleClass() throws IllegalAccessException,InstantiationException {
        java15NewFunc.hiddleCLass();
    }


}
