package org.example.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.dubbo.config.annotation.DubboReference;
import org.example.Service.DynamicDataSourceService;
import org.example.common.BaseObjectModel;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String sayHello(@RequestBody Map<String,Object> params, HttpServletRequest reques) throws IllegalAccessException {
        ObjectMapper mapper = new ObjectMapper();
        BaseObjectModel entity = mapper.convertValue(params,BaseObjectModel.class);
        Object obj = helloService.save(entity);
        return obj.toString();
//        return helloService.sayHello(params.get("sqlStatement").toString());
    }
}
