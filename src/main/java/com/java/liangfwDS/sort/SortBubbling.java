package com.java.liangfwDS.sort;


import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 冒泡排序
 * <p>
 *
 */
public class SortBubbling {
    @Test
    /**
     *
     */
    public void test1() {
        //  int[] array = new int[]{55, 44, 5, 1, 66, 7, 4, 3, 6, 7, 8};

        int[] array = new int[200000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)( Math.random() * 200000 + 1);
        }
        int tem;
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("开始时间为" + format);
        //1 比较的趟数
        for (int i = 0; i < array.length - 1; i++) {
            // 2.每趟比较的次数
            for (int j = 0; j < array.length - 1; j++) {
                // 两个数互相比较
                if (array[j] > array[j + 1]) {
                    tem = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tem;
                }
            }
        }
        Date endDate = new Date();
        String format1 = simpleDateFormat.format(endDate);
        System.out.println("结束时间为" + format1);
    }

    /**
     * 优化1:每比较一趟  后面就有几个有序的最大数。 所以不用比较后面的数了
     *
     */
    @Test
    public void test2() {
        int[] array = new int[200000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)( Math.random() * 200000 + 1);
        }
        int tem;
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("开始时间为" + format);
        //1. 比较的趟数
        for (int i = 1; i < array.length - 1; i++) {
            // 2.每趟比较的次数
            for (int j = 0; j < array.length - i; j++) {
                //3.两个数互相比较
                if (array[j] > array[j + 1]) {
                    tem = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tem;
                }
            }
        }
        Date endDate = new Date();
        String format1 = simpleDateFormat.format(endDate);
        System.out.println("结束时间为" + format1);
        for (int i = 0; i <100 ; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * 优化2:
     * 1.每比较一趟  后面就有几个有序的最大数。 所以不用比较后面的数了
     * 2.在优化1的基础上 如果有一趟比较没有发生交换 说明有序了 不用再比较了
     *   20W  2min
     */

    @Test
    public void test3() {
        int[] array = new int[200000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)( Math.random() * 200000 + 1);
        }
        int tem;
        Date date = new Date();
        boolean flag=false;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("开始时间为" + format);
        //1. 比较的趟数
        for (int i = 1; i < array.length - 1; i++) {
            // 2.每比较一次就有几个最大数在后面  后面就有几个有序的最大数
            for (int j = 0; j < array.length - i; j++) {
                //3.两个数互相比较
                if (array[j] > array[j + 1]) {
                    // 如果发生交互 就说明已经有序了不同比较了
                    flag=true;
                    tem = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tem;
                }

            }
 // 没发生交换 就说明已经有序了 跳出循环
            if(!flag){
                break;
            }
        }
        Date endDate = new Date();
        String format1 = simpleDateFormat.format(endDate);
        System.out.println("结束时间为" + format1);
        for (int i = 0; i <100 ; i++) {
            System.out.println(array[i]);
        }
    }

}
