package com.cathaybk.javaedu.lesson2.practice.practice;

public class LangStudent extends Student {
	
	public String language;
	
	public LangStudent() {
		System.out.println("沒有傳入參數的LangStudent建構子");
	}

	public LangStudent(String name, int id, int grade, String language) {
		super(name, id, grade);
		this.language = language;
	}
	
	public void print() {
		
//		super.print();
//		System.out.println("程式語言:"+program) 
		System.out.println("學生姓名:"+this.getName()+",學號:"+this.getId()+",年級:"+this.getGrade()+"\n外語:"+language);
	}
	
}
