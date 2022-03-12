package 左神算法.认识复杂度对数器二分法与异或运算.异或;

/**
 *
 *
 * 什么是异或 :无进位相加！
 *
 *异或运算的性质
 *
 * 0^N == N      N^N == 0
 * 异或运算满足交换律和结合率
 *
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2021/9/12 16:42
 */
public class 异或运算01_不需要额外变量交换两值
{
    /**
     * 如何不使用额外的值交换两个值呢
     * @param args
     */
    public static void main(String[] args) {
        int a=5;
        int b=10;
         a=a^b;
         b=a^b;
         a=a^b;
        System.out.println(a);
        System.out.println(b);

    }
}
