package com.amanoisuno.dynamicdatasource.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * 用户
 *
 * @author amanoisuno
 * @date 2021/12/15
 */
@Data
@TableName("user")
@KeySequence("seq_user")
public class User {

    @TableId(value = "id",type = IdType.INPUT)
    private Long id;
    private String name;
    private String tenantId;
}
