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
 * @description:使用数组实现栈和队列
 * @date: 2022-03-10 18:52
 */


public class StackUserArray {
    public static void main(String[] args) {
        StackArray stackArray = new StackArray(4);
        // 存储元素
        stackArray.pushEleStackArray(1);
        stackArray.pushEleStackArray(2);
        stackArray.pushEleStackArray(27);
        stackArray.pushEleStackArray(28);
//        int ele1 = stackArray.popEleStackArray();
//        int ele2 = stackArray.popEleStackArray();
//        stackArray.pushEleStackArray(29);
//
//        // 出元素
//        int ele3 = stackArray.popEleStackArray();
//        int ele4 = stackArray.popEleStackArray();

        int[] attay = stackArray.getEleStarckArray();
        for (int i = 0; i < attay.length; i++) {
            System.out.println(attay[i]);
        }


    }

}
