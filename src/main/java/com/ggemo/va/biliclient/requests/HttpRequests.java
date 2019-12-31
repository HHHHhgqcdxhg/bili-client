package com.ggemo.va.biliclient.requests;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.io.IOException;

public class HttpRequests {
    private CloseableHttpClient httpClient;

    public HttpRequests(RequestConfig requestConfig) {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(100);
        HttpClientBuilder clientbuilder = HttpClients.custom().setConnectionManager(cm);
        if (requestConfig != null) {
            clientbuilder.setDefaultRequestConfig(requestConfig);
        }
        this.httpClient = clientbuilder.build();
    }

    public CloseableHttpResponse request(HttpUriRequest httpUriRequest) throws IOException {
        return httpClient.execute(httpUriRequest);
    }
}
