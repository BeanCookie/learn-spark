package com.zeaho.spark.rdd;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LuZhong
 */
public class CounterCumulative {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount");
        SparkContext sparkContext = SparkContext.getOrCreate(sparkConf);
        AtomicInteger counter = new AtomicInteger();
        JavaRDD<String> lines = sparkContext.textFile(args[0], 1).toJavaRDD();

        lines.foreach(x -> counter.incrementAndGet());

        System.out.println("counter: " + counter.intValue());
    }
}
