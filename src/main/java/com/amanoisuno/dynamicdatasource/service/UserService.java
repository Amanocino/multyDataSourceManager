package com.amanoisuno.dynamicdatasource.service;

import com.amanoisuno.dynamicdatasource.entity.User;
import com.amanoisuno.dynamicdatasource.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * 用户服务
 *
 * @author amanoisuno
 * @date 2021/12/15
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public int insert(User user) throws Exception {
        int flag = userMapper.insert(user);
        return flag;
    }
}
