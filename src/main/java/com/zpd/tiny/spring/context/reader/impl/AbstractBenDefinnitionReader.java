package com.zpd.tiny.spring.context.reader.impl;

import com.zpd.tiny.spring.bean.beandefinition.BeanDefinition;
import com.zpd.tiny.spring.bean.beandefinition.BeanDefinitionRegistry;
import com.zpd.tiny.spring.context.reader.BeanDefinitionReader;
import com.zpd.tiny.spring.context.resource.Resource;

/**
 * @author ZhengPeidong
 * @date 2019年 11月23日 23:06:23
 */

public abstract class AbstractBenDefinnitionReader implements BeanDefinitionReader {
   protected BeanDefinitionRegistry registry;

   public AbstractBenDefinnitionReader(BeanDefinitionRegistry registry){
       this.registry = registry;
   }
}
