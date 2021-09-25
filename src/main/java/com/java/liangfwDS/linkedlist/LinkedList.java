package com.java.liangfwDS.linkedlist;

/**
 * 自定义实现双向列表
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2021/8/7 17:59
 */
public class LinkedList<E> extends AbstractList<E> {
    private Node firstNode;
    private Node lastNode;
    private static class Node<E>{
          Node<E> preNode;
          E ele;
          Node<E> nextNode;
          public Node(Node<E> prev,E ele,Node<E> next){
              this.preNode=prev;
              this.ele=ele;
              this.nextNode=next;
        }

    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }
}
