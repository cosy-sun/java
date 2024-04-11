package com.cosy.sun.jdk.newj;

public class Java20NewFunc {

    /**
     * 作用域值
     */

    public void ss() {
        record strings(String name, int id){
            strings{
                name = name + "";
                id = id + 10;
            }
        };

        strings sunzhenhua = new strings("sunzhenhua", 10);
        System.out.println(sunzhenhua.id());
        System.out.println(sunzhenhua.name());

    }

}
