package com.cathaybk.practice.nt01900432.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomLotto {

	public static void main(String[] args) {
		Random random = new Random();

		String result2;
		String result3;

		List<Integer> result = new ArrayList<>();

		while (result.size() < 6) {

			int a = random.nextInt(49) + 1;

			if (!result.contains(a)) {
				result.add(a);
			}

		}

		// result2 result3去除中括號及逗號
		result2 = result.toString().replace("[", "").replace("]", "").replace(",", "");
		System.out.println("排序前:" + result2);

		Collections.sort(result);
		result3 = result.toString().replace("[", "").replace("]", "").replace(",", "");
		System.out.println("排序後:" + result3);

	}
}
