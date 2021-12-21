package com.amanoisuno.dynamicdatasource.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/**
 * spring上下文持有者
 *
 * @author amanoisuno
 * @date 2021/12/15
 */
@Component
public class SpringContextHolder implements ApplicationContextAware {
    private static ApplicationContext APP_CONTEXT = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        APP_CONTEXT = applicationContext;
    }

    static <T> T getBean(Class<T> requiredType) {
        return APP_CONTEXT.getBean(requiredType);
    }

    //获取上下文
    public static ApplicationContext getApplicationContext() {
        return APP_CONTEXT;
    }

    public static Object getBean(String name) {
        return SpringContextHolder.APP_CONTEXT.getBean(name);
    }

    public static String getProperty(String key) {
        return SpringContextHolder.APP_CONTEXT.getEnvironment().getProperty(key);
    }
}
