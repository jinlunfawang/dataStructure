package 左神算法.链表结构栈队列递归哈希表和有序表.链表;

import 左神算法.链表结构栈队列递归哈希表和有序表.链表.bean.Node;

import java.util.ArrayList;
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
 * @description: 使用链表实现栈
 * @date: 2022-03-11 16:22
 */


public class StackUserNodeImpl {
    private Node head;

    public StackUserNodeImpl() {
        this.head = null;
    }

    /**
     * 存储元素 放到head
     *
     * @param value
     */
    public void putEleStackUserNode(int value) {
        if (head == null) {
            head = new Node(value);

        } else {
            Node node = new Node(value);
            // 新元素 给都
            node.nextNode = head;
            head = node;
        }

    }

    /**
     * 返回头
     *
     * @return
     */
    public int getEleStackUserNode() {
        if (head == null)  throw new RuntimeException("栈是空的 别拿了");
        int returnValue = head.value;
        if (head.nextNode != null) {
            head = head.nextNode;
        } else {
            head = null;
        }

        return returnValue;
    }


    public List<Integer> getStackArray() {
        ArrayList<Integer> integers = new ArrayList<>();

        if (head == null) return null;
        while (head != null) {
            integers.add(head.value);
            head = head.nextNode;
        }
        return integers;

    }
}
