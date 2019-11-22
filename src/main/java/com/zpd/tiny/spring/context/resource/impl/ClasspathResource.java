package com.zpd.tiny.spring.context.resource.impl;

import com.zpd.tiny.spring.context.resource.Resource;
import com.zpd.tiny.spring.utils.ClassLoaderZ;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author ZhengPeidong
 * @date 2019年 11月22日 22:52:52
 */

public class ClasspathResource implements Resource {

    private ClassLoaderZ classLoaderZ;

    private String path;

    private Class clazz;

    public ClasspathResource(ClassLoaderZ classLoaderZ, String path, Class clazz) {
        this.classLoaderZ = classLoaderZ;
        this.path = path;
        this.clazz = clazz;
    }

    @Override
    public boolean isExist() {
       if (StringUtils.isNotBlank(path)){
           if (clazz!=null){
               return clazz.getResource(path)!=null;
           }else if(classLoaderZ!=null){
               return classLoaderZ.getResource(path)!=null;
           }
           return this.getClass().getResource(path)!=null;
       }
       return  false;
    }

    @Override
    public File getFile() {
        return null;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        if (StringUtils.isNotBlank(path)){
            if (clazz!=null){
                return clazz.getResourceAsStream(path);
            }else if(classLoaderZ!=null){
                return clazz.getResourceAsStream(path);
            }
            return this.getClass().getResourceAsStream(path);
        }
        return  null;
    }
}
