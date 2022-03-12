package 左神算法.认识复杂度对数器二分法与异或运算;

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
 * 找一半的位置(mid=(left+right)/2) 判断该位置是否等于7
 * 如果大于7 r=mid-1
 * 如果小于7 l=mid+1
 * 如此循环 直到找到7
 * 时间复杂度为:O(logN)
 * 这时间复杂度是怎么来的?
 *     查找次数=2^N=数组的长度   n=LOG2(N) 在算法中 LOG2(N)的简写是logN
 */
public class 判断有序数组中是否存在某个值 {


    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 5, 0, 45, 5, 3434, 43, 2, 4};

        System.out.println(binaryFind(arr, 0));
    }

    /**
     * @param arr
     * @param ele
     * @return
     */
    private static boolean binaryFind(int[] arr, int ele) {
        // 排除异常情况
        if (arr == null||arr.length == 0) return false;
        Arrays.sort(arr);
        if (arr[0] <= ele && arr[arr.length - 1] >= ele) {
            int r = arr.length - 1;
            int l = 0;
            int mid;
            while (l < r) {
                mid = (l + r) >> 1;
                if (arr[mid] == ele) return true;
                else if (arr[mid] > ele) {
                    // 重点理解 因为需要排除mid的位置
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return arr[r] == ele;
        }
        return false;
    }

}