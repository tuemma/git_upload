package com.cathaybk.practice.nt01900432.b;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class outputHRmain {

	public static void main(String[] args) {

		String filePath = "C:\\Users\\Admin\\Desktop\\output.csv";

		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Sales("張志城", "信用卡部", 35000, 6000));
		employeeList.add(new Sales("林大鈞", "保代步", 38000, 4000));
		employeeList.add(new Supervisor("李中白", "資訊部", 65000));
		employeeList.add(new Supervisor("林小中", "理財部", 80000));

		try (BufferedWriter bufw = new BufferedWriter(new FileWriter(filePath, StandardCharsets.UTF_8))) {
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < employeeList.size(); i++) {
				
				Employee employee = employeeList.get(i);
				
				if (employee instanceof Sales) {
					Sales tranSale = (Sales) employee;
					sb.append(tranSale.getName()).append(",").append(tranSale.getPayment());

				} else {
					sb.append(employee.getName()).append(",").append(employee.getSalary());
				}

				bufw.write(sb.toString());
				sb.setLength(0);
				bufw.newLine();

			}

		} catch (IOException e) {
			e.printStackTrace();

		}

	}

}
