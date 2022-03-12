package com.java.liangfwDS.sort;


import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 插入排序 从n找最小 再从n-1 找最小
 * 8W   - 2s
 * <p>
 */
public class SelectBubbling {
    @Test
    /**
     * 最原始的:写法 一步一步写
     */
    public void test1() {
        int[] array = new int[]{6, 3, 42, 4, 2};
        /*for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100 + 1);
        }*/
        int minValue=array[0];
        int minIndex=0;
        //1. 第一趟排序 从最小索引0+1 开始比较
        for (int i = 0+1; i <array.length; i++) {
             if(minValue>array[i]){
                 minValue=array[i];
                 minIndex=i;
             }
        }
       // 将最小的放在第一个位置 交换minIndex位置和第一个位置的值
        if(minIndex!=0) {
            array[minIndex] = array[0];
            array[0] = minValue;
        }

         minValue=array[1];
         minIndex=1;
     //2. 第二趟排序
        for (int i = 0+1+1; i < array.length; i++) {
            if(minValue>array[i]){
                minValue=array[i];
                minIndex=i;
            }
        }

        if(minIndex!=1) {
            array[minIndex] = array[1];
            array[1] = minValue;
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(array[i]);
        }
    }

    @Test
    /**
     * 最后的样子
     * 20W      15S
     */
    public void test2() {
        int[] array = new int[200000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 200000 + 1);
        }

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("开始时间为" + format);
        for (int j = 0; j < array.length; j++) {
            int minValue=array[j];
            int minIndex=j;
            //1. 第一趟排序 从最小索引0+1 开始比较
            for (int i = j+1; i <array.length; i++) {
                if(minValue>array[i]){
                    minValue=array[i];
                    minIndex=i;
                }
            }
            // 将最小的放在第一个位置 交换minIndex位置和第一个位置的值
            if(minIndex!=j) {
                array[minIndex] = array[j];
                array[j] = minValue;
            }
        }

        Date endDate = new Date();
        String format1 = simpleDateFormat.format(endDate);
        System.out.println("结束时间为" + format1);
        for (int i = 0; i < 5; i++) {
            System.out.println(array[i]);
        }

    }


    @Test
    /**
     * 从头到尾 依次作为基准数 和剩余的数两两比较
     * 选择排序:
     * 第一趟：选第一个数作为基准值 找出最小的
     * 第二趟：选选第二个数为基准值 从剩下的找出最小的
     * 20W      15S
     */
    public void test3() {
        int[] array = new int[200000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 200000 + 1);
        }

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("开始时间为" + format);

        //1.从头位置选择基准数
        for (int i = 0; i <array.length-1 ; i++) {
            //2.选择的基准数 用这个数比较
            int minValue=array[i];
            int minIndex=i;
            //3.从基准数的位置向后两两比较 找出待排序数的最小值
            for (int j = i+1; j < array.length; j++) {
                if(minValue>array[j]){
                    minIndex=j;
                    minValue=array[j];
                }

            }
            //4 找出最小值基准位置后的最小值了 和基准位置交换
            if(minIndex!=i){
                array[minIndex]=array[i];
                array[i]=minValue;
            }
        }

        Date endDate = new Date();
        String format1 = simpleDateFormat.format(endDate);
        System.out.println("结束时间为" + format1);
        for (int i = 0; i < 50; i++) {
            System.out.println(array[i]);
        }

    }

@Test
    public void test4() {
        int[] array = new int[80000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 80000 + 1);
        }

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("开始时间为" + format);
        for (int i = 0; i < array.length; i++) {
            int minValue=array[i];
            int minIndex=i;

            for (int j = i+1; j <array.length ; j++) {
                if(minValue>array[j]){
                    minIndex=j;
                    minValue=array[j];
                }

            }

            // 交换位置
            if(minIndex!=i){
                array[minIndex]=array[i];
                array[i]=minValue;

            }
        }


        Date endDate = new Date();
        String format1 = simpleDateFormat.format(endDate);
        System.out.println("结束时间为" + format1);
        for (int i = 0; i < 50; i++) {
            System.out.println(array[array.length-1-i]);
        }

    }

}
