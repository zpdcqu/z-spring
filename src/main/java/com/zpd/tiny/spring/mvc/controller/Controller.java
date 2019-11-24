package com.zpd.tiny.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ZhengPeidong
 * @date 2019年 11月24日 11:41:30
 */

public interface Controller {
    ModelAndView handlerRequest(HttpServletRequest request, HttpServletRequest)
}
