package 左神算法.认识复杂度对数器二分法与异或运算;

/**
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2021/9/25 19:00
 * <p>
 * 在有序arr上，找满足>=value的最左位置
 * 例如 111222222223333333334444555
 * 查找小于等于2最左侧的位置 为 数组3的位置
 * 思路: 二分法
 * 二分 如果中间的位置>=value 记录第一个满足的位置index 且r=mid-1
 * 继续二分   中间位置=< value l=mid+1 继续二分 一直分到l=r的位置就是找到最左的位置
 */
public class 有序数组中找某个数最左侧的位置 {
    public static void main(String[] args) {
        int index = leftLocation(new int[]{1, 1, 2, 2, 2, 2, 2, 2}, 0);
        System.out.println(index);

    }

    /**
     * 查找小于等于value最左侧的位置
     *
     * @param arr
     * @param value
     * @return
     */


    private static int leftLocation(int[] arr, int value) {

        if (arr == null || arr.length == 0) throw new IllegalArgumentException("数组不能为空");
        int l = 0;
        int r = arr.length - 1;
        int index = -1;
        int mid;
        while (l <= r) {
            mid = (l + r) >> 1;
            if (arr[mid] >= value) {
                index = mid;
                r = mid - 1;

            } else {
                l = mid + 1;
            }
        }
        return index;

    }

}
