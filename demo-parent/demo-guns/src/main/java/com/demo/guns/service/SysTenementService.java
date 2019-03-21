package com.demo.guns.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.guns.core.common.page.LayuiPageInfo;
import com.demo.guns.entity.SysTenement;
import com.demo.guns.model.params.SysTenementParam;
import com.demo.guns.model.result.SysTenementResult;

/**
 * <p>
 * 机构 服务类
 * </p>
 *
 * @author 
 * @since 2019-03-21
 */
public interface SysTenementService extends IService<SysTenement> {

    /**
     * 新增
     *
     * @author 
     * @Date 2019-03-21
     */
    void add(SysTenementParam param);

    /**
     * 删除
     *
     * @author 
     * @Date 2019-03-21
     */
    void delete(SysTenementParam param);

    /**
     * 更新
     *
     * @author 
     * @Date 2019-03-21
     */
    void update(SysTenementParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author 
     * @Date 2019-03-21
     */
    SysTenementResult findBySpec(SysTenementParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author 
     * @Date 2019-03-21
     */
    List<SysTenementResult> findListBySpec(SysTenementParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author 
     * @Date 2019-03-21
     */
     LayuiPageInfo findPageBySpec(SysTenementParam param);

}
