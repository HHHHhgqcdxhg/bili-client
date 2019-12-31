package com.ggemo.va.biliclient.apis.impl;

import com.ggemo.va.biliclient.apis.AbstractApi;
import com.ggemo.va.biliclient.common.RequestMethodEnum;
import com.ggemo.va.biliclient.requests.HttpRequests;
import com.ggemo.va.biliclient.vo.request.impl.UserInfoRequest;
import com.ggemo.va.biliclient.vo.response.AbstractResponse;
import com.ggemo.va.biliclient.vo.response.impl.UserInfoResponse;
import com.ggemo.va.biliclient.vo.response.responsedata.UserInfoResponseData;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class UserInfoApi extends AbstractApi<UserInfoRequest, AbstractResponse<UserInfoResponseData>> {

    private static final String URL = "https://api.bilibili.com/x/space/acc/info";

    public UserInfoApi(Header[] headers, RequestConfig requestConfig) {
        super(headers, requestConfig);
    }

    @Override
    public UserInfoResponse request(HttpRequests requests, UserInfoRequest userInfoRequest) throws IOException, URISyntaxException {
        List<NameValuePair> parameters = userInfoRequest.getParameters();
        HttpUriRequest httpRequest = this.getHttpRequest(parameters);
        HttpResponse httpResponse = requests.request(httpRequest);
        HttpEntity responseEntity = httpResponse.getEntity();
        String responseString = EntityUtils.toString(responseEntity);
        UserInfoResponse res = UserInfoResponse.parse(responseString);
        return res;
    }


    @Override
    public RequestMethodEnum getRequestMethod() {
        return RequestMethodEnum.GET;
    }

    @Override
    public String getReference() {
        return null;
    }

    @Override
    public String getUrl() {
        return URL;
    }
}
