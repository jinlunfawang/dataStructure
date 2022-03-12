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
 * @description: 使用数组实现栈
 * @date: 2022-03-10 18:56
 */


public class StackArray {
    private int[] ints;
    // 表示数组中元素的个数
    private int size = 0;

    public StackArray(int len) {
        ints = new int[len];

    }

    public int popEleStackArray() {
        if (size == 0) throw new RuntimeException("骚年 栈空了不能再拿了了");
        size--;

        int anInt = ints[size];
        ints[size] = 0;
        return anInt;
    }

    public void pushEleStackArray(int ele) {
        if (size < ints.length) {
            ints[size] = ele;
            size++;
        } else throw new RuntimeException("骚年 栈满了不能再加了");
    }

    public int[] getEleStarckArray() {
        return ints;
    }
}
