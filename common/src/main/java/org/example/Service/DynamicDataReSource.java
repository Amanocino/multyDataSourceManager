package org.example.Service;

import org.example.common.BaseObjectModel;
import org.example.common.DatabaseDetail;
import org.example.common.ResultJson;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author : zhicheng chen
 * @date : 2022/2/16
 * @time : 17:17
 */
public interface DynamicDataReSource {
//    String sayHello(String name);
//    public ResultJson save(BaseObjectModel params, HttpServletRequest request) ;
    DatabaseDetail queryDataSourceByTenantId(String tenantId);
}
