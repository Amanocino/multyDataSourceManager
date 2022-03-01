package org.example.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.Service.DynamicDataReSource;
//import org.example.entity.DatabaseDetail;
import org.example.common.DatabaseDetail;
import org.example.entity.User;
import org.example.mapper.DatabaseDetailMapper;
import org.example.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@DubboService
@Service
public class DatabaseDetailService implements DynamicDataReSource {
    @Resource
    private DatabaseDetailMapper databaseDetailMapper;

    public DatabaseDetail selectDatabaseDetailByTenantId(String tenantId) {
        return databaseDetailMapper.selectOneByTenantId(tenantId);
    }


    @Override
    public org.example.common.DatabaseDetail queryDataSourceByTenantId(String tenantId) {
        return databaseDetailMapper.selectOneByTenantId(tenantId);
    }
}
