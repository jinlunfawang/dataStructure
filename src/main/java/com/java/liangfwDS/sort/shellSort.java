package com.java.liangfwDS.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 希尔排序
 *
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2020/9/11 15:23
 */
public class shellSort {


    @Test
    public void test1() {
        int[] arr = new int[20000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 20000000 + 1);

        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("开始时间为" + format);
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
// 从第gap 个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
//移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
//当退出while 后，就给temp 找到插入的位置
                    arr[j] = temp;
                }
            }


        }

        Date endDate = new Date();
        String format1 = simpleDateFormat.format(endDate);
        System.out.println("结束时间为" + format1);
        for (int i = 0; i < 50; i++) {
            System.out.println(arr[i]);
        }


    }
}
