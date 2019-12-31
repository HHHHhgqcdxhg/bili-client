package com.ggemo.va.biliclient.vo.request.impl;

import com.ggemo.va.biliclient.vo.request.Request;
import lombok.*;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
@Setter
public class UserInfoRequest implements Request {
    private static final String USER_ID = "mid";
    long userId;

    @Override
    public List<NameValuePair> getParameters() throws UnsupportedEncodingException {
        List<NameValuePair> kvs = new ArrayList<>(1);
        kvs.add(new BasicNameValuePair(USER_ID, String.valueOf(userId)));
        return kvs;
    }
}
