package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.example.Config.DynamicDataSource;
import org.example.anno.DynamicDataSourceSwiftScan;
import org.example.common.BaseObjectModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * 数据来源切面
 *
 * @author amanoisuno
 * @date 2021/12/15
 */
@Aspect
@Component
public class DataSourceAspect {

//    private final static String POINT_CUT = "dataSourcePointCut(dynamicDataSourceSwiftScan)";
    @Autowired
    private DynamicDataSource dynamicDataSource;


    /**
     * 切换数据源应发生在事务之前，否则仍然会使用默认数据源，
     * 故数据源切换放在controller层（默认事务应放到service层）
     * //@Pointcut("@annotation(DynamicSwitchDataSource)")
     */
//    @Pointcut("execution(public * org.example.controller..*.*(..))")
//    @Pointcut("(execution(public * org.example.Controller..*(..)))")
//    @Pointcut("@annotation(dynamicDataSourceSwiftScan)")
//    public void dataSourcePointCut(DynamicDataSourceSwiftScan dynamicDataSourceSwiftScan) {
//    }
    @Pointcut("@within(org.example.anno.DynamicDataSourceSwiftScan)")
    public void dataSourcePointCut() {
    }

    @Before("dataSourcePointCut()")
    public void beforeExecute(JoinPoint joinPoint) {
        String tenantId = getTenantIdFromSession(joinPoint);
        if (tenantId != null) {
            dynamicDataSource.setCurrentThreadDataSource(tenantId);
        }

    }

    @After("dataSourcePointCut()")
    public void afterExecute() {
        DynamicDataSource.clearCurrentDataSourceKey();
    }

    //TODO 从session中获取租客id
    private String getTenantIdFromSession(JoinPoint joinPoint) {
//        String tenantId ;
//        //获取目标方法的参数信息
//        Object[] obj = joinPoint.getArgs();
//        for (Object argItem : obj) {
//            System.out.println("---->now-->argItem:" + argItem);
//            if (argItem instanceof BaseObjectModel) {
//                BaseObjectModel paramVO = (BaseObjectModel) argItem;
//                return paramVO.getTenantId().toString();
//            }
//            System.out.println("---->after-->argItem:" + argItem);
//        }
//        return null;
        String tenantId ;
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = attributes.getRequest();
        tenantId = httpServletRequest.getHeader("tenantId");
        return tenantId;
    }
}
