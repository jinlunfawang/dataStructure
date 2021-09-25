package com.java.左程云数据结构基础.class01;

import java.util.Arrays;

/**
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2021/9/25 15:30
 * <p>
 * 方法1 依次遍历 如果要查找的值在最右边  那情况就不容乐观时间复杂度为O(n)。
 * 方法2 二分法 前提保证数组不为空 有序
 * 比如查找7这个数
 * 先判断首位置<7 未位置 >7
 * 找一半的位置(mid=) 如果大于7 向左再取一半 小于7 向右取一半 如此循环  直到找到7或者找到最后一个位置紧挨的两个位置
 * 时间复杂度为O（logN）
 */
public class 判断有序数组中是否存在某个值 {


    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 5, 2, 45, 5, 3434, 43, 2, 4};

        System.out.println(binaryFind2(arr, 45));
    }

    /**
     * 自己写 未优化
     * 感觉有点繁琐
     *
     * @param arr
     * @param ele
     * @return
     */
    private static boolean binaryFind(int[] arr, int ele) {
        if (arr == null) return false;
        Arrays.sort(arr);

        if (arr[0] == ele || arr[arr.length - 1] == ele) return true;

        if (arr[0] < ele && arr[arr.length - 1] > ele) {
            int r = arr.length - 1;
            int l = 0;
            // 为了避免死循环 比如 l=2 r=3     l=(l+r)/2=2 一直会这样循环的
            while ((l + 1) < r) {
                if (arr[(l + r) >> 1] == ele) return true;
                else if (arr[(l + r) >> 1] > ele) {
                    r = (l + r) >> 1;
                } else {
                    l = (l + r) >> 1;
                }
            }
        }
        return false;
    }


    /**
     * 优化后:
     *
     * @param arr
     * @param ele
     * @return
     */
    private static boolean binaryFind2(int[] arr, int ele) {

        if (arr == null || arr.length == 0) return false;
        Arrays.sort(arr);
        if (arr[0] == ele || arr[arr.length - 1] == ele) return true;

        if (arr[0] < ele && arr[arr.length - 1] > ele) {
            int left = 0;
            int right = arr.length - 1;
            int mid;
            while (left < right) {
                mid =(right + left) >> 1;
                if (arr[mid] == ele) return true;
                else if (arr[mid] > ele) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }

        }
        return false;
    }
}
