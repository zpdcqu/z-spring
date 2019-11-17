package com.zpd.tiny.spring.aop.advidor;

import java.util.List;

public interface AdvisorRegistry {
    void register(Advisor advisor);

    List<Advisor> getAdvisor();
}
