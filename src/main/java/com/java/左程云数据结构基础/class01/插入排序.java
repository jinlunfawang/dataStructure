package com.java.左程云数据结构基础.class01;

import org.junit.Test;

import java.util.Arrays;

/**
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2021/9/12 21:45
 */
public class 插入排序 {
    @Test
    public void test() {
        long maxTime = 100L;
        int maxLength = 1;
        // 1.生成最大长度为maxLength的数组
        boolean falg = true;
        // 2.排序 maxTime次
        for (int i = 0; i < maxTime; i++) {
            int[] arr1 = checkMachine.arrGen(maxLength);
            int[] arr2 = checkMachine.arrCopy(arr1);
            insertSort2(arr1);
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
     * 插入排序: 将待排序的数挨个和他前面的数比较 一直到合适的位置为止。
     * 待排序的数比他前面的数小就交换,交换后还小再交换 一直到不小或者前面没数了为止
     * 0-1 范围有序 :
     * 0-2 范围有序:
     * 0-3 范围有序:
     * 复杂度 O(n^2)
     * @param arr
     */

    private void insertSort(int[] arr) {
        if (arr.length < 2 || arr == null) return;
        // 1 第一for循环 找出待比较的数
        for (int i = 1; i < arr.length; i++) {
            // 2 第二个for 依次比较两个数并且向前移动
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    checkMachine.swap(arr, j, j - 1);
                }
            }
        }

    }

    private void insertSort2(int[] arr) {

        if(arr==null||arr.length<2) return;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j >0; j--) {
                if(arr[j-1]>arr[j])
                 checkMachine.swap(arr,j,j-1);
            }

        }

    }


}
