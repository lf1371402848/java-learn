package com.test.OOPTest;

/**
 * @Description: TODO
 * @Author: lf
 * @Date: 2021/9/3 1:04
 * @Version: 1.0
 */
public class 对象初始化顺序 {
    public static void main(String[] args) {
        Son son = new Son();
    }
}

class Father {
    private static String name;
    private static String bear;
    private int age;

    static {
        System.out.println("Father的静态匿名代码块");
    }

    {
        System.out.println("Father的匿名代码块");
    }

    public Father() {
        System.out.println("Father的无参构造器");
    }

    public static void makeMoney() {
        System.out.println("Father的静态方法");
    }

    public void walk() {
        System.out.println("Father的普通方法");
    }
}

class Son extends Father {
    private static String name;
    private int age;

    static {
        System.out.println("Son的静态匿名代码块");
    }

    {
        System.out.println("Son的匿名代码块");
    }

    public Son() {
        System.out.println("Son的无参构造器");
    }

    public static void play() {
        System.out.println("Son的静态方法");
    }

    public void walk() {
        System.out.println("Son的普通方法");
    }
}