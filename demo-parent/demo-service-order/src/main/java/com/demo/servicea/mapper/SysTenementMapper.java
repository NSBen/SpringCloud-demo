package com.demo.servicea.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.servicea.entity.SysTenement;

/**
 * <p>
 * 机构 Mapper 接口
 * </p>
 *
 * @author
 * @since 2019-03-21
 */
public interface SysTenementMapper extends BaseMapper<SysTenement> {
	SysTenement select1();
}
