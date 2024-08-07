package com.cathaybk.javaedu.lesson3;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sets { //無順序 不可重複

    public static void main(String[] args) {

        Set<Integer> hs = new HashSet<>();
        hs.add(9);
        hs.add(8);
        hs.add(1);
        hs.add(6);
        hs.add(5);
        hs.add(8);  // 重複的元素會被忽略
        System.out.println(hs);  //注意：元素的順序是不可預測的

        Set<Integer> lhs = new LinkedHashSet<>();
        lhs.add(1);
        lhs.add(8);
        lhs.add(9);
        lhs.add(6);
        lhs.add(5);
        lhs.add(8);  // 重複的元素會被忽略
        System.out.println(lhs);

        Set<String> ts = new TreeSet<>();
        ts.add("Mary");
        ts.add("Ben");
        ts.add("John");
        System.out.println(ts);

    }

}
