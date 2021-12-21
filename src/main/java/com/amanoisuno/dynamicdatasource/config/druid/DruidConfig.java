package com.amanoisuno.dynamicdatasource.config.druid;


import com.alibaba.druid.support.http.StatViewServlet;
import org.slf4j.Logger;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DruidConfig {
    private final Logger logger = org.slf4j.LoggerFactory.getLogger(DruidConfig.class);

    @Bean
    public ServletRegistrationBean statViewServlet() {
        //创建servlet注册实体
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //设置ip白名单
        servletRegistrationBean.addInitParameter("allow", "");
        //设置ip黑名单
        servletRegistrationBean.addInitParameter("deny", "");
        //设置控制台管理用户__登录用户名和密码
        servletRegistrationBean.addInitParameter("loginUsername", "druid");
        servletRegistrationBean.addInitParameter("loginPassword", "@firstarr");
        //是否可以重置数据
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    //过滤器
//    @Bean
//    public FilterRegistrationBean filterRegist() {
//        logger.info("注册过滤器");
//        FilterRegistrationBean frBean = new FilterRegistrationBean();
//        frBean.setFilter(new SrmFilter());
//        frBean.addUrlPatterns("/*");
//        return frBean;
//    }

    /**
     * druid过滤器
     *
     * @return
     */
//    @Bean
//    public FilterRegistrationBean statFilter() {
//        //创建过滤器
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new WebStatFilter());
//        //设置过滤器过滤路径
//        filterRegistrationBean.addUrlPatterns("/*");
//        //忽略过滤的形式
//        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.png,*.css,*.ico,/druid/*");
//        return filterRegistrationBean;
//    }
}
