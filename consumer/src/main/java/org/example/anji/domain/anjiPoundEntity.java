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
    @TableName("pound")
@ApiModel(value="anjiPoundEntity对象", description="")
public class anjiPoundEntity extends Model<anjiPoundEntity> {

    private static final long serialVersionUID=1L;

      @ApiModelProperty(value = "主键，唯一标识")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty(value = "井号")
      private String poundNo;

      @ApiModelProperty(value = "井号位置")
      private String poundLocation;

      @ApiModelProperty(value = "图片1")
      private String picture1;

      @ApiModelProperty(value = "图片2")
      private String picture2;

      @ApiModelProperty(value = "图片3")
      private String picture3;

      @ApiModelProperty(value = "井号状态 1：删除2：正常 3：禁用")
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
