package com.ayf.chat.common;

import com.ayf.chat.common.properties.StatusCode;
import lombok.Getter;

/**
 * @author YifeiAn
 * @date 2021-05-25 14:47
 */
@Getter
public class ApiException extends RuntimeException {
    private int code;
    private String msg;

    public ApiException(StatusCode statusCode, String message){
        super(message);
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
    }

    public ApiException(String message){
        super(message);
        this.code = StatusCode.BUSINESS_EXCEPTION.getCode();
        this.msg = StatusCode.BUSINESS_EXCEPTION.getMsg();
    }
}
