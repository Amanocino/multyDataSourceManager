package org.firstarr.stander.Config;

import lombok.extern.slf4j.Slf4j;
import org.example.Service.DynamicDataReSource;
import org.example.common.DatabaseDetail;
import org.firstarr.stander.mapper.DatabaseDetailMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 动态数据来源
 *
 * @author amanoisuno-li
 * @date 2021/12/15
 */
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {

    private DatabaseDetailMapper databaseDetailMapper = null;

    JdbcTemplate jdbcTemplate;
    /**
     * 缓存当前线程数据源的key（租户id）
     */
    private static final ThreadLocal<String> CURRENT_DATASOURCE_KEY = new ThreadLocal<>();
    /**
     * 缓存租户对应的数据源
     * ConcurrentHashMap<租户id，数据源>
     */
    private ConcurrentHashMap<Object, Object> targetDataSources = new ConcurrentHashMap<>();


    public DynamicDataSource(DataSource defaultTargetDataSource) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(targetDataSources);
    }

    /**
     * 选择当前线程数据源的key
     */
    @Override
    public Object determineCurrentLookupKey() {
        return CURRENT_DATASOURCE_KEY.get();
    }

    /**
     * 清除当前线程数据源key
     */
    public static void clearCurrentDataSourceKey() {
        CURRENT_DATASOURCE_KEY.remove();
    }

    /**
     * 设置当前线程的数据源
     */
    public void setCurrentThreadDataSource(String dataSourceKey) {
        if (!targetDataSources.containsKey(dataSourceKey)) {
            addNewDataSource(dataSourceKey);
        }
        CURRENT_DATASOURCE_KEY.set(dataSourceKey);
    }

    private synchronized void addNewDataSource(String dataSourceKey) {
        if (targetDataSources.containsKey(dataSourceKey)) {
            return;
        }
        DataSource datasource = createDataSource(dataSourceKey);
        targetDataSources.put(dataSourceKey, datasource);
        super.afterPropertiesSet();
    }


    private DataSource createDataSource(String dataSourceKey) {
        DatabaseDetail dbDetail = getDatabaseDetail(dataSourceKey);
        return DynamicDataSourceConfig.createDataSource(dbDetail);
    }

    /**
     * 拿到映射关系
     *
     * @return
     */
    private RowMapper getStudentMapper() {
        return (resultSet, i) -> {
            DatabaseDetail databaseDetail = new DatabaseDetail();
            databaseDetail.setId(resultSet.getLong("id"));
            databaseDetail.setDriverClassName(resultSet.getString("driverClassName"));
            databaseDetail.setPassword(resultSet.getString("password"));
            databaseDetail.setUrl(resultSet.getString("url"));
            databaseDetail.setUsername(resultSet.getString("username"));
            databaseDetail.setTenantId(resultSet.getString("tenant_id"));
            return databaseDetail;
        };
    }
    // 数据库信息动态获取
    private DatabaseDetail getDatabaseDetail(String dataSourceKey) {
        if (null == jdbcTemplate) {
            getDatabaseDetailMapper();
        }
        String sql = "select * from database_detail where tenant_id=? limit 1";
        Object[] param = new Object[]{dataSourceKey};
        List<DatabaseDetail> databaseDetailList = jdbcTemplate.query(sql, param, getStudentMapper());
        return databaseDetailList.get(0);
    }

    private synchronized void getDatabaseDetailMapper() {
        if (null == jdbcTemplate) {
            jdbcTemplate = SpringContextHolder.getBean(JdbcTemplate.class);
        }
    }

//    private synchronized void getDatabaseDetailMapper() {
//        if (null == dynamicDataSourceService) {
//            databaseDetailMapper = SpringContextHolder.getBean(DatabaseDetailMapper.class);
//        }
//    }


}
