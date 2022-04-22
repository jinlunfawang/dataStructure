package 左神算法.链表结构栈队列递归哈希表和有序表.链表;

import com.java.liangfwDS.linkedlist.ArrayList;
import 左神算法.链表结构栈队列递归哈希表和有序表.链表.bean.ListNode;

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
 * @description:给定一个链表 判断是否回文链表
 * @date: 2022-04-21 21:51
 * <p>
 * 方法一: 容器法 使用数组
 */


public class _234_回文链表 {

    public static void main(String[] args) {
        ListNode headNode = new ListNode(1);
        ListNode nextNode1 = new ListNode(0);
        ListNode nextNode2 = new ListNode(0);
       // ListNode nextNode3 = new ListNode(1);

        headNode.next = nextNode1;
        nextNode1.next=nextNode2;
      //  nextNode2.next=nextNode3;


        System.out.println(_234_回文链表.isPalindrome3(headNode));
    }

    /**
     * 使用数组判断
     * 额外空间为o(n)
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome2(ListNode head) {
        ArrayList<ListNode> listNode = new ArrayList<>();

        while (head != null) {
            listNode.add(head);
            if (head.next != null)
                head = head.next;
            else break;
        }


        int i = 0;
        while (i < listNode.size() / 2) {
            if (listNode.get(i).val == listNode.get(listNode.size() - i - 1).val) {
                i++;
            } else
                return false;

        }
        return true;
    }

    /**
     * 使用栈判断
     * 额外空间为o(n)
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode preNode = head;
        ListNode temNode = head;
        while (preNode != null) {
            stack.push(preNode);
            if (preNode.next != null)
                preNode = preNode.next;
            else break;
        }
        while (!stack.isEmpty()) {
            if (stack.pop().val != temNode.val) return false;
            else temNode = temNode.next;
        }
        return true;
    }

    /**
     * 使用栈判断 双指针链表后半段添加到栈中
     * 额外空间为o(n/2)
     *
     * @param
     * @return
     */
    public static boolean isPalindrome3(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode preNode = head;
        ListNode slowNode = head;
        ListNode fastNode = head;
        ListNode temNode1 = head;
        if(head.next==null ) return true;
        while (fastNode != null) {
            slowNode = slowNode.next;
            if (fastNode.next != null)

                fastNode = fastNode.next.next;
            else break;
        }
        while (slowNode != null) {
            stack.push(slowNode);
            slowNode = slowNode.next;

        }
        while (!stack.isEmpty()) {
            if (stack.pop().val != temNode1.val) return false;
            else temNode1 = temNode1.next;
        }
        return true;
    }

}

// [1,2,2,1]