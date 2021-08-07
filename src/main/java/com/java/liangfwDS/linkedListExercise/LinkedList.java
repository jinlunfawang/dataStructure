package com.java.liangfwDS.linkedListExercise;

/**
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2021/4/19 16:38
 */
public class LinkedList<T> extends AbstractList<T> {

    private Node first;

    static class Node<T> {
        T element;
        Node next;

        public Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    /**
     * 给某个索引位置添加元素 索引从0开始
     * 1.判断索引是否合格
     * 2.添加
     * 2.1 给第一个位置添加  first =newNode
     * 2.2 非首尾添加 找到index-1的node pre.next=newNode(ele,index位置的node)
     * 2.3 尾添加  最找到倒数第二个元素 pre.next=newNode
     *
     * @param index
     * @param ele
     */
    @Override
    public void add(int index, T ele) {
        // 头
        if (index == 0) {
            first = new Node(ele, first);
            // 头尾之前+尾
        } else {
            // 获取index前的元素
            Node<T> preNode = getIndeNode(index - 1);
            preNode.next = new Node(ele, getIndeNode(index));

        }
        size++;
    }

    @Override
    public T get(int index) {
        return getIndeNode(index).element;
    }

    /**
     * 1.找到index位置的元素 indexNode.element=ele
     *
     * @param index
     * @param ele
     * @return
     */
    @Override
    public T set(int index, T ele) {

        return getIndeNode(index).element = ele;
    }

    /**
     * 删除某位置的元素
     * 找到index-1 位置的preNode.next=pre.next.next;
     *
     * @param index
     */
    @Override
    public void remove(int index) {
        if (index == 0) first = first.next;
        else {
            Node<T> preNode = getIndeNode(index - 1);

            preNode.next = preNode.next.next;

        }
        size--;

    }

    @Override
    public int indexOf(T ele) {
        Node<T> tempNode = first;
        for (int i = 0; i < size; i++) {
            if (ele.equals(tempNode.element)) return i;
            tempNode = tempNode.next;
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;


    }

    /**
     * 获取某个索引位置的元素
     *
     * @param index
     */
    private Node<T> getIndeNode(int index) {
        rangeCheck(index);
        Node temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        LinkedList.Node<T> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }

            string.append(node.element);

            node = node.next;
        }
        string.append("]");
        return string.toString();
    }
}
