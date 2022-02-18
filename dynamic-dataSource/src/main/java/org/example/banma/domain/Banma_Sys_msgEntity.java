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
    @TableName("sys_msg")
@ApiModel(value="Banma_Sys_msgEntity对象", description="")
public class Banma_Sys_msgEntity extends Model<Banma_Sys_msgEntity> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty(value = "消息标题")
      private String messageTitle;

      @ApiModelProperty(value = "消息类型 1提示 2警示")
      private Integer messageType;

      @ApiModelProperty(value = "消息类别 ")
      private Integer messageKind;

      @ApiModelProperty(value = "消息内容")
      private String messageContent;

      @ApiModelProperty(value = "消息内容连接")
      private String messageUrl;

      @ApiModelProperty(value = "发送时间")
      private Long createtime;

      @ApiModelProperty(value = "发送人ID,如果为-1,则认为是系统发送")
      private String fromUserId;

      @ApiModelProperty(value = "状态标识 0常态 1 删除")
      private Integer flag;

      @ApiModelProperty(value = "邮件接收人,如果为-1,则认为是所有人")
      private String toUserIds;

      @ApiModelProperty(value = "接收人姓名")
      private String toUserNames;

      @ApiModelProperty(value = "备用字段")
      private String param1;

    private String param2;

    private String param3;


    @Override
    protected Serializable pkVal() {
          return this.id;
      }

}
