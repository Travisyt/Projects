package com.yu.spark

import com.yu.common.bean.Bean
import com.yu.common.utils.StringUtils
import org.apache.spark.{SparkConf, SparkContext}

case class InfoHandler(sc: SparkContext, dataFilePath: String, keySetFilePath: String) {

  def handler(): List[List[String]] = {
    val keyList = sc.textFile(keySetFilePath).collect().toList
    StringUtils.NULL = ""
    val dataList = sc.textFile(dataFilePath).map(e => {
      keyList.map(key => {
        StringUtils.findValueByKey(e, key)
      }).foldRight("")(_+","+_).split(",").toList
    }).collect.toList
    dataList
  }

  def beanGenerate(): Bean[String, String] = {

  }

}
