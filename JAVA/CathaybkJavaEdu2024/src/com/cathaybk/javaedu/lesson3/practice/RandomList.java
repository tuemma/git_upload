package com.cathaybk.javaedu.lesson3.practice;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

import javax.print.attribute.Size2DSyntax;


public class RandomList {


	public static void main(String[] args) {
		
		Random random = new Random();
		List<Integer> result = new ArrayList<>();
		
		int total =0;
		
		while (result.size()<15) {
			int a=random.nextInt(100)+1;
			if(!result.contains(a)) {
				result.add(a);
				total = a + total;
			}
		}
		Collections.sort(result);
		System.out.println(result);
		System.out.println("平均值:"+total/result.size());
		
	}
}