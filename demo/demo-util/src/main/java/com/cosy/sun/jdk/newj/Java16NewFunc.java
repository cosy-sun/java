package com.cosy.sun.jdk.newj;

public class Java16NewFunc {

    /**
     * 该版本更新如下：
     * 1. instanceof
     * 2. record
     * 3. sealed permits
     * 4. integer inter = 100；
     * 5. c++14新特性
     */

    public void integerNew() {
        Integer integer = 100;
        Double doubl1 = 100d;
    }

    public sealed class InnerClass permits Impl1, Impl2, Impl3 {

    }

    public final class Impl1 extends InnerClass {

    }

    non-sealed class Impl2 extends InnerClass {

    }

    private sealed class Impl3 extends InnerClass permits SubImpl2 {

    }

    public final class SubImpl2 extends Impl3 {

    }


    /**
     * vetcor api
     * 暂时不好用 好用了，
     */
    public void vector() {
//        int[] a = {1, 2, 3, 4, 5, 6};
//        int[] b = {2, 3, 4, 5, 6, 7};
//        var vectora = IntVector.fromArray(IntVector.SPECIES_128, a, 0);
//        var vectorb = IntVector.fromArray(IntVector.SPECIES_128, b, 0);
//        var mul = vectora.mul(vectorb);
//        System.out.println(mul);
    }

    /**
     * jpackage工具， 打包工具
     */

}
