package com.amanoisuno.dynamicdatasource.mapper;

import com.amanoisuno.dynamicdatasource.entity.DatabaseDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;


/**
 * 数据库细节映射器
 *
 * @author amanoisuno
 * @date 2021/12/15
 */
public interface DatabaseDetailMapper extends BaseMapper<DatabaseDetail> {

    @Select("select * from database_detail where tenant_id=#{tenantId} limit 1 ")
    DatabaseDetail selectOneByTenantId(String tenantId);
}
