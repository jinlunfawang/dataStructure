package com.atguigu.structure

/**
  * 单列表
  */
object DobuleLinked2 {
  def main(args: Array[String]): Unit = {
    val doubleLinked = new DobuleLinkedList2[Int]()
    doubleLinked.add(1)

    doubleLinked.delete(4)
    doubleLinked.printInfo()


  }
}


class DobuleLinkedList2[T] {

  // respect a node
  case class Node(var pre: Node, value: T, var next: Node)

  private var head: Node = _;
  // 为了提高添加效率  设置一个尾节点
  private var tail: Node = _;

  /**
    * 向双链表中添加元素
    */
  def add(ele: T): Boolean = {
    var newNode: Node = Node(null, ele, null);
    //1头元素 tail=head
    if (head == null) {
      head = newNode;
      //2 非 tail=newNode
    } else {
      tail.next = newNode
      newNode.pre = tail
    }
    tail = newNode
    true
  }

  def findEle(ele: T): Node = {
    var tem: Node = head
    while (tem != null) {
      if (tem.value == ele) {
        return tem
      }
      tem = tem.next
    }
    null

  }

  /**
    * 删除元素
    *
    * @param ele
    * @return
    */
  def delete(ele: T): Boolean = {
    if (head == null) true;
    // 头节点
    if (head.value == ele) {
      var nextNode: Node = head.next
      nextNode.pre = null
      head = nextNode;
      return true
    }
    if(tail.value==ele){
      var ptailNode:Node=tail.pre;
      ptailNode.next=null
      tail==ptailNode
      return true
    }
    //非头节点 找到要删除的元素 find.next find.per
    var findNode: Node = findEle(ele);
    var findNextNode: Node = findNode.next
    var findPreNode: Node = findNode.pre
    findNextNode.pre = findPreNode
    findPreNode.next = findNextNode
    true

  }


  /**
    * 打印列表
    */
  def printInfo(): Unit = {
    var tem: Node = head;
    while (tem != null) {
      print(tem.value + "-》")
      tem = tem.next
    }
  }
}