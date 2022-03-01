package org.test.anji.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 持久化用户登录会话
 * </p>
 *
 * @author ChenZhiCheng
 * @since 2022-02-28
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("login_token")
@ApiModel(value="anjiLogin_tokenEntity对象", description="持久化用户登录会话")
public class anjiLogin_tokenEntity extends Model<anjiLogin_tokenEntity> {

    private static final long serialVersionUID=1L;

    private String user_id;

    private String login_key;

      @ApiModelProperty(value = "创建时间")
      private Long create_time;

      @ApiModelProperty(value = "有效时间")
      private Long last_active_time;

      @ApiModelProperty(value = "更新时间")
      private Long last_update_time;

      @ApiModelProperty(value = "用户类型,1.系统管理员 2.部门管理员 3.特权用户4.普通用户")
      private Integer user_type;

      @ApiModelProperty(value = "最后一次登录的IP")
      private String last_active_ip;

      @ApiModelProperty(value = "组织id")
      private Integer dept_id;

      @ApiModelProperty(value = "组织名称")
      private String dept_name;

      @ApiModelProperty(value = "设备识别码")
      private String device_id;

      @ApiModelProperty(value = "用户登录类型，1为用户名密码登录，2为工号登录")
      private Integer login_type;


    @Override
    protected Serializable pkVal() {
          return null;
      }

}
