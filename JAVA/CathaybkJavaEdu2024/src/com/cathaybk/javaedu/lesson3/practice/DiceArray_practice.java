package com.cathaybk.javaedu.lesson3.practice;

import java.util.Random;

public class DiceArray_practice {
	
	 public static void main(String[] args) {
			Random random = new Random();
			
			//                      index : 0  1  2  3  4  5  6  7  8   9   10
			//                      strArr: 2  3  4  5  6  7  8  9  10  11  12 
			String[] strArr = new String[] {"","","","","","","","","","",""} ;
					
			for (int i =0; i < 20; i++) {
				
				int a = random.nextInt(6) + 1;
				int b = random.nextInt(6) + 1;
				int sum = a+b;
//				System.out.println(sum);
				
				strArr[sum-2] =strArr[sum-2]+ "*" ;  // * 存到StrArr""裡面
				
			}
			for (int i =0; i <strArr.length; i++) { 
//				System.out.println(strArr[i]);
				//  strArr"" 裡面沒有*
				if (!"".equals(strArr[i])){  //字串比較 用equal
					System.out.print(i+2);
					System.out.println(strArr[i]);
				}
				
			}

	    }
	 
}
