package com.amanoisuno.dynamicdatasource.config.factory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.amanoisuno.dynamicdatasource.model.BaseObjectModel;
import com.amanoisuno.dynamicdatasource.model.QueryModel;
import com.amanoisuno.dynamicdatasource.service.BaseService;
import com.amanoisuno.dynamicdatasource.service.BaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;

@Component
public class ServiceAction implements BaseServiceAction{
    @Autowired
    ServiceFactory serviceFactory;


    @Override
    public Object save(BaseObjectModel baseObjectModel) throws IllegalAccessException {
        BaseService iService = serviceFactory.getService(baseObjectModel.getArticleId(), baseObjectModel.getTableName());

        iService.save(baseObjectModel.getData());
        return baseObjectModel.getData();
    }

    @Override
    public Object update(BaseObjectModel baseObjectModel) throws IllegalAccessException {
        BaseService iService = serviceFactory.getService(baseObjectModel.getArticleId(), baseObjectModel.getTableName());
        iService.updateById(baseObjectModel.getData());
        return baseObjectModel.getData();
    }

    @Override
    public Object batchUpdate(BaseObjectModel baseObjectModel) throws IllegalAccessException {
        BaseService iService = serviceFactory.getService(baseObjectModel.getArticleId(), baseObjectModel.getTableName());
//        iService.updateBatchById(baseObjectModel.getObj());
        return null;
    }

    @Override
    public Object queryList(BaseObjectModel baseObjectModel) throws IllegalAccessException {
        BaseServiceImpl iService = serviceFactory.getService(baseObjectModel.getArticleId(), baseObjectModel.getTableName());

        // 将list中的数据转成json字符串
        String jsonObject= JSON.toJSONString(baseObjectModel.getData());
        //将json转成需要的对象
        QueryModel queryModel = JSONObject.parseObject(jsonObject, QueryModel.class);

//        QueryWrapper queryWrapper = iService.createQueryWrapper(queryModel.getPageObject());

        QueryWrapper queryWrapper = queryModel.getLikeQuery();

        return iService.list(queryWrapper);
    }

    @Override
    public Object queryPage(BaseObjectModel baseObjectModel) throws IllegalAccessException {
        BaseService iService = serviceFactory.getService(baseObjectModel.getArticleId(), baseObjectModel.getTableName());
        // 将list中的数据转成json字符串
        String jsonObject= JSON.toJSONString(baseObjectModel.getData());
        //将json转成需要的对象
        QueryModel queryModel = JSONObject.parseObject(jsonObject, QueryModel.class);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Object> page = new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(queryModel.getPageNum(), queryModel.getPageSize());
//        IPage<Object> page = queryModel.getPage();
//        QueryWrapper queryWrapper = iService.createQueryWrapper(queryModel.getPageObject());

//        if (!StringUtils.isEmpty(queryModel.getLikeObject())){
//            queryModel.getLikeQuery(queryWrapper);
//        }
        QueryWrapper queryWrapper = queryModel.getLikeQuery();

        return iService.page(page, queryWrapper);
    }

    @Override
    public Object queryDetail(BaseObjectModel baseObjectModel) throws IllegalAccessException {
        BaseService iService = serviceFactory.getService(baseObjectModel.getArticleId(), baseObjectModel.getTableName());

        return iService.getById((Serializable) baseObjectModel.getData());
    }

//    private String[] getFiledName(Object o) {
//        Field[] fields = o.getClass().getDeclaredFields();
//        String[] fieldNames = new String[fields.length];
//        for (int i = 0; i < fields.length; i++) {
//            System.out.println(fields[i].getType());
//            fieldNames[i] = fields[i].getName();
//        }
//        return fieldNames;
//    }


}
