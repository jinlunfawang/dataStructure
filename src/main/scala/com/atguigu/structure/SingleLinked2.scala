package com.atguigu.structure

/**
  * 单列表
  */
object SingleLinked2 {
  def main(args: Array[String]): Unit = {
    var list3 = new SingleLinkedList2[String]
    list3.addEle("1")
    list3.addEle("2")
    list3.addEle("3")
    list3.addEle("4")
    list3.addEle("5")
    list3.deleteEle("2")
    list3.printInfo()

  }
}


class SingleLinkedList2[T] {

  case class Node(value: T, var next: Node)

  private var head: Node = _;
  private var tail: Node = _;

  /**
    * 添加
    *
    * @param ele
    */
  def addEle(ele: T): Unit = {
    // 没有元素的时候 初始化头节点和尾节点
    if (head == null) {
      head = Node(ele, null)
      tail = head;

    } else {
      // 有元素的时候 只维护tail元素
      tail.next = Node(ele, null)
      tail = tail.next

    }


  }

  def contain(ele: T): Boolean = {

    // 是否有元素
    if (head == null) return false
    // 有元素
    else {
      // 取出每个值 赋值给临时变量比较
      var tem: Node = head
      do {
        if (tem.value == ele) return true
        tem = tem.next
      } while (tem != null)

      false
    }
  }

  /**
    * 删除元素
    *
    * @param ele
    * @return
    */
  def deleteEle(ele: T): Boolean = {
    //1. 当是空的时候
    if (head == null) false
    //2.当删除头元素的时候
    if (head.value == ele) {
      // 没有下一个元素
      if (head.eq(tail)) {
        tail = null;
      }
      // 有下一个元素
      head = head.next;
      true

    } else {
      //删除非头元素
      var currentNode: Node = head;
      var nextNode: Node = currentNode.next;
      while (nextNode != null) {
        if (ele == nextNode.value) {
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

  def printInfo(): Unit = {
    if (head == null) return
    var tmp: Node = head
    do {
      print(tmp.value + "->")
      tmp = tmp.next
    } while (tmp != null)
  }

}