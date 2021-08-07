package com.java.liangfwDS.array;

import org.junit.Test;


/**
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2021/4/15 10:01
 */
public class TestDynamicArray {
    @Test
    public void test1() {
        System.out.println(

        );
        DynamicArray<Person> dynamicArray = new DynamicArray();
        for (int i = 0; i < 20; i++) {
            dynamicArray.add(new Person(i));

        }

        DynamicArray<Integer> dynamicArray1 = new DynamicArray();
        for (int i = 0; i < 20; i++) {
            dynamicArray1.add(i);

        }

        System.out.println(dynamicArray.toString());
        System.out.println(dynamicArray1.toString());


    }
    @Test
    public void test2(){

        DynamicArray2<Integer> dynamicArray2 = new DynamicArray2<Integer>();
        for (int i = 0; i < 20; i++) {
            dynamicArray2.add(i);

        }
        System.out.println(dynamicArray2.toString());
        boolean contains = dynamicArray2.contains(213);

        System.out.println(contains);
        //  dynamicArray2sout.add(19,2000);
        System.out.println(dynamicArray2.get(19));
       // System.out.println(dynamicArray2.toString());

    }
}
