package com.amanoisuno.dynamicdatasource.entity;

import lombok.Data;


/**
 * 数据库的细节
 *
 * @author amanoisuno
 * @date 2021/12/15
 */
@Data
public class DatabaseDetail {
    private long id;
    private String tenantId;
    private String url;
    private String username;
    private String password;
    private String driverClassName;
}
