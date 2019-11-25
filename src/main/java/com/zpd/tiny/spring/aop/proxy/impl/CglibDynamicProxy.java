package com.zpd.tiny.spring.aop.proxy.impl;

import com.zpd.tiny.spring.aop.advidor.Advisor;
import com.zpd.tiny.spring.aop.creator.AopFactory;
import com.zpd.tiny.spring.aop.proxy.AopProxy;
import com.zpd.tiny.spring.bean.beandefinition.BeanDefinition;
import com.zpd.tiny.spring.bean.factory.BeanFactory;
import com.zpd.tiny.spring.utils.AopUtils;
import com.zpd.tiny.spring.utils.ClassLoaderZ;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

/**
 * cglib代理实现
 * @author ZhengPeidong
 * @date 2019年 11月17日 21:00:12
 */

public class CglibDynamicProxy implements MethodInterceptor, AopProxy {

//    private static final Log logger = LoggerFactory.getLogger(CglibDynamicProxy.class);

    // 增强
    private Enhancer enhancer = new Enhancer();
    // 目标
    private Object target;
    // 通知
    private List<Advisor> advisors;
    // 被增强bean类名
    private String beanName;
    // bean工厂
    private BeanFactory beanFactory;

    /**
     * 构造方法
     * @param target
     * @param advisors
     * @param beanName
     * @param beanFactory
     */
    public CglibDynamicProxy(Object target, List<Advisor> advisors, String beanName, BeanFactory beanFactory) {
        this.target = target;
        this.advisors = advisors;
        this.beanName = beanName;
        this.beanFactory = beanFactory;
    }



    /**
     * 拦截器
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return AopUtils.applyAdvice(target,o,method,objects,methodProxy);
    }

    /**
     * 获得代理
     */
    @Override
    public Object getProxy() {
        return getProxy(target.getClass().getClassLoader());
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
        System.out.printf("为"+target+"创建cglib代理");
        enhancer.setSuperclass(target.getClass());
        enhancer.setClassLoader(classLoader);
        enhancer.setInterfaces(target.getClass().getInterfaces());
        enhancer.setCallback(this);
        Object res = null;
        Constructor<?>[] constructors = target.getClass().getConstructors();
        if (constructors.length>0){
            BeanDefinition bd = beanFactory.getBeanDefinition(beanName);
            if (bd.getContructor()!=null){
                return enhancer.create()
            }
            )
        }
    }
}

