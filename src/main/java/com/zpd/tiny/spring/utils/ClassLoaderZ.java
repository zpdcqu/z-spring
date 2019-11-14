package com.zpd.tiny.spring.utils;

import java.io.*;

/**
 * 类加载器
 *
 * @author ZhengPeidong
 * @date 2019年 11月14日 19:18:36
 */

public class ClassLoaderZ extends ClassLoader {



    public void findFiles(File file) throws IOException {
        if (file==null){
            return;
        }
        File[] files = file.listFiles();
        for (File fi:files) {
            if (fi.isDirectory()){
                findFiles(fi);
            }else {
                Class clazz = loadClass(fi);
            }
        }
    }




    /**
     * 从class文件加载对象
     * @param file
     * @return
     * @throws IOException
     */
    private Class loadClass(File file) throws IOException {
        boolean isClass = isClassFile(file);
        if (!isClass){
            return null;
        }
        InputStream inputStream = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int res = 0;
        while((res = bis.read())!=-1){
            byteArrayOutputStream.write(res);
        }
        byte[] bytes = byteArrayOutputStream.toByteArray();
        String fileName = file.getName().split("\\.")[0];
        Class<?> aClass = this.defineClass(fileName, bytes, 0, bytes.length);
        return aClass;
    }






    /**
     * 判断文件是否为class文件
     * @param file
     * @return
     */
    private boolean isClassFile(File file){
        if (file==null){
            return false;
        }

        String fileName = file.getName();
       if (fileName.endsWith(".class")){
           return true;
       }else {
           return false;
       }
    }
}
