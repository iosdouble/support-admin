package com.zk.common.utils.http;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HttpClientUtil {
    private static HttpClientBuilder httpClientBuilder;
    private static Logger log;
    static {
        log = LoggerFactory.getLogger(HttpClientUtil.class);
        httpClientBuilder = HttpClientBuilder.create();
    }
 
    /**
     * 发送post请求
     * @param url  请求的url
     * @param body json串
     * @return
     */
    public static String sendPostJsonBody(String url, String body) {
        log.debug("[HttpClientUtil] [sendPostJsonBody] 入参 url={} body={}", url, body);
 
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
        StringEntity entity = new StringEntity(body, "utf-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);
 
        try {
            HttpClient client = httpClientBuilder.build();
            HttpResponse response = client.execute(httpPost);
            if (response.getStatusLine() != null && response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String result = EntityUtils.toString(response.getEntity(), "utf-8");
                log.debug("[HttpClientUtil] [sendPostJsonBody] 结果 url={} result={}", url, result);
                return result;
            }
            log.warn("[HttpClientUtil] [sendPostJsonBody] 请求失败 response={}", url, response.toString());
            return "";
        }
        catch (IOException ex) {
            log.error("[HttpClientUtil] [sendPostJsonBody] 请求异常 ex={}", url, ex);
            return "";
        }
    }
}

