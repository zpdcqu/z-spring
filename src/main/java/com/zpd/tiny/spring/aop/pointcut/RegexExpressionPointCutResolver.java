package com.zpd.tiny.spring.aop.pointcut;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * 正则匹配
 * @author ZhengPeidong
 * @date 2019年 11月17日 15:41:28
 */

public class RegexExpressionPointCutResolver implements RegexExpressionPointCut {
    @Override
    public boolean matchesClass(Class<?> targetClass, String expression) throws Exception {
        //表达式中的类名
        String className = RegexMatchUtils.matchClassName(expression);
        expression.replace(".","\\.");
        expression.replace("*",".*");

        String name = targetClass.getName();
        boolean matches = Pattern.matches(className,name);

        return matches;
    }

    /**
     * 匹配方法
     */
    @Override
    public boolean matchesMethod(Class<?> targeetClass, Method method, String expression) throws Exception {
        boolean isMatch =matchesClass(targeetClass,expression);
    if (!isMatch){
        return false;
    }

    String matchName = RegexMaatchUtils.matchMethodName(expression);
    String methodName = method.getName();
    if("*".equals(matchName)){
        return true;
    }
    return Pattern.matches(matchName,methodName);
    }
}
