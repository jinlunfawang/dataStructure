package com.atguigu.structure

import scala.reflect.ClassTag

/**
  * @Author: liangfangwei
  * @Date: 2020/6/18 20:23
  * @version 1.0
  */
object ArrayQueue3 {
  def main(args: Array[String]): Unit = {

val queue = new Queue3[Int](5)
    queue.addQueueEle(1)
    queue.addQueueEle(2)
    queue.addQueueEle(3)
    queue.addQueueEle(4)
    queue.addQueueEle(5)
    queue.removeQueueEle()
    queue.removeQueueEle()
    queue.removeQueueEle()
    queue.printQueue()
  }
}

/**
  * 使用数组来模拟队列
  *
  */
class Queue3[T: ClassTag](val initSize: Int) {
  var arr = new Array[T](initSize)
  var tail = 0
  var head = 0
  var count = 0

  def isFull =
    count == initSize


  def isEmpty =
    count == 0

  // add ele

  def addQueueEle(ele: T): Unit = {
    if (isFull)
      throw new UnsupportedOperationException("都溢出来了 你还加")
    arr(tail) = ele
    tail += 1
    count += 1
    if (tail == initSize) head = 0

  }

  // remove ele
  def removeQueueEle(): Option[T] = {
    if (isEmpty) None
    var res = arr(head);
    head += 1
    count -= 1
    if (head == initSize) head = 0
    Some(res)
  }

  // print queue
  def printQueue() = {
    var tem = head;
    for (i <- 0 until count) {
      print(arr(tem) + "->");
      tem += 1
      if (tem == initSize) tem = 0
    }
  }
}