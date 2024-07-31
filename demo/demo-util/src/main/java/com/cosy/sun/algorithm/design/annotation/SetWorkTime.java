package com.cosy.sun.algorithm.design.annotation;

import java.lang.reflect.Method;

public class SetWorkTime {
    @WorkTime(value = 8)
    //@WorkTime(8)
    public void setWorkTime(int time) throws Exception {
        //获得这个类的clazz对象
        Class<? extends SetWorkTime> class1 = this.getClass();
        //通过class对想获得方法
        Method method = class1.getDeclaredMethod("setWorkTime", int.class);
        //判断在这个方法上是否有注解
        if (method.isAnnotationPresent(WorkTime.class)) {
            //判断成功,通过方法获得在此方法上的注解
            WorkTime workTime = method.getAnnotation(WorkTime.class);
            //通过注解中的方法获取返回值,得到我们在使用注解的时候设置的值
            int value = workTime.value();
            if (time > value) {
                throw new RuntimeException("超过最长时间了");
            } else {
                System.out.println("设置成功");
            }
        }
    }
}
