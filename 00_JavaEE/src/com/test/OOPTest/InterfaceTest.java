package com.test.OOPTest;

/**
 * @Description: TODO
 * @Author: lf
 * @Date: 2021/9/4 0:45
 * @Version: 1.0
 */
public interface InterfaceTest {
    static void play1() {
        System.out.println("jdk8新特性");
    }

    default void play2() {
        System.out.println("jdk8新特性");
    }
}
