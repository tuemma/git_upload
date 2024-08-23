package com.cathaybk.practice.nt01900432.b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Readcsv {
	public static void main(String[] args) {

		/* 讀取CSV檔,輸出一筆資料轉存成一個Map,並將所有資料放入List中並利用 */
		String filepath = "C:\\Users\\Admin\\Desktop\\cars.csv";
		String line;

		List<Map<String, String>> maplist = new ArrayList<>();

		/* 用BufferedReader讀取CSV檔 */
		try (BufferedReader bufr = new BufferedReader(new FileReader(filepath))) {

			String[] header = bufr.readLine().split(","); //讀取CSV檔的第一行

			while ((line = bufr.readLine()) != null) { // 逐行讀取CSV檔，直到檔案結束
				String[] value = line.split(",");

				Map<String, String> map = new HashMap<>();

				for (int i = 0; i < header.length; i++) {
					map.put(header[i], value[i]);
				}
//				System.out.println(map);

				maplist.add(map);
			}
//			System.out.println(maplist);  [{},{},{}...]
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		/* 針對Price欄位進行資料排序 */      //匿名函數
		Collections.sort(maplist, (p1, p2) -> { // Double.parseDouble 於將字串轉換為double類型
			double price1 = Double.parseDouble(p1.get("Price"));
			double price2 = Double.parseDouble(p2.get("Price"));
			return Double.compare(price2, price1);  //降序排序
		});
//		System.out.println(maplist);

		/* 輸出為另一份CSV檔 */
		String fileoutput = "C:\\Users\\Admin\\Desktop\\car2.csv";
		try (BufferedWriter bufw = new BufferedWriter(new FileWriter(fileoutput))) {

			String[] header = { "﻿Manufacturer", "Type", "Min.Price", "Price" };
			bufw.write(String.join(",", header));
			bufw.newLine();

			for (Map<String, String> map : maplist) {  //遍歷maplist中的每一個Map對象。每個Map代表CSV文件中的一行數據

				List<String> values = new ArrayList<>();

				for (String header1 : header) {   
					values.add(map.get(header1));   //從map中提取對應的數據
//					System.out.println(map.get(header1));
				}

				bufw.write(String.join(",", values));
				bufw.newLine();
//				System.out.println("*");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
