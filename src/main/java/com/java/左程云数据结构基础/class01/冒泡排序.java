package com.java.左程云数据结构基础.class01;


import org.junit.Test;

import java.util.Arrays;

/**
 *
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2021/9/12 20:50
 */
public class 冒泡排序 {
    @Test
    public void test() {
      long maxTime = 10990000L;
        int maxLength = 22;
        // 1.生成最大长度为maxLength的数组
        boolean falg = true;
        // 2.排序 maxTime次
        for (int i = 0; i < maxTime; i++) {
            int[] arr1 = checkMachine.arrGen(maxLength);
            int[] arr2 = checkMachine.arrCopy(arr1);
            bubblingSort(arr1);
            Arrays.sort(arr2);
            // 3 看排的对不对 和自带的数组排序比较 有一次不对 直接跳出循环
            if (!checkMachine.arrEquals(arr1, arr2)) {
                falg = false;
                checkMachine.arrPrint(arr1);
                break;
            }
        }

        System.out.println(falg ? "nice" : "fuck fucking");

    }

    /**
     * 冒泡排序：数组数值从前往后,两两依次比较, 前者大于后者交换,否则向前移动一位置,
     * 每次可将待排序的中最大值挑出来放到末尾。
     * 时间复杂度为O(n^2)
     *
     * @param arr
     */
    private static void bubblingSort(int[] arr) {

        if (arr.length <2 || arr == null) return;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i ; j++) {
                if ( arr[j] > arr[j + 1] )
                    checkMachine.swap(arr, j, j + 1);
            }

        }


    }

}
