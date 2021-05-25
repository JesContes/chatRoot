package com.ayf.common.controller;

import com.ayf.common.ApiException;
import com.ayf.common.properties.ResultVo;
import com.ayf.common.properties.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.BindException;

/**
 * @author YifeiAn
 * @date 2021-5-25 14:53
 */

@RestControllerAdvice
@Slf4j
public class ControllerExceptionAdvice {
    @ExceptionHandler({BindException.class})
    public ResultVo methodArgumentNotValidExceptionHandler(BindException e){
        return new ResultVo(StatusCode.SYSTEM_EXCEPTION, e.getMessage());
    }

    @ExceptionHandler({ApiException.class})
    public ResultVo apiExceptionHandler(ApiException e){
        log.error(e.getMessage(), e);
        return new ResultVo(e.getCode(), e.getMsg(), e.getMessage());
    }
}
