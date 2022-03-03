package org.test;

import lombok.extern.slf4j.Slf4j;
import org.firstarr.stander.anno.EnableDynamicDataSourceSwift;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.spring.web.SpringfoxWebMvcConfiguration;

/**
 * @author : zhicheng chen
 * @date : 2022/2/17
 * @time : 9:49
 */
@EnableDiscoveryClient
@EnableTransactionManagement
@ConditionalOnClass(SpringfoxWebMvcConfiguration.class)
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("org.test.anji.mapper")
@EnableDynamicDataSourceSwift
@Slf4j
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
