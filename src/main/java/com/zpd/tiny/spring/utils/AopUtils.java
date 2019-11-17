package com.zpd.tiny.spring.utils;

import com.zpd.tiny.spring.aop.advice.Advice;
import com.zpd.tiny.spring.aop.advidor.Advisor;
import com.zpd.tiny.spring.aop.advidor.PointCutAdvisor;
import com.zpd.tiny.spring.aop.chain.AopAdviceChain;
import com.zpd.tiny.spring.bean.factory.BeanFactory;
import org.apache.commons.collections.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * aop工具类
 *
 * @author ZhengPeidong
 * @date 2019年 11月17日 15:25:06
 */

public class AopUtils {

    public static Object applyAdvice(Object target, Object proxy, List<Advisor>advisors, Object[]args, Method method, BeanFactory beanFacory) throws InvocationTargetException, IllegalAccessException {
        List<Advice> advices = getMachMethodAdvice(method,target.getClass(),advisors,beanFacory);
        if (CollectionUtils.isEmpty(advices)){
            return method.invoke(target,args);
        }else {
            return new AopAdviceChain(method,target,args,proxy,advices).invoke();
        }
    }

    public static List<Advice> getMachMethodAdvice(Method method,Class<?>clazz,List<Advisor advisors,BeanFactory beanFactory>){
        if (CollectionUtils.isEmpty()){
            return null;
        }
        List<Advice> advices = new ArrayList<>();
        for (Advisor advisor:advisors) {
            if (advisor instanceof PointCutAdvisor){
                PointCutAdvisor pointCutAdvisor  = (PointCutAdvisor) advisor;
                boolean res = pointCutAdvisor.getPointCutResolver().matchesMethod(clazz,method,advisor.getExpression());

                if (res){
                    advices.add((Advice) beanFactory.getBean(advisor.getAdviceBeanName()));
                }
            }

        }
    }
}
