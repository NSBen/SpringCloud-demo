package com.demo.guns.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 机构
 * </p>
 *
 * @author 
 * @since 2019-03-21
 */
@Data
public class SysTenementResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 机构id
     */
    private Long tenementId;

    /**
     * 简称
     */
    private String simpleName;

    /**
     * 全称
     */
    private String fullName;

    /**
     * 联系人
     */
    private String linkman;

    /**
     * 联系电话
     */
    private String mobile;

    /**
     * 租户类型id
     */
    private Long tenementTypeId;

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

}
