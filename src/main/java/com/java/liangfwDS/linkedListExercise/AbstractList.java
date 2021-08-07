package com.java.liangfwDS.linkedListExercise;

/**
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2021/4/19 16:25
 */
public abstract class AbstractList<T> implements List<T> {
    /**
     * protected 只能子类使用
     */
    protected int size;

    protected int size() {
        return size;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T ele) {

        return indexOf(ele) != ELEMENT_NOT_FOUND;

    }

    /**
     * 添加元素到末尾
     *
     * @param ele
     */
    public void add(T ele) {
        add(size, ele);
    }

    /**
     * 子类使用的校验方法
     * @param index
     */
    protected void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }

    protected void rangeCheck(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }


}
