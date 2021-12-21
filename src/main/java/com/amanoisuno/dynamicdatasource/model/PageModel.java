package com.amanoisuno.dynamicdatasource.model;

import lombok.Data;

@Data
public class PageModel {
    private Integer pageNum;
    private Integer pageSize;
    private Object pageObject;

}
