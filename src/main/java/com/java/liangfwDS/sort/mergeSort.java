package com.java.liangfwDS.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 归并排序
 *
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2020/9/12 10:39
 */
public class mergeSort {

    @Test
    public void test1() {
        int[] arr = new int[50];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 50 + 1);

        }
        //  int[] arr = {34,4,61,2,4,55};
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("开始时间为" + format);
        //swap(arr,0,1);
        mergeSort1(arr, 0, arr.length - 1);
        Date endDate = new Date();
        String format1 = simpleDateFormat.format(endDate);
        System.out.println("结束时间为" + format1);
        for (int i = 0; i < 20; i++) {
            System.out.println(arr[i]);
        }

    }


    private void mergeSort(int[] array, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) >> 1;
        // 对左边排序
        mergeSort(array, left, mid);
        // 对右边排序
        mergeSort(array, mid + 1, right);
        // 合并
        merge(array, left, mid, right);

    }

    // 治

    private void merge(int[] array, int left, int mid, int right) {
        // 临时数组的大小
        int[] temp = new int[right - left + 1];
        // 第一个数组的开始索引
        // 第二个数组的开始索引
        // temp 数组已经填入数组的个数
        int i = left, j = mid + 1, k = 0;
        // 两个数组有序 和合并办法 三段式
        // 保证i没有循环完 j没有 循环完
        while (i <= mid && j <= right) {
            // 将较小者放到topk中
            temp[k++] = array[i] <= array[j] ? array[i++] : array[j++];
        }
        while (i <= mid) temp[k++] = array[i++];
        while (j <= right) temp[k++] = array[j++];
        for (int p = 0; p < temp.length; p++) {
            array[left + p] = temp[p];
        }


    }

    private void mergeSort1(int[] array, int left, int right) {
        // 分
        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge1(array, left, mid, right);

    }

    // 治  两个数组进行合并
    private void merge1(int[] array, int left, int mid, int right) {
        int[] tem = new int[right - left + 1];
        // 左边数组的开始索引
        int l = left;
        //右边数组的开始索引
        int m = mid + 1;
        int k = 0;

        while (l <= mid && m <= right) {
            tem[k++] = array[l++]<=array[m++]?array[l++]:array[m++];
        }
         // 右边的都方完了
        while(l<mid) tem[k++]=array[l++];
        // 左边的房完了
        while (m<right) tem[k++]=array[m++];


    }

}