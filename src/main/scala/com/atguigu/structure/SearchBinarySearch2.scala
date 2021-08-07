package com.atguigu.structure

object SearchBinarySearch2 {
  // 初始化一个排序二叉树
  def initSBT(arr: Array[Int]) = {
    val sbt = new SearchBinaryTree2[Int]()
    arr.foreach(x => {
      sbt.addNode(x)
    })
    sbt
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(8, 4, 9, 10, 1, 6, 7, 12)
    val sbt = initSBT(arr)
    //sbt.midForeach(println)
    println(sbt.search(8))

  }

}

class SearchBinaryTree2[T: Ordering] {
  private val ord: Ordering[T] = implicitly[Ordering[T]]
  // 根节点
  var root: TreeNodes[T] = _

  /**
    * 向二叉树中插入节点
    *
    * @param v
    */
  def addNode(v: T) = {
    if (root == null) root = new TreeNodes[T](v)
    else root.add(v) // 添加节点
  }

  // 遍历这个树
  def midForeach(op: T => Unit): Unit = {
    if (root != null)
      root.midForeach(op)
  }

  // 查找二叉树
  def search(v: T): Boolean = {
    if (root == null) false
    else
      root.searchEle(v)
  }
  def deleteEle(v: T): Boolean = {
    // 如果树为空
    if(root==null) false
    // 如果不为空 删除的是根节点
    else if (ord.equiv(v,root.value))  true
    else{
      root.delete(v)
    }
    //

    false

  }

}

/**
  * 表示一个树的节点
  *
  * @param value
  * @tparam T
  */
class TreeNodes[T: Ordering](var value: T) {
  def delete(v: T) = ???

  private val ord: Ordering[T] = implicitly[Ordering[T]]
  // 根节点
  var root: TreeNodes[T] = _
  var left: TreeNodes[T] = _
  var right: TreeNodes[T] = _

  // 添加节点
  def add(v: T): Boolean = {

    if (ord.lteq(v, value)) {
      // 小于根节点的值 向左边添加
      if (left == null) left = new TreeNodes[T](v)
      else
        left.add(v)
    } else {
      if (right == null) right = new TreeNodes[T](v)
      else
      // 递归调用
        right.add(v) // 大于想右边添加
    }
    true
  }

  //中序遍历
  def midForeach(op: T => Unit): Unit = {
    if (left != null) left.midForeach(op)
    op(value)
    if (right != null) right.midForeach(op)
  }

  // 查找
  def searchEle(v: T): Boolean = {
    // 先判断当前节点是否是要找的
    // 如果和当前节点的值相等, 则直接返回 true
    if (ord.equiv(v, value)) true

    else if (ord.lt(v, value)) { // 如果小于当前节点, 则去左边查找
      if (left == null) false // 如果左节点是 false, 则直接返回 false. 否则就递归的去左节点查找
      else left.searchEle(v)
    } else {
      // 如果大于当前节点, 则去右边查找
      if (right == null)  false // 如果右节点是 false, 则直接返回 false. 否则就递归的去右节点查找
      else right.searchEle(v)
    }
  }

}


