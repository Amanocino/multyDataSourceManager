package org.example.Service;

import org.example.common.BaseObjectModel;
import org.example.common.ResultJson;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author : zhicheng chen
 * @date : 2022/2/16
 * @time : 17:17
 */
public interface DynamicDataSourceService {
//    String sayHello(String name);
//    public ResultJson save(BaseObjectModel params, HttpServletRequest request) ;
    Object save(BaseObjectModel baseObjectModel) throws IllegalAccessException;
    Object update(BaseObjectModel baseObjectModel) throws IllegalAccessException;
    Object batchSave(BaseObjectModel baseObjectModel) throws IllegalAccessException;
    Object batchUpdate(BaseObjectModel baseObjectModel) throws IllegalAccessException;
    Object queryList(BaseObjectModel baseObjectModel) throws IllegalAccessException;
    Object queryPage(BaseObjectModel baseObjectModel) throws IllegalAccessException;
    Object queryDetail(BaseObjectModel baseObjectModel) throws IllegalAccessException;
}
