package 左神算法.链表结构栈队列递归哈希表和有序表.链表;

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
 * @description: 使用数组实现队列
 * @date: 2022-03-10 19:32
 */


public class QueueUseArray {

    public static void main(String[] args) {
        QueueArray queueArray = new QueueArray(4);
        queueArray.putEleQueue(2);
        queueArray.putEleQueue(22);
        int headEle1 = queueArray.getEleFromQueue();

        queueArray.putEleQueue(333);
        queueArray.putEleQueue(555);
        int headEle2 = queueArray.getEleFromQueue();

        queueArray.putEleQueue(3334);
        int headEle4 = queueArray.getEleFromQueue();


        // queueArray.putEleQueue(4444);

        // 1. 从对头取元素
//        System.out.println(headEle4);

        //2. 查看队列
        int[] arr = queueArray.getQueueArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }


    }


}
