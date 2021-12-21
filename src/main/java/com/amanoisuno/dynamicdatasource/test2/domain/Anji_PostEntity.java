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
    @TableName("post")
@ApiModel(value="Anji_PostEntity对象", description="")
public class Anji_PostEntity extends Model<Anji_PostEntity> {

    private static final long serialVersionUID=1L;

      @ApiModelProperty(value = "主键，唯一标识")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty(value = "组织id")
      private Integer deptId;

      @ApiModelProperty(value = "职位名称")
      private String postName;

      @ApiModelProperty(value = "职位名称缩写")
      private String initFirstChar;

      @ApiModelProperty(value = "备注")
      private String memo;

      @ApiModelProperty(value = "是否初始的职位 0是1不是")
      private Integer isInit;

      @ApiModelProperty(value = "是否为干部，其中0是1不是")
      private Integer isLeader;

      @ApiModelProperty(value = "职位类型 1功能职位 2 权限职责职位 ")
      private Integer postType;

      @ApiModelProperty(value = "职位状态 1：删除2：正常 3：禁用")
      private Integer flag;

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
