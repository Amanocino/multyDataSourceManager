package org.example.common;

import lombok.Data;

import java.io.Serializable;


/**
 * 数据库的细节
 *
 * @author amanoisuno
 * @date 2021/12/15
 */
@Data
public class DatabaseDetail implements Serializable {
    private long id;
    private String tenantId;
    private String url;
    private String username;
    private String password;
    private String driverClassName;
}
