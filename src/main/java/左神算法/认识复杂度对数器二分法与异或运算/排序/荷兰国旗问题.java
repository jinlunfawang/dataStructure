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
 * @description: 给定一个数组  一个数num 要求小于 num的放在左边 大于num放在右边 等于num放中间
 * @date: 2022-03-20 21:22
 * num[i]==numm i+=
 * [i]<num [i]于小于区右一个交换 i++
 * [i]>num [i]于大于区左一个交换 i不变(为什么要i不变呢？ 因为新换的数 是你没判断过的)
 */


public class 荷兰国旗问题 {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,2,6,3};
        helanFlag(arr, 3);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);

        }
    }

    public static void helanFlag(int[] arr, int num) {
        if (arr == null || arr.length <= 1) return;

        int L = -1;
        int R = arr.length;//2
        int i = 0;
        while (i < R) { //i=1
            if (arr[i] == num) i++;
            else if (arr[i] > num) swapArr(arr, --R, i);
            else swapArr(arr, ++L, i++);

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
