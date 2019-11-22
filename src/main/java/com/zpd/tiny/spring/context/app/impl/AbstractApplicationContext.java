package com.zpd.tiny.spring.context.app.impl;

import com.zpd.tiny.spring.bean.factory.BeanFactory;
import com.zpd.tiny.spring.bean.factory.impl.DefaultBeanFactory;
import com.zpd.tiny.spring.context.app.ApplicationContext;
import com.zpd.tiny.spring.context.resource.Resource;
import com.zpd.tiny.spring.context.resource.impl.ClasspathResource;
import com.zpd.tiny.spring.context.resource.impl.FileSystemResource;
import com.zpd.tiny.spring.context.resource.impl.URLResource;


/**
 * @author ZhengPeidong
 * @date 2019年 11月22日 22:35:30
 */

public class AbstractApplicationContext implements ApplicationContext {

    protected BeanFactory beanFactory;

    public AbstractApplicationContext(){
        this.beanFactory = new DefaultBeanFactory();
    }



    public Resource getResource(String locations) throws Exception{
        if (locations.contains(":")){
            String [] split = locations.split(":");
            StringBuilder sb = new StringBuilder();
            sb.append(split[1]);
            for (int i = 2;i<split.length;i++){
                sb.append(":"+split[i]);
            }

            if ("url".equals(split[0])){
                return new URLResource(sb.toString());
            }else if ("classpath".equals(split[0])){
                return new ClasspathResource(null,sb.toString(),null);
            }else if ("file".equals(split[0])){
                return new FileSystemResource(sb.toString());
            }
        }else {
            throw new Exception("传入的配置文件ioc格式出错");
        }
        return null;
    }






























}
