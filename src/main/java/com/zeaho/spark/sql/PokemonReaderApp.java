package com.zeaho.spark.sql;

import com.zeaho.spark.constant.CatalogConstants;
import org.apache.spark.sql.AnalysisException;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog;

import static org.apache.spark.sql.functions.col;

/**
 * @author LuZhong
 */
public class PokemonReaderApp {
    public static void main(String[] args) throws AnalysisException {
        SparkSession sparkSession = SparkSession
                .builder()
                .appName("Spark SQL PokemonReaderApp")
                .getOrCreate();

        Dataset<Row> pokemonDataset = sparkSession.read()
                .option(HBaseTableCatalog.tableCatalog(), CatalogConstants.POKEMON)
                .format("org.apache.spark.sql.execution.datasources.hbase")
                .load();
        pokemonDataset.groupBy("type1").count()
                .orderBy(col("count").desc())
                .show();;
    }
}
