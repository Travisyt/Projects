package com.yu.spark

import org.apache.spark.{SparkConf, SparkContext}

object Test {

  def main(args: Array[String]): Unit = {
    def conf = new SparkConf().setMaster("local[*]").setAppName("Test")
    def ssc = new SparkContext(conf)
//    ssc.setLogLevel("OFF")


//    val classLoader = Test.getClass.getClassLoader
//    val testPath = classLoader.getResource("temp/test.txt").getPath
//    println(testPath)
//    val testList = List(List(1, 2), List(2, 3), List(3, 4))
//    val testArray = (List(1, 2), List(2, 3), List(3, 4))
//    val testText = ssc.textFile(testPath).collect()
//    println(testText.foreach(e => println(e + "\n\n")))
//    testArray.
//    println(testList.foreach(e => println(e + "\n\n")))
//    val testMap = ssc.parallelize(List(1, 2, 3, 4, 5)).map(e => (e, 2)).collect.toMap
//    println(testMap)
//    val test = List("a", "b", "c").foldLeft("")((a: String, b: String) => a+b)

//    val test = List("a", "b", "c").foldLeft("")(_+","+_).split(",").toList
    val test = List("a", "b", "c").foldRight("")(_+","+_).toString

    println("\n\n\n\n" + test + "\n\n\n\n")


  }


}
