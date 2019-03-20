package com.demo.guns.modular.system.model.param;

import java.io.Serializable;
import java.util.Date;

import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 管理员表
 * </p>
 *
 * @author
 * @since 2019-03-20
 */
@Data
@ApiModel
public class SysUserParam implements Serializable, BaseValidatingParam {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@ApiModelProperty(value = "主键id", example = "1")
	private Long userId;

	/**
	 * 头像
	 */
	@ApiModelProperty("头像")
	private String avatar;

	/**
	 * 账号
	 */
	@ApiModelProperty("账号")
	private String account;

	/**
	 * 密码
	 */
	@ApiModelProperty("密码")
	private String password;

	/**
	 * md5密码盐
	 */
	@ApiModelProperty("md5密码盐")
	private String salt;

	/**
	 * 名字
	 */
	@ApiModelProperty("名字")
	private String name;

	/**
	 * 生日
	 */
	@ApiModelProperty("生日")
	private Date birthday;

	/**
	 * 性别(字典)
	 */
	@ApiModelProperty("性别(字典)")
	private String sex;

	/**
	 * 电子邮件
	 */
	@ApiModelProperty("电子邮件")
	private String email;

	/**
	 * 电话
	 */
	@ApiModelProperty("电话")
	private String phone;

	/**
	 * 角色id(多个逗号隔开)
	 */
	@ApiModelProperty("角色id(多个逗号隔开)")
	private String roleId;

	/**
	 * 部门id(多个逗号隔开)
	 */
	@ApiModelProperty(value = "部门id(多个逗号隔开)", example = "1")
	private Long deptId;

	/**
	 * 状态(字典)
	 */
	@ApiModelProperty("状态(字典)")
	private String status;

	/**
	 * 创建时间
	 */
	@ApiModelProperty("创建时间")
	private Date createTime;

	/**
	 * 创建人
	 */
	@ApiModelProperty(value = "创建人id", example = "1")
	private Long createUser;

	/**
	 * 更新时间
	 */
	@ApiModelProperty("更新时间")
	private Date updateTime;

	/**
	 * 更新人
	 */
	@ApiModelProperty(value = "更新人", example = "1")
	private Long updateUser;

	/**
	 * 乐观锁
	 */
	@ApiModelProperty(value = "乐观锁", example = "1")
	private Integer version;

	@Override
	public String checkParam() {
		return null;
	}

}
