package org.example.service.impl;

import org.example.common.BaseObjectModel;
import org.example.mapper.DynamicSqlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.LinkedList;
import java.util.Map;

@Service
public class DynamicSqlService {
    @Autowired
    DynamicSqlMapper dynamicSqlMapper;
    @Autowired
    private DynamicSqlService dynamicSqlService;

    /**
     * 查询SQL语句执行
     * @param params
     * @return
     */
    public LinkedList<Map> dynamicSqlQuery(BaseObjectModel params) {
        return dynamicSqlMapper.querySqlExecute(params.getData().toString());
    }

    /**
     * 新增修改SQL语句执行
     * @param params
     * @return
     */
    public int dynamicSqlInsert(BaseObjectModel params) {
        return dynamicSqlService.updateObject(params.getData().toString());
    }

    @Transactional(rollbackFor = Exception.class)
    public int updateObject(String sqlStatement) {
        try{
            dynamicSqlMapper.insertSqlExecute(sqlStatement);
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw e;
        }
        return 0;
    }
}
