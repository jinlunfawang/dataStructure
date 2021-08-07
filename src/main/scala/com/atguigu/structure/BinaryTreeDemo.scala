package com.atguigu.structure

/**
  * @Author: liangfangwei
  * @Date: 2020/6/23 15:44
  * @version 1.0
  */
object BinaryTreeDemo {
  def main(args: Array[String]): Unit = {
  val tree = new BinartTree[Int](10)
    tree.isRoot=true
    tree.left = new BinartTree[Int](9)
    tree.right=new BinartTree[Int](20)
    tree.right.left=new BinartTree[Int](15)
    tree.right.right=new BinartTree[Int](36)
                 // 调用的时候传实际的参数
   //    tree.preForeach(x=>println(x))
    tree.midForeach(println(_))
  }
}

/**
  *  二叉树
  * @param value
  * @tparam T
  */
class BinartTree[T](val value:T){
  var isRoot:Boolean=false
  // 左子树
  var left: BinartTree[T] = _
  // 右子树
  var right: BinartTree[T] = _

  /**
    * 先序遍历
    * @param op
    */
  def preForeach(op:T=>Unit):Unit={
     op(value) // 当前节点 实际的函数
    if(left!=null) left.preForeach(op)
    if(right!=null) right.preForeach(op)

  }

  /**
    * 中序
    * @param op
    */
  def midForeach(op:T=>Unit):Unit={
    if(left!=null) left.midForeach(op)
    op(value)
    if(right!=null) right.midForeach(op)
  }
}





// 二叉树的一个节点
/*
class BinaryNode[T] {
  var left: BinaryNode[T] = _
  var right: BinaryNode[T] = _
  var value:T=_
}*/
