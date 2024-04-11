package com.cosy.sun.jdk.design.cloneTest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Blog extends CosySun implements Serializable{

	private String blogName;
	private String blogUrl;
	private String blogGitPages;
	private transient String password;
	private List<String> name = new ArrayList<>();
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void addName(String s) {
		name.add(s);
	}
	
	public List<String> getList() {
		return name;
	}
	
	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getBlogUrl() {
		return blogUrl;
	}

	public void setBlogUrl(String blogUrl) {
		this.blogUrl = blogUrl;
	}

	public String getBlogGitPages() {
		return blogGitPages;
	}

	public void setBlogGitPages(String blogGitPages) {
		this.blogGitPages = blogGitPages;
	}

	@Override
	public String toString() {
		return "Blog [blogName=" + blogName + ", blogUrl=" + blogUrl + ", blogGitPages=" + blogGitPages + ", password="
				+ password + ", name=" + name + "]";
	}

	@SuppressWarnings("unused")
	public Object clone() {
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos;
		Object readObject = null;
		byte[] b = null;
		try {
			oos = new ObjectOutputStream(baos);
			oos.writeObject(this);
			ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
			readObject = ois.readObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return readObject;
		
	}
	
}
