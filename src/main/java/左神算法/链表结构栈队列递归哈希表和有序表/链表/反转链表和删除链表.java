package 左神算法.链表结构栈队列递归哈希表和有序表.链表;

import 左神算法.链表结构栈队列递归哈希表和有序表.链表.bean.DoubleNode;
import 左神算法.链表结构栈队列递归哈希表和有序表.链表.bean.Node;

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
 * @description:
 * @date: 2022-03-06 19:00
 */


public class 反转链表和删除链表 {


    public static void main(String[] args) {
        System.out.println("远程修改的");

        int len = 1000;
        int value = 10000;
        int times = 100000;
        for (int i = 0; i < times; i++) {
            // 1. 初始化链表 指定长度链表
            Node head = randomLinkedList(len, value);
            DoubleNode doubleList = randomDoubuleList(len, value);
            // 2. 链表反转
            Node reverNode1 = reverNode(head);
            DoubleNode reverDoubleNode1 = reverDoubleNode(doubleList);

            // 3.输出
            Node reverNode2 = reverNodeUserArray(reverNode1);
            DoubleNode reverDoubleNode2 = reverDoubleNodeUserArray(reverDoubleNode1);

            if (!listNodeEqual(head, reverNode2)) {
                throw new RuntimeException("运行异常");
            }
            if (!listNodeEqualDouble(doubleList, reverDoubleNode2)) {
                throw new RuntimeException("双链表运行异常");

            }
        }

        System.out.println("finish");


    }

    private static boolean listNodeEqualDouble(DoubleNode head1, DoubleNode head2) {

        if (head1 == null && head2 == null) return true;

        while (head1 != null && head2 != null) {
            if (head1.next != head2.next || head1.last != head2.last) return false;
            head1 = head1.next;
            head2 = head2.next;

        }

        return head1 == null && head2 == null;
    }

    /**
     * 使用数组反转双链表
     *
     * @param reverDoubleNode1
     * @return
     */
    private static DoubleNode reverDoubleNodeUserArray(DoubleNode reverDoubleNode1) {
        if (reverDoubleNode1 == null) {
            return reverDoubleNode1;
        }

        ArrayList<DoubleNode> doubleNodes = new ArrayList<>();
        DoubleNode head = reverDoubleNode1;
        while (head != null) {
            doubleNodes.add(head);
            head = head.next;
        }
        doubleNodes.get(0).next = null;
        int N = doubleNodes.size();
        for (int i = 1; i < N; i++) {

            doubleNodes.get(i).next = doubleNodes.get(i - 1);


        }
        return doubleNodes.get(N - 1);
    }

    private static DoubleNode randomDoubuleList(int len, int value) {

        int N = (int) (Math.random() * (1 + len));
        if (N == 0) return null;
        DoubleNode head = new DoubleNode(value);
        DoubleNode pre = head;
        N--;
        while (N != 0) {

            DoubleNode cur = new DoubleNode((int) (Math.random() * (1 + len)));
            // 指针互相指
            pre.next = cur;
            cur.last = pre;

            pre = cur;
            N--;

        }

        return head;
    }

    /**
     * 反转链表: 把每一个节点的指针 反转过来即可 原来指向右接着指向左
     * 然后pre指针和 next指针向前移动即可
     *
     * @param head
     */
    public static Node reverNode(Node head) {
        // 上一个节点 当前指针指向新指向
        Node pre = null;
        // 只用来保存下一给值
        Node next = null;
        while (head != null) {
            next = head.nextNode;
            head.nextNode = pre;
            pre = head;
            head = next;
        }
        return pre;

    }

    /**
     * 每个节点的指针只要反转即可
     * pre:只做指针指向
     * next:保存下一个节点
     *
     * @param head
     * @return
     */
    public static DoubleNode reverDoubleNode(DoubleNode head) {

        DoubleNode pre = null;

        DoubleNode next = null;
        while (head != null) {
            next = head.next;

            head.next = pre;
            head.last = next;

            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 使用数组的方式反转链表
     *
     * @param head
     * @return
     */
    private static Node reverNodeUserArray(Node head) {

        if (head == null) return null;
        ArrayList<Node> nodeList = new ArrayList<>();
        while (head != null) {
            nodeList.add(head);
            // 存放的是引用的地址,
            head = head.nextNode;
        }
        nodeList.get(0).nextNode = null;
        int N = nodeList.size();
        // 把数组的前一个数 作为下一个数组Node的next
        for (int i = 1; i < N; i++) {
            nodeList.get(i).nextNode = nodeList.get(i - 1);

        }
        // 返回头节点的地址
        return nodeList.get(N - 1);
    }

    private static boolean listNodeEqual(Node head1, Node head2) {

        while (head1 != null && head2 != null) {
            if (head1.nextNode != head2.nextNode) return false;
            head1 = head1.nextNode;
            head2 = head2.nextNode;

        }
        return head1 == null && head2 == null;
    }

    // 生成随机长度的链表
    private static Node randomLinkedList(int len, int value) {
        Double l = Math.random() * (len + 1);
        int N = l.intValue();
        Node head = new Node(value);
        Node pre = head;
        if (N == 0) return head;
        N = N - 1;
        while (N != 0) {
            Double doublevalue = Math.random() * (value + 1);
            Node current = new Node(doublevalue.intValue());
            pre.nextNode = current;
            pre = current;
            N--;
        }
        return head;
    }


}
