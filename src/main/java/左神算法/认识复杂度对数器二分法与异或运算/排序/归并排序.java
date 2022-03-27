package 左神算法.认识复杂度对数器二分法与异或运算.排序;

import java.util.Arrays;

/**
 * -                   _ooOoo_
 * -                  o8888888o
 * -                  88" . "88
 * -                  (| -_- |)
 * -                   O\ = /O
 * -               ____/`---'\____
 * -             .   ' \\| |// `.
 * -              / \\||| : |||// \
 * -            / _||||| -:- |||||- \
 * -              | | \\\ - /// | |
 * -            | \_| ''\---/'' | |
 * -             \ .-\__ `-` ___/-. /
 * -          ___`. .' /--.--\ `. . __
 * -       ."" '< `.___\_<|>_/___.' >'"".
 * -      | | : `- \`.;`\ _ /`;.`/ - ` : | |
 * -        \ \ `-. \_ __\ /__ _/ .-` / /
 * ======`-.____`-.___\_____/___.-`____.-'======
 * .............................................
 * -          佛祖保佑             永无BUG
 *
 * @author :LiangFangWei
 * @description:归并排序
 * @date: 2022-03-15 22:14
 */


public class 归并排序 {
    /**
     * 归并 50个数 排序100次 耗时7S
     *
     * @param args
     */
    public static void main(String[] args) {
        long maxTime = 1L;
        int maxLength = 100000000;
        // 1.生成最大长度为maxLength的数组
        boolean falg = true;
        long beginTime = System.currentTimeMillis();
        // 2.排序 maxTime次
        for (int i = 0; i < maxTime; i++) {
            int[] arr1 = CheckMachine.arrGen(maxLength);
            int[] arr2 = CheckMachine.arrCopy(arr1);
            merge(arr1);

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


    public static void merge(int[] nums) {
        if (nums == null || nums.length <= 1) return;


        // 归并排序
        mergeSort(nums, 0, nums.length - 1);


    }

    public static void mergeSort(int[] nums, int L, int R) {

        if (L == R) {
            return;
        }

        int M = L + ((R - L) >> 1);
        mergeSort(nums, L, M);
        mergeSort(nums, M + 1, R);
        mergerArray(nums, L, M, R);

    }

    public static void mergerArray(int[] nums, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int pl = L;
        int pr = M + 1;
        int i = 0;
        while (pl <= M && pr <= R) {
            help[i++] = nums[pl] <= nums[pr] ? nums[pl++] : nums[pr++];
        }
        // 其中pl越界
        while (pr <= R) {
            help[i++] = nums[pr++];
        }
        while (pl <= M) {
            help[i++] = nums[pl++];
        }
        for (int j = 0; j < help.length; j++) {
            nums[L + j] = help[j];
        }
    }
}
