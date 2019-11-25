package com.zpd.tiny.spring.aop.advidor;

import com.zpd.tiny.spring.aop.pointcut.PointCut;

/**
 *  指定具体的切入点，顾问将通知进行包装，会根据不同的通知类型
 * 在不同的时间点，将切面织入到不同的切入点
 */
public interface PointCutAdvisor extends Advisor {

    /**
     * 获取切面解决器
     */
    PointCut getPointCutResolver();
}
