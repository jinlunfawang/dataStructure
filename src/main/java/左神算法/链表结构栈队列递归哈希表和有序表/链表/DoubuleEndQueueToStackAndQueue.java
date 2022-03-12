package 左神算法.链表结构栈队列递归哈希表和有序表.链表;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
 * @description: 使用双链表实现栈和队列
 * @date: 2022-03-11 17:01
 */


public class DoubuleEndQueueToStackAndQueue {

    /**
     * 双链表结构
     *
     * @param <T>
     */
    public static class DoubleNode<T> {

        public T value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(T data) {
            value = data;
        }
    }

    /**
     * 既可以先进先出也可以先进后出
     */
    public static class DoubuleNodeToStackAndQueue<T> {
        private DoubleNode head;
        private DoubleNode tail;

        /**
         * 得到头指针的元素
         *
         * @return
         */
        private T getEleQueueEnd() {
            if (head == null) {
                return null;
            }
            DoubleNode<T> cur = tail;

            if (head == tail) {
                head = null;
                tail = null;
            } else {

                tail = tail.last;
                tail.next = null;
                cur.last = null;

            }


            return cur.value;
        }

        /**
         * 得到尾指针的元素
         *
         * @return
         */
        private T getEleQueueHead() {
            if (head == null) {
                return null;
            }
            DoubleNode<T> cur = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                // 下一个节点为head
                head = head.next;
                // 断掉之前节点指向新的head节点
                cur.next = null;
                // 断掉新的last指向之前的节点
                head.last = null;
            }
            return cur.value;
        }


        private void addEleQueueEnd(T value) {
            DoubleNode<T> cur = new DoubleNode<T>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                cur.last = tail;
                tail = cur;
            }

        }

        /**
         * 保存新的几点
         * @param value
         */
        private void addEleQueueHead(T value) {
            DoubleNode cur = new DoubleNode(value);

            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head.last = cur;
                head = cur;

            }

        }


    }

    /**
     * 新进后出
     */
    public static class MyStack<T> {
        private DoubuleNodeToStackAndQueue myStack;

        public MyStack() {
            this.myStack = new DoubuleNodeToStackAndQueue<T>();

        }

        public void pushFromStack(T value) {
            myStack.addEleQueueHead(value);

        }

        public T popFromStack() {
            return (T) myStack.getEleQueueHead();
        }


    }

    /**
     * 先进先出
     */
    public static class MyQueue<T> {

        private DoubuleNodeToStackAndQueue myQueue;

        public MyQueue() {
            this.myQueue = new DoubuleNodeToStackAndQueue();

        }

        public void pushFromQueue(T value) {
            myQueue.addEleQueueHead(value);

        }

        public T popFromQueue() {
            return (T) myQueue.getEleQueueEnd();
        }

    }


    public static boolean isEqual(Integer o1, Integer o2) {
        if (o1 == null && o2 != null) {
            return false;
        }
        if (o1 != null && o2 == null) {
            return false;
        }
        if (o1 == null && o2 == null) {
            return true;
        }
        return o1.equals(o2);
    }

    public static void main(String[] args) {
        int oneTestDataNum = 1000;
        int value = 10000;
        int testTimes = 10000;
        for (int i = 0; i < testTimes; i++) {
            MyStack<Integer> myStack = new MyStack<>();
            MyQueue<Integer> myQueue = new MyQueue<>();
            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < oneTestDataNum; j++) {
                int nums = (int) (Math.random() * value);
                if (stack.isEmpty()) {
                    myStack.pushFromStack(nums);
                    stack.push(nums);
                } else {
                    if (Math.random() < 0.5) {
                        myStack.pushFromStack(nums);
                        stack.push(nums);
                    } else {
                        if (!isEqual(myStack.popFromStack(), stack.pop())) {
                            System.out.println("oops!");
                        }
                    }
                }
                // 队列的测试
                int numq = (int) (Math.random() * value);
                if (stack.isEmpty()) {
                    myQueue.pushFromQueue(numq);
                    queue.offer(numq);
                } else {
                    if (Math.random() < 0.5) {
                        myQueue.pushFromQueue(numq);
                        queue.offer(numq);
                    } else {
                        if (!isEqual(myQueue.popFromQueue(), queue.poll())) {
                            System.out.println("oops!");
                        }
                    }
                }
            }
        }
        System.out.println("finish!");
    }

}
