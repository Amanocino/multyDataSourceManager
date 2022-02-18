package org.example.model;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.Iterator;

@Data
public class QueryModel {
    private Integer pageNum;
    private Integer pageSize;
    private Object pageObject;
    private Object likeObject;
    private Object orderObject;
//    private String orderField;
//    private boolean isAsc;

    public IPage<Object> getPage() {
        IPage<Object> page = new Page<Object>(pageNum, pageSize);
//        if (!StringUtils.isEmpty(orderField)) {
//            OrderItem orderItem = new OrderItem();
//            orderItem.setAsc(isAsc);
//            orderItem.setColumn(orderField);
//            page.orders().add(orderItem);
//        }
        return page;

    }


    public QueryWrapper getLikeQuery() {

        QueryWrapper queryWrapper = new QueryWrapper();

        if (!StringUtils.isEmpty(pageObject)) {
            JSONObject res_data=(JSONObject) JSONObject.toJSON(pageObject);
            Iterator sIteratorEqual = res_data.keySet().iterator();
            while(sIteratorEqual.hasNext()){
                Object key=sIteratorEqual.next();   //循环遍历每个key
                String value = res_data.getString(key.toString());   //获取key里的value

                if (!StringUtils.isEmpty(value)){
                    queryWrapper.eq(true, key.toString(), value);
                }

            }
        }
        if (!StringUtils.isEmpty(likeObject)) {
            JSONObject res_data=(JSONObject) JSONObject.toJSON(likeObject);
            Iterator sIterator = res_data.keySet().iterator();
            while(sIterator.hasNext()){
                Object key=sIterator.next();   //循环遍历每个key
                String value = res_data.getString(key.toString());   //获取key里的value

                queryWrapper.like(key.toString(), value);
            }
        }
        if (!StringUtils.isEmpty(orderObject)) {
            JSONObject res_data=(JSONObject) JSONObject.toJSON(orderObject);
            Iterator sIterator = res_data.keySet().iterator();
            while(sIterator.hasNext()){
                Object key=sIterator.next();   //循环遍历每个key
                String value = res_data.getString(key.toString());   //获取key里的value
                Boolean isAsc = value.toUpperCase().equals("ASC")?Boolean.TRUE:Boolean.FALSE;
                queryWrapper.orderBy(true, isAsc, key);
            }
        }

//        if (!StringUtils.isEmpty(orderField)) {
//            queryWrapper.orderBy(true, isAsc, orderField);
//        }

        return queryWrapper;
    }
}
