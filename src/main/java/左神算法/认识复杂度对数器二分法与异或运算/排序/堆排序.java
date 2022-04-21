package 左神算法.认识复杂度对数器二分法与异或运算.排序;

import java.util.PriorityQueue;

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
 * @description: 堆排序原理:
 * 1.大根堆的结构:
 * 找到每个元素合适的位置:每次放入一个数都和其该元素的父顶点位置的元素比较 如果不大于父定点元素该位置就是合适的位置
 * 2.依次取堆顶元素
 * 数组的最后一个元素和index=0位置最大元素交换,和该左右子数中最大的一个交换。一直交换到什么地步即可
 * 时间复杂度:调整为大根堆结构的时间复杂度O(N*logN)
 * 取元素的过程时间复杂度也是O(N*logN)
 * @date: 2022-04-16 21:24
 */


public class 堆排序 {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 56, 1, 6, 33, 51, -1};
        堆排序.heapSort2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }
    }

    private static void heapSort2(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int arrLength = arr.length;
        // 1 形成大根堆结构
        for (int i = 0; i < arrLength; i++) {
            heapInsert2(arr, i);
        }
        int heapsize = arrLength - 1;
        //2.依次将堆顶元素放到heapSize 位置 再调整为大根堆
        while (heapsize > 0) {
            CheckMachine.swap(arr, 0, heapsize);
            heapify2(arr, heapsize);
            heapsize--;
        }
    }

    // 0位置元素找到合适的位置
    private static void heapify2(int[] arr, int heapsize) {
        // index 表示待交换的位置
        int index = 0;
        int left = 1;
        while (left < heapsize) {
            int largest = left + 1 < heapsize && arr[left + 1] > arr[left] ? left + 1 : left;
            if (arr[index] < arr[largest]) {
                CheckMachine.swap(arr, index, largest);
                index = largest;
                left = index * 2 + 1;
            } else break;

        }

    }


    private static void heapInsert2(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            CheckMachine.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;

        }
    }


    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length; i++) {//O(N)
            heapInsert(arr, i);//O(logN)
        }
        int heapSize = arr.length - 1;
        while (heapSize > 0) {
            heapify(arr, 0, heapSize--);
        }


    }

    // arr[index]位置的数能否往下移动
    private static void heapify(int[] arr, int index, int heapSize) {
        CheckMachine.swap(arr, 0, heapSize);
        int left = index * 2 + 1;
        // 左孩子下标不越界 那么有左孩子
        while (left < heapSize) {
            // 两个孩子中 谁的值大 把小标给largest
            // 只有左孩子 left->largest
            // 左右都有 两个中谁最大给largest
            // 左右孩子中值最大的下标。
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            if (arr[largest] > arr[index]) {
                CheckMachine.swap(arr, largest, index);
                index = largest;
                left = index * 2 + 1;
            } else {
                break;
            }

        }
    }

    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            CheckMachine.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
}
