package com.atguigu.structure

import scala.reflect.ClassTag

/**
  * 定义一个队列 使用循环队列
  */
object ArrayQueue {
  def main(args: Array[String]): Unit = {

    val queue = new Queue[Int](4)
    queue.enQueue(1)
    queue.enQueue(2)
    queue.enQueue(3)
    queue.enQueue(4)
    queue.PrintQueue
    print("***************")
    queue.deQueue();
    queue.deQueue();
    queue.deQueue();
    queue.deQueue();
    queue.PrintQueue

  }
}

/**
  * 使用数组来模拟队列
  *
  */
class Queue[T: ClassTag](val initSize: Int) {
  // 内置数组 存储元素
  val arr = new Array[T](initSize);
  // 队列中元素的个数
  var count: Int = 0
  // 队列头部
  var head: Int = 0
  // 队列尾部: 指向队列中下一个要添加的元素的位置  
  var tail: Int = 0

  // 是否为空
  def isFull =
    count == 0
  // 是否满了
  def isEmpty = count == initSize
  //  入队方法
  def enQueue(ele: T): Unit = {
    //1.判断不为空
    if (isEmpty)
      throw new UnsupportedOperationException("队列已满, 不能再添加元素....")
    //2加入元素
    arr(tail) = ele
    tail += 1
    count += 1
    // tail 到了数组的尾部, 则从头开始  
    if (tail == initSize) tail = 0;
  }

  def deQueue(): Option[T] = {
    //1. 判断为空
    if (isFull)
      None
    //2. 取出对尾元素
    count -= 1
    var res = arr(head)
    head += 1
    if (head == initSize)
      head = 0
    Some(res)
  }

  def PrintQueue: Unit = {
    var temp = head;
    for (i <- 0 until count) {
      print(arr(temp) + "->")
      temp += 1;
      if (temp == initSize) temp = 0
    }

  }

}