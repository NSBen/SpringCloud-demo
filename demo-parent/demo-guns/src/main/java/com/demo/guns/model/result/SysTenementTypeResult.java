package com.demo.guns.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 机构类型
 * </p>
 *
 * @author 
 * @since 2019-03-21
 */
@Data
public class SysTenementTypeResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 租户类型id
     */
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
