package com.demo.guns.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 部门
 * </p>
 *
 * @author 
 * @since 2019-03-21
 */
@Data
public class SysDeptParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 部门id
     */
    private Long deptId;

    /**
     * 简称
     */
    private String simpleName;

    /**
     * 全称
     */
    private String fullName;

    /**
     * 部门类型
     */
    private String deptType;

    /**
     * 父部门id
     */
    private Long pid;

    /**
     * 父id路径
     */
    private String pids;

    /**
     * 是否虚拟部门
     */
    private Boolean isVirtual;

    /**
     * 全路径名称
     */
    private String fullPath;

    /**
     * 微信部门id
     */
    private String wxDeptId;

    /**
     * 描述
     */
    private String description;

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
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 更新人
     */
    private Long updateUser;

    /**
     * 机构id
     */
    private Long tenementId;

    @Override
    public String checkParam() {
        return null;
    }

}
