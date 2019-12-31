package com.ggemo.va.biliclient.vo.response;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class AbstractResponse<T extends ResponseData> {
    private int code;
    private String message;
    Integer ttl;

    private T data;

    public static AbstractResponse parse(String json) {
        throw new UnsupportedOperationException();
    }
}
