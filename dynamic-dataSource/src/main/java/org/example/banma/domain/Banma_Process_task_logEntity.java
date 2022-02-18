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
    @TableName("process_task_log")
@ApiModel(value="Banma_Process_task_logEntity对象", description="")
public class Banma_Process_task_logEntity extends Model<Banma_Process_task_logEntity> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    private Integer taskId;

      @ApiModelProperty(value = "任务处理标识 0待处理1 通过 2拒绝 3退回 4撤回 -1 删除 5转交 6发起 7抄送 100下级审批")
      private Integer taskState;

      @ApiModelProperty(value = "任务处理说明")
      private String memo;

      @ApiModelProperty(value = "操作人ID")
      private Integer userId;

      @ApiModelProperty(value = "操作人名称")
      private String userName;

      @ApiModelProperty(value = "部门ID")
      private Integer deptId;

      @ApiModelProperty(value = "创建时间")
      private Long createtime;

    private Long updatetime;

      @ApiModelProperty(value = "申请单ID")
      private Integer applyId;

      @ApiModelProperty(value = "或签成员/抄送人ID，多个以“，”隔开")
      private String assignee;

      @ApiModelProperty(value = "或签成员/抄送人姓名，多个以“，”隔开")
      private String assigneeNames;

      @ApiModelProperty(value = "抄送人清单")
      private String cc;

      @ApiModelProperty(value = "抄送设置 0、不抄送 1、指定成员 2、岗位 3、角色 4、连续多级主管 5、发起人 10全部")
      private Integer ccType;

      @ApiModelProperty(value = "抄送人名称")
      private String ccNames;

    private String param1;

    private String param2;

    private String param3;

      @ApiModelProperty(value = "多级主管依次，审批层级")
      private Integer sort;

      @ApiModelProperty(value = "任务的排序")
      private Integer taskSort;

      @ApiModelProperty(value = "默认回滚到的任务节点ID")
      private Integer rollbackTaskId;


    @Override
    protected Serializable pkVal() {
          return this.id;
      }

}
