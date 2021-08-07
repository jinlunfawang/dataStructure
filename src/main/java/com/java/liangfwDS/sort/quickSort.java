package com.java.liangfwDS.sort;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 快速排序
 *
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2020/9/11 15:23
 */
public class quickSort {
    // 对left 和right之间排序
    public  void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        // 返回首值的真正位置 10 保证10位置左边都小于arr[10] 右边都大于arr[10]
        int mid = partiton(arr, left, right);
        //左边排序
        quickSort(arr, left, mid - 1);
        // 对右边排序
        quickSort(arr, mid +1, right);
    }

    public  int partiton(int[] array, int i, int j) {

        int key = array[i];// 用左边的数字为基准数
        while (i < j) {
            //因为默认基准是从左边开始，所以从右边开始比较
            //当队尾的元素大于等于基准数据 时,就一直向前挪动 j 指针
            while (i < j && array[j] >= key) {
                j--;
            }
            //当找到比 array[i] 小的时，就把后面的值 array[j] 赋给它
            if (i < j) {
                array[i] = array[j];
            }
            //当队首元素小于等于基准数据 时,就一直向后挪动 i 指针
            while (i < j && array[i] <= key) {
                i++;
            }
            //当找到比 array[j] 大的时，就把前面的值 array[i] 赋给它
            if (i < j) {
                array[j] = array[i];
            }
        }
        //跳出循环时 i 和 j 相等,此时的 i 或 j 就是 key 的正确索引位置
        //把基准数据赋给正确位置
        array[i] = key;
        return i;
    }


    @Test
    public void test1() {
        int[] arr = new int[2000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 2000000 + 1);

        }
      //  int[] arr = {34,4,61,2,4,55};
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("开始时间为" + format);
        //swap(arr,0,1);
        quickSort(arr,0,arr.length-1);
        Date endDate = new Date();
        String format1 = simpleDateFormat.format(endDate);
        System.out.println("结束时间为" + format1);
        for (int i = 0; i < 50; i++) {
            System.out.println(arr[i]);
        }


    }

    public void quicksort2(int[] arr,int left,int right){
        if(left>=right)return;

        int standLocation=getStandLocation(arr, left ,right);
        quicksort2(arr,left,standLocation-1);
        quicksort2(arr,standLocation+1,right);

    }

    private int getStandLocation(int[] arr, int left, int right) {

        int standValue=arr[left];
        while(left<right){

            while(left<right&& standValue<=arr[right]){
                right--;
            }
            if(left<right){
                arr[left]=arr[right];
            }

            while (left<right&&standValue>=arr[left]){
                left++;
            }
            if(left<right){
                arr[right]=arr[left];
            }


        }
        arr[right]=standValue;

        return right;
    }


}
