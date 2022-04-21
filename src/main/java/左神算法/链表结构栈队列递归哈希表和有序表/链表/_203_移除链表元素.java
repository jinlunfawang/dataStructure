package 左神算法.链表结构栈队列递归哈希表和有序表.链表;

import com.java.leetcode.链表.ListNode;

/**
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2021/4/20 17:45
 */
public class _203_移除链表元素 {
    /**
     * 迭代法:循环找到 值为val的节点
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = head;
        while (node != null) {
            if (node.val == val && node.next == null) {
                node = null;
            } else {
                node.val = node.next.val;
                node.next = node.next.next;
                node = node.next;
            }

        }
        return head;

    }
}
