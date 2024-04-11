package com.cosy.sun.jdk.util;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Arrays;

public class DemoTestTest {

        static class InnerClass {
            public String cdno;
            public BigDecimal amt;

            @Override
            public String toString() {
                return this.cdno + "-" + amt;
            }
        }


        public static void main(String... args) {
            InnerClass innerClass = new InnerClass();
            Class<? extends InnerClass> aClass = innerClass.getClass();
            Arrays.stream(aClass.getDeclaredFields()).forEach(item -> {
                item.setAccessible(true);
                try {
                    Class<?> type = item.getType();
                    String simpleName = type.getSimpleName();
                    if(StringUtils.equals(simpleName, "String")) {
                        item.set(innerClass, "");
                    }
                    if(StringUtils.equals(simpleName, "BigDecimal")) {
                        item.set(innerClass, new BigDecimal("0"));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
            System.out.println(innerClass);
        }



}
