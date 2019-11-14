package com.zpd.tiny.spring.aop.advice;

import java.lang.reflect.Method;

/**
 * 环绕通知
 */
public interface AroundAdvice extends Advice {
    Object around(Method method, Object[] args, Object target);
}
