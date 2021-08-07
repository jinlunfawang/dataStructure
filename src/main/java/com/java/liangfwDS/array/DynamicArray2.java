package com.java.liangfwDS.array;



/**
 * 自定义可以存放任何类型的动态数组 所以需要定义:泛型
 * <p>
 * 泛型:new 对象根据传入的类型,确定类中泛型所表示的对象
 * 泛型的本质:占位符
 * 泛型的好处:扩展类参数或者返回值的类型 提高类的通用性  如果没有泛型需要在定义类指定参数和返回值类型，
 *
 * 有缩容的
 */
public class DynamicArray2<T> {

    // ------------1.属性-------------
    private T[] elements;
    private int size;
    // 数组默认容量 常数定值只有一份 不用变
    private static final int DEFAULT_CAPACITY = 10;
// 元素不存在
    private static final int ELEMENT_NOT_FOUND = -1;
   // 记录扩容次数 只是为了方便显示而已
    private static int sumCampacity=0;
    // ------------2.构造器-------------

    /**
     * 默认构造10的大小
     */
    public DynamicArray2() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 传入其他长度的构造函数
     *
     * @param capacity
     */
    public DynamicArray2(int capacity) {
        elements = (T[]) new Object[capacity];

    }

    // ------------3.方法-------------

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
        return size == 0;
    }

    ;

    /**
     * 是否包含某一个元素
     *  查找元素的角标只要不是-1 即有这个元素
     *
     * @param ele
     * @return
     */
    public boolean contains(T ele) {

        return indexOf(ele) != ELEMENT_NOT_FOUND;

    }

    ;
    /**
     * 某一个位置添加一个具体的元素
     *
     * @param index
     * @param ele
     */
    public void add(int index,  T ele) {

        //1. 判断index是否合法
        if(index<0||index >size) throw new IllegalArgumentException("index illegal ");

        //2. 扩容后添加
        if (size == index) {
            // 位运算效率高 扩容1.5倍
            int newCampacity=size+(size>>1);
            T[] newElements = (T[])new Object[newCampacity];
            for (int i = 0; i < size; i++) {
                newElements[i]=elements[i];
            }
            elements=newElements;
            for (int i = size-1; i < index; i--) {
                elements[i]=elements[i-1];
            }
            size++;
            elements[index]=ele;

        }else {
            //3.不需要扩容添加
            for (int i = size; i > index; i--) {
                elements[i]=elements[i-1];
            }
            size++;
            elements[index]=ele;

        }

    };

    /**
     * 添加元素到数组尾部
     *
     * @param ele
     */
    public void add(T ele) {
        add(size, ele);
    }


    public T get(int index) {
        if(index<0||index >=size) throw new IllegalArgumentException("index illegal ");
        return elements[index];
    };

    public T set(int index, T ele) {
        if(index<0||index >=size) throw new IllegalArgumentException("index illegal ");
         elements[index]=ele;
         return  ele;

    };



    /**
     * 删除 index位置的元素 将index+1 向前移动
     *
     * @param index
     */
    public void remove(int index) {

        for (int i = index; i < size; i++) {
            elements[i]=elements[i+1];
        }
        elements[--size]=null;
    }

    ;

    /**
     * 查看元素索引
     *
     * @param ele
     */
    public int indexOf(T ele) {
        for (int i = 0; i < size; i++) {
            if(elements[i].equals(ele)) return i;

        }

      return ELEMENT_NOT_FOUND;

    }

    ;

    /**
     * 清楚所有元素
     * 1.size=0
     * 2.让对象没有引用 对象为null
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i]=null;

        }
        size=0;

    }

    ;

    /**
     * toString 拼接字符串
     *
     * size: [ 1,2,3]
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        //1 拼接size
        stringBuilder.append("size : ").append(size).append("  ").append("[ ");
        //2 拼接数组内容
        for (int i = 0; i < size; i++) {
            if(i==size-1) stringBuilder.append(elements[i]).append("]");
            else stringBuilder.append(elements[i]).append(",");
        }
        return stringBuilder.toString();

    }
}

