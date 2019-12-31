package com.ggemo.va.biliclient.vo.request;

import org.apache.http.NameValuePair;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author 清纯的小黄瓜
 */
public interface Request {

    /**
     * 返回Request实例对应的Entity
     * @return
     */
    public List<NameValuePair> getParameters() throws UnsupportedEncodingException;

}
