package 左神算法.链表结构栈队列递归哈希表和有序表.链表;


import 左神算法.链表结构栈队列递归哈希表和有序表.链表.bean.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2021/4/20 9:47
 */
public class _206_反转链表 {

    /**
     * 迭代法:
     * 定义两个指针:执向一前一后  改变前后两个指针指向 实现局部反转 同时向前移动
     * 最终实现了链表的反转
     * prePoint:
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode curNode = head;
        ListNode tempNode;
        while (curNode != null) {
            // 暂存下一个节点 用来移动指针
             tempNode=curNode.next;
          curNode.next=preNode;
          preNode=curNode;
          curNode=tempNode;

        }

        return preNode;
    }

    /**
     *  迭代法
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
         ListNode pre=null;
         ListNode cur=head;
         ListNode curNextpNode;
         while (cur!=null){
             curNextpNode=cur.next;
             //1. 实现局部反转
             cur.next=pre;
             // 2. 指针同时向前移动
             pre=cur;
             cur=curNextpNode;

         }
         return pre;

    }

    /**
     * 递归法
     *
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        // 最小子问题的解
      if(head==null||head.next==null) return head;
        // 分解问题的过程
        ListNode p = reverseList3(head.next);
        // 解合并的过程
        head.next.next=head;

        head.next=null;
        return p;
    }

}
