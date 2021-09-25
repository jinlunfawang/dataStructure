package com.java.test;

/**
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2021/9/12 9:26
 */
public class 测试带符号右移和不带符号右移 {

    public static void main(String[] args) {
        int a=1<<1;
        int c =(a>>1)|1 ;
        System.out.println(a);
    }
}
