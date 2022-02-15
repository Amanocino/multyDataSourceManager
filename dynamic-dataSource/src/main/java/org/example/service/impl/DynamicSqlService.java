package org.example.service.impl;

import org.example.mapper.DynamicSqlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Map;

@Service
public class DynamicSqlService {
    @Autowired
    DynamicSqlMapper dynamicSqlMapper;

    /**
     * 查询SQL语句执行
     * @param sqlStatement
     * @return
     */
    public LinkedList<Map> dynamicSqlQuery(String sqlStatement) {
        return dynamicSqlMapper.querySqlExecute(sqlStatement);
    }

    /**
     * 新增修改SQL语句执行
     * @param sqlStatement
     * @return
     */
    public int dynamicSqlInsert(String sqlStatement) {
        return dynamicSqlMapper.insertSqlExecute(sqlStatement);
    }
}
