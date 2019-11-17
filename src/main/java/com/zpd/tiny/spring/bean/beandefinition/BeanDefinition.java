package com.zpd.tiny.spring.bean.beandefinition;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * bean定义接口
 * @author ZhengPeidong
 * @date 2019年 11月17日 21:18:15
 */

public interface BeanDefinition {

    String SINGLETON = "singleton";
    String PROTOTYPE = "prototype";

    Class<?> getBeanClass();

    String getBeanName();

   String  getBeanFactory();

   String getCreateBeanMethod();
   String getStaticCreateBeanMethod();

   String getBeanInitMethodName();

   String getScope();

   boolean isSingleton();

   boolean isPrototype();

   default boolean validate(){
       if (getBeanClass()==null){
           if (StringUtils.isBlank(getBeanFactory())&&StringUtils.isBlank(getCreateBeanMethod())){

                return false;
           }
        }
        return true;
    }

    List<?> getContructorArg();

    Constructor<?> getConsructor();

    void setContructor(Constructor<?> contructor);

    Method getFactoryMethod(Method factoryMethod);

    void setProperyKeyValue(Map<String,Object> properties);
}