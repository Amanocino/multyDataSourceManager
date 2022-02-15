package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.LinkedList;
import java.util.Map;

@Mapper
public interface DynamicSqlMapper {
    @Select({"${sql}"})
    LinkedList<Map> querySqlExecute(@Param("sql") String sql);

    @Insert({"${sql}"})
    int insertSqlExecute(@Param("sql") String sql);
}
