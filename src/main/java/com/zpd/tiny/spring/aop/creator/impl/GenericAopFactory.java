package com.zpd.tiny.spring.aop.creator.impl;

import com.zpd.tiny.spring.aop.proxy.AopProxy;
import com.zpd.tiny.spring.aop.advidor.Advisor;
import com.zpd.tiny.spring.aop.creator.AopFactory;
import com.zpd.tiny.spring.aop.proxy.impl.CglibDynamicProxy;
import com.zpd.tiny.spring.bean.factory.BeanFactory;

import java.util.List;

/**
 * @author ZhengPeidong
 * @date 2019年 11月17日 20:55:02
 */

public class GenericAopFactory implements AopFactory {
    @Override
    public AopProxy createAopProxyInstance(Object target, List<Advisor> advisors, BeanFactory beanFactory, String beanName) {
        boolean res = judgeUseWhichProxyMode(target);
        if (res){
            return new JDKDynamicProxy(target,advisors,beanFactory);
        }else {
            //cglib
            return new CglibDynamicProxy(target,advisors,beanFactory,beanName);
        }
    }
}
