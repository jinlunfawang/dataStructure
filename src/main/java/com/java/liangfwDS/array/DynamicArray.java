package com.java.liangfwDS.array;




/**
 * 自定义动态数组
 *
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2021/4/8 9:03
 */
public class DynamicArray<E> {

    /**
     * 数组中元素的数量
     */
    private int size;

    /**
     * 数组开辟空间的大小
     */
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENT_NO_FOUND = -1;

    /**
     * 默认构造10的大小
     */
    public DynamicArray() {
        // this 代表前对象
        this(DEFAULT_CAPACITY);
    }

    /**
     * 传入其他长度的构造函数
     *
     * @param capacity
     */
    public DynamicArray(int capacity) {
        capacity = (capacity > DEFAULT_CAPACITY) ? capacity : DEFAULT_CAPACITY;
        elements = (E[]) new Object[capacity];
    }

    /**
     * 元素的数量
     *
     * @return
     */
    public int size() {
        return size;

    }

    ;

    /**
     * 是否为空
     *
     * @return
     */
    public boolean isEmpty() {

        // 这种写法太复杂了 可以为简写一下  boolean flag=size==0?true:false;
        return size == 0;

    }

    ;

    /**
     * 是否包含某一个元素
     *
     * @param ele
     * @return
     */
    public boolean contains(E ele) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == ele) {
                return true;
            }
        }
        return false;

    }

    ;

    /**
     * 添加元素到数组尾部
     *
     * @param ele
     */
    public void add(E ele) {
        //1.是否满了
        // 1.1 没满直接添加
        if (size < elements.length) {
            elements[size] = ele;
            size++;
        } else {
            //1.2. 满了 扩容后再加
            E[] dynamicArray = (E[])new Object[2 * size];
            for (int i = 0; i < elements.length; i++) {
                dynamicArray[i] = elements[i];
            }
            elements = dynamicArray;
            elements[size] = ele;
            size++;
        }
    }


    public E get(int index) {
        // 异常比return 更能定位大到问题的所在
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("index 异常");
        else return elements[index];

    }

    ;

    public E set(int index, E element) {
        if (index < 0 || index >=size) throw new IndexOutOfBoundsException("index out bounds");
        else {
            E oldEle = elements[index];
            elements[index] = element;
            return oldEle;
        }

    }

    ;

    /**
     * 某一个位置添加一个具体的元素
     *
     * @param index
     * @param ele
     */
    public void add(int index, E ele) {
  // index 只能在 0--size 之间
        if (index < 0||index >=size) throw new IndexOutOfBoundsException("index out bounds");
        // 1 判断是否扩容 不扩容
        if (size + 1 <= elements.length) {
            // 1.1 index 到size-1 位置的元素都往后移动
            for (int i = size - 1; i >= index; i--) {
                elements[i + 1] = elements[i];
            }
            elements[index]=ele;
            size++;
                //1.2
        } else {
            // 2. 扩容
            //1.2. 满了 扩容后再加 扩容为1.5倍 位运算效率高
            int newCapacity=size+(size>>2);
            E[] dynamicArray = (E[])new Object[newCapacity];
            for (int i = 0; i < elements.length; i++) {
                dynamicArray[i] = elements[i];
            }
            elements = dynamicArray;
            add(index, ele);
            //2.1 先扩容 再添加
        }
        return;

    }

    ;

    /**
     * 删除 index位置的元素 将index+1 向前移动
     *
     * @param index
     */
    public void remove(int index) {
        if (index < 0 || index >= size )
            throw new IllegalArgumentException("index illegal");

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        elements[size]=null;
    }

    ;

    /**
     * 查看元素索引
     *
     * @param ele
     */
    public int indexOf(E ele) {
        if (contains(ele)) {
            for (int i = 0; i < size; i++) {
                // 等号比较内存地址
                if (elements[i].equals(ele)) {
                    return i;
                }
            }

        }
        return ELEMENT_NO_FOUND;
    }

    ;

    /**
     * 清楚所有元素 size=0 如果對於兌現
     * 让对象没有引用
     */
    public void clear() {

        for (int i = 0; i < size; i++) {
            elements[i]=null;

        }

        size = 0;
    }

    ;

    /**
     * toString 拼接字符串 size: [ 1,2,3]
     */
    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size: ").append(size).append("  [ ");

        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                stringBuilder.append(elements[i]);
                break;
            }
            stringBuilder.append(elements[i]).append(",");
        }
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }
}
