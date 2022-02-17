package org.example.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseObjectModel implements Serializable {
    private Integer articleId;
    private String tableName;
    private Object data;

    private Integer tenantId;

}
