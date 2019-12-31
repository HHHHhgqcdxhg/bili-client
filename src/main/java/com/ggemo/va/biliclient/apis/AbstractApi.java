package com.ggemo.va.biliclient.apis;


import com.ggemo.va.biliclient.common.RequestMethodEnum;
import com.ggemo.va.biliclient.common.utils.HeaderUtil;
import com.ggemo.va.biliclient.vo.request.Request;
import com.ggemo.va.biliclient.vo.response.AbstractResponse;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;

import java.net.URISyntaxException;
import java.util.List;

public abstract class AbstractApi<Req extends Request, Res extends AbstractResponse> implements Api<Req, Res> {
    private Header[] headers;
    RequestConfig requestConfig;

    public abstract String getUrl();
    public abstract RequestMethodEnum getRequestMethod();
    public abstract String getReference();

    public AbstractApi(Header[] headers, RequestConfig requestConfig) {
        this.headers = headers;
        this.requestConfig = requestConfig;
    }

    protected HttpUriRequest getHttpRequest(List<NameValuePair> parameters) throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder(getUrl());
        uriBuilder.addParameters(parameters);
        HttpUriRequest httpRequest;
        if (getRequestMethod() == RequestMethodEnum.GET) {
            httpRequest = new HttpGet(uriBuilder.build());
        }else {
            httpRequest = new HttpPost(uriBuilder.build());
        }
        if (headers != null) {
            httpRequest.setHeaders(headers);
        }
        if (getReference() != null) {
            HeaderUtil.setIfNotExist(httpRequest, "Reference", getReference());
        }
        return httpRequest;
    }
}
