package com.zpd.tiny.spring.context.reader;

import com.zpd.tiny.spring.context.resource.Resource;

/**
 * 读取文件传输的字节流
 * @author ZhengPeidong
 * @date 2019年 11月23日 23:03:13
 */

public interface BeanDefinitionReader {

    void loadBeandefinition(Resource resource);
    void loadBeandefinition(Resource ... resources) throws Exception;
}
