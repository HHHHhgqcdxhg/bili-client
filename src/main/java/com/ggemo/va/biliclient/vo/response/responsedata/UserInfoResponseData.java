package com.ggemo.va.biliclient.vo.response.responsedata;

import com.alibaba.fastjson.annotation.JSONField;
import com.ggemo.va.biliclient.vo.response.ResponseData;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class UserInfoResponseData implements ResponseData {
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class Official {
        Integer role;
        String title;
        @JSONField(name = "desc")
        String description;
        Integer type;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class Vip {
        Integer type;
        Integer status;
        @JSONField(name = "theme_type")
        Integer themeType;
    }

    Long mid;
    String name;
    String sex;
    String face;
    String sign;
    Integer rank;
    Integer level;

    @JSONField(name = "jointime")
    Long joinTime;

    Integer moral;
    Integer silence;
    String birthday;
    Integer coins;
    @JSONField(name = "fans_badge")
    Boolean fansBadge;
    Official official;
    Vip vip;
    @JSONField(name = "is_followed")
    boolean followed;
    @JSONField(name = "top_photo")
    String topPhoto;
    Object theme;
    @JSONField(name = "sys_notice")
    Object sysNotice;
}
