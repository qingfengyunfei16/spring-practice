package com.yunfan.spring.ioc.overview.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Administrator
 * @description 超级注解
 * @create 2020/11/9 15:14
 * @since 1.0.0
 */
//指定标注作用范围
@Target(ElementType.TYPE)
//指定保留存储策略
@Retention(RetentionPolicy.RUNTIME)
public @interface Super {
}
