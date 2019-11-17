package com.zpd.tiny.spring.pointcut;

import java.lang.reflect.Method;

/**
 * 切面
 *
 * @author ZhengPeidong
 * @date 2019年 11月17日 15:37:28
 */

public interface PointCut {
    boolean matchesClass(Class<?> targetClass,String expression) throws Exception;
    boolean matchesMethod(Class<?>targeetClass, Method method, String expression) throws Exception;
}
