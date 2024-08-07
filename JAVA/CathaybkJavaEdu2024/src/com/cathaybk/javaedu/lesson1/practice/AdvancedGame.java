package com.cathaybk.javaedu.lesson1.practice;

import java.util.Random;

public class AdvancedGame {
	public static void main(String[] args) {
		
		Random random = new Random();
		//0:剪刀 1:石頭 2:布
		
		int aWin=0;
		int bWin=0;
		while(aWin < 2 && bWin < 2) {
			
			int a = random.nextInt(3);
			int b = random.nextInt(3);
			
			System.out.print("A出拳:"+getResult(a)+" B出拳:"+getResult(b));
			System.out.print(" ");

			if ((a == 0 && b == 2) || (a == 1 && b == 0) || (a == 2 && b == 1)) {
				System.out.println("A贏");
				aWin = aWin+1;
			} else if ((b == 0 && a == 2) || (b == 1 && a == 0) || (b == 2 && a == 1)) {
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

	
	public static String getResult(int aORb) {
		switch (aORb) {

		case 0:
//			System.out.println("剪刀");
			return "剪刀";

		case 1:
//			System.out.println("石頭");
			return "石頭";

		case 2:
//			System.out.println("布");
			return "布";

		}
		return null;		
	}
	
}
