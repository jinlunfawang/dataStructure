package com.atguigu.structure


object BinarySearchDemo {
  def main(args: Array[String]): Unit = {
    val arr = Array(10, 20, 30, 33, 60, 100, 200, 1000,23)
    println(binarySearch(arr, 23, 0, arr.length - 1))
  }

  /**
    *
    * @param arr
    * @param ele
    * @param low  开始索引
    * @param high 结束索引
    * @return
    */
  def binarySearch(arr: Array[Int], ele: Int, low: Int, high: Int): Int = {

    if (low > high) -1
    else {
      var midIndex: Int = (low + high) / 2
      var midValue: Int = arr(midIndex)
      if (ele == midValue) midIndex
      else if (ele < midValue) {
        //元素小于折半位置的值, 则去左边查找
        binarySearch(arr, ele, low, midIndex - 1)
      } else {
        binarySearch(arr, ele, midIndex + 1, high)
      }
    }
  }


}
