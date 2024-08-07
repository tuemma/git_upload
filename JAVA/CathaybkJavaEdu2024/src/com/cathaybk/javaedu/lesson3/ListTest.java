package com.cathaybk.javaedu.lesson3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(/*預設空間*/);
        
//      自動封裝
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        System.out.println(list);
        System.out.println(list.get(0));  //get(引數):取第幾個元素
        System.out.println(list.size());  //size():取List長度

        doSort(list);
        System.out.println(list.size());
        System.out.println(list);

        List<Integer> list2 = new LinkedList<>();
        doSort(list2);
    }

    public static void doSort(List<Integer> list) {
        // doSomething;
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
    }

}
