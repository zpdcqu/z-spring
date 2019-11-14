package com.zpd.tiny.spring.aop.creator;

import com.zpd.tiny.spring.aop.advidor.Advisor;
import com.zpd.tiny.spring.bean.factory.BeanFactory;

import java.util.List;

/**
 * aop工厂
 */
public interface AopFactory {
    AopProxy createAopProxyInstance(Object target, List<Advisor> advisors, BeanFactory beanFactory, String beanName);

    /**
     * 没有接口使用cglib 有接口使用jdk
     * @param target
     * @return
     */
    default boolean judgeUseWhichProxyMode(Object target) {
        Class<?>[] interfaces = target.getClass().getInterfaces();
        return interfaces.length > 0;
    }

    static AopFactory createProxyIinstance(){
        return new GenericAopFactory();
    }
}