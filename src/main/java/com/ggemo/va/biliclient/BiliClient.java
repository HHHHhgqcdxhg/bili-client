package com.ggemo.va.biliclient;

import com.ggemo.va.biliclient.apis.impl.UserInfoApi;
import com.ggemo.va.biliclient.requests.HttpRequests;
import com.ggemo.va.biliclient.vo.request.impl.UserInfoRequest;
import com.ggemo.va.biliclient.vo.response.impl.UserInfoResponse;
import org.apache.http.Header;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.message.BasicHeader;

import java.io.IOException;
import java.net.URISyntaxException;

public class BiliClient {
    Header[] headers;
    private HttpRequests requests;

    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36";

    private UserInfoApi userInfoApi;

    public BiliClient(String cookie, RequestConfig requestConfig) {
        if (cookie != null && !cookie.isEmpty() && !cookie.isBlank()) {
            this.headers = new Header[2];
            this.headers[1] = new BasicHeader("Cookie", cookie);
        } else {
            this.headers = new Header[1];
        }
        this.headers[0] = new BasicHeader("User-Agent", USER_AGENT);

        this.requests = new HttpRequests(requestConfig);

        this.userInfoApi = new UserInfoApi(this.headers, requestConfig);
    }

    public UserInfoResponse getUserInfo(Long userId) throws IOException, URISyntaxException {
        return userInfoApi.request(this.requests, new UserInfoRequest(userId));
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        var client = new BiliClient(null, null);
        var res = client.getUserInfo(11357018L);
        System.out.println(res);
    }
}
