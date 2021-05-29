package com.ayf.chat.common.properties;

/**
 * @author YifeiAn
 */

public enum StatusCode {
    /**
     * 请求成功
     */
    SUCCESS(200, "请求成功") ,

    /**
     * 业务异常
     */
    BUSINESS_EXCEPTION(1301, "业务异常"),

    /**
     * 系统异常
     */
    SYSTEM_EXCEPTION(1302, "系统异常"),

    /**
     * 校验失败
     */
    VALIDATE_EXCEPTION(1304, "校验失败")
    ;

    /**
     * 状态编码
     */
    private final int code;
    /**
     * 返回信息
     */
    private final String msg;

    StatusCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode(){
        return this.code;
    }

    public String getMsg(){
        return this.msg;
    }
}
