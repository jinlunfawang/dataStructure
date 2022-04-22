package 左神算法.链表结构栈队列递归哈希表和有序表.链表;

import 左神算法.链表结构栈队列递归哈希表和有序表.链表.bean.ListNode;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2021/4/20 15:41
 */
public class _141_环形链表 {
    /**
     * 快慢指针:
     * 快指针每次走两步 fasterPoint=faster.next.next;
     * 慢指针每次走一步 slowPoint=slowPoint.next;
     * 如果faserPoint==slowPoint 有环
     * 如果 faserPoint!=null&&faster.next!=null
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode fasterPoint = head;
        ListNode slowPoint = head;
        while (fasterPoint != null && fasterPoint.next != null) {
            fasterPoint = fasterPoint.next.next;
            slowPoint = slowPoint.next;
            if (slowPoint == fasterPoint) return true;
        }
        return false;


    }

    /**
     * 练习 双指针
     *
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {

        ListNode slow = head;
        ListNode faster = head;
        while (faster != null && faster.next != null) {
            slow = slow.next;
            faster = faster.next.next;
            if (slow == faster)
                return true;
        }
        return false;

    }
}

