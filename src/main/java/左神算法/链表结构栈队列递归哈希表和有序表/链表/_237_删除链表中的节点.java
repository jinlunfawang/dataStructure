package 左神算法.链表结构栈队列递归哈希表和有序表.链表;

import 左神算法.链表结构栈队列递归哈希表和有序表.链表.bean.ListNode;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 *
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2021/4/19 21:47
 */
public class _237_删除链表中的节点 {

    /**
     *  删除链表的的节点
       思路一: 如果传入index 找到index-1 preNode的值
             preNode.next=preNode.next.next;
       思路二:如果传入node ,待删除节点的值替换为next节点的值 待删除节点的next 替换为 nextNOde
           node.val=node.next.val;
           node.next=node.next.next;

     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;

    }

}
