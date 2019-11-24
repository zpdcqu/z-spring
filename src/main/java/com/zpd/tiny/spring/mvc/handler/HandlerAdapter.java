package com.zpd.tiny.spring.mvc.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 适配器
 * @author ZhengPeidong
 * @date 2019年 11月24日 11:47:46
 */

public interface HandlerAdapter {

    Object handler(HttpServletRequest request, HttpServletResponse response);

    boolean isMatch(HttpServletRequest request);
}
