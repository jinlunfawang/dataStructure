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
 * @description: 获取堆栈中的最小元素
 * @date: 2022-03-12 21:19
 */


public class _155_最小栈 {

    //
    public static class MinStack {
        private Stack<Integer> dataStack = new Stack<Integer>();
        private Stack<Integer> minStack = new Stack<Integer>();

        public void push(int val) {
            if (minStack.empty()) {
                minStack.push(val);

            } else if (val < getMin()) {
                minStack.push(val);
            } else {
                minStack.push(minStack.peek());
            }
            dataStack.push(val);

        }

        public void pop() {
            if(minStack.isEmpty()||dataStack.isEmpty()) throw new RuntimeException("是空不能取了");
            this.minStack.pop();
            this.dataStack.pop();
        }

        public int getMin() {

            return minStack.peek();
        }
    }


}
