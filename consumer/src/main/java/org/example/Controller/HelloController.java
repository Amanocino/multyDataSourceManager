package org.example.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Config.DynamicDataSource;
import org.example.anji.domain.anjiDeptmentEntity;
import org.example.anji.service.impl.anjiDeptmentServiceImpl;
import org.example.anno.DynamicDataSourceSwiftScan;
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
@DynamicDataSourceSwiftScan
@RestController
public class HelloController {
    @Autowired
    private DynamicDataSource dynamicDataSource;
    @Autowired
    private anjiDeptmentServiceImpl anjiDeptmentService;

//    @GlobalTransactional(rollbackFor = Exception.class)
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String sayHello(@RequestBody Map<String,Object> params, HttpServletRequest request) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        anjiDeptmentEntity entity = mapper.convertValue(params, anjiDeptmentEntity.class);
        Object obj = anjiDeptmentService.save(entity);
        return obj.toString();
//        return helloService.sayHello(params.get("sqlStatement").toString());
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String sayHi(@RequestBody Map<String,Object> params, HttpServletRequest reques) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        anjiDeptmentEntity entity = mapper.convertValue(params, anjiDeptmentEntity.class);
        Object obj = anjiDeptmentService.save(entity);
        return "success";
//        return helloService.sayHello(params.get("sqlStatement").toString());
    }
}
