package com.zpd.tiny.spring.mvc.annotation;

import java.lang.annotation.*;

/**
 * @author ZhengPeidong
 * @date 2019年 11月24日 11:35:30
 */

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestMapping {
    String name() default "";
    String[] value() default{};
    String[] path() default {};

    RequestMethod[] method() default {};
    String[] params() default {};
    String[] headers() default {};
    String[] consums() default {};
    String[] produces() default {};
}
