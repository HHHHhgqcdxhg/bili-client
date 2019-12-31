package com.ggemo.va.biliclient.apis;

import com.ggemo.va.biliclient.common.RequestMethodEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiEnum {
    /**
     *
     */
    USER_INFO("https://api.bilibili.com/x/space/acc/info?mid=128912828", "用户信息", RequestMethodEnum.GET);

    String route;
    String description;
    RequestMethodEnum requestMethod;
}
