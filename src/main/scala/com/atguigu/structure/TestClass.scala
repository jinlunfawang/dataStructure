package com.atguigu.structure


object TestClass {
  def main(args: Array[String]): Unit = {

    var name: String = "jinlian"
    var age: Int = 18
    //（1）字符串，通过$引用
    val s =
      """
        |select
        |    name,
        |    age
        |from user
        |where name="zhangsan"
      """.stripMargin
    println(s)
print("************")
    val s1 =
      s"""
         |select
         |    name,
         |    age
         |from user
         |where name="$name" and age=${age+2}
            """.stripMargin
    println(s1)
    print("************")

    val s2 = s"name=$name"
    println(s2)
  }
}
