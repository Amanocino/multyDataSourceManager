package org.example.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.Service.DynamicDataSourceService;

/**
 * @author : zhicheng chen
 * @date : 2022/2/16
 * @time : 17:10
 */
@DubboService
public class DubboServiceImpl implements DynamicDataSourceService {

    @Override
    public String sayHello(String name){
        return "Hello World:"+ name;
    }
}
