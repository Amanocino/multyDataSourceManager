package org.test.anji.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ChenZhiCheng
 * @since 2022-02-28
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("oplog")
@ApiModel(value="anjiOplogEntity对象", description="")
public class anjiOplogEntity extends Model<anjiOplogEntity> {

    private static final long serialVersionUID=1L;

      @ApiModelProperty(value = "主键，唯一标识")
        @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      @ApiModelProperty(value = "类型，1组织 2部门")
      private Integer deptId;

      @ApiModelProperty(value = "操作日志名称")
      private String logName;

      @ApiModelProperty(value = "操作模块名称")
      private String modelName;

      @ApiModelProperty(value = "操作日志类型 1.新增 2 删除 3 修改  4 登录 5 退出 6 修改密码 7 重置密码")
      private Integer logType;

      @ApiModelProperty(value = "业务操作类型（可按模块划分）")
      private Integer businessType;

      @ApiModelProperty(value = "操作状态 0 成功 1操作失败")
      private Integer actionState;

      @ApiModelProperty(value = "项目系统id")
      private Integer articleId;

      @ApiModelProperty(value = "创建人")
      private Integer createuser;

      @ApiModelProperty(value = "创建时间")
      private Long createtime;


    @Override
    protected Serializable pkVal() {
          return this.id;
      }

}
