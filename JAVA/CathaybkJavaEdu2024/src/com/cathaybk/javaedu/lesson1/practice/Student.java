package com.cathaybk.javaedu.lesson1.practice;

public class Student {
	
	private String name = "Jason";
	private int id = 8888 ;
	private int grade = 1;
	
	public void print() {
		System.out.println("學生姓名:"+name+"學號:"+id+"年級:"+grade);
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
}
