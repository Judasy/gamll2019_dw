package com.wang.realtime.utils

import com.alibaba.fastjson.JSON
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.spark.streaming.dstream.InputDStream
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}


object RealTimeStartupApp {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("consumer-Kafka").setMaster("local[*]")
    val context = new SparkContext(sparkConf)
    val streamingContext = new StreamingContext(context,Seconds(5))

    val stream: InputDStream[ConsumerRecord[String, String]] = myKafkaUtil.getKafkaStrem("wang",streamingContext)
    stream.map(_.value()).map(flag => {
      println(flag)
      flag
    })


    streamingContext.start()
    streamingContext.awaitTermination()
  }
}
