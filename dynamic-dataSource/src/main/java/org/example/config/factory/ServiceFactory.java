package org.example.config.factory;

import org.example.service.BaseServiceImpl;
import org.example.utils.SwitchCaseUtil;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ServiceFactory implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    private String[] articleStringArray = new String[]{"Mes", "Daqing", "Anji", "Nanchang", "Langchao", "Lamp"};


    public BaseServiceImpl getService(Integer articleId, String tableName) throws IllegalAccessException {
        if (articleId>articleStringArray.length){
            throw new IllegalAccessException("不存在指定系统");
        }
        String articleName = articleStringArray[articleId-1];
        return applicationContext != null ? (BaseServiceImpl) applicationContext.getBean(SwitchCaseUtil.lowerFirstCase(articleName)+"_"+SwitchCaseUtil.upperFirstCase(tableName)+"ServiceImpl") : null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
