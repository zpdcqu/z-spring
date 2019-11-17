package com.zpd.tiny.spring.bean.aware;

import com.zpd.tiny.spring.ApplicationContext;

/**
 * 注入常用的对象
 *
 * @author ZhengPeidong
 * @date 2019年 11月14日 20:39:27
 */
public interface ApplicationContextAware {

    void setApplicationContextAware(ApplicationContext applicationContext);
}
