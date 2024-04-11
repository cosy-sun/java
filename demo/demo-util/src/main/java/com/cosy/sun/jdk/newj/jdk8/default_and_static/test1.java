package com.cosy.sun.jdk.newj.jdk8.default_and_static;

class test1 {

	void test() {
		DefaultAble default1 = new DefaultImpl();
		default1.test();
		DefaultAble default2 = new OverrideImpl();
		default2.test();
	}
	
	void teststatic() {
		DefaultAble test2 = DefaultAble.test2(DefaultImpl :: new);
		test2.test();
		
		DefaultAble test3 = DefaultAble.test2(OverrideImpl :: new );
		test3.test();
	}
	
}
