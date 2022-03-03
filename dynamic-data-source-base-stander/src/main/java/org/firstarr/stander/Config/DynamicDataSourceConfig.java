package org.firstarr.stander.Config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.example.Service.DynamicDataReSource;
import org.example.common.DatabaseDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


/**
 * 动态数据源配置
 *
 * @author amanoisuno
 * @date 2021/12/15
 */
@Configuration
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
public class DynamicDataSourceConfig {

//    @Bean("defaultDataSource")
//    public DataSource defaultDataSource() {
//        return createDataSource(dynamicDataSourceService.queryDataSourceByTenantId(defaultTenantId));
//    }
    @Bean("defaultDataSource")
    @ConfigurationProperties(prefix = "dynamic-datasource.default")
    public DataSource defaultDataSource() {
        DruidDataSource druidDataSource = DruidDataSourceBuilder.create().build();
        return druidDataSource;
    }
//        @Bean("defaultDataSource")
//        @ConfigurationProperties(prefix = "dynamic-datasource.default")
//        public DataSource defaultDataSource() {
//            DruidDataSource druidDataSource = DruidDataSourceBuilder.create().build();
//            return druidDataSource;
//        }

    @Bean
    @Primary
    public DynamicDataSource dynamicDataSource(DataSource defaultDataSource) {
        return new DynamicDataSource(defaultDataSource);
    }

    static DataSource createDataSource(DatabaseDetail dbDetail) {
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUsername(dbDetail.getUsername());
//        druidDataSource.setPassword(dbDetail.getPassword());
//        druidDataSource.setDriverClassName(dbDetail.getDriverClassName());
//        druidDataSource.setUrl(dbDetail.getUrl());
        return DataSourceBuilder.create().url(dbDetail.getUrl())
                .driverClassName(dbDetail.getDriverClassName())
                .username(dbDetail.getUsername())
                .password(dbDetail.getPassword()).build();
//        return druidDataSource;
//        return druidDataSource;
    }

}
