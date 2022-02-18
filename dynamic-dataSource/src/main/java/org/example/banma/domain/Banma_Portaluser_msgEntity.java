package org.example.banma.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
    @TableName("portaluser_msg")
@ApiModel(value="Banma_Portaluser_msgEntity对象", description="")
public class Banma_Portaluser_msgEntity extends Model<Banma_Portaluser_msgEntity> {

    private static final long serialVersionUID=1L;

    private Integer userId;

    private Integer msgId;

      @ApiModelProperty(value = "0未读 1删除 2已读")
      private Integer flag;

      @ApiModelProperty(value = "修改时间")
      private Long updatetime;


    @Override
    protected Serializable pkVal() {
          return null;
      }

}
