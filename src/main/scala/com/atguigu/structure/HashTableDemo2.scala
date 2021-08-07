package com.atguigu.structure


/**
  * hashTable的数据结构
  *
  */
object HashTableDemo2 {
  def main(args: Array[String]): Unit = {
    val hashTable = new HashTables2[String]
    hashTable.addEle("hello")
    hashTable.addEle("world")
    hashTable.addEle("world")

    hashTable.printAll()
  }
}

class HashTables2[T] {
  private var initSize:Int=100
  // hashTable的结构
  private var array = new Array[DoubleLinkedList[T]](initSize)


  /**
    * 添加元素
    *
    * @param e
    */
  def addEle(e: T): Unit = {
  val index = e.hashCode().abs%initSize
    if(array(index)==null){
      array(index)=new DoubleLinkedList[T]
    }
      array(index).addEle(e)

  }
  // 删除元素
def deleteEleHashCode(e:T):Unit={

}

  /**
    * 输出元素
    */
  def printAll(): Unit = {
    for (i <- 0 until array.length) {
      var list:DoubleLinkedList[T] = array(i)
      print(s"$i: ")
      if (list != null) {
        list.printfEle
      }
      println()
    }
  }
}