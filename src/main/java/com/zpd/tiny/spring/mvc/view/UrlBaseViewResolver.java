package com.zpd.tiny.spring.mvc.view;

import org.apache.commons.lang3.StringUtils;

/**
 * @author ZhengPeidong
 * @date 2019年 11月27日 21:44:01
 */

public abstract class UrlBaseViewResolver implements ViewResolver {

    private final String REDIRECT_URL_PREFIX = "redirect:";
    private final String FOWARD_URL_PREFIX="forward:";

    public abstract View resolverView(String vineName);
}
