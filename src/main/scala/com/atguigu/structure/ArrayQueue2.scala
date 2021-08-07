package com.atguigu.structure

import scala.reflect.ClassTag

/**
  * @Author: liangfangwei
  * @Date: 2020/6/18 20:23
  * @version 1.0
  */
object ArrayQueue2 {
  def main(args: Array[String]): Unit = {
    val queue2 = new Queue2[Int](4)
    queue2.inQueue(1)
    queue2.inQueue(2)
    queue2.inQueue(3)
    queue2.inQueue(4)
    queue2.inQueue(5)
    queue2.outQueue()
    queue2.outQueue()
    queue2.outQueue()
    queue2.printQueue


  }
}

/**
  * 使用数组来模拟队列
  *
  */
class Queue2[T: ClassTag](val initSize: Int) {
  val arr = new Array[T](initSize)

  // 指针
  var tail = 0
  var head = 0
  // 元素个数
  var count = 0

  // 判断是否满了 个数==初始化的个数
  def isFull1(): Boolean = {
    count == initSize
  }


  def isEmpty1(): Boolean = {
    count == 0
  }


  // 入队
  def inQueue(ele: T) {
    //  判断是否满了
    if (isFull1) throw new UnsupportedOperationException("骚年队列已经满了 你还加个毛毛线------")

    //  向对尾加元素
    arr(tail) = ele

    // conut+1
    count += 1

    // tail+1
    tail += 1
    // 如果tail执向最后一个 循环队列 tail=0 从头开始加

    if (tail == initSize)
      tail = 0


  }

  // 出队
  def outQueue(): Option[T] = {
    // 判断有没有元素
    if (isEmpty1) None
    // 取出对头元素
    var res = arr(head)
    // head向后移动一个
    head += 1
    count -= 1
    // 如果当前位置是最后一个 head重新指向头
    if (head == initSize) head == 0
    Some(res)
  }

  def printQueue: Unit = {
    var temp = head;
    for (i <- 0 until count) {
      print(arr(temp) + "->")
      temp += 1;
      if (temp == initSize) temp = 0
    }


  }
}