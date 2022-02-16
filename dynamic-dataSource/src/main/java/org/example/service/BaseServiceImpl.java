package org.example.service;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M , T> implements BaseService<T>{
    @Override
    public void createWrapper(AbstractWrapper wrapper, Object wrapperEntity){

    }

    @Override
    public QueryWrapper<Object> createQueryWrapper(Object wrapperEntity){
        QueryWrapper<Object> wrapper = new QueryWrapper(wrapperEntity);
        createWrapper(wrapper, wrapperEntity);
        return wrapper;
    }

    @Override
    public UpdateWrapper<Object> createUpdateWrapper(Object wrapperEntity){
        UpdateWrapper<Object> wrapper = new UpdateWrapper(wrapperEntity);
        createWrapper(wrapper, wrapperEntity);
        return wrapper;
    }

}
