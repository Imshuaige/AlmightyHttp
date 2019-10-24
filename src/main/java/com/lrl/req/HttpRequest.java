package com.lrl.req;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HttpRequest {
    public static String doRequest(HttpUriRequest request) {
        return request(request);
    }

    private static String request(HttpUriRequest request) {
        request.addHeader("Content-Type", "Content-Disposition: form-data; boundary=------------------------------0ea3fcae38ff");
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        StringBuffer buffer = null;
        try {
            HttpResponse response = httpClient.execute(request);
            InputStream is = response.getEntity().getContent();
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            buffer = new StringBuffer();
            String line = "";
            while ((line = in.readLine()) != null)
            {
                buffer.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("发送消息收到的返回：" + buffer.toString());
        return buffer.toString();
    }
}
