package com.zpd.tiny.spring.aop.proxy;

import com.zpd.tiny.spring.aop.advidor.Advisor;
import com.zpd.tiny.spring.aop.advidor.PointCutAdvisor;

import java.util.ArrayList;
import java.util.List;

/**
 * 提供代理接口
 */
public interface AopProxy {
    Object getProxy();
    Object getProxy(ClassLoader classLoader);

    /**
     * 获取所有匹配的通知者（advisor）
     * @param clazz
     * @param advisors
     * @return
     * @throws Exception
     */
    default List<Advisor> getMatchAdvisors(Class clazz, List<Advisor> advisors) throws Exception {
        List<Advisor> match = new ArrayList<>();
        for (Advisor advisor:advisors) {
            if (advisor instanceof PointCutAdvisor){
                PointCutAdvisor pointCutAdvisor  = (PointCutAdvisor) advisor;
                if (pointCutAdvisor.getPointCutResolver().matchesClass(clazz,pointCutAdvisor.getExpression()));{
                    match.add(advisor);
                }
            }
        }
        return match;
    }

}
