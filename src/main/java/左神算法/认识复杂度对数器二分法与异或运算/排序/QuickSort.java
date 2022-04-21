package 左神算法.认识复杂度对数器二分法与异或运算.排序;

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
 * @description: 每次选择最左边的右边的数玩paration
 * @date: 2022-03-21 23:10
 */


public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{-4, 0, 7, 4, 9, -5, -1, 0, -7, -1};
        //  quickSort2(arr);
        quickSort3(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");

        }
    }

    /**
     * 快速排序终极版本
     * 随机选择num数:如果一直选择右边的数作为参考 假如数组是降序, 那么每次递归的时候就数组的长度就是N-1
     * 所以时间复杂度为n^2。假如16个数如果每次左右递归的数很平均   可以分为log2^16层 每层的复杂度为n 所以时间复杂度为nlogN
     * <p>
     * //           16
     * //      8          8
     * //   4    4      4    4
     * // 2  2  2  2  2  2   2  2
     *
     * @param nums
     */
    public static void quickSort3(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        process3(nums, 0, nums.length - 1);
    }

    public static void quickSort2(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        process2(nums, 0, nums.length - 1);
    }

    public static void quickSort1(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        process1(nums, 0, nums.length - 1);
    }


    private static void process3(int[] nums, int l, int r) {
        if (l >= r) return;
        swap(nums, l + (int) (Math.random() * (r - l + 1)), r);

        int[] mid = partition2(nums, l, r);
        // 左侧范围重复玩这个递归
        process3(nums, l, mid[0] - 1);
        // 右侧范围重复玩这个递归

        process3(nums, mid[1], r);
    }

    private static void process2(int[] nums, int l, int r) {
        if (l >= r) return;
        //
        int[] mid = partition2(nums, l, r);
        // 左侧范围重复玩这个递归
        process2(nums, l, mid[0] - 1);
        // 右侧范围重复玩这个递归

        process2(nums, mid[1], r);
    }

    /**
     * l 到r上玩partition  每次递归搞定r位置的排序 即nums[r] 去他该去的位置
     *
     * @param nums
     * @param l
     * @param r
     */
    private static void process1(int[] nums, int l, int r) {
        if (l >= r) return;
        //
        int mid = partition(nums, l, r);
        // 左侧范围重复玩这个递归
        process1(nums, l, mid - 1);
        // 右侧范围重复玩这个递归

        process1(nums, mid + 1, r);
    }


    private static int[] partition2(int[] nums, int l, int r) {
        int num = nums[r];

        int lessIndex = l - 1;
        int moreIndex = r + 1;
        int i = l;
        while (i < moreIndex) {
            if (nums[i] < num) {
                swap(nums, ++lessIndex, i++);
            } else if (nums[i] > num) {
                swap(nums, --moreIndex, i);
            } else {
                i++;
            }
        }

        return new int[]{lessIndex + 1, moreIndex};
    }

    private static int partition(int[] nums, int l, int r) {
        int num = nums[r];

        int lessIndex = -1;
        int moreIndex = r + 1;
        int i = 0;
        while (i < moreIndex) {
            if (nums[i] < num) {
                swap(nums, ++lessIndex, i++);
            } else if (nums[i] > num) {
                swap(nums, --moreIndex, i);
            } else {
                i++;
            }

        }

        return i - 1;
    }


    private static void swap(int[] nums, int l, int r) {
        if (l == r) return;
        nums[l] = nums[l] ^ nums[r];
        nums[r] = nums[l] ^ nums[r];
        nums[l] = nums[l] ^ nums[r];
    }
}
