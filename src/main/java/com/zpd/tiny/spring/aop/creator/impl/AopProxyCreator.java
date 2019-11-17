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
 * @author ZhengPeidong
 * @date 2019年 11月17日 20:37:24
 */

public class AopProxyCreator implements AopPostProcessor , BeanFactoryAware, AdvisorRegistry {

    private BeanFactory beanFactory;

    private List<Advisor> advisors;

    public AopProxyCreator(){
        advisors = new ArrayList<>();
    }


    @Override
    public Object postProcessorWeaving(Object bean, String beanName) throws Exception {
       List<Advisor> matchAdvisor  = new ArrayList<>();
       matchAdvisor = getMatchAdvisor(bean);

       if (matchAdvisor!=null&&matchAdvisor.size()>0){
            bean = AopFactory.createProxyIinstance().createAopProxyInstance(bean,matchAdvisor,beanFactory,beanName).getProxy();
        }
        return bean;
    }

    private List<Advisor> getMatchAdvisor(Object bean) throws Exception {
        if (bean==null){
            return null;
        }
        List<Advisor> matchAdvisor = new ArrayList<>();
        Class<?> clazz = bean.getClass();
        for (Advisor advisor:advisors){
            if (advisor instanceof PointCutAdvisor){
                if (((PointCutAdvisor) advisor).getPointCutResolver().matchesClass(clazz,advisor.getExpression())){
                    matchAdvisor.add(advisor);
                }
            }
        }
        return advisors;
    }

    @Override
    public void register(Advisor advisor) {
        this.advisors.add(advisor);
    }

    @Override
    public List<Advisor> getAdvisor() {
        return this.advisors;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }
}
