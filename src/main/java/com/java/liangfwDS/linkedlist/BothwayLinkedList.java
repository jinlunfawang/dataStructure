package com.java.liangfwDS.linkedlist;

/**
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2021/4/28 17:53
 */
public class BothwayLinkedList<E> extends AbstractList<E> {


    // 指向第一个节点
    private Node<E> first;
    // 指向最后一个节点
    private Node<E> last;

    static class Node<E> {
        E element;
       Node nextNode;
       Node PrdNode;
        public Node(E element, Node nextNode,Node PrdNode) {
            this.element = element;
            this.nextNode = nextNode;
            this.PrdNode = PrdNode;
        }
    }
    @Override
    public void clear() {
        size=0;
        first=null;
        last=null;
    }

    @Override
    public E get(int index) {

        return getIndexNode(index).element;

    }

    @Override
    public E set(int index, E element) {
        E oldElement = getIndexNode(index).element;
        getIndexNode(index).element = element;
        return oldElement;
    }

    /**
     * 重点练习添加
     *
     * @param index
     * @param element 找到前面元素 找到后面的元素
     *                注意index 位置
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        if (index == 0) {
            //first = new Node(element, first);
        } else {
            //1. 获取index前的node节点
          //  Node<E> beforeNode = getIndexNode(index - 1);
         //   beforeNode.nextNode = new Node<E>(element, beforeNode.nextNode);

        }
        size++;
    }

    /**
     * 注意测试边界
     * <p>
     * 1.找到index 前面的元素
     * 2.pre.next=pre.next.next
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        Node<E> node = first;
        if (index == 0) {

            first = first.nextNode;
        } else {

            Node<E> preNode = getIndexNode(index - 1);
            node = preNode.nextNode;
            preNode.nextNode = node.nextNode;


        }
        size--;
        return node.element;
    }

    /**
     * 获取元素的位置
     * 1.从头开始遍历元素是否相等(Node temp =first  temp.equals(elements) ) 如不相等 则temp=temp.next;
     *
     *
     * @param element
     * @return
     */
    @Override
    public int indexOf(E element) {


        Node<E> temp = first;
        for (int i = 0; i < size; i++) {
            if (element.equals(temp.element)) {
                return i;
            }
            temp = temp.nextNode;
        }
        return ELEMENT_NOT_FOUND;
    }


    /**
     * 获取index位置的Node

     */

    private Node<E> getIndexNode(int index) {

        rangeCheck(index);
        Node<E> tempNode = first;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.nextNode;
        }

        return tempNode;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }

            string.append(node.element);

            node = node.nextNode;
        }
        string.append("]");
        return string.toString();
    }


}
