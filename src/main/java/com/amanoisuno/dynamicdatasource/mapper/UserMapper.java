package com.amanoisuno.dynamicdatasource.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.amanoisuno.dynamicdatasource.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 用户映射器
 *
 * @author amanoisuno
 * @date 2021/12/15
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user")
    List<User> selectAll();
}
