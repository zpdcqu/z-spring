package com.zpd.tiny.spring.bean.beandefinition;

/**
 * 注册bean 定义
 * @author ZhengPeidong
 * @date 2019年 11月21日 22:47:33
 */

public interface BeanDefinitionRegistry {
    void register(BeanDefinition bd,String beanName);
    boolean cotainsBeanDefinition(String beanName);
    BeanDefinition geetBeanDefinition(String beanName);

}
