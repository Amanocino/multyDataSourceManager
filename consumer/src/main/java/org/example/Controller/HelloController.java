package org.example.Controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.example.Service.DynamicDataSourceService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author : zhicheng chen
 * @date : 2022/2/17
 * @time : 9:52
 */
@RestController
public class HelloController {
    @DubboReference
    private DynamicDataSourceService helloService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String sayHello(@RequestBody Map<String,Object> params, HttpServletRequest reques){
        return helloService.sayHello("Lily");
    }
}
