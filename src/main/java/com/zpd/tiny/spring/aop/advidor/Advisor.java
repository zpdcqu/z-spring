package com.zpd.tiny.spring.aop.advidor;

/**
 * @author ZhengPeidong
 * @date 2019年 11月14日 23:13:09
 */

public interface Advisor {
    String getAdviceBeanName();
    String getExpress();
}
