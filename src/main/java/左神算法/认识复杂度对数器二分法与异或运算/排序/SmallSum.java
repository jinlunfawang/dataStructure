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
 * @description: 归并的应用
 * 在一个数组中，一个数左边比它小的数的总和，叫数的小和，所有数的小和累加起来，叫数组小和。求数组小和。(禁止使用暴力法)
 * 例子： [1,3,4,2,5]
 * 1左边比1小的数：没有
 * 3左边比3小的数：1
 * 4左边比4小的数：1、3
 * 2左边比2小的数：1
 * 5左边比5小的数：1、3、4、 2
 * 所以数组的小和为1+1+3+1+1+3+4+2=16
 * @date: 2022-03-19 14:23
 * <p>
 * 思路: 求一个数求左边比他小的数的总和 也就是当前数右边有几个数比他大 那么一定会产生几个当前数的小和
 * [1,3,4,2,5] 1右边有4个比1大 一定会产生4个1
 * 3 有2个    2 个3
 * 4 有1个    2 个4
 * 2 有1个    1 个2
 * 1.所以一个数组求出左半部分比小数的总和 再求出右半部分数组和小和 再merge起来 求总的小和
 * 2.其中做半部分依次可以递归 求出每个数在自己小范围内的数组小和 再累加起来即可。
 * <p>
 * <p>
 * <p>
 * 扩展:什么样可以使用归并排序？
 * 当你在纠结 某一个数左边或者右边比你大或者小的的时候
 */


public class SmallSum {

    public static void main(String[] args) {
        System.out.println(arraySmallSum(new int[1]));
    }

    public static int arraySmallSum(int[] ints) {
        ints = new int[]{1, 3, 4, 2, 5};
        if (ints == null || ints.length <= 1) {
            return 0;

        }
        return process(ints, 0, ints.length - 1);

    }

    private static int process(int[] ints, int L, int R) {
        if (L == R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        int leftSum = process(ints, L, mid);
        int rigthSum = process(ints, mid + 1, R);
        int mergerSun = merge(ints, L, mid, R);
        return leftSum + rigthSum + mergerSun;


    }

    private static int merge(int[] ints, int l, int mid, int r) {
        int[] help = new int[r - l + 1];

        int res = 0;
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= r) {
            res += ints[p1] < ints[p2] ? (r - p2+1) * ints[p1] : 0;
            help[i++] = ints[p1] < ints[p2] ? ints[p1++] : ints[p2++];

        }
        while (p1 <= mid) {
            help[i] = ints[p1++];
        }
        while (p2 <= r) {
            help[i] = ints[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            ints[l + j] = help[j];

        }
        return res;
    }


}
