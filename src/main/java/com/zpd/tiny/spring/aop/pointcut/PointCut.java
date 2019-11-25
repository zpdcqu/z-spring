package com.zpd.tiny.spring.aop.pointcut;

import java.lang.reflect.Method;

/**
 * 切面
 *
 * @author ZhengPeidong
 * @date 2019年 11月17日 15:37:28
 */

public interface PointCut {
    // 是否匹配class
    boolean matchesClass(Class<?> targetClass,String expression) throws Exception;
    // 是否匹配方法
    boolean matchesMethod(Class<?>targeetClass, Method method, String expression) throws Exception;
}
