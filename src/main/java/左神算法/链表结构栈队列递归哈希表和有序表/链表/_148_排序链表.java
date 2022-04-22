package 左神算法.链表结构栈队列递归哈希表和有序表.链表;

import 左神算法.链表结构栈队列递归哈希表和有序表.链表.bean.ListNode;

import java.util.ArrayList;
import java.util.Comparator;

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
 * @date: 2022-04-22 15:32
 */


public class _148_排序链表 {

    public static void main(String[] args) {
        ListNode headNode = new ListNode(1);
        ListNode nextNode1 = new ListNode(5);
        ListNode nextNode2 = new ListNode(3);
        ListNode nextNode3 = new ListNode(2);

        headNode.next = nextNode1;
        nextNode1.next = nextNode2;
        nextNode2.next = nextNode3;


        System.out.println(_148_排序链表.sortList(headNode));
    }

    public static ListNode sortList(ListNode head) {
      if(head==null||head.next==null) return head;
        ArrayList<ListNode> arrayList = new ArrayList<>();
        ListNode tempNode=null;
        while (head != null) {
            tempNode= new ListNode(head.val);
            arrayList.add(tempNode);
            head = head.next;
        }
        arrayList.sort(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });



        for (int i = arrayList.size() - 1; i > 0; i--) {
            arrayList.get(i - 1).next = arrayList.get(i);
        }
        return arrayList.get(0);

    }
}
