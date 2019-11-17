package com.zpd.tiny.spring.bean.postprocessor;

/**
 * @author ZhengPeidong
 * @date 2019年 11月17日 20:39:04
 */

public interface AopPostProcessor extends BeanPostProcessor {
    Object postProcessorWeaving(Object bean,String beanName) throws Exception;
}
