package com.zpd.tiny.spring.bean.aware;

import com.zpd.tiny.spring.bean.factory.BeanFactory;

/**
 * @author ZhengPeidong
 * @date 2019年 11月17日 20:49:43
 */

public interface BeanFactoryAware extends Aware {
    void setBeanFactory(BeanFactory beanFactory);

}
