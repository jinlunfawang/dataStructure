package com.java.liangfwDS.linkedListExercise;

/**
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2021/4/19 16:22
 */
public interface List<T> {

    static final int ELEMENT_NOT_FOUND = -1;

    void add(int index, T ele);

    T get(int index);

    T set(int index, T ele);

    void remove(int index);

    int indexOf(T ele);

    void clear();



}




