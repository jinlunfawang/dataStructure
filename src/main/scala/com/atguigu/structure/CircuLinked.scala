package com.atguigu.structure

object CircuLinked {
  def main(args: Array[String]): Unit = {
    val cricu = new CricuLinkedlist[Int]
    cricu.addEle(1)
    cricu.addEle(2)
    cricu.addEle(3)
    cricu.addEle(4)
    cricu.addEle(5)
    cricu.deleteEle(1)
    cricu.printfEle
  }
}
// 循环列表
class CricuLinkedlist[T] extends DoubleLinkedList[T] {


  var len: Int = 0
  /**
    * 元素的个数
    */
  def length = len

  /**
    * 添加元素 每次加元素 头尾指针都指一次
    *
    * @param ele
    * @return
    */

  override def addEle(ele: T): Boolean = {
    super.addEle(ele)
    if(head.eq(tail)){
      return false
    }
    tail.next = head
    head.pre = tail
    len += 1
    true
  }

  /**
    * 删除元素 每次加元素 头尾指针都指一次
    *
    * @param ele
    * @return
    */
  override def deleteEle(ele: T): Boolean = {
    if (super.deleteEle(ele)) {
      head.pre = tail
      tail.next = head
      len -= 1
      true
    } else {
      false
    }
  }

  /**
    * 查找元素
    */

  override def find(ele: T): Node = {
    var tem: Node = head
    while (tem != null) {
      if (ele == tem.vale) return tem
      if (tem.eq(tail)) return null
      tem = tem.next;

    }
    null
  }

  override def printfEle: Unit = {

    if (head == null) return
    var tem: Node = head;
    while (true) {
      if (tem.eq(tail)) {
        println(tem.vale)
        return
      } else {
        print(tem.vale + "->")
      }
      tem = tem.next
    }
  }
}