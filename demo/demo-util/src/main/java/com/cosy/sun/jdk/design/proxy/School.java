package com.cosy.sun.jdk.design.proxy;

import java.util.ArrayList;
import java.util.List;

public class School implements Istudent{

	private List<BigChild> students = new ArrayList<>();
	
	public School() {
		super();
	}
	
	public void addStudent(BigChild student) {
		students.add(student);
	}
	
	@Override
	public void readBook() {
		for(BigChild student : students) {
			student.readBook();
		}
	}

	
	public static void main(String [] args ) {
		Child child = new Child("sunzhenhua");
		
		BigChild bigChild = new BigChild(child);
		
		School school = new School();
		school.addStudent(bigChild);
		school.readBook();
	}
	
}
