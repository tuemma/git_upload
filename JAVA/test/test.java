package com.cathaybk.practice.nt01900432.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class test {

	 public static void main(String[] args) {
	        // 创建示例数据
	        List<Map<String, Object>> list = new ArrayList<>();
	        
	        Map<String, Object> item1 = new HashMap<>();
	        item1.put("category", "A");
	        item1.put("value", 10);
	        
	        Map<String, Object> item2 = new HashMap<>();
	        item2.put("category", "B");
	        item2.put("value", 20);
	        
	        Map<String, Object> item3 = new HashMap<>();
	        item3.put("category", "A");
	        item3.put("value", 30);
	        
	        Map<String, Object> item4 = new HashMap<>();
	        item4.put("category", "C");
	        item4.put("value", 40);
	        
	        list.add(item1);
	        list.add(item2);
	        list.add(item3);
	        list.add(item4);
	        
	        // 根据 "category" 字段的值进行分组
	        Map<String, List<Map<String, Object>>> groupedByCategory = list.stream()
	            .collect(Collectors.groupingBy(map -> (String) map.get("category")));
	        
	        // 打印分组结果
	        for (Map.Entry<String, List<Map<String, Object>>> entry : groupedByCategory.entrySet()) {
	            System.out.println("Category: " + entry.getKey());
	            for (Map<String, Object> map : entry.getValue()) {
	                System.out.println("  " + map);
	            }
	        }
	    }
}
