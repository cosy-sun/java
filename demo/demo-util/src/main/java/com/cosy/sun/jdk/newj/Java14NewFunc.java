package com.cosy.sun.jdk.newj;

import java.util.Objects;


public class Java14NewFunc {

    private String name;

    public boolean instanceofName(Object o) {
        return o instanceof Java14NewFunc func && Objects.equals(this.name, func.name);
    }

    /**
     * instanceof的新模式匹配
     */
    public void instanceofNew(Object o) {
        if(o instanceof String str) {
            System.out.println(str.length());
        }
    }

    /**
     * switch 表达式，  标准在14中，之前都是预览
     *
     * 可以多之匹配
     *
     * 可以使用yield关键字返回
     */

    /**
     * 文本块使用 """ """
     */



}
