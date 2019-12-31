package com.ggemo.va.biliclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.va.biliclient.vo.response.AbstractResponse;
import com.ggemo.va.biliclient.vo.response.responsedata.UserInfoResponseData;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserInfoResponse extends AbstractResponse<UserInfoResponseData> {
    public UserInfoResponse(int code, String message, Integer ttl, UserInfoResponseData data) {
        super(code, message, ttl, data);
    }

    public static UserInfoResponse parse(String json) {
        UserInfoResponse res = JSON.parseObject(json, UserInfoResponse.class);
        return res;
    }
}
