package com.cathaybk.practice.nt01900432.b;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class SumCSV {

	public static void main(String[] args) {

		/* 讀取CSV檔,輸出一筆資料轉存成一個Map,並將所有資料放入List 中並利用 */
		String filepath = "C:\\Users\\Admin\\Desktop\\cars.csv";
		String line;

		List<Map<String, String>> maplist = new ArrayList<>();

		/* 用BufferedReader讀取CSV檔 */
		try (BufferedReader bufr = new BufferedReader(new FileReader(filepath))) {

			String[] header = bufr.readLine().split(",");

			while ((line = bufr.readLine()) != null) { // 逐行讀取CSV檔案，直到檔案結束
				String[] value = line.split(",");

				Map<String, String> map = new HashMap<>();

				for (int i = 0; i < header.length; i++) {
					map.put(header[i], value[i]);

				}
				maplist.add(map);

			}

			/* 根據Manufacturer做字母排序 */
			Collections.sort(maplist, (m1, m2) -> {
				String manufacturer1 = m1.get(header[0]);
				String manufacturer2 = m2.get(header[0]);
				return manufacturer1.compareTo(manufacturer2); // 降序排序
			});

			/* 打印出來 */
			System.out.printf("%-12s %-9s %7s %7s \n", "Manufacturer", "TYPE", "Min.Price", "Price");

			BigDecimal sum1 = BigDecimal.ZERO;
			BigDecimal sum2 = BigDecimal.ZERO;
			BigDecimal total1 = BigDecimal.ZERO;
			BigDecimal total2 = BigDecimal.ZERO;

			for (int i = 0; i < maplist.size(); i++) {

				BigDecimal minPrice = new BigDecimal(maplist.get(i).get(header[2]));
				BigDecimal price = new BigDecimal(maplist.get(i).get(header[3]));

				System.out.printf("%-12s %-9s %9s %7s \n", maplist.get(i).get(header[0]), maplist.get(i).get(header[1]),
						maplist.get(i).get(header[2]), maplist.get(i).get(header[3]));

				total1 = total1.add(minPrice);
				total2 = total2.add(price);

				if (i + 1 == maplist.size()) { // 印出最後一行小計

					sum1 = sum1.add(minPrice);
					sum2 = sum2.add(price);
					System.out.printf("%s %28s %7s  \n", "小計", sum1, sum2);
					break;
				}
				
				sum1 = sum1.add(minPrice); // sum1 = sum1 + minprice
				sum2 = sum2.add(price);

				if (!(maplist.get(i).get(header[0])).equals(maplist.get(i + 1).get(header[0]))) {

					System.out.printf("%s %28s %7s  \n", "小計", sum1, sum2);
					sum1 = BigDecimal.ZERO;
					sum2 = BigDecimal.ZERO;

				} 
			}
			System.out.printf("%s %28s %7s  \n", "合計", total1, total2);

//			BigDecimal total1 = BigDecimal.ZERO;
//			BigDecimal total2 = BigDecimal.ZERO;
//			/*最後一行合計*/
//			for (int j = 0; j < maplist.size(); j++) {
//
//				BigDecimal minprice = new BigDecimal(maplist.get(j).get(header[2]));
//				BigDecimal price = new BigDecimal(maplist.get(j).get(header[3]));
//
//				total1 = total1.add(minprice); // sum1 = sum1 + minprice
//				total2 = total2.add(price); // sum2 = sum2 + price
//
//			}
//			System.out.printf("%s %28s %7s  \n", "合計", total1, total2);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}