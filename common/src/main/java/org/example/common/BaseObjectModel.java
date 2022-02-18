package org.example.common;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class BaseObjectModel implements Serializable {
    @Range(groups = {ValidGroup.Crud.Create.class, ValidGroup.Crud.Update.class,
            ValidGroup.Crud.Query.class, ValidGroup.Crud.Delete.class}, min = 1, max = 7, message=
            "系统id" +
            "仅支持以下类型，`1`: Mes `2`: 大庆业务系统 " +
            "`3`: " +
            "安吉业务系统 `4`: 南昌业务系统 `5`: 浪潮系统 `6`: 斑马项目")
    private Integer articleId;
    @NotBlank(groups = {ValidGroup.Crud.Create.class, ValidGroup.Crud.Update.class,
            ValidGroup.Crud.Query.class, ValidGroup.Crud.Delete.class}, message = "操作表名称为必填项")
    private String tableName;
    @NotNull(message = "操作数据为必填项，可为空Json对象{}")
    private Object data;

    private Integer tenantId;

}
