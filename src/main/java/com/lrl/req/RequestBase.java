package com.lrl.req;

import java.util.Map;

public interface RequestBase {
    String request(String url, Map<String,String> param);
}
