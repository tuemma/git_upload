package com.cathaybk.javaedu.lesson2.practice.practice1;

public class Ocean {

    public static void main(String[] args) {
        Swimmer swimPlayer = new SwimPlayer("菲爾普斯");
        Seaplane seaplane = new Seaplane("海空一號");
        Flyer helicopter = new Helicopter("阿帕契");
        doSwim(swimPlayer);
        doSwim(seaplane);
        doFly(seaplane);
        doFly(helicopter);
    }

    public static void doSwim(Swimmer swimmer) {  //呼叫swim()方法
        swimmer.swim();
    }

    public static void doFly(Flyer flyer) {  //呼叫fly()方法
        flyer.fly();
    }

}
