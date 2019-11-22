package com.zpd.tiny.spring.bean.beanreference;

/**
 * 包装属性依赖的属性类型
 * @author ZhengPeidong
 * @date 2019年 11月22日 22:30:21
 */

public class BeanReference {

    private String beanName;

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
