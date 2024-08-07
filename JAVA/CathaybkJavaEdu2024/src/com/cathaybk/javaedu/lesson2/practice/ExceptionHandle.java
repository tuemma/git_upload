package com.cathaybk.javaedu.lesson2.practice;

import java.awt.print.Printable;
import java.util.Random;

public class ExceptionHandle {
	public static void main(String[] args) {
		Random random = new Random();
		
		int a = random.nextInt(101);
		
		if (a % 2 == 1) {
			System.out.println(a);
		}else {
		}
	}

}
