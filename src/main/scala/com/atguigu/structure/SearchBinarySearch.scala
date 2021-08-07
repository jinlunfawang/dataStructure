package com.atguigu.structure


object SearchBinarySearch {
  // 初始化一个排序二叉树
  def initSBT(arr: Array[Int]) = {
    val sbt = new SearchBinaryTree[Int]()
    arr.foreach(x => {
      sbt.addNode(x)
    })
    sbt
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(8, 4, 9, 10, 1, 6, 7, 12)
    val sbt = initSBT(arr)
    sbt.midForeach(println)

  }

}

class SearchBinaryTree[T: Ordering] {
  private val ord: Ordering[T] = implicitly[Ordering[T]]
  // 根节点
  var root: TreeNode[T] = _

  /**
    * 向二叉树中插入节点
    *
    * @param v
    */
  def addNode(v: T) = {
    if (root == null) root = new TreeNode[T](v) // 如果是第一次添加
    else {
      // 不是第一次添加   交给root去完成
      root.add(v)
    }
  }

  def midForeach(op: T => Unit): Unit = {
    if (root != null)
      root.midForeach(op)
  }

}

/**
  * 表示一个树的节点
  *
  * @param value
  * @tparam T
  */
class TreeNode[T: Ordering](var value: T) {
  private val ord: Ordering[T] = implicitly[Ordering[T]]
  // 根节点
  var root: TreeNode[T] = _
  var left: TreeNode[T] = _
  var right: TreeNode[T] = _

  // 添加节点
  def add(v: T): Boolean = {
    // 要么添加左子树 要么添加右子树
    if (ord.lteq(v, value)) { // 要添加的值小于等于当前root节点的值
      // 如果左节点是null 新添加的值直接为左节点
      if (left == null) { //
        left = new TreeNode[T](v) // 如果左节点是null 则新添加的值直接为左节点
      } else left.add(v) // 否则交给左节点继续处理
    } else {
      if (right == null) { //
        right = new TreeNode[T](v) // 如果左节点是null 则新添加的值直接为左节点
      } else right.add(v)
    }
    true
  }

  //中序遍历
  def midForeach(op: T => Unit): Unit = {
    // 先遍历子左子节点
    if (left != null) left.midForeach(op)
    // 再遍历当前节点
      op(value)
    // 最后遍历有子节点
    if (right != null) right.midForeach(op)
  }
}


