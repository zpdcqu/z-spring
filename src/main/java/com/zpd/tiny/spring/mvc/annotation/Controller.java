package com.zpd.tiny.spring.mvc.annotation;

import java.lang.annotation.*;

/**
 * @author ZhengPeidong
 * @date 2019年 11月24日 11:33:37
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Controller {
    String value() default "" ;
}
