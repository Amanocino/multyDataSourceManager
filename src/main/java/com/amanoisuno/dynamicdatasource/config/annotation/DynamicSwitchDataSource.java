package com.amanoisuno.dynamicdatasource.config.annotation;

import java.lang.annotation.*;


/**
 * 动态切换数据来源
 * 根据session 或者header中的租户id，动态切换数据源，无租户id时，使用默认数据源
 * @author amanoisuno
 * @date 2021/12/15
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DynamicSwitchDataSource {
}
