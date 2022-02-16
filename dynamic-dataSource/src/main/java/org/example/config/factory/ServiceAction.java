package org.example.config.factory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.example.model.BaseObjectModel;
import org.example.model.QueryModel;
import org.example.service.BaseService;
import org.example.service.BaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.utils.ObjectSwitch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.Serializable;
import java.util.List;

@Component
public class ServiceAction implements BaseServiceAction{
    @Autowired
    ServiceFactory serviceFactory;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object save(BaseObjectModel baseObjectModel) throws IllegalAccessException {

        try{
            BaseService iService = serviceFactory.getService(baseObjectModel.getArticleId(), baseObjectModel.getTableName());

            iService.save(baseObjectModel.getData());
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw e;
        }

        return baseObjectModel.getData();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object update(BaseObjectModel baseObjectModel) throws IllegalAccessException {
        try{
            BaseService iService = serviceFactory.getService(baseObjectModel.getArticleId(), baseObjectModel.getTableName());

            iService.updateById(baseObjectModel.getData());
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw e;
        }

        return baseObjectModel.getData();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object batchSave(BaseObjectModel baseObjectModel) throws IllegalAccessException {
        try{
            BaseService iService = serviceFactory.getService(baseObjectModel.getArticleId(), baseObjectModel.getTableName());

//            iService.saveBatch(ObjectSwitch.castList(baseObjectModel.getData(), Object.class));
            iService.saveBatch((List<Object>)baseObjectModel.getData());
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw e;
        }

        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object batchUpdate(BaseObjectModel baseObjectModel) throws IllegalAccessException {
        try{
            BaseService iService = serviceFactory.getService(baseObjectModel.getArticleId(), baseObjectModel.getTableName());

//            iService.updateBatchById(ObjectSwitch.castList(baseObjectModel.getData(), Object.class));
            iService.updateBatchById((List<Object>)baseObjectModel.getData());
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw e;
        }

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
