package com.zeaho.spark.sql;

import com.mongodb.spark.MongoSpark;
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
public class PokemonApp {
    public static void main(String[] args) throws AnalysisException {
        SparkSession sparkSession = SparkSession
                .builder()
                .appName("Spark SQL PokemonReaderApp")
                .config("spark.mongodb.output.uri", "mongodb+srv://lzzz:TbELEqepgnyPPhCZ@cluster0.zdi8e.mongodb.net/spark?retryWrites=true&w=majority")
                .getOrCreate();

        Dataset<Row> pokemonDataset = sparkSession.read()
                .option(HBaseTableCatalog.tableCatalog(), CatalogConstants.POKEMON)
                .format("org.apache.spark.sql.execution.datasources.hbase")
                .load();

        Dataset<Row> groupByPokemonDataset = pokemonDataset.groupBy("type1").count()
                .orderBy(col("count").desc());

        MongoSpark.write(groupByPokemonDataset)
                .option("collection", "pokemon")
                .mode("overwrite")
                .save();
    }
}
