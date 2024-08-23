package com.cathaybk.practice.nt01900432.b;

public class Sales extends Employee {

	private int bouns;
	private int payment;
   
	
	public Sales(String name, String department, int salary, int bouns) {
		super(name, department, salary);
		this.bouns = (int) (bouns * 0.05);
		this.payment = salary + this.bouns;

	}
	
	@Override
	public void printInfo() {
		super.printInfo();;
		System.out.println("業績獎金: " + bouns);
		System.out.println("總計: " + payment);
	}

	public int getBouns() {
		return bouns;
	}

	public void setBouns(int bouns) {
		this.bouns = bouns;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

}
