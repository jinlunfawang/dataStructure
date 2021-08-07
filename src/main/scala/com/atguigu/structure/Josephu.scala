package com.atguigu.structure

/**
  * 约瑟夫问题
  *
  */
object Josephu {
  def main(args: Array[String]): Unit = {
    print("留下来的是:" + start(5, 2, 2) + "号")
  }

  /**
    *
    * @param n n个人围成一桌
    * @param k 从k开始数
    * @param m 数到m的那个人出圈
    *     解决思路 循环列表
    *     find 开始的元素.pre
    *     循环指定的次数删除元素
    *
    *
    *
    *
    */
  def start(n: Int, k: Int, m: Int) = {

    val list = new CricuLinkedlist[Int]
    // 构建n个循环链表
    for (i <- 1 to n) {
      list.addEle(i)
    }
    list.printfEle
    // 找到开始的节点
    var startNode: list.Node = list.find(k).pre
    // 开始出圈 当只剩下一个人的时候 游戏结束
    while (list.len!=1) {
      for (num <- 1 to m) {
        startNode = startNode.next
      }
      list.deleteEle(startNode.vale)
      print(startNode.vale+"->")
      startNode = startNode.pre

    }

    list.head.vale
  }

}
