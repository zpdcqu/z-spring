package com.zpd.tiny.spring.aop.creator.impl;

import com.zpd.tiny.spring.aop.proxy.AopProxy;
import com.zpd.tiny.spring.aop.advidor.Advisor;
import com.zpd.tiny.spring.aop.creator.AopFactory;
import com.zpd.tiny.spring.aop.proxy.impl.CglibDynamicProxy;
import com.zpd.tiny.spring.bean.factory.BeanFactory;

import java.util.List;

/**
 * aop工厂实现类
 * @author ZhengPeidong
 * @date 2019年 11月17日 20:55:02
 */

public class GenericAopFactory implements AopFactory {
    /**
     * 创建aop
     */
    @Override
    public AopProxy createAopProxyInstance(Object target, List<Advisor> advisors, BeanFactory beanFactory, String beanName) {
        // 判断是否是接口
        boolean res = judgeUseWhichProxyMode(target);
        if (res){
            // 有接口使用jdk代理
            return new JDKDynamicProxy(target,advisors,beanFactory);
        }else {
            //cglib 没有接口
            return new CglibDynamicProxy(target,advisors,beanFactory,beanName);
        }
    }
}
