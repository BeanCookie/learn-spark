package com.zeaho.spark.rdd;

import com.zeaho.spark.util.HBaseUtils;

import java.util.Arrays;

/**
 * @author lzzz
 */
public class HBaseWriter {
    private static final String TABLE_NAME = "hello_hbase";

    public static void main(String[] args) {
        HBaseUtils.createTable(TABLE_NAME, Arrays.asList("a", "b", "c", "d"));
        HBaseUtils.putRow(TABLE_NAME, "rowKey1", "a", "qualifier", "valuevalue");
    }
}
