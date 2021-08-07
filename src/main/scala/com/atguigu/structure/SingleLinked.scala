package com.atguigu.structure

/**
  * 单列表
  */
object SingleLinked {
  def main(args: Array[String]): Unit = {
    var linkedList = new SingleLinkedList[Int]();
    linkedList.add(2)
    linkedList.add(2)
    print(linkedList.printInfo())
  }
}


class SingleLinkedList[T] {

  // respect a node
  case class Node(vale: T, var next: Node)

  private var head: Node = _;
  // 为了提高添加效率  设置一个尾节点
  private var tail: Node = _;

  /**
    * 向 单链表添加元素
    */
  def add(ele: T): Boolean = {
    if (head == null) {
      // 头节点一旦确定, 后续不再变化(除非删除)  
      head = Node(ele, null)
      tail = head
    }
    else {
      tail.next = Node(ele, null)
      tail = tail.next // tail 指向新节点
    }
    true
  }

  /**
    * 删除元素
    * @param ele
    * @return
    */
  def delete(ele: T): Boolean = {
    // 1.没有数据直接 返回false
    if (head == null) false
    // 2.删除头节点
    if (head.vale == ele) {
      if (head.eq(tail)) {
        tail = head.next
      }
      head = head.next
       true
    } else { //3.非头节点
      var currentNode: Node = head
      var nextNode: Node = currentNode.next
      while (nextNode != null) {
        if (nextNode.vale == ele) {
          // 删除
          currentNode.next = nextNode.next
          if (nextNode.eq(tail)) {
            tail = currentNode
          }
           true
        }
        currentNode = nextNode
        nextNode = currentNode.next
      }
      false

    }
  }

  /**
    *
    * 测试指定元素是否存在
    */
  def contains(ele: T): Boolean = {
    if (head == null) false
    var tmp: Node = head
    do {
      if (tmp.vale == ele) return true
      tmp = tmp.next
    } while (tmp != null)
    false
  }

  /**
    * 打印列表
    */
  def printInfo(): Unit = {
    if (head == null) return
    var tmp: Node = head
    do {
      print(tmp.vale + "->")
      tmp = tmp.next
    } while (tmp != null)
  }
}