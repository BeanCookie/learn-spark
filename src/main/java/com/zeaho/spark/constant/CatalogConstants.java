package com.zeaho.spark.constant;

/**
 * @author LuZhong
 */
public class CatalogConstants {
    public static final String POKEMON = "{\n" +
            "  \"table\": {\n" +
            "    \"namespace\": \"default\",\n" +
            "    \"name\": \"pokemon\"\n" +
            "  },\n" +
            "  \"rowkey\": \"abilities\",\n" +
            "  \"columns\": {\n" +
            "    \"abilities\": {\n" +
            "      \"cf\": \"rowkey\",\n" +
            "      \"col\": \"abilities\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"against_bug\": {\n" +
            "      \"cf\": \"cf1\",\n" +
            "      \"col\": \"against_bug\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"against_dark\": {\n" +
            "      \"cf\": \"cf2\",\n" +
            "      \"col\": \"against_dark\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"against_dragon\": {\n" +
            "      \"cf\": \"cf3\",\n" +
            "      \"col\": \"against_dragon\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"against_electric\": {\n" +
            "      \"cf\": \"cf4\",\n" +
            "      \"col\": \"against_electric\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"against_fairy\": {\n" +
            "      \"cf\": \"cf5\",\n" +
            "      \"col\": \"against_fairy\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"against_fight\": {\n" +
            "      \"cf\": \"cf6\",\n" +
            "      \"col\": \"against_fight\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"against_fire\": {\n" +
            "      \"cf\": \"cf7\",\n" +
            "      \"col\": \"against_fire\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"against_flying\": {\n" +
            "      \"cf\": \"cf8\",\n" +
            "      \"col\": \"against_flying\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"against_ghost\": {\n" +
            "      \"cf\": \"cf9\",\n" +
            "      \"col\": \"against_ghost\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"against_grass\": {\n" +
            "      \"cf\": \"cf10\",\n" +
            "      \"col\": \"against_grass\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"against_ground\": {\n" +
            "      \"cf\": \"cf11\",\n" +
            "      \"col\": \"against_ground\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"against_ice\": {\n" +
            "      \"cf\": \"cf12\",\n" +
            "      \"col\": \"against_ice\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"against_normal\": {\n" +
            "      \"cf\": \"cf13\",\n" +
            "      \"col\": \"against_normal\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"against_poison\": {\n" +
            "      \"cf\": \"cf14\",\n" +
            "      \"col\": \"against_poison\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"against_psychic\": {\n" +
            "      \"cf\": \"cf15\",\n" +
            "      \"col\": \"against_psychic\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"against_rock\": {\n" +
            "      \"cf\": \"cf16\",\n" +
            "      \"col\": \"against_rock\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"against_steel\": {\n" +
            "      \"cf\": \"cf17\",\n" +
            "      \"col\": \"against_steel\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"against_water\": {\n" +
            "      \"cf\": \"cf18\",\n" +
            "      \"col\": \"against_water\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"attack\": {\n" +
            "      \"cf\": \"cf19\",\n" +
            "      \"col\": \"attack\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"base_egg_steps\": {\n" +
            "      \"cf\": \"cf20\",\n" +
            "      \"col\": \"base_egg_steps\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"base_happiness\": {\n" +
            "      \"cf\": \"cf21\",\n" +
            "      \"col\": \"base_happiness\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"base_total\": {\n" +
            "      \"cf\": \"cf22\",\n" +
            "      \"col\": \"base_total\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"capture_rate\": {\n" +
            "      \"cf\": \"cf23\",\n" +
            "      \"col\": \"capture_rate\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"classfication\": {\n" +
            "      \"cf\": \"cf24\",\n" +
            "      \"col\": \"classfication\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"defense\": {\n" +
            "      \"cf\": \"cf25\",\n" +
            "      \"col\": \"defense\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"experience_growth\": {\n" +
            "      \"cf\": \"cf26\",\n" +
            "      \"col\": \"experience_growth\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"height_m\": {\n" +
            "      \"cf\": \"cf27\",\n" +
            "      \"col\": \"height_m\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"hp\": {\n" +
            "      \"cf\": \"cf28\",\n" +
            "      \"col\": \"hp\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"japanese_name\": {\n" +
            "      \"cf\": \"cf29\",\n" +
            "      \"col\": \"japanese_name\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"name\": {\n" +
            "      \"cf\": \"cf30\",\n" +
            "      \"col\": \"name\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"percentage_male\": {\n" +
            "      \"cf\": \"cf31\",\n" +
            "      \"col\": \"percentage_male\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"pokedex_number\": {\n" +
            "      \"cf\": \"cf32\",\n" +
            "      \"col\": \"pokedex_number\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"sp_attack\": {\n" +
            "      \"cf\": \"cf33\",\n" +
            "      \"col\": \"sp_attack\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"sp_defense\": {\n" +
            "      \"cf\": \"cf34\",\n" +
            "      \"col\": \"sp_defense\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"speed\": {\n" +
            "      \"cf\": \"cf35\",\n" +
            "      \"col\": \"speed\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"type1\": {\n" +
            "      \"cf\": \"cf36\",\n" +
            "      \"col\": \"type1\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"type2\": {\n" +
            "      \"cf\": \"cf37\",\n" +
            "      \"col\": \"type2\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"weight_kg\": {\n" +
            "      \"cf\": \"cf38\",\n" +
            "      \"col\": \"weight_kg\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"generation\": {\n" +
            "      \"cf\": \"cf39\",\n" +
            "      \"col\": \"generation\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"is_legendary\": {\n" +
            "      \"cf\": \"cf40\",\n" +
            "      \"col\": \"is_legendary\",\n" +
            "      \"type\": \"string\"\n" +
            "    }\n" +
            "  }\n" +
            "}\n" +
            "\n";
}
