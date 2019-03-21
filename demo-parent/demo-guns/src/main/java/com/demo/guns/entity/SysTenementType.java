package com.demo.guns.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 机构类型
 * </p>
 *
 * @author 
 * @since 2019-03-21
 */
@TableName("sys_tenement_type")
public class SysTenementType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 租户类型id
     */
    @TableId(value = "tenement_type_id", type = IdType.ID_WORKER)
    private Long tenementTypeId;

    /**
     * 类型名称
     */
    private String typeName;

    /**
     * 是否平台租户
     */
    private Boolean isPlatform;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createUser;

    /**
     * 更新人
     */
    @TableField(fill = FieldFill.UPDATE)
    private Long updateUser;


    public Long getTenementTypeId() {
        return tenementTypeId;
    }

    public void setTenementTypeId(Long tenementTypeId) {
        this.tenementTypeId = tenementTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public String toString() {
        return "SysTenementType{" +
        "tenementTypeId=" + tenementTypeId +
        ", typeName=" + typeName +
        ", isPlatform=" + isPlatform +
        ", sort=" + sort +
        ", status=" + status +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", createUser=" + createUser +
        ", updateUser=" + updateUser +
        "}";
    }

	public Boolean getIsPlatform() {
		return isPlatform;
	}

	public void setIsPlatform(Boolean isPlatform) {
		this.isPlatform = isPlatform;
	}

}
