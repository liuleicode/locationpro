package com.ll.location.prop;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropLoader {

    private static Logger logger = Logger.getLogger(PropLoader.class);

    public static Properties load(String propertyFileName) {

        logger.error("load properties(" + propertyFileName + ").");

        Properties properties;

        InputStream is = null;
        try {
            // 读取方式一
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(propertyFileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            properties = new Properties();
            properties.load(reader);
        } catch (Exception ex) {
            properties = null;
            ex.printStackTrace();
            logger.error("load properties(" + propertyFileName + ") exception. " + ex.getMessage());
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return properties;
    }

    public static boolean save(Properties properties, String propertyFileName) {

        if (properties == null)
            return false;

        URL resUrl = Thread.currentThread().getContextClassLoader().getResource(propertyFileName);
        try {
            String path = URLDecoder.decode(resUrl.getFile(), "UTF-8");
            FileOutputStream outFile = new FileOutputStream(path);

            properties.store(outFile, "comment");
            outFile.flush();
            outFile.close();
        } catch (Exception ex) {
            logger.error("save properties(" + propertyFileName + ") error.");
            return false;
        }

        return true;
    }

    public static String realPath(String propertyFileName) throws UnsupportedEncodingException {

        URL resUrl = Thread.currentThread().getContextClassLoader().getResource(propertyFileName);
        String path = URLDecoder.decode(resUrl.getFile(), "UTF-8");

        return path;
    }
}