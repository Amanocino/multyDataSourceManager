package org.example.test1.domain;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2021-12-17
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("database_detail")
@ApiModel(value="Lamp_Database_detailEntity对象", description="")
public class Lamp_Database_detailEntity extends Model<Lamp_Database_detailEntity> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    private String tenant_id;

    private String url;

    private String username;

    private String password;

    private String driverClassName;


    @Override
    protected Serializable pkVal() {
          return this.id;
      }

}
