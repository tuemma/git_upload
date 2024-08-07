package com.cathaybk.javaedu.lesson3;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
        
        Set<Student> students = new HashSet<>();
        students.add(new Student("Justin", "B835031"));
        students.add(new Student("Monica", "B835032"));
        students.add(new Student("Justin", "B835031"));
        System.out.println(students);
        
        /* calss Student
        @Override
        public String toString() {
            return "Student [name=" + name + ", number=" + number + "]";
        }*/

        Set<String> strSet = new HashSet<>();
        strSet.add("1");
        strSet.add(new String("1"));
        strSet.add(new String("1"));
        System.out.println(strSet);
        /*在 Java 中，String 類重寫了 equals 和 hashCode 方法
         * 因此 new String("1") 與 "1" 被視為相同。*/

        //比較字符串
        System.out.println("1".equals(new String("1")));
        System.out.println(new String("1").equals(new String("1")));
    }
}
