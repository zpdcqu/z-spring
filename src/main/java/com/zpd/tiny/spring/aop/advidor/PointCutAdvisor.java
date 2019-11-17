package com.zpd.tiny.spring.aop.advidor;

import com.zpd.tiny.spring.aop.pointcut.PointCut;

public interface PointCutAdvisor extends Advisor {
    PointCut getPointCutResolver();
}
