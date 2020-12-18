package com.zeaho.spark.util;

import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author LuZhong
 */
public class ResourceUtils {
    public static String getCatalog(String name) {
        URL filePath = ResourceUtils.class.getResource(String.format("/catalog/%s.json", name));
        try {
            return StringUtils.join(Files.readAllLines(Paths.get(filePath.toURI())).toArray());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
