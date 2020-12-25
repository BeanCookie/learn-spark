package com.zeaho.spark.streaming;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.lf5.LogLevel;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.sql.*;
import org.apache.spark.sql.catalyst.encoders.ExpressionEncoder;
import org.apache.spark.sql.streaming.OutputMode;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.streaming.StreamingQueryException;
import org.apache.spark.streaming.Seconds;
import org.apache.spark.streaming.Time;
import scala.Tuple2;

import java.beans.Encoder;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;

import static org.apache.spark.sql.functions.col;

/**
 * @author LuZhong
 */
public class FirstStructuredStreamingApp {

    public static class LineData {
        private String line;
        private Time timestamp;

        public String getLine() {
            return line;
        }

        public void setLine(String line) {
            this.line = line;
        }

        public Time getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Time timestamp) {
            this.timestamp = timestamp;
        }
    }

    public static void main(String[] args) throws StreamingQueryException {
        SparkSession session = SparkSession
                .builder()
                .appName("JavaStructuredNetworkWordCount")
                .getOrCreate();

        session.sparkContext().setLogLevel(LogLevel.ERROR.getLabel());

        // Create DataFrame representing the stream of input lines from connection to localhost:1999
        Dataset<Row> lines = session.readStream()
                .format("socket")
                .option("host", "localhost")
                .option("port", 1999)
                .option("includeTimestamp", true)
                .load();

        // Split the lines into words
        Dataset<Row> words = lines
                .as(Encoders.tuple(Encoders.STRING(), Encoders.TIMESTAMP()))
                .flatMap(new FlatMapFunction<Tuple2<String, Timestamp>, Tuple2<String, Timestamp>>() {
                    @Override
                    public Iterator<Tuple2<String, Timestamp>> call(Tuple2<String, Timestamp> line) throws Exception {
                        return Arrays.stream(line._1.split(" ")).map(word -> new Tuple2<>(word, line._2)).iterator();
                    }
                }, Encoders.tuple(Encoders.STRING(), Encoders.TIMESTAMP()))
                .toDF("word", "timestamp");

        // Generate running word count
        Dataset<Row> wordCounts = lines.groupBy(
                functions.window(
                        col("timestamp"),
                        "5 seconds"
                ),
                col("value")
        ).sum();

        // Start running the query that prints the running counts to the console
        StreamingQuery query = wordCounts.writeStream()
                .format("console")
                .outputMode(OutputMode.Complete())
                .start();

        query.awaitTermination();
    }
}
