package com.zpd.tiny.spring.aop.advidor;

public interface PointCutAdvisor extends Advisor {
    PointCut getPointCutResolver();
}
