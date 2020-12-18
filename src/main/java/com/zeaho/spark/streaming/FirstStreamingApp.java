package com.zeaho.spark.streaming;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import scala.Tuple2;

import java.util.Arrays;

/**
 * @author LuZhong
 */
public class FirstStreamingApp {
    public static void main(String[] args) throws InterruptedException {

        // 创建StreamingContext
        SparkConf conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount");
        // 批处理间隔为10秒
        JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(10));
        // 创建一个监听localhost:1999的DStream
        JavaReceiverInputDStream<String> lines = jssc.socketTextStream("localhost", 1999);

        JavaPairRDD<String, Float> weight = jssc.sparkContext().parallelizePairs(Arrays.asList(new Tuple2<>("a", 1f)));


        JavaDStream<String> words = lines.flatMap(x -> Arrays.asList(x.split(" ")).iterator());

        JavaPairDStream<String, Integer> pairs = words.mapToPair(s -> new Tuple2<>(s, 1));
        JavaPairDStream<String, Integer> wordCounts = pairs.reduceByKey(Integer::sum);
        wordCounts.print();

        // 开始计算
        jssc.start();
        // 等待计算结束
        jssc.awaitTermination();
    }
}
