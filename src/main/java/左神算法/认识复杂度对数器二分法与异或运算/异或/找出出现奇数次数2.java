package 左神算法.认识复杂度对数器二分法与异或运算.异或;

/**
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2021/9/25 20:18
 * 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这两种数
 * 思路:
 * 假设这两种数为 a b
 * 每个数异或之后 最终的结果为 a^b 且不等于0
 * 既然不等于0 , 提取出最右侧的1(假设这个1在第八位), 那么这个1 一定可以把所有的数分为两类
 * 第八位为1 和第八位不为1 且a和b一定是分开的
 * 第八位为1的异或那么剩下的为a     a^a^b=b
 */
public class 找出出现奇数次数2 {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2, 2, 2, 2, 2, 4, 5, 5};
        int[] ints = twoOdds(arr1);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
    private static int[] twoOdds(int[] arr) {
        // 存储a^b的结果
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result ^= arr[i];
        }
        // 提取出最右侧的1
        // 怎么提: 取反+1 再与运算
        int rightOne = result & (~result + 1);
        int a = 0;
        for (int i = 0; i < arr.length; i++) {
            // 将最右是1 和不是1的分开
            if ((arr[i] & rightOne) != 0) {
                a ^= arr[i];
            }
        }
        return new int[]{a, a ^ result};

    }
}
