package com.code.test;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by hejiaxu on 2021/2/25
 */
public class CopyOnWriteArrayTest {
    public static void main(String[] args) {
        CopyOnWriteArrayList arrayList = new CopyOnWriteArrayList();
        arrayList.add("b");
        arrayList.add("b");

        arrayList.forEach(

                a -> {
                    arrayList.add("a");
                    System.out.println(a);
                }
        );
        arrayList.forEach(

                a -> {
                    arrayList.add("a");
                    System.out.println(a);
                }
        );
    }
}
