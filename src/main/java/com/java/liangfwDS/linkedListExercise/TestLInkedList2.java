package com.java.liangfwDS.linkedListExercise;

import com.java.liangfwDS.linkedlist.SingleLinkedList;
import org.junit.Test;

/**
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2021/4/19 17:37
 */
public class TestLInkedList2 {

    @Test
    public void testList2() {
    LinkedList<Integer> list = new LinkedList<>();
        SingleLinkedList<Object> list1 = new SingleLinkedList<>();

        list.add(20);
       list.add(0,10);
        list.add(44);
        list.add(list.size,40);
        System.out.println(list.toString());
  /*      list.remove(1);
        System.out.println(list.toString());*/

    }
}
