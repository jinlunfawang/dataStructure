package com.atguigu.structure

import scala.util.Random
import scala.util.control.Breaks._

object Sort {

  def randomArr() ={
    val random=new Random()
    (1 to 1000000).map(_=>random.nextInt()).toArray
  }
  def main(args: Array[String]): Unit = {
    var arr = Array(45, 46, 5, 6, 1, 4, 3, 2)
    //  bubbleSort2(arr)
    // insetSort(arr)
    val start:Long = System.currentTimeMillis()
   quickSort(randomArr())
 //   bubbleSort(randomArr())
    print(System.currentTimeMillis()-start)
   /* for (i <- 0 to arr.length - 1) {
      print(arr(i) + "->")
    }*/
  }


  /**
    * 冒泡排序
    *
    * @param arr
    */
  def bubbleSort(arr: Array[Int]) {
    // 需要对多少个元素进行排序
    for (i <- 0 until arr.length - 1) {
      //  排好最大的
      for (j <- 0 until arr.length - i - 1) {
        if (arr(j) > arr(j + 1)) {
          var tem = arr(j);
          arr(j) = arr(j + 1)
          arr(j + 1) = tem
        }
      }
    }

  }

  /**
    * 冒泡排序2
    *
    * @param arr
    */
  def bubbleSort2(arr: Array[Int]) {
    // 比较的次数
    for (j <- 0 to arr.length - 2) {
      // 找出最大的
      for (i <- 0 to arr.length - 2 - j) {
        if (arr(i) > arr(i + 1)) {
          var tem = arr(i)
          arr(i) = arr(i + 1)
          arr(i + 1) = tem
        }
      }

    }
  }

  /**
    * 插入排序
    *
    * @param arr
    */
  def insetSort(arr: Array[Int]) {
    //一共arr.length-1个元素需要比较
    for (j <- 0 until arr.length - 1) {
      breakable {
        // 一个元素需要比较的次数
        for (i <- j + 1 until(0, -1)) {
          if (arr(i) < arr(i - 1)) {
            var tem = arr(i);
            arr(i) = arr(i - 1)
            arr(i - 1) = tem
          } else {
            break
          }
        }
      }
    }

  }

  /**
    * 插入排序2
    *
    * @param arr
    */
  def insetSort2(arr: Array[Int]) {

    for (i <- 0 to arr.length - 1) {
      breakable {
        for (j <- i + 1 until(0, -1)) {
          if (arr(j) < arr(j - 1)) {
            var tem = arr(j)
            arr(j) = arr(j - 1)
            arr(j - 1) = tem
          } else {
            //  后面的元素不需要比较了
            break
          }
        }

      }
    }

  }


  /**
    * 快速排序
    */
  def quickSort(arr: Array[Int]): Unit = {

    //分区 返回基准值的正确的位置
    def paratinon(arr: Array[Int], left: Int, right: Int): Int = {
      // 左指针 向右走
      var l: Int = left
      var r: Int = right
      var p: Int = arr(left)
      while (r > l) {
        //  左指针向右走 大于基准值的时候停下来
        while (arr(l) <= p && l < right) {
          l += 1
        }
        // 有指针向左走 小于基准值的时候婷下
        while (arr(r) >= p && left < r) {
          r -= 1
        }
        if (l <= r) {
          // 交换两个元素
          var tem = arr(l)
          arr(l) = arr(r)
          arr(r) = tem
        }
      }
      var tem = arr(left)
      arr(left) = arr(r)
      arr(r) = tem
      // 直到两个值相遇 返回基准值的位置
      r
    }

    // 排序 left开始的坐标 right 结束的坐标
    def quick(arr: Array[Int], left: Int, right: Int): Unit = {
      // 左指针与右指针重合
      if (left >= right) return
      // 基准位置右边比基准打 左边比基准小
      var mid: Int = paratinon(arr, left, right)
      // 对左边排序 递归调用
      quick(arr, left, mid - 1);
      quick(arr, mid + 1, right);
    }
      quick(arr, 0, arr.length - 1)
  }


  /**
    * 归并排序
    */

  def mergeSort(arr:Array[Int]): Unit ={

    def sort(arr:Array[Int],start:Int,stop:Int): Unit ={

    }
    sort(arr,0,arr.length-1)
  }
}





