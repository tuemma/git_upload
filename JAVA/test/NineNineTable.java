package com.cathaybk.practice.nt01900432.b;

public class NineNineTable {

	public static void main(String[] args) {

		int length = 9;

		for (int i = 1; i <= length; i = i + 1) {

			for (int j = 2; j <= length; j = j + 1) {

				System.out.printf("%d * %d = %2d  ", j, i, j * i);
			}

			System.out.println("");
		}

	}

}
