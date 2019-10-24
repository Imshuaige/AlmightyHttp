package com.lrl.req.impl;

import com.lrl.req.HttpRequest;
import com.lrl.req.RequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;

import java.util.Map;

public class FormPostRequest implements RequestBase {
    @Override
    public String request(String url, Map<String, String> param) {
        if (param!=null&&param.size()>0) {
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            param.entrySet().stream().forEach(en->builder.addPart(en.getKey(),new StringBody(en.getValue(), ContentType.MULTIPART_FORM_DATA)));
            HttpPost request = new HttpPost(url);
            if (builder!=null) {
                request.setEntity(builder.build());
            }
            return HttpRequest.doRequest(request);
        }
        return "";
    }
}
