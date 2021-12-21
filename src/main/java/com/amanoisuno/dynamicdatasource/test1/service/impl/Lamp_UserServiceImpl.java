package com.amanoisuno.dynamicdatasource.test1.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.amanoisuno.dynamicdatasource.test1.domain.Lamp_UserEntity;
import com.amanoisuno.dynamicdatasource.test1.domain.lampUserEntity;
import com.amanoisuno.dynamicdatasource.test1.mapper.Lamp_UserMapper;
import com.amanoisuno.dynamicdatasource.test1.service.Lamp_UserService;
import com.amanoisuno.dynamicdatasource.service.BaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ChenZhiCheng
 * @since 2021-12-17
 */
@Service
public class Lamp_UserServiceImpl extends BaseServiceImpl<Lamp_UserMapper, Lamp_UserEntity> implements Lamp_UserService {

    @Override
    public void createWrapper(AbstractWrapper wrapper, Object wrapperEntity) {
        // 将list中的数据转成json字符串
        String jsonObject= JSON.toJSONString(wrapperEntity);
        //将json转成需要的对象
        Lamp_UserEntity lamp_userEntity= JSONObject.parseObject(jsonObject,Lamp_UserEntity.class);
//        Lamp_UserEntity lamp_userEntity = (Lamp_UserEntity)JSONObject.toBean(jsonObject, Lamp_UserEntity.class);
//        Lamp_UserEntity lamp_userEntity = (Lamp_UserEntity) wrapperEntity;
        if (wrapperEntity instanceof Lamp_UserEntity ){

            if(lamp_userEntity.getId() != null) {
                wrapper.eq("id", lamp_userEntity.getId());
            }

            if(lamp_userEntity.getName() != null) {
                wrapper.eq("name", lamp_userEntity.getName());
            }

            if(lamp_userEntity.getTenant_id() != null) {
                wrapper.eq("tenant_id", lamp_userEntity.getTenant_id());
            }
        }


        return ;
    }
}
