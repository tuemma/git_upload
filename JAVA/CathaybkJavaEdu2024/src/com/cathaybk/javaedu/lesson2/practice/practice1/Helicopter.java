package com.cathaybk.javaedu.lesson2.practice.practice1;

public class Helicopter extends Airplane {

    public String name;

    public Helicopter(String name) {
        this.name = name;
    }

    
    /*fly() 方法是從 Airplane 類別中繼承而來的
     * Airplane 類別可能定義了 fly() 方法
     * 而 Helicopter 類別則對其進行了覆寫*/
    @Override
    public void fly() {
        System.out.println(name + " 垂直起飛");
    }

}
