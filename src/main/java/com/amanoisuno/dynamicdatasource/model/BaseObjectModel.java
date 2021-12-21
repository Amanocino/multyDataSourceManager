package com.amanoisuno.dynamicdatasource.model;

import lombok.Data;

@Data
public class BaseObjectModel {
    private Integer articleId;
    private String tableName;
    private Object data;

}
