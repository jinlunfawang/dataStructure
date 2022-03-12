package 左神算法.链表结构栈队列递归哈希表和有序表.链表;

import java.util.List;

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
 * @description: 测试链表实现栈
 * 栈的结构 先进后出的
 * @date: 2022-03-11 16:11
 */


public class StackUserNode {
    public static void main(String[] args) {

        StackUserNodeImpl stackUserNode = new StackUserNodeImpl();
        stackUserNode.putEleStackUserNode(1);
        stackUserNode.putEleStackUserNode(2);

        int ele = stackUserNode.getEleStackUserNode();
        System.out.println(ele);

        int ele2 = stackUserNode.getEleStackUserNode();
        System.out.println(ele2);
        List<Integer> stackArray = stackUserNode.getStackArray();
        if (stackArray == null) System.out.println("栈是空的");
        else {
            for (Integer ele1 : stackArray) {
                System.out.println(ele1);

            }
        }

    }


}
