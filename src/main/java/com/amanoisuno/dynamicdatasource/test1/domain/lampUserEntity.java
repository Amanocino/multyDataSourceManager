package com.amanoisuno.dynamicdatasource.test1.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ChenZhiCheng
 * @since 2021-12-14
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("user")
@ApiModel(value="lampUserEntity对象", description="")
public class lampUserEntity extends Model<lampUserEntity> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    private String name;

    private String tenantId;


    @Override
    protected Serializable pkVal() {
          return this.id;
      }

}
