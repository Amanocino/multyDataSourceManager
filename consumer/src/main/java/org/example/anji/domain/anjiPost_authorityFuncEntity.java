package org.example.anji.domain;

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
 * @since 2022-02-28
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("post_authorityFunc")
@ApiModel(value="anjiPost_authorityFuncEntity对象", description="")
public class anjiPost_authorityFuncEntity extends Model<anjiPost_authorityFuncEntity> {

    private static final long serialVersionUID=1L;

      @ApiModelProperty(value = "主键，唯一标识")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty(value = "职位id")
      private Integer postId;

      @ApiModelProperty(value = "权限id")
      private Integer authId;

      @ApiModelProperty(value = "状态 1删除 2正常3禁用")
      private Integer flag;

      @ApiModelProperty(value = "创建人")
      private Integer createuser;

      @ApiModelProperty(value = "创建时间")
      private Long createtime;

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
