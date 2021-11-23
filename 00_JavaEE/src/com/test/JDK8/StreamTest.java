package com.test.JDK8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @Description: TODO
 * @Author: lf
 * @Date: 2021/9/5 23:47
 * @Version: 1.0
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("boy");
        list.add("girl");
        list.add("middle");
        for (Object o : list) {
            if (!"middle".equals(o)) {
                System.out.println(o);
            }
        }
        System.out.println("------------------------------");
        list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return !"middle".equals(s);
            }
        }).forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        System.out.println("------------------------------");
        list.stream().filter(s -> !"middle".equals(s)).forEach(s -> System.out.println(s));
        System.out.println("------------------------------");
        list.stream().filter(s -> !"middle".equals(s)).forEach(System.out::println);
    }
}
