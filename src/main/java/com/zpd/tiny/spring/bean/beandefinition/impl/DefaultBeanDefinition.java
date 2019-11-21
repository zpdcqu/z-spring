package com.zpd.tiny.spring.bean.beandefinition.impl;

import com.zpd.tiny.spring.bean.beandefinition.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * @author ZhengPeidong
 * @date 2019年 11月21日 22:49:30
 */

public class DefaultBeanDefinition implements BeanDefinition {

    private Class<?> clazz;

    private String beanName;

    private String beanFactoryName;

    private String createBeanMethodName;

    private String staticCreateBeanMethodName;

    private String beanInitMethodName;

    private String beanDestoryMethodName;

    private boolean isSingleton;

    private Constructor constructor;

    private Method method;

    private List<?> constructorArg;

    private Map<String,Object> values;

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public void setBeanFactoryName(String beanFactoryName) {
        this.beanFactoryName = beanFactoryName;
    }

    public void setCreateBeanMethodName(String createBeanMethodName) {
        this.createBeanMethodName = createBeanMethodName;
    }

    public void setStaticCreateBeanMethodName(String staticCreateBeanMethodName) {
        this.staticCreateBeanMethodName = staticCreateBeanMethodName;
    }

    public void setBeanInitMethodName(String beanInitMethodName) {
        this.beanInitMethodName = beanInitMethodName;
    }

    public void setBeanDestoryMethodName(String beanDestoryMethodName) {
        this.beanDestoryMethodName = beanDestoryMethodName;
    }

    public void setSingleton(boolean singleton) {
        isSingleton = singleton;
    }


    public void setMethod(Method method) {
        this.method = method;
    }

    public void setConstructorArg(List<?> constructorArg) {
        this.constructorArg = constructorArg;
    }

    public void setValues(Map<String, Object> values) {
        this.values = values;
    }

    @Override
    public Class<?> getBeanClass() {
        return this.clazz;
    }

    @Override
    public String getBeanName() {
        return this.beanName;
    }

    @Override
    public String getBeanFactory() {
        return this.beanFactoryName;
    }

    @Override
    public String getCreateBeanMethod() {
        return this.createBeanMethodName;
    }

    @Override
    public String getStaticCreateBeanMethod() {
        return this.staticCreateBeanMethodName;
    }

    @Override
    public String getBeanInitMethodName() {
        return this.beanInitMethodName;
    }

    @Override
    public String getScope() {
        return this.isSingleton?BeanDefinition.SINGLETON:BeanDefinition.PROTOTYPE;
    }

    @Override
    public boolean isSingleton() {
        return this.isSingleton;
    }

    @Override
    public boolean isPrototype() {
        return this.isPrototype();
    }

    @Override
    public List<?> getContructorArg() {
        return this.constructorArg;
    }

    @Override
    public Constructor<?> getConstructor() {
        return this.constructor;
    }


    @Override
    public void setContructor(Constructor<?> contructor) {
        this.constructor = contructor;
    }

    @Override
    public Method getFactoryMethod(Method factoryMethod) {
        return this.method = factoryMethod;
    }

    @Override
    public List<?> getConstouctorArg() {
        return this.constructorArg;
    }

    @Override
    public Constructor<?> getContructor() {
        return this.constructor;
    }

    @Override
    public void setConstructor(Constructor<?> constructor) {
        this.constructor = constructor;
    }

    @Override
    public Method getFactoryMethod() {
        return this.method;
    }

    @Override
    public void setFactoryMethod(Method factoryMethod) {
        this.method = factoryMethod;
    }

    @Override
    public Map<String, Object> getPropertyKeyVale() {
        return this.values;
    }

    @Override
    public void setProperyKeyValue(Map<String, Object> properties) {
        this.values = properties;
    }
}
