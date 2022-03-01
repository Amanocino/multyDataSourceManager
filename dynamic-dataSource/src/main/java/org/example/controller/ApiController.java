package org.example.controller;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.common.*;
import org.example.config.factory.ServiceAction;
import org.example.entity.User;
//import org.example.model.BaseObjectModel;
import org.example.service.DatabaseDetailService;
import org.example.service.UserService;
import org.example.service.impl.DynamicSqlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * 用户控制器
 *
 * @author chenzhicheng
 * @date 2021/12/15
 */
@RestController
@Api(tags = "多租户管理端--用户模块")
public class ApiController {

    @Autowired
    private ServiceAction serviceAction;
    @Autowired
    private DynamicSqlService dynamicSqlService;
    @Autowired
    private DatabaseDetailService databaseDetailService;

    @Autowired
    private UserService userService;
    @ApiOperation(value = "获取用户", notes = "获取各租户下所有用户")
    @GetMapping("/user")
    public List<User> getAll() {
        return userService.selectAll();
    }

    @ApiOperation(value = "新增用户", notes = "新增用户")
    @PostMapping("/user")
    public int insertOne(@RequestBody User user) {
        try {
            return userService.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @ApiOperation(value = "获取租户数据库", notes = "获取各租户下的对应数据库")
    @RequestMapping(value = "/databaseDetailByTenantId", method = RequestMethod.POST)
    public ResultJson getDatabaseDetailByTenantId(@RequestBody BaseObjectModel params, HttpServletRequest request) {
        if (null== params || null==params.getTenantId()){
            return new ResultJson().error("查询失败，tenantId不能为空！");
        }
        DatabaseDetail databaseDetail = databaseDetailService.selectDatabaseDetailByTenantId(params.getTenantId().toString());
        ResultJson resultJson = new ResultJson().success("查询成功");

        resultJson.setData(databaseDetail);
        return resultJson;
    }

    /**
     * 保存数据
     * @param params
     * @param request
     * @return
     */

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResultJson save(@Validated(value = ValidGroup.Crud.Create.class) @RequestBody BaseObjectModel params, HttpServletRequest request) throws Exception {

        int userId=Integer.parseInt(request.getHeader("userId"));
        int tenantId=Integer.parseInt(request.getHeader("tenantId"));
        params.setTenantId(tenantId);
        Object obj = serviceAction.save(params);
        ResultJson resultJson = new ResultJson().success("新增成功");

        resultJson.setData(obj);
        return resultJson;
    }

    /**
     * 编辑数据
     * @param params
     * @param request
     * @return
     */

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultJson update(@Validated(value = ValidGroup.Crud.Update.class) @RequestBody BaseObjectModel params, HttpServletRequest request) throws IllegalAccessException {

        int userId=Integer.parseInt(request.getHeader("userId"));
        int tenantId=Integer.parseInt(request.getHeader("tenantId"));
        params.setTenantId(tenantId);
        Object obj = serviceAction.update(params);
        ResultJson resultJson = new ResultJson().success("编辑成功");

        resultJson.setData(obj);
        return resultJson;
    }

    /**
     * 批量新增数据
     * @param params
     * @param request
     * @return
     */

    @RequestMapping(value = "/batchSave", method = RequestMethod.POST)
    public ResultJson batchSave(@Validated(value = ValidGroup.Crud.Create.class) @RequestBody BaseObjectModel params, HttpServletRequest request) throws IllegalAccessException {

        int userId=Integer.parseInt(request.getHeader("userId"));
        int tenantId=Integer.parseInt(request.getHeader("tenantId"));
        params.setTenantId(tenantId);
        Object obj = serviceAction.batchSave(params);

        ResultJson resultJson = new ResultJson().success("批量新增成功");
        resultJson.setData(obj);
        return resultJson;
    }

    /**
     * 批量编辑数据
     * @param params
     * @param request
     * @return
     */

    @RequestMapping(value = "/batchUpdate", method = RequestMethod.POST)
    public ResultJson batchUpdate(@Validated(value = ValidGroup.Crud.Update.class)@RequestBody BaseObjectModel params, HttpServletRequest request) throws IllegalAccessException {

        int userId=Integer.parseInt(request.getHeader("userId"));
        int tenantId=Integer.parseInt(request.getHeader("tenantId"));
        params.setTenantId(tenantId);
        Object obj = serviceAction.batchUpdate(params);
        ResultJson resultJson = new ResultJson().success("批量编辑成功");
        resultJson.setData(obj);
        return resultJson;
    }

    /**
     * 查询数据列表
     * @param params
     * @param request
     * @return
     */

    @RequestMapping(value = "/queryList", method = RequestMethod.POST)
    public ResultJson queryList(@Validated(value = ValidGroup.Crud.Query.class)@RequestBody BaseObjectModel params, HttpServletRequest request) throws IllegalAccessException {

        int userId=Integer.parseInt(request.getHeader("userId"));
        int tenantId=Integer.parseInt(request.getHeader("tenantId"));
        params.setTenantId(tenantId);
        Object obj = serviceAction.queryList(params);
        ResultJson resultJson = new ResultJson().success("查询成功");
        resultJson.setData(obj);
        return resultJson;
    }

    /**
     * 分页查询数据
     * @param params
     * @param request
     * @return
     */

    @RequestMapping(value = "/queryPage", method = RequestMethod.POST)
    public ResultJson queryPage(@Validated(value = ValidGroup.Crud.Query.class)@RequestBody BaseObjectModel params, HttpServletRequest request) throws IllegalAccessException {
        int userId=Integer.parseInt(request.getHeader("userId"));
        int tenantId=Integer.parseInt(request.getHeader("tenantId"));
        params.setTenantId(tenantId);
        Object obj = serviceAction.queryPage(params);
        ResultJson resultJson = new ResultJson().success("查询成功");
        resultJson.setData(obj);
        return resultJson;
    }

    /**
     * 根据id查询数据详情
     * @param params
     * @param request
     * @return
     */

    @RequestMapping(value = "/queryById", method = RequestMethod.POST)
    public ResultJson queryById(@Validated(value = ValidGroup.Crud.Query.class)@RequestBody BaseObjectModel params, HttpServletRequest request) throws IllegalAccessException {
        int userId=Integer.parseInt(request.getHeader("userId"));
        int tenantId=Integer.parseInt(request.getHeader("tenantId"));
        params.setTenantId(tenantId);
        Object obj = serviceAction.queryDetail(params);
        ResultJson resultJson = new ResultJson().success("查询成功");
        resultJson.setData(obj);
        return resultJson;
    }

    /**
     * 根据SQL语句执行查询操作
     * @param params 执行的SQL语句|String
     * @param request
     * @return
     */

    @RequestMapping(value = "/queryBySql", method = RequestMethod.POST)
    public ResultJson queryBySql(@Validated(value = ValidGroup.Crud.QueryStatement.class)@RequestBody BaseObjectModel params, HttpServletRequest request){
        ResultJson resultJson = new ResultJson();

        int userId=Integer.parseInt(request.getHeader("userId"));
        int tenantId=Integer.parseInt(request.getHeader("tenantId"));
        params.setTenantId(tenantId);
//        if(params == null
//                || !params.containsKey("sqlStatement") || StringUtils.isEmpty(params.get("sqlStatement"))){
//            resultJson.setResult(Dict.REQUEST_FAIL);
//            resultJson.setMessage("缺少必要参数");
//            return resultJson;
//        }
        try {
//            String sqlStatement = null == params.get("sqlStatement") ? "null" : params.get("sqlStatement").toString();
            LinkedList<Map> obj = dynamicSqlService.dynamicSqlQuery(params);
            resultJson.setResult(Dict.REQUEST_SUCCEED);
            resultJson.setMessage("查询成功");
            resultJson.setData(obj);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return resultJson;
    }

    /**
     * 根据SQL语句执行新增或修改操作
     * @param params
     * @param request
     * @return
     */

    @RequestMapping(value = "/insertOrUpdateBySql", method = RequestMethod.POST)
    public ResultJson insertOrUpdateBySql(@Validated(value = ValidGroup.Crud.SaveStatement.class)@RequestBody BaseObjectModel params, HttpServletRequest request){
        ResultJson resultJson = new ResultJson();

        int userId=Integer.parseInt(request.getHeader("userId"));
        int tenantId=Integer.parseInt(request.getHeader("tenantId"));
        params.setTenantId(tenantId);
//        if(params == null
//                || !params.containsKey("sqlStatement") || StringUtils.isEmpty(params.get("sqlStatement"))){
//            resultJson.setResult(Dict.REQUEST_FAIL);
//            resultJson.setMessage("缺少必要参数");
//            return resultJson;
//        }
        try {
//            String sqlStatement = null == params.get("sqlStatement") ? "null" : params.get("sqlStatement").toString();
            int obj = dynamicSqlService.dynamicSqlInsert(params);
            resultJson.setResult(Dict.REQUEST_SUCCEED);
            resultJson.setMessage("新增成功");
            resultJson.setData(obj);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return resultJson;
    }
}
