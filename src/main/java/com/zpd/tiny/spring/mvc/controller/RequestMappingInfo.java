package com.zpd.tiny.spring.mvc.controller;

import com.zpd.tiny.spring.mvc.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author ZhengPeidong
 * @date 2019年 11月24日 11:43:22
 */

public class RequestMappingInfo {
    private RequestMapping classRequestMapping;

    private String beanName;

    private RequestMapping methodRequestMapping;

    private Method method;

    private Object handler;

    public boolean isMath(HttpServletRequest request){
        //todo
        return  false;
    }
}
