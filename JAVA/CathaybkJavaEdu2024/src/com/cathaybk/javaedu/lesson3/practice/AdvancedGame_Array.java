package com.cathaybk.javaedu.lesson3.practice;

import java.util.Random;

public class AdvancedGame_Array {
	
public static void main(String[] args) {
		
		Random random = new Random();
		//0:剪刀 1:石頭 2:布
		
		String[] strArr = new String[] {"剪刀","石頭","布"};
		
				
		int aWin=0;
		int bWin=0;
		while(aWin < 2 && bWin < 2) {
			
			String a = strArr[random.nextInt(3)];
			String b = strArr[random.nextInt(3)];
			
			System.out.print("A出拳:"+a+" B出拳:"+b);
			System.out.print(" ");

			if ((a == "剪刀" && b == "布") || (a == "石頭" && b == "剪刀") || (a == "布" && b == "石頭")) {
				System.out.println("A贏");
				aWin = aWin+1;
			} else if ((b == "剪刀" && a == "布") || (b == "石頭" && a == "剪刀") || (b == "布" && a == "石頭")) {
				System.out.println("B贏");
				bWin = bWin+1;
			} else {
				System.out.println("平手");
			}
				
		}
		if(aWin==2) {
			System.out.println("最後贏家:A");
		}else {
			System.out.println("最後贏家:B");
		}
			
//			getResult(a);
//			getResult(b);

		}	

	
//	public static String getResult(int aORb) {
//		switch (aORb) {
//
//		case 0:
//		    System.out.println("剪刀");
//			return "剪刀";
//
//		case 1:
//			System.out.println("石頭");
//			return "石頭";
//
//		case 2:
//			System.out.println("布");
//			return "布";
//
//		}
//		return null;		
//	}

}
