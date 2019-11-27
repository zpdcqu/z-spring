package com.zpd.tiny.spring.mvc.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author ZhengPeidong
 * @date 2019年 11月27日 21:46:39
 */

public class AbstractBaseUrlView implements View {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void render(HttpServletRequest req, HttpServletResponse response, Map<String, Object> model) {

    }
}
