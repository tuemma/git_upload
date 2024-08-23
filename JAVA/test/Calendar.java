package com.cathaybk.practice.nt01900432.b;

import java.time.LocalDate;
import java.util.Scanner;

import oracle.sql.ConcreteProxyUtil;

public class Calendar {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("輸入介於1-12間的整數m:");
		int month = scan.nextInt();
		scan.close();

		System.out.println("           2024年" + month + "月");
		System.out.println("-----------------------------");
		System.out.printf("%2s  %2s  %2s  %2s  %2s  %2s  %2s ", "日", "一", "二", "三", "四", "五", "六", "日");
		System.out.println();
		System.out.println("=============================");

		LocalDate firstDayOfMonth = LocalDate.of(2024, month, 1);

		int firstdayOfWeek = firstDayOfMonth.getDayOfWeek().getValue(); // 星期幾變成數字 一1 二2 、、、 日7

		/* 印前面的空格 */
		if (firstdayOfWeek == 7) { // 1號為禮拜日時不空格
			System.out.print("");

		} else {
			for (int i = 1; i <= firstdayOfWeek; i += 1) {
				System.out.printf("%4s", "");
			}
		}

		/* 日期換行 */
		for (int j = 1; j <= firstDayOfMonth.lengthOfMonth(); j += 1) { // lengthOfMonth()獲取該LocalDate所在月份的天數

			System.out.printf("%4d", j);

			if ((firstdayOfWeek + j) % 7 == 0) {
				System.out.println("");
			}
		}
	}
}
