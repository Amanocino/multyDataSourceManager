package com.amanoisuno.dynamicdatasource.controller;

import com.amanoisuno.dynamicdatasource.common.ResultJson;
import com.amanoisuno.dynamicdatasource.entity.User;
import com.amanoisuno.dynamicdatasource.config.factory.ServiceAction;
import com.amanoisuno.dynamicdatasource.model.BaseObjectModel;
import com.amanoisuno.dynamicdatasource.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 用户控制器
 *
 * @author amanoisuno
 * @date 2021/12/15
 */
@RestController
@Api(tags = "多租户管理端--用户模块")
public class UserController {

    @Autowired
    private ServiceAction serviceAction;


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

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResultJson save(@RequestBody BaseObjectModel params, HttpServletRequest request){
        ResultJson resultJson = new ResultJson();

        int userId=Integer.parseInt(request.getHeader("userId"));

        try {

            Object obj = serviceAction.save(params);
            resultJson.setData(obj);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

        }
        return resultJson;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultJson update(@RequestBody BaseObjectModel params, HttpServletRequest request){
        ResultJson resultJson = new ResultJson();

        int userId=Integer.parseInt(request.getHeader("userId"));

        try {

            Object obj = serviceAction.update(params);
            resultJson.setData(obj);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

        }
        return resultJson;
    }

    @RequestMapping(value = "/batchUpdate", method = RequestMethod.POST)
    public ResultJson batchUpdate(@RequestBody BaseObjectModel params, HttpServletRequest request){
        ResultJson resultJson = new ResultJson();

        int userId=Integer.parseInt(request.getHeader("userId"));

        try {

            Object obj = serviceAction.batchUpdate(params);
            resultJson.setData(obj);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

        }
        return resultJson;
    }

    @RequestMapping(value = "/queryList", method = RequestMethod.POST)
    public ResultJson queryList(@RequestBody BaseObjectModel params, HttpServletRequest request){
        ResultJson resultJson = new ResultJson();

        int userId=Integer.parseInt(request.getHeader("userId"));

        try {

            Object obj = serviceAction.queryList(params);
            resultJson.setData(obj);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return resultJson;
    }

    @RequestMapping(value = "/queryPage", method = RequestMethod.POST)
    public ResultJson queryPage(@RequestBody BaseObjectModel params, HttpServletRequest request){
        ResultJson resultJson = new ResultJson();

        int userId=Integer.parseInt(request.getHeader("userId"));

        try {

            Object obj = serviceAction.queryPage(params);
            resultJson.setData(obj);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return resultJson;
    }

    @RequestMapping(value = "/queryById", method = RequestMethod.POST)
    public ResultJson queryById(@RequestBody BaseObjectModel params, HttpServletRequest request){
        ResultJson resultJson = new ResultJson();

        int userId=Integer.parseInt(request.getHeader("userId"));

        try {

            Object obj = serviceAction.queryDetail(params);
            resultJson.setData(obj);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return resultJson;
    }
}
