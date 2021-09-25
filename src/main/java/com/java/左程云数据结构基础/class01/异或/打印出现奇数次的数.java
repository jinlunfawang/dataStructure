package com.java.左程云数据结构基础.class01.异或;

/**
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2021/9/25 19:55
 * 题目:一个数组中有一种数出现了奇数次
 * 其他都出现偶数次 打印出现奇数次的数
 */
public class 打印出现奇数次的数 {

    public static void main(String[] args) {
        int oddNumber = findOddNumer(new int[]{1, 1,2, 2, 2, 2, 3});
        System.out.println(oddNumber);
    }


    private static int findOddNumer(int[] arr) {
        int oddNumber=0;
        for (int i = 0; i < arr.length; i++) {
            oddNumber = oddNumber ^ arr[i];
        }
        return oddNumber;
    }
}
