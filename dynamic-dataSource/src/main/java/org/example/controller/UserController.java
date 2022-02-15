package org.example.controller;

import org.example.common.Dict;
import org.example.common.ResultJson;
import org.example.config.factory.ServiceAction;
import org.example.entity.User;
import org.example.model.BaseObjectModel;
import org.example.service.UserService;
import org.example.service.impl.DynamicSqlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;
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
public class UserController {

    @Autowired
    private ServiceAction serviceAction;
    @Autowired
    private DynamicSqlService dynamicSqlService;

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

    /**
     * 保存数据
     * @param params
     * @param request
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResultJson save(@RequestBody BaseObjectModel params, HttpServletRequest request){
        ResultJson resultJson = new ResultJson();

        int userId=Integer.parseInt(request.getHeader("userId"));

        try {

            Object obj = serviceAction.save(params);
            resultJson.setResult(Dict.REQUEST_SUCCEED);
            resultJson.setMessage("新增成功");
            resultJson.setData(obj);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

        }
        return resultJson;
    }

    /**
     * 编辑数据
     * @param params
     * @param request
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultJson update(@RequestBody BaseObjectModel params, HttpServletRequest request){
        ResultJson resultJson = new ResultJson();

        int userId=Integer.parseInt(request.getHeader("userId"));

        try {

            Object obj = serviceAction.update(params);
            resultJson.setResult(Dict.REQUEST_SUCCEED);
            resultJson.setMessage("编辑成功");
            resultJson.setData(obj);
        } catch (Exception e) {


        }
        return resultJson;
    }

    /**
     * 批量编辑数据
     * @param params
     * @param request
     * @return
     */
    @RequestMapping(value = "/batchUpdate", method = RequestMethod.POST)
    public ResultJson batchUpdate(@RequestBody BaseObjectModel params, HttpServletRequest request){
        ResultJson resultJson = new ResultJson();

        int userId=Integer.parseInt(request.getHeader("userId"));

        try {

            Object obj = serviceAction.batchUpdate(params);
            resultJson.setResult(Dict.REQUEST_SUCCEED);
            resultJson.setMessage("批量编辑成功");
            resultJson.setData(obj);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

        }
        return resultJson;
    }

    /**
     * 查询数据列表
     * @param params
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryList", method = RequestMethod.POST)
    public ResultJson queryList(@RequestBody BaseObjectModel params, HttpServletRequest request){
        ResultJson resultJson = new ResultJson();

        int userId=Integer.parseInt(request.getHeader("userId"));

        try {

            Object obj = serviceAction.queryList(params);
            resultJson.setResult(Dict.REQUEST_SUCCEED);
            resultJson.setMessage("查询成功");
            resultJson.setData(obj);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return resultJson;
    }

    /**
     * 分页查询数据
     * @param params
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryPage", method = RequestMethod.POST)
    public ResultJson queryPage(@RequestBody BaseObjectModel params, HttpServletRequest request){
        ResultJson resultJson = new ResultJson();

        int userId=Integer.parseInt(request.getHeader("userId"));

        try {

            Object obj = serviceAction.queryPage(params);
            resultJson.setResult(Dict.REQUEST_SUCCEED);
            resultJson.setMessage("查询成功");
            resultJson.setData(obj);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return resultJson;
    }

    /**
     * 根据id查询数据详情
     * @param params
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryById", method = RequestMethod.POST)
    public ResultJson queryById(@RequestBody BaseObjectModel params, HttpServletRequest request){
        ResultJson resultJson = new ResultJson();

        int userId=Integer.parseInt(request.getHeader("userId"));

        try {

            Object obj = serviceAction.queryDetail(params);
            resultJson.setResult(Dict.REQUEST_SUCCEED);
            resultJson.setMessage("查询成功");
            resultJson.setData(obj);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return resultJson;
    }

    /**
     * 根据SQL语句执行查询操作
     * @param params 执行的SQL语句|String
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryBySql", method = RequestMethod.POST)
    public ResultJson queryBySql(@RequestBody Map<String, Object> params, HttpServletRequest request){
        ResultJson resultJson = new ResultJson();

        int userId=Integer.parseInt(request.getHeader("userId"));
        if(params == null
                || !params.containsKey("sqlStatement") || StringUtils.isEmpty(params.get("sqlStatement"))){
            resultJson.setResult(Dict.REQUEST_FAIL);
            resultJson.setMessage("缺少必要参数");
            return resultJson;
        }
        try {
            String sqlStatement = null == params.get("sqlStatement") ? "null" : params.get("sqlStatement").toString();
            LinkedList<Map> obj = dynamicSqlService.dynamicSqlQuery(sqlStatement);
            resultJson.setResult(Dict.REQUEST_SUCCEED);
            resultJson.setMessage("查询成功");
            resultJson.setData(obj);
        } catch (Exception e) {
            e.printStackTrace();

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
    public ResultJson insertOrUpdateBySql(@RequestBody Map<String, Object> params, HttpServletRequest request){
        ResultJson resultJson = new ResultJson();

        int userId=Integer.parseInt(request.getHeader("userId"));
        if(params == null
                || !params.containsKey("sqlStatement") || StringUtils.isEmpty(params.get("sqlStatement"))){
            resultJson.setResult(Dict.REQUEST_FAIL);
            resultJson.setMessage("缺少必要参数");
            return resultJson;
        }
        try {
            String sqlStatement = null == params.get("sqlStatement") ? "null" : params.get("sqlStatement").toString();
            int obj = dynamicSqlService.dynamicSqlInsert(sqlStatement);
            resultJson.setResult(Dict.REQUEST_SUCCEED);
            resultJson.setMessage("新增成功");
            resultJson.setData(obj);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return resultJson;
    }
}
