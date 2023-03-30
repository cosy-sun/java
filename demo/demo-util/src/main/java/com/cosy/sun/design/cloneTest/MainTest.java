package com.cosy.sun.design.cloneTest;

public class MainTest {

	
	public static void main(String[] args) {
		
		Blog blog = new Blog();
		
		blog.setBlogName("cosy-sun");
		blog.setBlogUrl("cosy-sun.github.io");
		blog.setBlogGitPages("gitPages");
		blog.addName("sunzhenhua");
		blog.setPassword("12341234");
		System.out.println(blog);
		Blog clone = (Blog)blog.clone();
		System.out.println(clone);
		
		clone.setBlogName("sunzhenhua");
		clone.addName("cosy-sun");
		clone.getList().remove("sunzhenhua");
		
		System.out.println(clone);
		System.out.println(blog);
	}
	
}
