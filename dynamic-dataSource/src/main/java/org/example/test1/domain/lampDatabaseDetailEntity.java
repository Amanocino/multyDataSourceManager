package org.example.test1.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
    @TableName("database_detail")
@ApiModel(value="lampDatabaseDetailEntity对象", description="")
public class lampDatabaseDetailEntity extends Model<lampDatabaseDetailEntity> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    private String tenantId;

    private String url;

    private String username;

    private String password;

    @TableField("driverClassName")
    private String driverClassName;


    @Override
    protected Serializable pkVal() {
          return this.id;
      }

}
