package com.atguigu.structure


object HashTableDemo {
  def main(args: Array[String]): Unit = {
    val hashTable = new HashTables[Int]
    hashTable.addEle(10)
    hashTable.addEle(20)
    hashTable.addEle(20)
    hashTable.deleteEleHashCode(20)
    hashTable.printAll()
  }
}

class HashTables[T] {
  val initSize: Int = 100
  var arr: Array[DoubleLinkedList[T]] = new Array[DoubleLinkedList[T]](100)

  /**
    * 添加元素
    *
    * @param e
    */
  def addEle(e: T): Unit = {
    // 找到e元素应该取那个链表所在数组的索引
    var index = e.hashCode().abs % initSize
    // 向链表中添加元素
    if (arr(index) == null)
      arr(index) = new DoubleLinkedList[T]
    arr(index).addEle(e)
  }
  // 删除元素
def deleteEleHashCode(e:T):Unit={
  var index =e.hashCode().abs%initSize
     arr(index).deleteEle(e)
}

  /**
    * 输出元素
    */
  def printAll(): Unit = {
    for (i <- 0 until arr.length) {
      var list:DoubleLinkedList[T] = arr(i)
      print(s"$i: ")
      if (list != null) {
        list.printfEle
      }
      println()
    }
  }
}