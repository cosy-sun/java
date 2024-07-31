package com.cosy.sun.algorithm.design.annotation;

import java.lang.annotation.*;

@Target(value = {ElementType.METHOD})
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
public @interface WorkTime {
	//设置方法,返回值是整形
	int value();

}
