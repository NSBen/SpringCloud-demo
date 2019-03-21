package com.demo.guns.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.guns.core.common.page.LayuiPageInfo;
import com.demo.guns.entity.SysDept;
import com.demo.guns.model.params.SysDeptParam;
import com.demo.guns.model.result.SysDeptResult;

/**
 * <p>
 * 部门 服务类
 * </p>
 *
 * @author 
 * @since 2019-03-21
 */
public interface SysDeptService extends IService<SysDept> {

    /**
     * 新增
     *
     * @author 
     * @Date 2019-03-21
     */
    void add(SysDeptParam param);

    /**
     * 删除
     *
     * @author 
     * @Date 2019-03-21
     */
    void delete(SysDeptParam param);

    /**
     * 更新
     *
     * @author 
     * @Date 2019-03-21
     */
    void update(SysDeptParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author 
     * @Date 2019-03-21
     */
    SysDeptResult findBySpec(SysDeptParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author 
     * @Date 2019-03-21
     */
    List<SysDeptResult> findListBySpec(SysDeptParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author 
     * @Date 2019-03-21
     */
     LayuiPageInfo findPageBySpec(SysDeptParam param);

}
