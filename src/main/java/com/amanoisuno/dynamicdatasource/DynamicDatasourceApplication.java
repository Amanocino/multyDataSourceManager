package com.amanoisuno.dynamicdatasource;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.spring.web.SpringfoxWebMvcConfiguration;
import java.net.InetAddress;


/**
 * 动态数据源的应用程序
 *
 * @author amanoisuno-li
 * @date 2021/12/15
 */
@ConditionalOnClass(SpringfoxWebMvcConfiguration.class)
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.amanoisuno.dynamicdatasource")
@Slf4j
public class DynamicDatasourceApplication implements WebMvcConfigurer {

    @SneakyThrows
    public static void main(String[] args) {
        ConfigurableApplicationContext application = SpringApplication.run(DynamicDatasourceApplication.class, args);
        Environment env = application.getEnvironment();
        log.info("\n----------------------------------------------------------\n\t" +
                        "应用 '{}' 运行成功! 访问连接:\n\t" +
                        "Swagger文档: \t\thttp://{}:{}/doc.html\n\t" +
                        "数据库监控: \t\thttp://{}:{}/druid\n" +
                        "springboot监控：\t\thttp://{}:{}/actuator/beans" +
                        "在线apifox文档：\t\thttps://www.apipark.cn/s/3f4b91d7-462c-44e8-b885-ceb018029c29 访问密码：Q0Rehq3X" +
                        "----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port", "9990"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port", "9990"));
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
