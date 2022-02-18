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
    @TableName("process_apply")
@ApiModel(value="Banma_Process_applyEntity对象", description="")
public class Banma_Process_applyEntity extends Model<Banma_Process_applyEntity> {

    private static final long serialVersionUID=1L;

      @ApiModelProperty(value = "主键ID")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    private String applyNo;

      @ApiModelProperty(value = "审批类型")
      private String applyType;

      @ApiModelProperty(value = "申请名称")
      private String applyName;

      @ApiModelProperty(value = "审核状态：1为删除状态，2为待审核 3.拒绝状态，4 退回 5为撤回状态 6废除 7 审批通过 8 结束 9 异常结束 ")
      private Integer flag;

      @ApiModelProperty(value = "创建人")
      private Integer createuser;

      @ApiModelProperty(value = "创建时间")
      private Long createtime;

      @ApiModelProperty(value = "修改人")
      private Integer updateuser;

      @ApiModelProperty(value = "修改时间")
      private Long updatetime;

      @ApiModelProperty(value = "流程实例ID")
      private String processEntityId;

      @ApiModelProperty(value = "外键ID")
      private Integer keyId;

      @ApiModelProperty(value = "变更说明")
      private String memo;

      @ApiModelProperty(value = "申请时间")
      private Long applyTime;

    private Integer applyUser;

      @ApiModelProperty(value = "流程版本号")
      private Integer dataVersion;

      @ApiModelProperty(value = "流程ID")
      private Integer processId;

      @ApiModelProperty(value = "项目ID")
      private Integer projectId;

      @ApiModelProperty(value = "项目名称")
      private String projectName;

      @ApiModelProperty(value = "变更申请json字符串")
      private String param1;

      @ApiModelProperty(value = "产品线ID")
      private String param2;

    private String param3;

      @ApiModelProperty(value = "发起人的部门ID")
      private Integer deptId;


    @Override
    protected Serializable pkVal() {
          return this.id;
      }

}
