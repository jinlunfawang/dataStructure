package 左神算法.链表结构栈队列递归哈希表和有序表.链表;

import 左神算法.链表结构栈队列递归哈希表和有序表.链表.bean.Node;

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
 * @description: 删除列表中给定的值
 * @date: 2022-03-12 11:40
 */


public class RemoveNodeValue {


    public Node removeElements(Node head, int val) {

        // 删除的头
        while (head != null && head.value == val) {
            head = head.nextNode;
        }
        if (head == null) return null;

        Node temNode = head;
        // 删除的不是头

        while (temNode.nextNode != null) {
            if (temNode.nextNode.value == val) {
                temNode.nextNode = temNode.nextNode.nextNode;
            } else {
                temNode = temNode.nextNode;
            }

        }
        return head;


    }

}
