package 左神算法.链表结构栈队列递归哈希表和有序表.链表;

import 左神算法.链表结构栈队列递归哈希表和有序表.链表.bean.ListNode;

import java.util.ArrayList;

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
 * @description: 给定一个链表的头节点 返回中间节点 如果是偶数的节点 返回中间后一个节点
 * @date: 2022-04-21 21:17
 * 方法一: 双指针
 * 方法二: 放到容器中 算出中间节点的下标 返回
 * 时间复杂度为 O(n)
 */


public class _876_链表的中间结点 {

    public ListNode middleNode(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;

        while (fastNode.next != null) {
            slowNode = slowNode.next;
            if (fastNode.next.next != null)
                fastNode = fastNode.next.next;
            else break;

        }
        return slowNode;

    }

    public ListNode middleNode2(ListNode head) {
        ArrayList<ListNode> listNodes = new ArrayList<>();
        while (head != null) {
            listNodes.add(head);
            if (head.next != null)
                head = head.next;
            else break;
        }
        return listNodes.get(listNodes.size() / 2);


    }
}
