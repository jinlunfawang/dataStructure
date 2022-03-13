package 左神算法.链表结构栈队列递归哈希表和有序表.链表;

import java.util.LinkedList;
import java.util.Queue;

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
 * @description: 使用队列实现栈 队列是先进先出 栈先进后出
 * 一个data队列 :放数据
 * 一个help队列: 取数据时把data的数据除过最后一个元素都放进help 然后出队列 交换两个栈1
 *
 * @date: 2022-03-13 10:28
 */


public class _225_使用队列实现栈 {

    public static class MyStack {
        private Queue<Integer> dataQueue = new LinkedList<Integer>();
        private Queue<Integer> helpQueue = new LinkedList<Integer>();

        public void push(int x) {
            dataQueue.offer(x);

        }

        public int pop() {
            while (dataQueue.size() > 1) {
                helpQueue.offer(dataQueue.poll());
            }
            int res = dataQueue.peek();
            Queue<Integer> tempQueue = new LinkedList<Integer>();

            tempQueue = dataQueue;
            dataQueue = helpQueue;
            helpQueue = tempQueue;

            return res;

        }

        /**
         * Get the top element.
         */
        public int top() {
            return dataQueue.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return dataQueue.isEmpty();
        }


    }
}
