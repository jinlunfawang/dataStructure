package 左神算法.认识复杂度对数器二分法与异或运算.排序;

import org.junit.Test;

import java.util.Arrays;

/**
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2021/9/12 17:44
 */
public class 选择排序 {
    /**
     * 对数器测试:
     * 什么是对数器:生成不同的测试数据 用来检测方法的正确性。
     * 在排序中对数器怎么生成:
     */
    @Test
    public void test1() {
        int maxTime = 100;
        int maxLength = 50000;
        // 1.生成最大长度为maxLength的数组
        boolean falg = true;
        long beginTime = System.currentTimeMillis();
        // 2.排序 maxTime次
        for (int i = 0; i < maxTime; i++) {
            int[] arr1 = CheckMachine.arrGen(maxLength);
            int[] arr2 = CheckMachine.arrCopy(arr1);
            selectSort2(arr1);

            Arrays.sort(arr2);

            // 3 看排的对不对 和自带的数组排序比较 有一次不对 直接跳出循环
            if (!CheckMachine.arrEquals(arr1, arr2)) {
                falg = false;
                CheckMachine.arrPrint(arr1);
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - beginTime);
        System.out.println(falg ? "nice" : "fuck fucking");

    }

    /**
     * 选择排序:
     * 数据元素以此比较,每次从未排序的元素中选择最小值的位置,然后交换最小位置的值和比较位置的值交换。
     *
     * @param arrs
     */
    private static void selectSort(int[] arrs) {
        // 1.数组长度为空或者是1 不排序直接返回
        if (arrs == null || arrs.length < 2) {
            return;
        }
        //2.数组不为空 
        for (int i = 0; i < arrs.length; i++) {
            int minIndex = i;
            // 找出最小值的位置
            for (int j = i + 1; j < arrs.length; j++) {
                minIndex = arrs[j] < arrs[minIndex] ? j : minIndex;
            }
            CheckMachine.swap(arrs, minIndex, i);

        }

    }


    private static void selectSort2(int[] arrs) {

        if (arrs == null || arrs.length <= 1) {
            return;
        }
        for (int i = 0; i < arrs.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arrs.length; j++) {
                minIndex = arrs[minIndex] < arrs[j] ? minIndex : j;

            }
            CheckMachine.swap(arrs, i, minIndex);

        }

    }


}
