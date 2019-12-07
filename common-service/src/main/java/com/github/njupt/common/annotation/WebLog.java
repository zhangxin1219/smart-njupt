package com.github.njupt.common.annotation;

import java.lang.annotation.*;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/10/28 09:14
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface WebLog {
    String description() default "";
}
