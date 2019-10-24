package com.lrl.constant;


import com.lrl.enums.RequestEnum;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class RequestConstant {
    public static final String  FORM_POST = "FORM_POST";
    public static final String  JSON_POST = "JSON_POST";
    public static final String  GET = "GET";
    public static final String  TEXT = "TEXT";
    public static final String  HTML = "HTML";
    public static final String  XML = "HTML";
    public static final String  BINARY = "BINARY";
    public static Map<String,String> requestMethods = new HashMap<>();
    private static Properties pro = new Properties();

    static {
        for (RequestEnum t : RequestEnum.values()){
            requestMethods.put(t.getType(), t.getClazz());
        }
        InputStream ins = Thread.currentThread().getContextClassLoader().getResourceAsStream("method.properties");
        try {
            pro.load(ins);
            Set<String> strings = pro.stringPropertyNames();
            strings.stream().forEach(str->requestMethods.put(str,pro.getProperty(str)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
