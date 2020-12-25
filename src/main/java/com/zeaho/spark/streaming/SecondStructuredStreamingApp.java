package com.zeaho.spark.streaming;

import org.apache.log4j.lf5.LogLevel;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.sql.*;
import org.apache.spark.sql.streaming.OutputMode;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.streaming.StreamingQueryException;
import org.apache.spark.sql.streaming.Trigger;

import java.util.Arrays;

import static org.apache.spark.sql.functions.col;

/**
 * @author LuZhong
 */
public class SecondStructuredStreamingApp {
    public static void main(String[] args) throws StreamingQueryException {
        SparkSession session = SparkSession
                .builder()
                .appName("JavaStructuredNetworkWordCount")
                .getOrCreate();

        session.sparkContext().setLogLevel(LogLevel.ERROR.getLabel());

        // Create DataFrame representing the stream of input lines from connection to localhost:1999
        Dataset<Row> left = session.readStream()
                .format("rate")
                .option("rowsPerSecond", 1)
                .load();

        Dataset<Row> right = session.readStream()
                .format("rate")
                .option("rowsPerSecond", 2)
                .load();

        Dataset<Row> windowLines = left
                .join(right, left.col("timestamp").equalTo(right.col("timestamp")))
                .select(
                        left.col("timestamp"),
                        left.col("value").as("left_value"),
                        right.col("value").as("right_value")
                );

        // Start running the query that prints the running counts to the console
        StreamingQuery query = windowLines.writeStream()
                .format("console")
                .outputMode(OutputMode.Append())
                .trigger(Trigger.ProcessingTime(1000))
                .start();

        query.awaitTermination();
    }
}
