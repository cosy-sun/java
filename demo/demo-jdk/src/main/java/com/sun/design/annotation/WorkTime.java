package com.sun.design.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.METHOD})
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
public @interface WorkTime {
	//设置方法,返回值是整形
	int value();
	
}
