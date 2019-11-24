package com.zpd.tiny.spring.mvc.handler;

import com.zpd.tiny.spring.bean.aware.ApplicationContextAware;
import com.zpd.tiny.spring.context.app.ApplicationContext;
import com.zpd.tiny.spring.mvc.controller.RequestMappingInfo;
import org.omg.PortableInterceptor.RequestInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author ZhengPeidong
 * @date 2019年 11月24日 11:52:04
 */

public class RequestMappingHandlerMapping implements HandlerMapping,InitializingBean, ApplicationContextAware {

    private ApplicationContext applicationContext;

    private List<RequestMappingInfo> requestMappingInfos;

    private Map<String,List<RequestMappingInfo>> urlMaps;
    @Override
    public void setApplicationContextAware(ApplicationContext applicationContext) {
        this.applicationContext  = applicationContext;
    }

    @Override
    public Object getHandler(HttpServletRequest request) {
        return null;
    }

    @Override
    public void afterPropertiesSet() {
    String [] beanNameForType  = applicationContext.getBeanNameByType(Object.class);
    for (String beanName:beanNameForType) {
        Class type = applicationContext.getType(beanName);

        //判断是否控制器类型

        if (isHandler(type)){
            detectHandlerMethod(type);
        }


    }



    }
    private void detectHandlerMethod(Class type){

    }

    private boolean isHandler(Class benaType){
        return  false;
    }
}
