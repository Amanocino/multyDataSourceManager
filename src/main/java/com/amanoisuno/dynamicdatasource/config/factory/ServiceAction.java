package com.amanoisuno.dynamicdatasource.config.factory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.amanoisuno.dynamicdatasource.common.api.Page;
import com.amanoisuno.dynamicdatasource.model.BaseObjectModel;
import com.amanoisuno.dynamicdatasource.model.PageModel;
import com.amanoisuno.dynamicdatasource.service.BaseService;
import com.amanoisuno.dynamicdatasource.service.BaseServiceImpl;
import com.amanoisuno.dynamicdatasource.test1.domain.Lamp_UserEntity;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

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
        QueryWrapper queryWrapper = iService.createQueryWrapper(baseObjectModel.getData());

        return iService.list(queryWrapper);
    }

    @Override
    public Object queryPage(BaseObjectModel baseObjectModel) throws IllegalAccessException {
        BaseService iService = serviceFactory.getService(baseObjectModel.getArticleId(), baseObjectModel.getTableName());
        // 将list中的数据转成json字符串
        String jsonObject= JSON.toJSONString(baseObjectModel.getData());
        //将json转成需要的对象
        PageModel pageModel= JSONObject.parseObject(jsonObject, PageModel.class);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Object> page = new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(pageModel.getPageNum(), pageModel.getPageSize());
        QueryWrapper queryWrapper = iService.createQueryWrapper(pageModel.getPageObject());

        return iService.page(page, queryWrapper);
    }

    @Override
    public Object queryDetail(BaseObjectModel baseObjectModel) throws IllegalAccessException {
        BaseService iService = serviceFactory.getService(baseObjectModel.getArticleId(), baseObjectModel.getTableName());

        return iService.getById((Serializable) baseObjectModel.getData());
    }
}
