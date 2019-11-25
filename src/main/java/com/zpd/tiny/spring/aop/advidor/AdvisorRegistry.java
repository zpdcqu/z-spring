package com.zpd.tiny.spring.aop.advidor;

import java.util.List;
/**
 * 通知注册
 */
public interface AdvisorRegistry {
    /**
     * 注册通知
     */
    void register(Advisor advisor);

    /**
     * 获取所有通知
     * @return
     */
    List<Advisor> getAdvisor();
}
