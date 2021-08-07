package com.atguigu.structure

/**
  * 双向列表
  */
object DoubleLinked {
  def main(args: Array[String]): Unit = {
    val doubleLinked = new DoubleLinkedList[Int]()
    doubleLinked.addEle(1)

    doubleLinked.deleteEle(1)
    doubleLinked.printfEle;
  }
}


class DoubleLinkedList[T] {

  // respect a DoubleNode
  case class Node(var next: Node, var vale: T, var pre: Node)
  var head: Node = _
  var tail: Node = _

  /**
    * 新增元素
    *
    * @param ele
    * @return
    */
  def addEle(ele: T) = {
    var newNode: Node = Node(null, ele, null)
    //1 头元素  pre=null
    if (head == null) {
      head = newNode

    } else {
      // 2非头 tail尾指向新节点 新节点前指针指向节点 更新尾节点
      tail.next = newNode
      newNode.pre = tail
    }
    tail = newNode
    true
  }

  /**
    * 打印元素
    */
  def printfEle: Unit = {
    if (head == null) return
    var tem: Node = head;
    while (tem != null) {
      print(tem.vale + "->")
      tem = tem.next
    }
    println()
  }

  /**
    * 删除元素  讲义版本
    */

  def deleteEle(ele: T): Boolean = {
    var targetNode: Node = find(ele);
    if (targetNode == null) {
      false
    } else { // 删除的节点存在
      var preNode: Node = targetNode.pre
      var nextNode: Node = targetNode.next
      if (targetNode == head) { // 删除的是头节点
        if(head.next!=null){
          nextNode.pre = null
          head = nextNode
        }else{
          head=null
          tail=null
        }

      } else if (targetNode == tail) { // 尾节点
        preNode.next = null
        tail = preNode
      } else {
        preNode.next = nextNode
        nextNode.pre = preNode
      }
      true
    }


  }

  def find(ele: T): Node = {
    var tem: Node = head
    while (tem != null) {
      if (ele == tem.vale) return tem
      tem = tem.next;
    }
    null
  }

}