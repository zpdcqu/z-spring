package com.zpd.tiny.spring.aop.creator.impl;

import com.zpd.tiny.spring.aop.advidor.Advisor;
import com.zpd.tiny.spring.aop.advidor.AdvisorRegistry;
import com.zpd.tiny.spring.aop.advidor.PointCutAdvisor;
import com.zpd.tiny.spring.aop.creator.AopFactory;
import com.zpd.tiny.spring.bean.aware.BeanFactoryAware;
import com.zpd.tiny.spring.bean.factory.BeanFactory;
import com.zpd.tiny.spring.bean.postprocessor.AopPostProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * aop代理
 * @author ZhengPeidong
 * @date 2019年 11月17日 20:37:24
 */

public class AopProxyCreator implements AopPostProcessor , BeanFactoryAware, AdvisorRegistry {

    // spring 核心 beanFactory
    private BeanFactory beanFactory;

    // 通知
    private List<Advisor> advisors;

    public AopProxyCreator(){
        advisors = new ArrayList<>();
    }


    /**
     * 后置织入
     * @param bean      
     * @param beanName
     * @return
     * @throws Exception
     */
    @Override
    public Object postProcessorWeaving(Object bean, String beanName) throws Exception {
       List<Advisor> matchAdvisor  = new ArrayList<>();
       matchAdvisor = getMatchAdvisor(bean);

       if (matchAdvisor!=null&&matchAdvisor.size()>0){
            bean = AopFactory.createProxyIinstance().createAopProxyInstance(bean,matchAdvisor,beanFactory,beanName).getProxy();
        }
        return bean;
    }

    /**
     * 获得匹配的通知
     * @param bean
     * @return
     * @throws Exception
     */
    private List<Advisor> getMatchAdvisor(Object bean) throws Exception {
        if (bean==null){
            return null;
        }
        List<Advisor> matchAdvisor = new ArrayList<>();
        Class<?> clazz = bean.getClass();
        // 遍历所有通知
        for (Advisor advisor:advisors){
            if (advisor instanceof PointCutAdvisor){
                if (((PointCutAdvisor) advisor).getPointCutResolver().matchesClass(clazz,advisor.getExpression())){
                    matchAdvisor.add(advisor);
                }
            }
        }
        return advisors;
    }

    /**
     * 注册
     */
    @Override
    public void register(Advisor advisor) {
        this.advisors.add(advisor);
    }

    /**
     * 获得通知
     */
    @Override
    public List<Advisor> getAdvisor() {
        return this.advisors;
    }

    /**
     * 设置beanFactory
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }
}
