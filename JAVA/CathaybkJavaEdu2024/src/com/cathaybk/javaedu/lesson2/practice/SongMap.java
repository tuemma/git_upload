package com.cathaybk.javaedu.lesson2.practice;

import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class SongMap {
	
	public static void main(String[] args) {
		Map<String, String> map= new TreeMap<>();
		map.put("Coldplay", "Yellow");
		map.put("Adele", "Skyfall");
		map.put("Lady Gaga", "Shallow");
		
		for(Entry<String, String> Entry : map.entrySet()) {
			System.out.println("Singer : "+ Entry.getKey()+", Song : "+Entry.getValue());
		}
		
		System.out.println(map.keySet());
		System.out.println(map.values());
			
	}
}
