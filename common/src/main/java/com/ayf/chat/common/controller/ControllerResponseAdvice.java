package com.ayf.chat.common.controller;

import com.ayf.chat.common.ApiException;
import com.ayf.chat.common.properties.ResultVo;
import com.ayf.chat.common.properties.StatusCode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author YifeiAn
 * @date 2021-5-29 17:37
 * import from https://blog.csdn.net/chaitoudaren/article/details/105610962?spm=1001.2014.3001.5501
 */

@RestControllerAdvice(basePackages = {"com.ayf.chat"})
public class ControllerResponseAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return !methodParameter.getParameterType().isAssignableFrom(ResultVo.class);
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (methodParameter.getGenericParameterType().equals(String.class)){
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.writeValueAsString(new ResultVo(o));
            } catch (JsonProcessingException e){
                throw new ApiException(StatusCode.RESPONSE_RETURN_EXCEPTION, e.getMessage());
            }
        }
        return new ResultVo(o);
    }
}
