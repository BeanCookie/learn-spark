package com.zeaho.spark.sql;

import com.zeaho.spark.constant.CatalogConstants;
import org.apache.spark.sql.AnalysisException;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog;

/**
 * @author LuZhong
 */
public class PokemonWriterApp {
    public static void main(String[] args) throws AnalysisException {
        SparkSession sparkSession = SparkSession
                .builder()
                .appName("Spark SQL PokemonWriterApp")
                .getOrCreate();

        Dataset<Row> dataset = sparkSession.read()
                .option("header", true)
                .csv("/vagrant_data/pokemon0820.csv");

        dataset.write()
                .option(HBaseTableCatalog.tableCatalog(), CatalogConstants.POKEMON)
                .option(HBaseTableCatalog.newTable(), "5")
                .format("org.apache.spark.sql.execution.datasources.hbase")
                .save();
        dataset.show(3);
    }
}
