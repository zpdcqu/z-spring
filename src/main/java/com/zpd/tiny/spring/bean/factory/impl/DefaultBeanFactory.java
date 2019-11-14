package com.zpd.tiny.spring.bean.factory.impl;

import com.zpd.tiny.spring.bean.factory.BeanFactory;

import java.util.Map;

/**
 * bean工厂实现类
 *
 * @author ZhengPeidong
 * @date 2019年 11月14日 20:51:08
 */

public class DefaultBeanFactory implements BeanFactory {
    @Override
    public Object getBean(String beanName) {
        return null;
    }

    @Override
    public void registerBeanPostProcessor(AopPostProcessor postProcessor) {

    }

    @Override
    public String[] getBeanNameByType(Class<?> clazz) {
        return new String[0];
    }

    @Override
    public Map<String, Object> getBeansByType(Class<?> clazz) {
        return null;
    }
}
