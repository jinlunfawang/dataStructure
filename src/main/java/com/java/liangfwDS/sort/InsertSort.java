package com.java.liangfwDS.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


/**
 * 插入排序
 *
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2020/9/11 15:23
 */
public class InsertSort {
    /**
     * 逐步推导
     */
    @Test
    public void test1() {

        int[] arr = new int[200000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=(int)(Math.random()*200000+1);

        }
        // 待插入数的个数
        for (int i = 1; i < arr.length; i++) {
            int insetVal = arr[i];
            // arr[1]的前面这个数的下标
            int insertIndex = i - 1;
            // 给insertVal找到位置
            while (insertIndex >= 0 && insetVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insetVal;
        }


    }

    /**
     * 测试速度
     * 20w 4s
     */
    @Test
    public void test2() {
        int[] arr = new int[200000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=(int)(Math.random()*200000+1);

        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("开始时间为" + format);
        // 待插入数的个数
        for (int i = 1; i < arr.length; i++) {
            // 待插入的数
            int insertVal = arr[i];
            // 待插入的位置
            int insertIndex = i - 1;
            //待插入的数小于于arr[index] 将arr[index] 向后移动
            while (insertIndex >= 0 && arr[insertIndex] > insertVal) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            // 否则
            arr[insertIndex + 1] = insertVal;

        }

        Date endDate = new Date();
        String format1 = simpleDateFormat.format(endDate);
        System.out.println("结束时间为" + format1);
        for (int i = 0; i < 50; i++) {
            System.out.println(arr[i]);
        }

    }

    /**
     * 自己练习
     */
    @Test
    public void test3() {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=(int)(Math.random()*20+1);
        }
        // 待插入数的个数
        for (int i = 1; i < arr.length; i++) {
            int insertIndex=i-1;
            int insertValue=arr[i];

            // 两两比较 有序的大数字 后移
             while (insertIndex>=0&&insertValue<arr[insertIndex]){
               arr[insertIndex+1]=arr[insertIndex];
               insertIndex--;
             }
             // 如果有
            arr[insertIndex+1]=insertValue;
        }

        System.out.println(Arrays.toString(arr));

    }

}
