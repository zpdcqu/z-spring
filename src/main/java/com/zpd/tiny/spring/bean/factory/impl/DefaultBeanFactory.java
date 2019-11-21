package com.zpd.tiny.spring.bean.factory.impl;

import com.zpd.tiny.spring.bean.beandefinition.BeanDefinition;
import com.zpd.tiny.spring.bean.factory.BeanFactory;
import com.zpd.tiny.spring.bean.postprocessor.AopPostProcessor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * bean工厂实现类
 *
 * @author ZhengPeidong
 * @date 2019年 11月14日 20:51:08
 */

public class DefaultBeanFactory implements BeanFactory,BeanDefinition {



    private Map<String, BeanDefinition> bdMap = new ConcurrentHashMap<>();

    private Map<String,Object> beanMap = new ConcurrentHashMap<>();

    private ThreadLocal<Set<String>> initialedBeans = new ThreadLocal<>();

    private List<AopPostProcessor> aopPostProcessors = new ArrayList<>();



    @Override
    public Object getBean(String beanName) {
        return null;
    }

    @Override
    public void registerBeanPostProcessor(AopPostProcessor postProcessor) {
        aopPostProcessors.add(postProcessor);

    }

    @Override
    public String[] getBeanNameByType(Class<?> clazz) {
        return new String[0];
    }

    @Override
    public Map<String, Object> getBeansByType(Class<?> clazz) {
        return null;
    }

    @Override
    public Class getType(String beanName) {
        Object o = beanMap.get(beanName);
        return o.getClass();
    }

    @Override
    public Class<?> getBeanClass() {
        return null;
    }

    @Override
    public String getBeanName() {
        return null;
    }

    @Override
    public String getBeanFactory() {
        return null;
    }

    @Override
    public String getCreateBeanMethod() {
        return null;
    }

    @Override
    public String getStaticCreateBeanMethod() {
        return null;
    }

    @Override
    public String getBeanInitMethodName() {
        return null;
    }

    @Override
    public String getScope() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public boolean isPrototype() {
        return false;
    }

    @Override
    public List<?> getContructorArg() {
        return null;
    }

    @Override
    public Constructor<?> getConsructor() {
        return null;
    }

    @Override
    public void setContructor(Constructor<?> contructor) {

    }

    @Override
    public Method getFactoryMethod(Method factoryMethod) {
        return null;
    }

    @Override
    public void setProperyKeyValue(Map<String, Object> properties) {

    }
}
