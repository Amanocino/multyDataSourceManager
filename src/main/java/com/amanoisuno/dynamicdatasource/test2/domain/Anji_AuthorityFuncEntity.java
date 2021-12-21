package com.amanoisuno.dynamicdatasource.test2.domain;

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
 * @since 2021-12-20
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("authorityFunc")
@ApiModel(value="Anji_AuthorityFuncEntity对象", description="")
public class Anji_AuthorityFuncEntity extends Model<Anji_AuthorityFuncEntity> {

    private static final long serialVersionUID=1L;

      @ApiModelProperty(value = "主键，唯一标识")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty(value = "权限名称")
      private String authName;

      @ApiModelProperty(value = "权限名称缩写")
      private String initFirstChar;

      @ApiModelProperty(value = "权限url")
      private String rightUrl;

      @ApiModelProperty(value = "是否初始的菜单 0是 1不是")
      private Integer isInit;

      @ApiModelProperty(value = "权限菜单类型 1 权限目录 2 页面 3 按钮")
      private Integer authType;

      @ApiModelProperty(value = "标签值")
      private String tag;

      @ApiModelProperty(value = "父级菜单id")
      private Integer pid;

      @ApiModelProperty(value = "所有父级ids，拼接方式：，1,2,3，")
      private String pids;

      @ApiModelProperty(value = "状态 1删除 2正常3禁用")
      private Integer flag;

      @ApiModelProperty(value = "排序")
      private Integer sort;

      @ApiModelProperty(value = "菜单标识")
      private String identification;

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
