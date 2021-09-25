package com.java.左程云数据结构基础.class01;

/**
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2021/9/12 16:42
 */
public class 异或交换两值
{
    /**
     * 如何不使用额外的值交换两个值呢
     * @param args
     */
    public static void main(String[] args) {
        int a=5;
        int b=5;
         a=a^b;
         b=a^b;
         a=a^b;
        System.out.println(a);
        System.out.println(b);


    }
}
