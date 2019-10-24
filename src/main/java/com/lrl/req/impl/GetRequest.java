package com.lrl.req.impl;

import com.lrl.req.HttpRequest;
import com.lrl.req.RequestBase;
import org.apache.http.client.methods.HttpGet;

import java.util.Map;

public class GetRequest implements RequestBase {
    @Override
    public String request(String url, Map<String, String> param) {
        HttpGet request = new HttpGet(url);
        return HttpRequest.doRequest(request);
    }
}
