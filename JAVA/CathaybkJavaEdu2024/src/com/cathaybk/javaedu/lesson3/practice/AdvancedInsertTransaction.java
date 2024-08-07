package com.cathaybk.javaedu.lesson3.practice;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

import com.cathaybk.javaedu.lesson3.jdbc.PreparedStatementDemo;

public class AdvancedInsertTransaction {

	public static final String INSERT_CARS_SQL = "insert into STUDENT.CARS (MANUFACTURER, TYPE, MIN_PRICE, PRICE) values (?, ?, ?, ?)";

	public static final String CONN_URL = "jdbc:oracle:thin:@//localhost:1521/XE";

	public static final String USER = "student";

	public static final String PASSWORD = "student123456";

	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection(CONN_URL, USER, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT_CARS_SQL);) {
			
			Random random = new Random();
			conn.setAutoCommit(false);
			
			for(int i  = 0; i < 2; i++) {
				
				pstmt.setString(1,"00000");
				pstmt.setString(2,"00000"+ i);
				pstmt.setInt(3,random.nextInt(1000)+1);
				pstmt.setInt(4,random.nextInt(1000)+1);
				
			}

			
		}
		catch(Exception e){
			e.printStackTrace();
		}
            

}
}