package 左神算法.链表结构栈队列递归哈希表和有序表.链表;

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
 * @description: 数组实现队列 先进先出
 * @date: 2022-03-11 12:14
 */


public class QueueArray {
    private int[] array;
    // 记录存储元素的个数
    private int size;
    // 队列可存储的个数
    private int limit;
    // 放值的位置
    private int pushI;
    // 取值的位置
    private int popI;

    public QueueArray(int len) {
        this.array = new int[len];
        this.limit = len;
        this.popI = 0;
        this.popI = 0;


    }

    /**
     * 存储元素
     */

    public void putEleQueue(int ele) {
        // 有没有放满
        if (size == limit) throw new RuntimeException("队列满了 不能再存储了");
        // 放哪里
        array[pushI] = ele;
        size++;
        // 下一个取的位置
        pushI = pushI < limit - 1 ? pushI + 1 : 0;
    }

    public int getEleFromQueue() {


        if (size == 0) throw new RuntimeException("队列空了 不能再取了");
        // 取哪里
        int returnEle = array[popI];
        size--;
        // 下一个放的位置
        popI = popI < limit - 1 ? popI + 1 : 0;
        return returnEle;
    }


    public int[] getQueueArray() {
        int N = popI;

        int[] returnArr = new int[size];
        if (pushI > popI)
            for (int i = 0; i < size; i++) {
                returnArr[i] = array[popI + i];

            }
        if (pushI < popI)

            for (int i = 0; i < size; i++) {
                if (i < pushI)
                    returnArr[i] = array[i];
                else {
                    returnArr[i] = array[N];
                    N++;
                }


            }
        return returnArr;
    }
}
