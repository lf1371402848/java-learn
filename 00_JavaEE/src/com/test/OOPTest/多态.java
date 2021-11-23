package com.test.OOPTest;

/**
 * @Description: TODO
 * @Author: lf
 * @Date: 2021/9/3 1:04
 * @Version: 1.0
 */
public class 多态 {
    public static void main(String[] args) {
        Father1 father1 = new Son1();
        System.out.println(father1);
        //System.out.println(father1.smile);
        System.out.println(father1.bear);
        father1.walk();
        father1.joke();
        //father1.play();
        System.out.println("---------------------");
        Son1 son1 = (Son1) father1;
        System.out.println(son1.bear);
        System.out.println(son1.smile);
        son1.walk();
        son1.joke();
        son1.play();
    }
}

class Father1 {
    String name = "father";
    String bear = "bear";
    int age;

    public void walk() {
        System.out.println("Father的普通方法1");
    }
    public void joke() {
        System.out.println("Father的普通方法2");
    }
}

class Son1 extends Father1 {
    String name = "son";
    String smile = "smile";
    int age;

    @Override
    public void walk() {
        System.out.println("Son的普通方法1");
    }

    public void play() {
        System.out.println("Son的普通方法2");
    }
}