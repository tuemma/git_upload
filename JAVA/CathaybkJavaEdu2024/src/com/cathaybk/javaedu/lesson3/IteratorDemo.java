package com.cathaybk.javaedu.lesson3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        Iterator<String> iter = list.iterator();
        //list.iterator() 返回一個 Iterator 物件，用於遍歷 list 中的元素
        
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

}
