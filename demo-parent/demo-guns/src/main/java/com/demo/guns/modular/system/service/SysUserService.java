package com.demo.guns.modular.system.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.guns.core.common.page.LayuiPageInfo;
import com.demo.guns.modular.system.entity.SysUser;
import com.demo.guns.modular.system.model.param.SysUserParam;
import com.demo.guns.modular.system.model.result.SysUserResult;

/**
 * <p>
 * 管理员表 服务类
 * </p>
 *
 * @author 
 * @since 2019-03-20
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 新增
     *
     * @author 
     * @Date 2019-03-20
     */
    void add(SysUserParam param);

    /**
     * 删除
     *
     * @author 
     * @Date 2019-03-20
     */
    void delete(SysUserParam param);

    /**
     * 更新
     *
     * @author 
     * @Date 2019-03-20
     */
    void update(SysUserParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author 
     * @Date 2019-03-20
     */
    SysUserResult findBySpec(SysUserParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author 
     * @Date 2019-03-20
     */
    List<SysUserResult> findListBySpec(SysUserParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author 
     * @Date 2019-03-20
     */
     LayuiPageInfo findPageBySpec(SysUserParam param);

}
