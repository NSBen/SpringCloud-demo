package com.demo.guns.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.guns.core.common.page.LayuiPageInfo;
import com.demo.guns.entity.SysTenementType;
import com.demo.guns.model.params.SysTenementTypeParam;
import com.demo.guns.model.result.SysTenementTypeResult;

/**
 * <p>
 * 机构类型 服务类
 * </p>
 *
 * @author 
 * @since 2019-03-21
 */
public interface SysTenementTypeService extends IService<SysTenementType> {

    /**
     * 新增
     *
     * @author 
     * @Date 2019-03-21
     */
    void add(SysTenementTypeParam param);

    /**
     * 删除
     *
     * @author 
     * @Date 2019-03-21
     */
    void delete(SysTenementTypeParam param);

    /**
     * 更新
     *
     * @author 
     * @Date 2019-03-21
     */
    void update(SysTenementTypeParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author 
     * @Date 2019-03-21
     */
    SysTenementTypeResult findBySpec(SysTenementTypeParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author 
     * @Date 2019-03-21
     */
    List<SysTenementTypeResult> findListBySpec(SysTenementTypeParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author 
     * @Date 2019-03-21
     */
     LayuiPageInfo findPageBySpec(SysTenementTypeParam param);

}
