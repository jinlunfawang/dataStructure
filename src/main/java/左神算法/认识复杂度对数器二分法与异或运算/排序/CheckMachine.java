package 左神算法.认识复杂度对数器二分法与异或运算.排序;

/**
 * 对数器
 *
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2021/9/12 21:03
 */
public class CheckMachine {

    /**
     * 交换两个位置
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int arr[], int i, int j) {
        // 异或不可以交换同一个位置上
        if (i == j) return;
        // 异或实现交换
        /**
         * 1.异或就是无进位相加
         * 2.异或满足交换律
         * 3.N^N=0 0^N=N
         *  注意不可以交换同一个位置上的数 如果是同一个位置那么就是0
         */
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];

    }

    /**
     * 生成随机数组
     *
     * @param maxLength
     * @return
     */
    public static int[] arrGen(int maxLength) {
        if (maxLength < 1) return null;
        //1. 随机长度的数组
        // maxLength+1 为了防止maxLength=1 的时候 数组为空
        int[] arr1 = new int[(int) (Math.random() * (maxLength + 1))];
        for (int i = 0; i < arr1.length; i++) {
            // 为了让出现负数
            arr1[i] = (int) (Math.random() * maxLength - Math.random() * maxLength);
        }
        return arr1;
    }



    /**
     * 打印数组
     *
     * @param arr1
     */
    public static void arrPrint(int[] arr1) {
        if (arr1 == null || arr1.length == 0) return;
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");

        }
    }



    /**
     * 判断两个数组是否相等
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean arrEquals(int[] arr1, int[] arr2) {
        //1 长度相等
        if (arr1.length != arr1.length) return false;
        // 2 值相等

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                System.out.println();
                return false;
            } ;
        }
        return true;
    }

    /**
     * 复制数组
     *
     * @param arr1
     * @return
     */
    public static int[] arrCopy(int[] arr1) {
        if (arr1 != null && arr1.length >= 0) {
            int[] arr = new int[arr1.length];
            for (int i = 0; i < arr1.length; i++) {
                arr[i] = arr1[i];

            }
            return arr;
        }
        throw new IllegalArgumentException("数组不可以为空");
    }

}
