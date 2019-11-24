package com.zpd.tiny.spring.mvc.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ZhengPeidong
 * @date 2019年 11月24日 11:59:35
 */

public class SimpleControllerHandlerAdapter implements HandlerAdapter {
    @Override
    public Object handler(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    @Override
    public boolean isMatch(HttpServletRequest request) {
        return false;
    }
}
