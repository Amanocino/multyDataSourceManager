package com.amanoisuno.dynamicdatasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.amanoisuno.dynamicdatasource.entity.DatabaseDetail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


/**
 * 动态数据源配置
 *
 * @author amanoisuno
 * @date 2021/12/15
 */
@Configuration
public class DynamicDataSourceConfig {

    @Value("${dynamic-datasource.default.url}")
    private String defaultUrl;
    @Value("${dynamic-datasource.default.driverClassName}")
    private String driverClassName;
    @Value("${dynamic-datasource.default.username}")
    private String defaultUsername;
    @Value("${dynamic-datasource.default.password}")
    private String defaultPassword;

//    @Bean("defaultDataSource")
//    public DataSource defaultDataSource() {
//        return DataSourceBuilder.create().url(defaultUrl)
//                .driverClassName(driverClassName)
//                .username(defaultUsername)
//                .password(defaultPassword).build();
//    }
        @Bean("defaultDataSource")
        @ConfigurationProperties(prefix = "dynamic-datasource.default")
        public DataSource defaultDataSource() {
            DruidDataSource druidDataSource = DruidDataSourceBuilder.create().build();
            return druidDataSource;
        }

    @Bean
    @Primary
    public DynamicDataSource dynamicDataSource(DataSource defaultDataSource) {
        return new DynamicDataSource(defaultDataSource);
    }

    static DataSource createDataSource(DatabaseDetail dbDetail) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(dbDetail.getUsername());
        druidDataSource.setPassword(dbDetail.getPassword());
        druidDataSource.setDriverClassName(dbDetail.getDriverClassName());
        druidDataSource.setUrl(dbDetail.getUrl());
//        return DataSourceBuilder.create().url(dbDetail.getUrl())
//                .driverClassName(dbDetail.getDriverClassName())
//                .username(dbDetail.getUsername())
//                .password(dbDetail.getPassword()).build();
        return druidDataSource;
    }

}
