package com.zpd.tiny.spring.context.reader.impl;

import com.zpd.tiny.spring.bean.beandefinition.BeanDefinition;
import com.zpd.tiny.spring.bean.beandefinition.BeanDefinitionRegistry;
import com.zpd.tiny.spring.bean.beandefinition.impl.DefaultBeanDefinition;
import com.zpd.tiny.spring.context.resource.Resource;
import org.apache.tools.ant.taskdefs.optional.windows.Attrib;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 解析传入的文件流，生成BeanDefinition并注册
 *
 * @author ZhengPeidong
 * @date 2019年 11月23日 23:09:05
 */

public class XmlBeanDefinitionReader extends AbstractBenDefinnitionReader{


    public XmlBeanDefinitionReader (BeanDefinitionRegistry registry) {
        super(registry);
    }
    @Override
    public void loadBeandefinition(Resource resource) {
        loadBeandefinition(resource);
    }

    @Override
    public void loadBeandefinition(Resource... resources) throws Exception {
        for (Resource res: resources){
            parse(res);
        }
    }

    private void parse(Resource resource) throws IOException, DocumentException, ClassNotFoundException {
        InputStream inputStream  = resource.getInputStream();
        //get document object
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);

        Element rootElement  = document.getRootElement();

        //解析

        List<Element> elementList = (List<Element>) document.getRootElement();
        for (Element element:elementList) {
            List<Attribute> attributes = element.attributes();
            BeanDefinition beanDefinition = new DefaultBeanDefinition();
            for (Attribute attribute:attributes){
                //class标签
                if ("class".equals(attribute.getName())) {


                    String data = (String) attribute.getData();
                    Class<?> clazz = Class.forName(data);
                    ((DefaultBeanDefinition) beanDefinition).setClazz(clazz);

                }else if ("id".equals(attribute.getName())){

                    //id 标签
                    String data  = (String) attribute.getData();
                    ((DefaultBeanDefinition) beanDefinition).setBeanName(data);
                }
            }

            if (beanDefinition.getBeanName()!=null){
                this.registry.register(beanDefinition,beanDefinition.getBeanName());
            }

        }


    }
}
