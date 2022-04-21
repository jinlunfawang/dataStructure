package 左神算法.认识复杂度对数器二分法与异或运算.排序;

import static 左神算法.认识复杂度对数器二分法与异或运算.排序.CheckMachine.swap;

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
 * @description:给定一个数组 一个数num 要求小于等于num的放在左边 大于num放在右边 要求空间复杂的为O(1) 时间复杂的为O(n)
 * @date: 2022-03-19 19:24
 * 思路1: 定义两个指针head last 分别指向数组的头和尾
 * 遍历数组和num比较 如果arr[head]小于num就 head++ 比较小下一轮,
 * 否则,arr[head]和arr[last]交换 同时last-- 交换后再和arr[head]比较 如果arr[head]>arr[last]就和末尾再交换 再比较
 * <p>
 * 思路2:每遇到一个小于num的数 小于区域就向左变扩一下
 * 定义一个下于区域的索引初始j=-1
 *     遍历数组遇到大于num的数  直接跳过 i++
 *      小于等于num的数   j++ 交换j位置和i位置的数
 * 相当于小于区推着大于区域向前走 遇到小就放到小于区域左扩一个 大于区域向右移动一位
 */


public class Paration {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 5, 4, 3, 2, -1, -3, 99};
        resetParation(arr, 3);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);

        }

    }

    public static void resetParation(int[] arr, int num) {
        if (arr == null || arr.length <= 1) return;
        int last = arr.length - 1;
        int head = 0;
        while (head < last) {
            if (arr[head] <= num) {
                head++;
            } else {
                do {
                    if (head == last) return;
                    swapArr(arr, head, last--);
                } while (arr[head] > num);
            }
        }


    }

    public static void resetParation2(int[] arr, int num) {
        if (arr == null || arr.length <= 1)
            return;
        int i = -1;
        int j = 0;
        while (j < arr.length) {
            if (arr[j++] > num) continue;
            swapArr(arr, ++i, j);
        }
    }


    private static void swapArr(int[] arr, int i, int j) {
        if (i != j) {
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }

}
