package org.example.test2.domain;

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
 * @since 2021-12-20
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("deptment")
@ApiModel(value="Anji_DeptmentEntity对象", description="")
public class Anji_DeptmentEntity extends Model<Anji_DeptmentEntity> {

    private static final long serialVersionUID=1L;

      @ApiModelProperty(value = "主键，唯一标识")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty(value = "类型，1组织")
      private Integer deptType;

      @ApiModelProperty(value = "组织ID")
      private String deptNo;

      @ApiModelProperty(value = "组织名称")
      private String deptName;

      @ApiModelProperty(value = "组织名称缩写")
      private String initFirstChar;

      @ApiModelProperty(value = "组织层级，顶层为0，逐级递增")
      private Integer deptLvl;

      @ApiModelProperty(value = "父级id，0代表顶级组织")
      private Integer pid;

      @ApiModelProperty(value = "所有父级ids，拼接方式：，1,2,3，")
      private String pids;

      @ApiModelProperty(value = "部门状态，1：删除2：正常3 禁用")
      private Integer flag;

      @ApiModelProperty(value = "组织末级  0 false 1 true")
      private Integer lastLevel;

      @ApiModelProperty(value = "项目系统id")
      private Integer articleId;

      @ApiModelProperty(value = "创建人")
      private Integer createuser;

      @ApiModelProperty(value = "创建时间")
      private Long createtime;

      @ApiModelProperty(value = "修改人")
      private Integer updateuser;

      @ApiModelProperty(value = "修改时间")
      private Long updatetime;

      @ApiModelProperty(value = "备用参数1")
      private String param1;

      @ApiModelProperty(value = "备用参数2")
      private String param2;

      @ApiModelProperty(value = "备用参数3")
      private String param3;


    @Override
    protected Serializable pkVal() {
          return this.id;
      }

}
