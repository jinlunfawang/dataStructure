package com.atguigu.structure

/**
  * 单列表
  */
object SingleLinked3 {
  def main(args: Array[String]): Unit = {
    var list = new SingleLinkedList3[Int];
    list.addEle(1);
    list.addEle(2);
    list.addEle(3);
    list.addEle(4);
    list.addEle(5);
    list.addEle(6);
    list.addEle(7);
    list.addEle(8);
    list.deleteEle(7)
    list.printLinkList()

  }
}


class SingleLinkedList3[T] {

  // 定义一个节点
  case class Node(value: T, var next: Node)
  // 头节点
  private var head: Node = _;
  // 尾节点
  private var tail: Node = _;

  /**
    * 添加元素
    *
    * @param ele
    */
  def addEle(ele: T) {

    if (head == null) {
      head = Node(ele, null)
      tail = head
    } else {
      tail.next = Node(ele, null)
      tail = tail.next;

    }

  }

  /**
    * 包含
    */
  def containEle(ele: T): Boolean = {
    if (head == null) {
      false
    } else {
      // 从头取出来每一个值 赋值给临时变量  依次遍历
      var tem: Node = head
      do {
        if (tem.value == ele) return true
        tem = tem.next
      } while (tem != null)
      false
    }
  };

  /**
    * 删除元素
    */
  def deleteEle(ele: T): Boolean = {
    //1 .为空
    if (head == null) false
    //2 不为空
    //2.1 删除头元素
    if (ele == head.value) {
      head = head.next
      true
    } else {
      // 2.2删除非头元
      var currentNode: Node = head;
      var nextNode: Node = currentNode.next;
      // 找到要删除的节点
      while (nextNode != null) {
        if (nextNode.value == ele) {
          currentNode.next = nextNode.next;
          return true;
        }
        currentNode = nextNode
        nextNode = currentNode.next
      }
      false
    }
  }

  /**
    * 打印
    */
  def printLinkList() {
    if (head == null) return
    var tem: Node = head
    do {
      print(tem.value + "->");
      tem = tem.next
    } while (tem != null)

  }

}

