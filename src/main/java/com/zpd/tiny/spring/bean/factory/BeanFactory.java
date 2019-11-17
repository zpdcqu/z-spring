package com.zpd.tiny.spring.bean.factory;

import com.zpd.tiny.spring.bean.postprocessor.AopPostProcessor;

import java.util.Map;

/**
 * bean工厂接口
 *
 * @author ZhengPeidong
 * @date 2019年 11月14日 20:45:10
 */

public interface BeanFactory {
    /**
     * 从ioc中获取对象
     * @param beanName
     * @return
     */
    Object getBean(String beanName);

    /**
     * 后置处理
     * @param postProcessor
     */

    void registerBeanPostProcessor(AopPostProcessor postProcessor);

    /**
     * 根据字节码对象获得所有实例化对象的名称
     * @param clazz
     * @return
     */
    String[] getBeanNameByType(Class<?> clazz);

    /**
     * 获取所有实例化对象
     * @param clazz
     * @return
     */
    Map<String,Object> getBeansByType(Class<?> clazz);

    Class getType(String beanName);

}
