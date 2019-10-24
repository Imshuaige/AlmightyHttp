package com.lrl.enums;

public enum RequestEnum {
    /**
     * FORM_POST
     */
    FORM_POST("FORM_POST","com.lrl.req.impl.FormPostRequest"),

    /**
     * JSON_POST
     */
    JSON_POST("JSON_POST","com.lrl.req.impl.JsonPostRequest"),

    /**
     * GET
     */
    GET("GET","com.lrl.req.impl.GetRequest");
    private String type;
    private String clazz;

    RequestEnum() {
    }

    RequestEnum(String type, String clazz) {
        this.type = type;
        this.clazz = clazz;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
}
