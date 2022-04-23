package 左神算法.链表结构栈队列递归哈希表和有序表.链表;

import 左神算法.认识复杂度对数器二分法与异或运算.排序.CheckMachine;
import 左神算法.链表结构栈队列递归哈希表和有序表.链表.bean.ListNode;

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
 * @description: 将单向链表按某值划分成左边小、中间相等、右边大的形式
 * @date: 2022-04-22 17:01
 */


public class ListNodePataition {
    public static void main(String[] args) {
        ListNode headNode = new ListNode(4);
        ListNode nextNode1 = new ListNode(3);
        ListNode nextNode2 = new ListNode(2);
        ListNode nextNode3 = new ListNode(1);
        ListNode nextNode4 = new ListNode(7);
        headNode.next = nextNode1;
        nextNode1.next = nextNode2;
        nextNode2.next = nextNode3;
        nextNode3.next = nextNode4;


        ListNodePataition.listPartition1(headNode, 0);
    }

    // 搞一个数组 将所以节点加到数组中 数组玩paratition
    public static ListNode listPartition1(ListNode head, int standValue) {

        System.out.println("以 " + standValue + " 为基准partition前:");
        CheckMachine.printNode(head);
        int i = 0;

        ListNode tempNode1 = head;
        ListNode tempNode2 = head;

        while (tempNode1 != null) {
            tempNode1 = tempNode1.next;
            i++;
        }
        ListNode[] nodeArr = new ListNode[i];

        for (int j = 0; j < nodeArr.length; j++) {
            nodeArr[j] = new ListNode(tempNode2.val);
            tempNode2 = tempNode2.next;
        }
        partition(nodeArr, standValue);

        for (int j = nodeArr.length - 1; j > 0; j--) {
            nodeArr[j - 1].next = nodeArr[j];

        }
        System.out.println("以 " + standValue + " 为基准partition后:");
        CheckMachine.printNode(nodeArr[0]);
        return nodeArr[0];

    }

    /**
     * 6个变量 分别表示
     * lessHead
     * lessTail
     * equalHead
     * equalTail
     * moreHead
     * moreTail
     * 遍历链表 将遍历的节点指向合适的变量
     * 后续将三个区域串起来 就是大于的右边 小于的左边
     *
     * @param head
     * @param standValue
     * @return
     */
    public static ListNode listPartition2(ListNode head, int standValue) {
        System.out.println("以 " + standValue + " 为基准partition前:");
        CheckMachine.printNode(head);
        ListNode lessHead = null;
        ListNode lessTail = null;
        ListNode equalHead = null;
        ListNode equalTail = null;
        ListNode moreHead = null;
        ListNode moreTail = null;
        ListNode next;
        ListNode returnNode;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < standValue) {
                if (lessHead == null) {
                    lessHead = head;
                    lessTail = head;
                } else {
                    lessTail.next = head;
                    lessTail = head;
                }

            } else if (head.val == standValue) {
                if (equalHead == null) {
                    equalHead = head;
                    equalTail = head;
                } else {
                    equalTail.next = head;
                    equalTail = head;
                }
            } else {
                if (moreHead == null) {
                    moreHead = head;
                    moreTail = head;
                } else {
                    moreTail.next = head;
                    moreTail = head;
                }
            }

            head = next;
        }

        // 有小于区域的情况
        if (lessTail != null) {
            lessTail.next = equalHead;
            equalTail = equalTail == null ? moreHead : equalHead;
        }

        // 有等于区的情况
        if (equalTail != null) {
            equalTail.next = moreHead;
        }

        returnNode = lessHead != null ? lessHead : (equalHead != null ? equalHead : moreHead);
        System.out.println("以 " + standValue + " 为基准partition后:");
        CheckMachine.printNode(returnNode);
        return returnNode;

    }

    private static void partition(ListNode[] nodeArr, int standValue) {
        // 小于区初始角标
        int lessIndex = -1;
        int index = 0;
        int moreIndex = nodeArr.length;
        while (index < moreIndex) {
            if (nodeArr[index].val < standValue) {
                CheckMachine.swapNode(nodeArr, ++lessIndex, index++);
            } else if (nodeArr[index].val > standValue) {
                CheckMachine.swapNode(nodeArr, index, --moreIndex);
            } else {
                index++;

            }
        }
    }


}
