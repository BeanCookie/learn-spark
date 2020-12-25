package com.zeaho.spark.streaming;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.Optional;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

/**
 * @author LuZhong
 */
public class FirstStreamingApp {
    public static void main(String[] args) throws InterruptedException {

        // 创建StreamingContext
        SparkConf conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount");
        // 批处理间隔为10秒
        JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(10));
        jssc.checkpoint("./checkpoint");
        // 创建一个监听localhost:1999的DStream
        JavaReceiverInputDStream<String> lines = jssc.socketTextStream("localhost", 1999);


        JavaDStream<String> words = lines.flatMap(x -> Arrays.asList(x.split(" ")).iterator());

        JavaPairRDD<String, Boolean> ignoreRdd = jssc.sparkContext().parallelize(Arrays.asList("apple", "banana")).mapToPair(s -> new Tuple2<>(s, true));


        JavaPairDStream<String, Integer> pairs = words
                .mapToPair(s -> new Tuple2<>(s, 1))
                .transformToPair((Function<JavaPairRDD<String, Integer>, JavaPairRDD<String, Integer>>) word -> word.join(ignoreRdd)
                        .filter((Function<Tuple2<String, Tuple2<Integer, Boolean>>, Boolean>) x -> x._2._2)
                        .mapToPair((PairFunction<Tuple2<String, Tuple2<Integer, Boolean>>, String, Integer>) x -> new Tuple2<>(x._1, x._2._1)));


        JavaPairDStream<String, Integer> wordCounts = pairs.reduceByKey(Integer::sum);


        wordCounts.updateStateByKey((Function2<List<Integer>, Optional<Integer>, Optional<Integer>>) (integers, state) -> Optional.of(integers.stream().reduce(Integer::sum).orElse(0) + state.orElse(0))).print();

        // 开始计算
        jssc.start();
        // 等待计算结束
        jssc.awaitTermination();
    }
}
