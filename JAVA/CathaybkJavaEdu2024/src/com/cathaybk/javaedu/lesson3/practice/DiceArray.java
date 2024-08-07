package com.cathaybk.javaedu.lesson3.practice;

import java.util.Random;
import java.util.function.BiConsumer;

public class DiceArray {

    public static void main(String[] args) {
        diceArray();
    }

    private static void diceArray() {
        

        //                        index   0   1   2   3   4   5   6   7   8   9   10          
        //                        統計對象  2   3   4   5   6   7   8   9   10  11  12
        String[] results = new String[] { "", "", "", "", "", "", "", "", "", "", "" };

        for (int i = 1; i <= 20; i++) {
            results[dice() + dice() - 2] += "*";
        }

        for (int i = 0; i < results.length; i++) {
            String result = results[i];
            if (!"".equals(result)) {
                System.out.println((i + 2) + result);
            }
        }
    }

    private static int dice() {
        return (int) (Math.random() * 10 % 6) + 1;
        //     * 10 % 6        0 1 2 3 4 5
        //     * 10 % 6 + 1    1 2 3 4 5 6
    }
	
//	public static void main(String[] args) {
//		Random rand = new Random();
//		
//		//result: 2 3 4 5 6 7 ... 12
//		//index:  0 1 2 3 4 5 ... 10
//		
//		String[] results = new String[] { "", "", "", "", "", "", "", "", "", "", "" };
//		for (int i = 0; i < 20; i++) {
//			int result1 =rand.nextInt(6)+1;
//			int result2 =rand.nextInt(6)+1;
//			int sum =result1+result2;
//			results[sum-2] = results[sum-2] + "*"; // result[sum-2] += "*"
//		}
//		for (int i = 0; i < results.length; i++) {
//			String resultString =results[i];
//			if ("".equals(result)) {
//				continue;
//			}
//			System.out.println((i+2)+result);
//		}
//	
//		
//	}
//	private static int getIndexBySumOfResults()
	
}
