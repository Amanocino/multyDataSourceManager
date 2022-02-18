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
    @TableName("process_task")
@ApiModel(value="Banma_Process_taskEntity对象", description="")
public class Banma_Process_taskEntity extends Model<Banma_Process_taskEntity> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty(value = "节点名称")
      private String nodeName;

      @ApiModelProperty(value = "审批方式 1单签 2会签 3自动审批 4依次审批")
      private Integer examineType;

      @ApiModelProperty(value = "审批人为空时:0 提示异常 1、自动审批 2、转交给审核管理员 ")
      private Integer noHanderAction;

      @ApiModelProperty(value = "匹配方式，1按初始节点匹配 2按上级节点匹配")
      private Integer matchType;

      @ApiModelProperty(value = "关联的表单页面url")
      private String formkey;

      @ApiModelProperty(value = "其他选择条件 1产品线匹配")
      private Integer otherSetType;

      @ApiModelProperty(value = "任务类型  0发起人 1审批人 2抄送人 3条件 4路由")
      private Integer taskType;

      @ApiModelProperty(value = "抄送人清单")
      private String cc;

      @ApiModelProperty(value = "抄送设置 0、不抄送 1、指定成员 2、主管 3、角色 4、连续多级主管 5、发起人 6指定岗位  10全部")
      private Integer ccType;

      @ApiModelProperty(value = "审批意见必填 1必填 2非必填")
      private Integer requiredComment;

      @ApiModelProperty(value = "驳回处理 1、退回初始节点 2、退回上级审批节点")
      private Integer rejectSet;

      @ApiModelProperty(value = "审批通过状态 1、审核后状态 2、审批中 3、审批通过 4、已立项")
      private String accessSet;

      @ApiModelProperty(value = "审批人员选择 1、指定成员 2、主管 3、角色 4、连续多级主管 5、发起人 6指定岗位 7找不到主管时，有上级主管代替，直至顶层")
      private Integer setType;

      @ApiModelProperty(value = "主管审批：发起人的第n级审批，直接主管为1")
      private Integer directorLevel;

      @ApiModelProperty(value = "审批终点：选择连续多级主管审批是为n级，其他审批为0，（如果是连续多级主管审批，最高级别为1，其他的为相应的级别数字）")
      private Integer examineEndDirectorLevel;

      @ApiModelProperty(value = "1由上级主管代替审批 ")
      private Integer noDirectorAction;

      @ApiModelProperty(value = "可填报数据 1销售合同单号、2采购合同单号、3项目编号、4、发票号")
      private Integer dataType;

      @ApiModelProperty(value = "填报规则 1、审批通过前填报 2、审批通过后填报")
      private Integer fillRule;

      @ApiModelProperty(value = "组合方式，1 并集 2交集")
      private Integer compounding;

      @ApiModelProperty(value = "条件的优先级")
      private Integer priorityLevel;

      @ApiModelProperty(value = "路由的条件")
      private String conditionList;

      @ApiModelProperty(value = "审批人集合，json字符串")
      private String nodeUserList;

      @ApiModelProperty(value = "操作人ID")
      private Integer operatorId;

      @ApiModelProperty(value = "创建时间")
      private Long createtime;

    private Long updatetime;

      @ApiModelProperty(value = "状态标识 1 删除 2常态 3禁用")
      private Integer flag;

      @ApiModelProperty(value = "排序")
      private Integer sort;

      @ApiModelProperty(value = "父级ID")
      private Integer pid;

      @ApiModelProperty(value = "流程版本号")
      private Integer dataVersion;

      @ApiModelProperty(value = "流程ID")
      private Integer processId;

    private String param1;

    private String param2;

    private String param3;


    @Override
    protected Serializable pkVal() {
          return this.id;
      }

}
