package com.java.leetcode.链表;

/**
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2021/4/20 10:36
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
