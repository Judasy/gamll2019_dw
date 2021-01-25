package com.wang.realtime.utils

import java.io.InputStreamReader
import java.util.Properties

/**
 * 读取Properties文件的工具类
 */
object myPropertiesUtil {

  def load(propertieName:String): Properties ={
    val prop=new Properties();
    prop.load(new InputStreamReader(Thread.currentThread().getContextClassLoader.
      getResourceAsStream(propertieName) , "UTF-8"))
    prop
  }
}
