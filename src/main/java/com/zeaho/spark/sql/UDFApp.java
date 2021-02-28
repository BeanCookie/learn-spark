package com.zeaho.spark.sql;

import org.apache.spark.sql.AnalysisException;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.api.java.UDF1;
import org.apache.spark.sql.api.java.UDF2;
import org.apache.spark.sql.types.DataTypes;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class UDFApp {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) throws AnalysisException {
        SparkSession sparkSession = SparkSession
                .builder()
                .appName("Spark SQL UDF example")
                .getOrCreate();

        sparkSession.read()
                .option("header", true)
                .csv("/vagrant_data/click_log.csv")
                .createOrReplaceTempView("click_log");

        sparkSession.read()
                .option("header", true)
                .csv("/vagrant_data/time_zone.csv")
                .createOrReplaceTempView("time_zone");

        sparkSession.udf().register("DateFormat", (UDF2<String, String, String>) (timestamp, timeZone) -> {
            if (Objects.isNull(timeZone)) {
                timeZone = "UTC+8";
            }
            return Instant.ofEpochMilli(Long.parseLong(timestamp))
                    .atZone(ZoneId.of(timeZone))
                    .format(DATE_TIME_FORMATTER);

        }, DataTypes.StringType);

        sparkSession.sql("SELECT \n" +
                "a.user_id, \n" +
                "a.click_article_id, \n" +
                "a.click_timestamp, \n" +
                "b.time_zone, \n" +
                "DateFormat(a.click_timestamp, b.time_zone) \n" +
                "FROM \n" +
                "click_log as a\n" +
                "LEFT JOIN time_zone as b ON a.user_id = b.user_id")
                .show(100);
    }
}
