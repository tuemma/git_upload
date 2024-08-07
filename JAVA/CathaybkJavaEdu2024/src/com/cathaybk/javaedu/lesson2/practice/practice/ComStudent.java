package com.cathaybk.javaedu.lesson2.practice.practice;

public class ComStudent extends Student {

	public String program;

	public ComStudent() {
		System.out.println("沒有傳入參數的ComStudent建構子");
		
	}

	public ComStudent(String name, int id, int grade, String program) {
		super(name, id, grade);  //super() 呼叫建構子
		this.program = program;
	}
	
	public void print() {
		
		/*super.print();
		 *System.out.println("程式語言:"+program) */
		System.out.println("學生姓名:"+this.getName()+",學號:"+this.getId()+",年級:"+this.getGrade()+"\n程式語言:"+program);
	}
	

}
