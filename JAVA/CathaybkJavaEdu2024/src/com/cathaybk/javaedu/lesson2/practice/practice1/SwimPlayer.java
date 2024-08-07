package com.cathaybk.javaedu.lesson2.practice.practice1;

//SwimPlayer 類別必須實作 Swimmer 介面中定義的所有方法
public class SwimPlayer implements Swimmer {  
	
	public String name;  //一個公開(public)的實例變數，用來存儲選手的名字

    //建構子
    public SwimPlayer(String name) {
        this.name = name;
    }

    
    /*swim() 方法是從 Swimmer 介面中繼承而來的
     * Swimmer 介面定義了 swim() 方法
     * SwimPlayer 類別實作了這個方法*/
    @Override
    public void swim() {
        System.out.println(name + " 游泳");
    }

}
