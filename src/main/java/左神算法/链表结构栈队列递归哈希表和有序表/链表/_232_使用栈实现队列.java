package 左神算法.链表结构栈队列递归哈希表和有序表.链表;

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
 * @description: 使用栈实现队列 两个栈不停在倒
 * @date: 2022-03-13 09:19
 */

public class _232_使用栈实现队列 {

    public static class MyQueue {
        private Stack<Integer> pushStack;
        private Stack<Integer> popStack;


        public MyQueue() {
            this.pushStack = new Stack<>();
            this.popStack = new Stack<>();
        }

        public void push(int x) {
            //1 倒一下
            while (!popStack.isEmpty()) {
                this.pushStack.push(this.popStack.pop());
            }
            //  把元素放到push栈的栈顶
            this.pushStack.push(x);
        }

        public int pop() {
            //  倒一下
            while (!pushStack.isEmpty()) {
                this.popStack.push(this.pushStack.pop());
            }
            //  把元素放到push栈的栈顶
            return this.popStack.pop();

        }

        public int peek() {
            while (!pushStack.isEmpty()) {
                this.popStack.push(this.pushStack.pop());
            }
            //  把元素放到push栈的栈顶

            return popStack.peek();


        }

        public boolean empty() {
            return pushStack.isEmpty() && popStack.isEmpty() ? true : false;
        }
    }

}
