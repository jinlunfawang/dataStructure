package 左神算法.链表结构栈队列递归哈希表和有序表.链表;

import 左神算法.链表结构栈队列递归哈希表和有序表.链表.bean.ListNode;

import java.util.HashMap;

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
 * @description: 输入两个链表，找出它们的第一个公共节点。
 * 题目链接: https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * @date: 2022-04-23 11:08
 * 方法一: hash表 将A链表的所有节点都放到hashMap中 依次以链接B的每个节点取hashMap中去取 如果能取到 则认为有相交 否则没有相交
 * 空间复杂度为O(n) 时间复杂度为O(m)
 */


public class _剑指Offe52_两个链表的第一个公共节点 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, Integer> hash = new HashMap<ListNode, Integer>();
        ListNode cur = headA;
        while (cur != null) {
            hash.put(cur, 1);
            cur = cur.next;
        }
        cur = headB;
        while (cur != null) {
            if (hash.get(cur) != null) {
                return cur;
            }
            cur = cur.next;

        }
        return null;
    }

    // 遍历两个链表求出链表长度 从链表最短的那个长度开始遍历 如果相等 则返回
    // 初始化两个指针开始的位置,如果相等则返回 否则就丢弃
    // 空间复杂度为O(1) 时间复杂度为:O(n)
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int Aindex = 0;
        int Bindex = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null || curB != null) {
            if (curA!=null) {
                Aindex++;
                curA=curA.next;
            }
            if (curB!=null) {
                Bindex++;
                curB=curB.next;
            }

        }
        ListNode startANewHead = headA;
        ListNode startBNewHead = headB;
        int diff = Math.abs(Aindex - Bindex);
        while (diff > 0) {
            diff--;
            if (Aindex > Bindex) {
                startANewHead = startANewHead.next;
            } else {
                startBNewHead = startBNewHead.next;
            }
        }
        while (startBNewHead != null) {
            if (startANewHead == startBNewHead) {
                return startANewHead;
            }
            startANewHead = startANewHead.next;
            startBNewHead = startBNewHead.next;

        }
        return null;


    }


}
