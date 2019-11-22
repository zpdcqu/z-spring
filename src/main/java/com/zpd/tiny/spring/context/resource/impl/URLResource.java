package com.zpd.tiny.spring.context.resource.impl;

import com.zpd.tiny.spring.context.resource.Resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author ZhengPeidong
 * @date 2019年 11月22日 22:59:56
 */

public class URLResource implements Resource {

    private URL url;

    public URLResource(String  path) throws MalformedURLException {
        this.url = new URL(path);
    }

    @Override
    public boolean isExist() {
        return url!=null;
    }

    @Override
    public File getFile() {
        return null;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return url.openStream();
    }
}
