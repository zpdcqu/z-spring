package com.zpd.tiny.spring.mvc.model;

import java.util.Map;

/**
 * @author ZhengPeidong
 * @date 2019年 11月24日 12:00:23
 */

public class ModelAndView {

    private Map<String,Object> model;
    private Object view;
    private HttpStatus status;

    public ModelAndView(Map<String, Object> model, Object view) {
        this.model = model;
        this.view = view;
    }

    public ModelAndView(Object view) {

        this.view = view;
    }

    public ModelAndView(Object view, HttpStatus status) {
        this.view = view;
        this.status = status;
    }

    public ModelAndView(Map<String, Object> model, HttpStatus status) {
        this.model = model;
        this.status = status;
    }

    public ModelAndView(Map<String, Object> model, Object view, HttpStatus status) {
        this.model = model;
        this.view = view;
        this.status = status;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }

    public Object getView() {
        return view;
    }

    public void setView(Object view) {
        this.view = view;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
