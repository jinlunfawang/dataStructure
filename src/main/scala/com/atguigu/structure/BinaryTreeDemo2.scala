package com.atguigu.structure

/**
  * 普通的有序二叉树结构
  */
object BinaryTreeDemo2 {
  def main(args: Array[String]): Unit = {

    val tree = new BinartTree2[Int](10)
    tree.isRoot=true
    tree.rightTree = new BinartTree2[Int](9)
    tree.leftTree=new BinartTree2[Int](20)
    tree.leftTree.leftTree=new BinartTree2[Int](15)
    tree.leftTree.rightTree=new BinartTree2[Int](36)
    tree.preForeach(println(_))

  }
}

/**
  *  代表一个子树
  * @param value
  * @tparam T
  */
class BinartTree2[T](val value:T) {
  var isRoot:Boolean=false
  // 左子树
  var leftTree:BinartTree2[T]=_
  // 右子树
  var rightTree:BinartTree2[T]=_

  /**
    * 先序遍历
    *
    * @param op
    */
  def preForeach(op: T => Unit): Unit = {
     op(value)
    if(leftTree!=null) leftTree.preForeach(op)
    if(rightTree!=null) rightTree.preForeach(op)

  }


}
