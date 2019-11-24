package com.zpd.tiny.spring.mvc.handler;

import javax.servlet.http.HttpServletRequest;

/**
 * handlerMapping
 */
public interface HandlerMapping {
    Object getHandler(HttpServletRequest request);
}
