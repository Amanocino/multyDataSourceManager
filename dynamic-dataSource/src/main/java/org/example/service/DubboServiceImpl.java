package org.example.service;

import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author : zhicheng chen
 * @date : 2022/2/16
 * @time : 17:10
 */
//@DubboService
public class DubboServiceImpl  {

//    @Override
    public String sayHello(String name){
        return "Hello World:"+ name;
    }
}
