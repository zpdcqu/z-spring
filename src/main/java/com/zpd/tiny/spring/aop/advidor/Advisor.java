package com.zpd.tiny.spring.aop.advidor;

/**
 * 顾问是切面的另一种实现，可以完成简单的织入功能。通知定义了增强
 * 代码切入到目标代码的时间点，是目标方法执行之前执行，还是执行之后执行
 * 切入点定义切入的位置，通知定义切入的时间。
 * @author ZhengPeidong
 * @date 2019年 11月14日 23:13:09
 */

public interface Advisor {

    /**
     * 获取通知的Bean名
     * @return
     */
    String getAdviceBeanName();

    /**
     * 表达式
     */
    String getExpression();
}
