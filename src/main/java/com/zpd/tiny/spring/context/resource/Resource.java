package com.zpd.tiny.spring.context.resource;

import sun.awt.image.InputStreamImageSource;

import java.io.File;

/**
 * 存放读取配置文件的接口
 */
public interface Resource extends InputStreamSource {

    boolean isExist();
    File getFile();
}
