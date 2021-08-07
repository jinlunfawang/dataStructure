package com.java.liangfwDS.linkedlist;

import org.junit.Test;

/**
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2021/4/19 16:01
 */
public class TestSingleLinkedList {


    @Test
    public void testList() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.add(20);
        list.add(0,10);
        list.add(30);
        list.add(list.size,40);
        System.out.println(list.toString());
        list.remove(1);
        list.rangeCheck(666);
        System.out.println(list.toString());

    }


    @Test
    public void testArrayTrim() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arrayList.add(i);
        }

        for (int i = 0; i < 100; i++) {
            arrayList.remove(0);
        }
    }
}
