package org.example.banma.domain;

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
 * @since 2022-02-18
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("process")
@ApiModel(value="Banma_ProcessEntity对象", description="")
public class Banma_ProcessEntity extends Model<Banma_ProcessEntity> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty(value = "流程名称")
      private String processName;

      @ApiModelProperty(value = "流程类型")
      private String processType;

      @ApiModelProperty(value = "创建人ID")
      private Integer createuser;

      @ApiModelProperty(value = "创建时间")
      private Long createtime;

      @ApiModelProperty(value = "修改人ID")
      private Integer updateuser;

      @ApiModelProperty(value = "修改时间")
      private Long updatetime;

      @ApiModelProperty(value = "流程状态标识1 删除 2常态 3禁用")
      private Integer flag;

      @ApiModelProperty(value = "流程描述")
      private String processDesc;

      @ApiModelProperty(value = "流程版本")
      private String processVersion;

      @ApiModelProperty(value = "数据版本")
      private Integer dataVersion;

    private String param1;

    private String param2;

    private String param3;


    @Override
    protected Serializable pkVal() {
          return this.id;
      }

}
