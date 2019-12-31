package com.ggemo.va.biliclient.apis;

import com.ggemo.va.biliclient.requests.HttpRequests;
import com.ggemo.va.biliclient.vo.request.Request;
import com.ggemo.va.biliclient.vo.response.AbstractResponse;

import java.io.IOException;
import java.net.URISyntaxException;


public interface Api<ReqData extends Request, Res extends AbstractResponse> {
    Res request(HttpRequests requests, ReqData reqData) throws IOException, URISyntaxException;
}
