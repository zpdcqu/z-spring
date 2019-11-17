package com.zpd.tiny.spring.aop.advidor.impl;

import com.zpd.tiny.spring.aop.advidor.PointCutAdvisor;

/**
 * 切点通知实现
 *
 * @author ZhengPeidong
 * @date 2019年 11月14日 23:16:29
 */

public class RegexMachAdvisor implements PointCutAdvisor {

    // 通知名称
    private String adviceName;

    //表达式
    private String expression;

    //切点
    private PointCut pointCut;


    public RegexMachAdvisor(String adviceName, String expression, PointCut pointCut) {
        this.adviceName = adviceName;
        this.expression = expression;
        this.pointCut = pointCut;
    }

    @Override
    public PointCut getPointCutResolver() {
        return this.pointCut;
    }

    @Override
    public String getAdviceBeanName() {
        return this.adviceName;
    }

    @Override
    public String getExpress() {
        return this.expression;
    }
}
