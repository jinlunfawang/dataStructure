package 左神算法.链表结构栈队列递归哈希表和有序表.链表;
import 左神算法.链表结构栈队列递归哈希表和有序表.链表.bean.RandomNode;
import java.util.HashMap;

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
 * @description: rand指针是单链表节点结构中新增的指针，rand可能指向链表中的任意一个节点，也可能指向null。
 * 给定一个由Node节点类型组成的无环单链表的头节点 head，请实现一个函数完成这个链表的复制，并返回复制的新链表的头节点。
 * @date: 2022-04-23 10:36
 * <p>
 * 方法 hash表:
 *  1.将每个节点存储到hash表中
 *  2.从hash表取出克隆好的节点,连接好next节点和randomk节点
 */


public class _138_复制带随机指针的链表 {
    public RandomNode copyRandomList(RandomNode head) {
        HashMap<RandomNode, RandomNode> hashMap = new HashMap<>();
        RandomNode cur = head;
        while (cur != null) {
            hashMap.put(cur, new RandomNode(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            // 连接好next指针
            hashMap.get(cur).next = hashMap.get(cur.next);
            // 连接好random指针
            hashMap.get(cur).random = hashMap.get(cur.random);
            cur = cur.next;
        }
        return hashMap.get(head);
    }
}
