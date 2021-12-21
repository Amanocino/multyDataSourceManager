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
    @TableName("employee")
@ApiModel(value="Anji_EmployeeEntity对象", description="")
public class Anji_EmployeeEntity extends Model<Anji_EmployeeEntity> {

    private static final long serialVersionUID=1L;

      @ApiModelProperty(value = "主键，唯一标识")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty(value = "部门id")
      private Integer deptId;

      @ApiModelProperty(value = "员工编号或工号")
      private String employeeNo;

      @ApiModelProperty(value = "员工名称")
      private String employeeName;

      @ApiModelProperty(value = "员工名称缩写")
      private String initFirstChar;

      @ApiModelProperty(value = "登录账号")
      private String account;

      @ApiModelProperty(value = "密码，采用base64加密存储")
      private String password;

      @ApiModelProperty(value = "用户描述")
      private String memo;

      @ApiModelProperty(value = "性别：W 女 M 男")
      private String sex;

      @ApiModelProperty(value = "证件类型 1身份证 2 护照 3军人证")
      private Integer identifyType;

      @ApiModelProperty(value = "证件号")
      private String identifyNo;

      @ApiModelProperty(value = "出生日期")
      private Long birthday;

      @ApiModelProperty(value = "手机号")
      private String phone;

      @ApiModelProperty(value = "邮箱")
      private String email;

      @ApiModelProperty(value = "户籍所在地")
      private String employeeNative;

      @ApiModelProperty(value = "联系地址")
      private String linkLocation;

      @ApiModelProperty(value = "学历，1本科 2研究生 3博士")
      private Integer education;

      @ApiModelProperty(value = "专业")
      private String major;

      @ApiModelProperty(value = "工资卡号")
      private String bankNo;

      @ApiModelProperty(value = "头像url")
      private String headerImg;

      @ApiModelProperty(value = "合同类型,1劳动合同 2劳务合同 3实习合同 4无固定期限合同 5其他合同")
      private Integer agreementType;

      @ApiModelProperty(value = "项目系统id")
      private Integer articleId;

      @ApiModelProperty(value = "班组ID")
      private Integer teamId;

      @ApiModelProperty(value = "用户状态 1：删除2：正常3 禁用 4 离职")
      private Integer flag;

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
