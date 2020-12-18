package com.zeaho.spark.sql;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.*;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import java.util.ArrayList;
import java.util.List;

import static org.apache.spark.sql.functions.col;

/**
 * @author LuZhong
 */
public class BaseSQLApp {
    public static class Pokemon {
        private String abilities;
        private String against_bug;
        private String against_dark;
        private String against_dragon;
        private String against_electric;
        private String against_fairy;
        private String against_fight;
        private String against_fire;
        private String against_flying;
        private String against_ghost;
        private String against_grass;
        private String against_ground;
        private String against_ice;
        private String against_normal;
        private String against_poison;
        private String against_psychic;
        private String against_rock;
        private String against_steel;
        private String against_water;
        private String attack;
        private String base_egg_steps;
        private String base_happiness;
        private String base_total;
        private String capture_rate;
        private String classfication;
        private String defense;
        private String experience_growth;
        private String height_m;
        private String hp;
        private String japanese_name;
        private String name;
        private String percentage_male;
        private String pokedex_number;
        private String sp_attack;
        private String sp_defense;
        private String speed;
        private String type1;
        private String type2;
        private String weight_kg;
        private String generation;
        private String is_legendary;

        public String getAbilities() {
            return abilities;
        }

        public void setAbilities(String abilities) {
            this.abilities = abilities;
        }

        public String getAgainst_bug() {
            return against_bug;
        }

        public void setAgainst_bug(String against_bug) {
            this.against_bug = against_bug;
        }

        public String getAgainst_dark() {
            return against_dark;
        }

        public void setAgainst_dark(String against_dark) {
            this.against_dark = against_dark;
        }

        public String getAgainst_dragon() {
            return against_dragon;
        }

        public void setAgainst_dragon(String against_dragon) {
            this.against_dragon = against_dragon;
        }

        public String getAgainst_electric() {
            return against_electric;
        }

        public void setAgainst_electric(String against_electric) {
            this.against_electric = against_electric;
        }

        public String getAgainst_fairy() {
            return against_fairy;
        }

        public void setAgainst_fairy(String against_fairy) {
            this.against_fairy = against_fairy;
        }

        public String getAgainst_fight() {
            return against_fight;
        }

        public void setAgainst_fight(String against_fight) {
            this.against_fight = against_fight;
        }

        public String getAgainst_fire() {
            return against_fire;
        }

        public void setAgainst_fire(String against_fire) {
            this.against_fire = against_fire;
        }

        public String getAgainst_flying() {
            return against_flying;
        }

        public void setAgainst_flying(String against_flying) {
            this.against_flying = against_flying;
        }

        public String getAgainst_ghost() {
            return against_ghost;
        }

        public void setAgainst_ghost(String against_ghost) {
            this.against_ghost = against_ghost;
        }

        public String getAgainst_grass() {
            return against_grass;
        }

        public void setAgainst_grass(String against_grass) {
            this.against_grass = against_grass;
        }

        public String getAgainst_ground() {
            return against_ground;
        }

        public void setAgainst_ground(String against_ground) {
            this.against_ground = against_ground;
        }

        public String getAgainst_ice() {
            return against_ice;
        }

        public void setAgainst_ice(String against_ice) {
            this.against_ice = against_ice;
        }

        public String getAgainst_normal() {
            return against_normal;
        }

        public void setAgainst_normal(String against_normal) {
            this.against_normal = against_normal;
        }

        public String getAgainst_poison() {
            return against_poison;
        }

        public void setAgainst_poison(String against_poison) {
            this.against_poison = against_poison;
        }

        public String getAgainst_psychic() {
            return against_psychic;
        }

        public void setAgainst_psychic(String against_psychic) {
            this.against_psychic = against_psychic;
        }

        public String getAgainst_rock() {
            return against_rock;
        }

        public void setAgainst_rock(String against_rock) {
            this.against_rock = against_rock;
        }

        public String getAgainst_steel() {
            return against_steel;
        }

        public void setAgainst_steel(String against_steel) {
            this.against_steel = against_steel;
        }

        public String getAgainst_water() {
            return against_water;
        }

        public void setAgainst_water(String against_water) {
            this.against_water = against_water;
        }

        public String getAttack() {
            return attack;
        }

        public void setAttack(String attack) {
            this.attack = attack;
        }

        public String getBase_egg_steps() {
            return base_egg_steps;
        }

        public void setBase_egg_steps(String base_egg_steps) {
            this.base_egg_steps = base_egg_steps;
        }

        public String getBase_happiness() {
            return base_happiness;
        }

        public void setBase_happiness(String base_happiness) {
            this.base_happiness = base_happiness;
        }

        public String getBase_total() {
            return base_total;
        }

        public void setBase_total(String base_total) {
            this.base_total = base_total;
        }

        public String getCapture_rate() {
            return capture_rate;
        }

        public void setCapture_rate(String capture_rate) {
            this.capture_rate = capture_rate;
        }

        public String getClassfication() {
            return classfication;
        }

        public void setClassfication(String classfication) {
            this.classfication = classfication;
        }

        public String getDefense() {
            return defense;
        }

        public void setDefense(String defense) {
            this.defense = defense;
        }

        public String getExperience_growth() {
            return experience_growth;
        }

        public void setExperience_growth(String experience_growth) {
            this.experience_growth = experience_growth;
        }

        public String getHeight_m() {
            return height_m;
        }

        public void setHeight_m(String height_m) {
            this.height_m = height_m;
        }

        public String getHp() {
            return hp;
        }

        public void setHp(String hp) {
            this.hp = hp;
        }

        public String getJapanese_name() {
            return japanese_name;
        }

        public void setJapanese_name(String japanese_name) {
            this.japanese_name = japanese_name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPercentage_male() {
            return percentage_male;
        }

        public void setPercentage_male(String percentage_male) {
            this.percentage_male = percentage_male;
        }

        public String getPokedex_number() {
            return pokedex_number;
        }

        public void setPokedex_number(String pokedex_number) {
            this.pokedex_number = pokedex_number;
        }

        public String getSp_attack() {
            return sp_attack;
        }

        public void setSp_attack(String sp_attack) {
            this.sp_attack = sp_attack;
        }

        public String getSp_defense() {
            return sp_defense;
        }

        public void setSp_defense(String sp_defense) {
            this.sp_defense = sp_defense;
        }

        public String getSpeed() {
            return speed;
        }

        public void setSpeed(String speed) {
            this.speed = speed;
        }

        public String getType1() {
            return type1;
        }

        public void setType1(String type1) {
            this.type1 = type1;
        }

        public String getType2() {
            return type2;
        }

        public void setType2(String type2) {
            this.type2 = type2;
        }

        public String getWeight_kg() {
            return weight_kg;
        }

        public void setWeight_kg(String weight_kg) {
            this.weight_kg = weight_kg;
        }

        public String getGeneration() {
            return generation;
        }

        public void setGeneration(String generation) {
            this.generation = generation;
        }

        public String getIs_legendary() {
            return is_legendary;
        }

        public void setIs_legendary(String is_legendary) {
            this.is_legendary = is_legendary;
        }
    }

    public static void fun1(Dataset<Row> dataset) {
        dataset.show(3);

        dataset.printSchema();

        dataset.select("name", "percentage_male").show(3);

        dataset.select("name", "percentage_male")
                .where(col("percentage_male").lt(50))
                .show(3);

        dataset.groupBy("type1").count()
                .orderBy(col("count").desc())
                .show();

        dataset.createOrReplaceTempView("pokemon");
    }

    public static void fun2(SparkSession sparkSession, Dataset<Row> dataset) {
        dataset.createOrReplaceTempView("pokemon");
        sparkSession.sql("SELECT name, percentage_male FROM pokemon WHERE percentage_male < 50 LIMIT 3").show();
        sparkSession.sql("SELECT type1, COUNT(type1) FROM pokemon GROUP BY type1 ORDER BY count(type1) DESC").show();
        sparkSession.sql("SELECT name,weight_kg FROM pokemon where weight_kg > 888 LIMIT 10").show();
    }

    public static void fun3(SparkSession sparkSession) {
        Dataset<Pokemon> pokemonDataset = sparkSession.read().csv("/vagrant_data/pokemon0820.csv").as(Encoders.bean(Pokemon.class));
        pokemonDataset.printSchema();
    }

    public static void fun4(SparkSession sparkSession, JavaRDD<Pokemon> pokemonRDD) {
        Dataset<Row> pokemonDataset = sparkSession.createDataFrame(pokemonRDD, Pokemon.class);
    }

    public static void fun5(SparkSession sparkSession, Dataset<Row> dataset) {
        String schemaString = "abilities,against_bug,against_dark,against_dragon,against_electric,against_fairy,against_fight,against_fire,against_flying,against_ghost,against_grass,against_ground,against_ice,against_normal,against_poison,against_psychic,against_rock,against_steel,against_water,attack,base_egg_steps,base_happiness,base_total,capture_rate,classfication,defense,experience_growth,height_m,hp,japanese_name,name,percentage_male,pokedex_number,sp_attack,sp_defense,speed,type1,type2,weight_kg,generation,is_legendary";
        List<StructField> fields = new ArrayList<>();
        for (String fieldName : schemaString.split(",")) {
            StructField field = DataTypes.createStructField(fieldName, DataTypes.StringType, true);
            fields.add(field);
        }
        StructType schema = DataTypes.createStructType(fields);
        Dataset<Row> pokemonDataset = sparkSession.createDataFrame(dataset.rdd(), schema);
    }


    public static void main(String[] args) throws AnalysisException {
        SparkSession sparkSession = SparkSession
                .builder()
                .appName("Spark SQL basic example")
                .getOrCreate();
        Dataset<Row> dataset = sparkSession.read()
                .option("header", true)
                .csv("/vagrant_data/pokemon0820.csv");


//        dataset.select("name")
//                .orderBy(col("weight_kg").desc())
//                .limit(10)
//                .show();

        dataset.createOrReplaceTempView("pokemon");
        sparkSession.sql("SELECT name,weight_kg FROM pokemon where weight_kg > 888 LIMIT 10").show();

//        JavaRDD<Pokemon> pokemonRDD = dataset.javaRDD()
//                .map(row -> {
//                    Pokemon pokemon = new Pokemon();
//                    pokemon.setAbilities(row.getString(0));
//                    return pokemon;
//                });
    }
}
