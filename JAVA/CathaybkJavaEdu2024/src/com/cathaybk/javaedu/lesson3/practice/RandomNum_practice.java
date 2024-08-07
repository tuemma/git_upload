package com.cathaybk.javaedu.lesson3.practice;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class RandomNum_practice {

	public static void main(String[] args) {
		Random random = new Random();
	
		/*Set*/
//		Set<Integer> result = new TreeSet<>();
//		
//		while (result.size()<5) {
//			
//			int a = random.nextInt(10)+1;
//			result.add(a);
//			
//		}
//		System.out.println(result);
		
		
		/*List*/
		List<Integer> result2 = new ArrayList<>();
		
		while (result2.size()<5) {
			
			int a = random.nextInt(10)+1; //解決不重複
			if (!result2.contains(a)) {  //if (result2.contains(a)==false)
				result2.add(a);
			}

		}
		Collections.sort(result2);
		System.out.println(result2);
	}

}
