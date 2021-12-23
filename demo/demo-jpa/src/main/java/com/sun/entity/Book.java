package com.sun.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book", schema = "db_example")
public class Book {

	@Id
	private String name;
	private String data;
	private String author;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String name, String data, String author) {
		super();
		this.name = name;
		this.data = data;
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [name=" + name + ", data=" + data + ", author=" + author + "]";
	}
	
}
