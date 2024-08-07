package com.cathaybk.javaedu.lesson2.practice.practice;

public class Student implements IPrint{
	
	private String name;
	private int id;
	private int grade;
	
	//建構子(一種方法) 跟class名子一樣  初始化參數
	public Student(String name, int id, int grade) {
		this.name = name;
		this.id = id;
		this.grade = grade;
	}
	
	public Student() {
		
	}
	
	@Override
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
