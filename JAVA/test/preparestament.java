package com.cathaybk.practice.nt01900432.b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class preparestament {
	public static final String CONN_URL = "jdbc:oracle:thin:@//localhost:1521/XE";

	public static void main(String[] args) {

		Output();
		System.out.println("");

		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("請選擇以下指令輸入: select、insert、update、delete");
			String input = scan.nextLine();
//		scan.close();

			if (input.equals("select")) {
				doQuery();
			} else if (input.equals("insert")) {
				doInsert();
			} else if (input.equals("update")) {
				doUpdate();
			} else if (input.equals("delete")) {
				doDelete();
			}
		}

	}

	public static void Output() {
		try (Connection conn = DriverManager.getConnection(CONN_URL, "student", "student123456"); // 1.取得連線
				PreparedStatement pstmt = conn.prepareStatement("select * from STUDENT.CARS ");) { // 2.寫入SQL指令

			ResultSet rs = pstmt.executeQuery(); // 3.執行SQL ResultSet物件儲存查詢結果

			List<Map<String, String>> listmap = new ArrayList<>(); // [{},{},{}....]

			while (rs.next()) { // 遍歷ResultSet中的每一行記錄
				Map<String, String> map = new HashMap<>(); // Map 要在迴圈裡!! 才會有不同的記憶體空間
				map.put("MANUFACTURER", rs.getString("MANUFACTURER")); // rs.getString()獲取對應列的字符串數據
				map.put("TYPE", rs.getString("TYPE"));
				map.put("MIN_PRICE", rs.getString("MIN_PRICE"));
				map.put("PRICE", rs.getString("PRICE"));
				listmap.add(map);
//				System.out.println(map);				
//				System.out.println(listmap);
			}

//			System.out.println(listmap);   //[{},{},{}...] 

			StringBuilder sb = new StringBuilder();
			for (Map<String, String> map2 : listmap) { // 遍歷每一筆資料 並打印出來

//				System.out.println(listmap.get(1).get("MANUFACTURER"));
//				System.out.println(map2);	//{}			

				sb.append("製造商:").append(map2.get("MANUFACTURER")).append(" 型號:").append(map2.get("TYPE"))
						.append(" 售價:").append(map2.get("MIN_PRICE")).append(" 底價:").append(map2.get("PRICE"));

				System.out.println(sb.toString()); // 回傳整串字串回去
				sb.setLength(0);

			}
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void doQuery() {

		try (Connection conn = DriverManager.getConnection(CONN_URL, "student", "student123456");
				Scanner scan = new Scanner(System.in);
				PreparedStatement pstmt = conn
						.prepareStatement("select * from STUDENT.CARS where MANUFACTURER = ? and TYPE = ? ");) {

			System.out.print("請輸入製造商:");
			String manu = scan.nextLine();
			System.out.println("請輸入類型:");
			String type = scan.nextLine();

			pstmt.setString(1, manu);
			pstmt.setString(2, type);

			ResultSet rs = pstmt.executeQuery(); // ResultSet物件儲存查詢結果

			List<Map<String, String>> listmap = new ArrayList<>();

			while (rs.next()) {
				Map<String, String> map = new HashMap<>();
				map.put("MANUFACTURER", rs.getString("MANUFACTURER"));
				map.put("TYPE", rs.getString("TYPE"));
				map.put("MIN_PRICE", rs.getString("MIN_PRICE"));
				map.put("PRICE", rs.getString("PRICE"));

				listmap.add(map);
			}

			for (Map<String, String> map2 : listmap) {

				StringBuilder sb = new StringBuilder();
				sb.append("製造商:").append(map2.get("MANUFACTURER")).append(" 型號:").append(map2.get("TYPE"))
						.append(" 售價:").append(map2.get("MIN_PRICE")).append(" 底價:").append(map2.get("PRICE"));

				System.out.println(sb.toString());

			}
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void doInsert() {
		try (Connection conn = DriverManager.getConnection(CONN_URL, "student", "student123456")) {
			conn.setAutoCommit(false);
			try (Scanner scan = new Scanner(System.in);
					PreparedStatement pstmt = conn.prepareStatement(
							"insert into STUDENT.CARS (MANUFACTURER, TYPE, MIN_PRICE, PRICE) values (?, ?, ?, ?)")) {

				System.out.print("請輸入製造商:");
				String manu = scan.nextLine();
				System.out.println("請輸入類型:");
				String type = scan.nextLine();
				System.out.println("請輸入底價:");
				String minprice = scan.nextLine();
				System.out.println("請輸入售價:");
				String price = scan.nextLine();

				pstmt.setString(1, manu);
				pstmt.setString(2, type);
				pstmt.setString(3, minprice);
				pstmt.setString(4, price);

				pstmt.executeUpdate();
				conn.commit(); 
				System.out.println("新增成功");
			} catch (Exception e) {
				conn.rollback();  //一旦出現例外，將資料庫回歸到交易前的原始狀態
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void doUpdate() {
		try (Connection conn = DriverManager.getConnection(CONN_URL, "student", "student123456")) {
			conn.setAutoCommit(false);
			try (Scanner scan = new Scanner(System.in);
					PreparedStatement pstmt = conn.prepareStatement(
							"update STUDENT.CARS set MIN_PRICE = ?, PRICE = ? where MANUFACTURER = ? and TYPE = ?")) {

				System.out.print("請輸入製造商:");
				String manu = scan.nextLine();
				System.out.println("請輸入類型:");
				String type = scan.nextLine();
				System.out.println("請輸入底價:");
				String minprice = scan.nextLine();
				System.out.println("請輸入售價:");
				String price = scan.nextLine();

				pstmt.setString(1, minprice);
				pstmt.setString(2, price);
				pstmt.setString(3, manu);
				pstmt.setString(4, type);

				pstmt.executeUpdate();
				conn.commit(); 
				System.out.println("修改成功");
			} catch (Exception e) {
				conn.rollback();  //一旦出現例外，將資料庫回歸到交易前的原始狀態
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void doDelete() {
		try (Connection conn = DriverManager.getConnection(CONN_URL, "student", "student123456")) {
			conn.setAutoCommit(false);
			try (Scanner scan = new Scanner(System.in);
					PreparedStatement pstmt = conn
							.prepareStatement("delete from STUDENT.CARS where MANUFACTURER = ? and TYPE = ?")) {

				System.out.print("請輸入製造商:");
				String manu = scan.nextLine();
				System.out.println("請輸入類型:");
				String type = scan.nextLine();

				pstmt.setString(1, manu);
				pstmt.setString(2, type);

				pstmt.executeUpdate();
				conn.commit(); 
				System.out.println("刪除成功");
			} catch (Exception e) {
				conn.rollback();  // 一旦出現例外，將資料庫回歸到交易前的原始狀態
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}