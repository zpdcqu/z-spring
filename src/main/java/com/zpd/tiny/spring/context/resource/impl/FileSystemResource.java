package com.zpd.tiny.spring.context.resource.impl;

import com.zpd.tiny.spring.context.resource.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author ZhengPeidong
 * @date 2019年 11月22日 22:57:30
 */

public class FileSystemResource implements Resource {

    private File file;

    public FileSystemResource(String path) {
        this.file = new File(path);
    }



    @Override
    public boolean isExist() {
        return file.exists();
    }

    @Override
    public File getFile() {
        return file;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(file);
    }
}
