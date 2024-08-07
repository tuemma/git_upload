package com.cathaybk.javaedu.lesson3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestComparable {

    public static void main(String[] args) {
        
//        List<String> list1 = new ArrayList<>();
//        list1.add("aA");
//        list1.add("AA");
//        list1.add("bA");
//        list1.add("BA");
//        System.out.println("排序前：" + list1);
//        Collections.sort(list1);
//        System.out.println("排序後：" + list1);
//        System.out.println("-------------------");
         
    	
        List<Person> list = new ArrayList<>();
        list.add(new Person("Mary", 25, "B Dept"));
        list.add(new Person("Peter", 29, "A Dept"));
        list.add(new Person("John", 27, "a Dept"));

        System.out.println("排序前：" + list);
        // 使用Collections.sort(List<T>); T需實作Comparable
        
        /*
        Collections.sort(list);
        System.out.println("排序後：" + list);
        */
        
        // 實作Comparator介面
        /*這段程式碼使用了匿名內部類別來實現 Comparator 介面，
         * 根據Dept進行升序排序。
         * 注意 compareTo 方法會考慮字母大小寫，"A Dept" 會排在 "B Dept" 之前。*/
        Collections.sort(list, new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {  // compare（）：　Comparator介面 的方法
                return o1.getDept().compareTo( o2.getDept() );  // compareTo（） :　Comparable介面的方法
            }

        });
        System.out.println("排序後：" + list);
        
        // 使用selfComparator自定義 實作Comparator介面的類別
        Collections.sort(list, new selfComparator());
        System.out.println("排序後：" + list);
    }

}

class selfComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();  //根據Age進行升序排序
    }

}
