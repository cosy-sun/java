package com.cosy.sun.jdk.newj.jdk8.annotation_repeatable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target( ElementType.TYPE )
@Retention( RetentionPolicy.RUNTIME )
public @interface Szhs {

	Szh[] value();
	
}
