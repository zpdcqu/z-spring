package com.zpd.tiny.spring.aop.advice;

import java.lang.reflect.Method;

/**
 *  前置通知
 */
public interface BeforeAdvice extends Advice {

    /**
     *  前置通知
     * @param method 方法
     * @param args   入参
     * @param target 目标
     */
    void before(Method method,Object[] args,Object target);
}
