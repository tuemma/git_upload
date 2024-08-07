package com.cathaybk.javaedu.lesson3.practice;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cathaybk.javaedu.lesson3.jdbc.PreparedStatementDemo;

import oracle.jdbc.internal.ResultSetCache;

public class QueryByManufacturer {

	public static void main(String[] args) {

		String connUrl = "jdbc:oracle:thin:@//localhost:1521/XE";

		try (Connection conn = DriverManager.getConnection(connUrl, "student", "student123456");
				PreparedStatement pstmt = conn.prepareStatement("select * from STUDENT.CARS where MANUFACTURER = ?");) {

			pstmt.setString(1, "Toyota");

			ResultSet rs = pstmt.executeQuery();

			List<Map<String, String>> listmap = new ArrayList<>();
			
			while (rs.next()) {
				Map<String, String> map = new HashMap<>();   //Map 要在迴圈裡!! 才會有不同的記憶體空間
				map.put("MANUFACTURER", rs.getString("MANUFACTURER"));
				map.put("TYPE", rs.getString("TYPE"));
				map.put("MIN_PRICE", rs.getString("MIN_PRICE"));
				map.put("PRICE", rs.getString("PRICE"));
//				System.err.println(map);
				listmap.add(map);
//				System.out.println(listmap);
			}

			for (Map<String, String> map2 : listmap) {
//				System.out.println(map2);

				StringBuilder sb = new StringBuilder();
				BigDecimal price = new BigDecimal(map2.get("PRICE"));
				BigDecimal minprice = new BigDecimal(map2.get("MIN_PRICE"));
//				listmap.get(0).get("MANUFACTURER");
				
				if (!map2.isEmpty()) {
					sb.append("製造商:").append(map2.get("MANUFACTURER"))
					.append(" 型號:").append(map2.get("TYPE"))
					.append(" 售價:").append(map2.get("MIN_PRICE"))
					.append(" 底價:").append(map2.get("PRICE"))
					.append(" 售價高於底價:").append(price.subtract(minprice));

				} else {
					sb.append("查無結果");

				}
				System.out.println(sb.toString());
			}

			rs.close();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
}