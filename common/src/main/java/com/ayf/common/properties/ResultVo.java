package com.ayf.common.properties;

import lombok.Getter;

/**
 * @author YifeiAn
 * @date 2021-5-25 14:55
 */
@Getter
public class ResultVo {
    /**
     * 状态码
     */
    private final int code;

    /**
     * 状态码信息
     */
    private final String msg;
    /**
     * 返回数据
     */
    private final Object object;

    public ResultVo(StatusCode statusCode, Object object){
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.object = object;
    }

    public ResultVo(int code, String msg, Object object){
        this.code = code;
        this.msg = msg;
        this.object = object;
    }

}
