package 左神算法.认识复杂度对数器二分法与异或运算.排序;


import org.junit.Test;

import java.util.Arrays;

/**
 *
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2021/9/12 20:50
 *
 *
 */
public class 冒泡排序 {
    @Test
    public void test() {
      long maxTime = 100L;
        int maxLength = 50000;
        // 1.生成最大长度为maxLength的数组
        boolean falg = true;
        long beginTime = System.currentTimeMillis();
        // 2.排序 maxTime次
        for (int i = 0; i < maxTime; i++) {
            int[] arr1 = CheckMachine.arrGen(maxLength);
            int[] arr2 = CheckMachine.arrCopy(arr1);
            bubblingSort(arr1);

            Arrays.sort(arr2);
            // 3 看排的对不对 和自带的数组排序比较 有一次不对 直接跳出循环
            if (!CheckMachine.arrEquals(arr1, arr2)) {
                falg = false;
                CheckMachine.arrPrint(arr1);
                break;
            }
        }
      long endTime=System.currentTimeMillis();
        System.out.println(endTime-beginTime);
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
                    CheckMachine.swap(arr, j, j + 1);
            }

        }
    }


}
