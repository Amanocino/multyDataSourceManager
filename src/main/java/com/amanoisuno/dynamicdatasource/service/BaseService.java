package com.amanoisuno.dynamicdatasource.service;

import com.amanoisuno.dynamicdatasource.test1.domain.lampUserEntity;
import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.service.IService;

public interface BaseService<T> extends IService<T> {
    void createWrapper(AbstractWrapper wrapper, Object wrapperEntity);

    QueryWrapper<Object> createQueryWrapper(Object wrapperEntity);

    UpdateWrapper<Object> createUpdateWrapper(Object wrapperEntity);
//    default QueryWrapper<T> createQueryWrapper(T wrapperEntity){
//        QueryWrapper<T> wrapper = new QueryWrapper();
//        createWrapper(wrapper, wrapperEntity);
//        return wrapper;
//    }
//
//    default UpdateWrapper<T> createUpdateWrapper(T wrapperEntity){
//        UpdateWrapper<T> wrapper = new UpdateWrapper();
//        createWrapper(wrapper, wrapperEntity);
//
//        return wrapper;
//    }
}
