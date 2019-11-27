package com.zpd.tiny.spring.mvc.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author ZhengPeidong
 * @date 2019年 11月27日 21:41:41
 */

public interface View {
    void render(HttpServletRequest req, HttpServletResponse response, Map<String,Object> model);

}
