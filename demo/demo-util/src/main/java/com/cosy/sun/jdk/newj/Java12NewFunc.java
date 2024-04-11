package com.cosy.sun.jdk.newj;

public class Java12NewFunc {

    public enum Day {
        mon,
        tues,
        thres,
        fors,
        ;
    }

    /**
     * switch表达式
     */
    public void switchNew() {
        Day days = Day.mon;
        int i = switch (days) {
            case mon, tues -> 3;
            case thres, fors -> 2;
        };
        System.out.println(i);
    }

    /**
     * shenandoash gc
     */

}
