package com.demo.guns.modular.system.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.guns.core.common.page.LayuiPageFactory;
import com.demo.guns.core.common.page.LayuiPageInfo;
import com.demo.guns.modular.system.entity.SysUser;
import com.demo.guns.modular.system.mapper.SysUserMapper;
import com.demo.guns.modular.system.model.param.SysUserParam;
import com.demo.guns.modular.system.model.result.SysUserResult;
import  com.demo.guns.modular.system.service.SysUserService;

import cn.stylefeng.roses.core.util.ToolUtil;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author 
 * @since 2019-03-20
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public void add(SysUserParam param){
        SysUser entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(SysUserParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(SysUserParam param){
        SysUser oldEntity = getOldEntity(param);
        SysUser newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public SysUserResult findBySpec(SysUserParam param){
        return null;
    }

    @Override
    public List<SysUserResult> findListBySpec(SysUserParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(SysUserParam param){
        Page pageContext = getPageContext();
        QueryWrapper<SysUser> objectQueryWrapper = new QueryWrapper<>();
        IPage page = this.page(pageContext, objectQueryWrapper);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(SysUserParam param){
        return param.getUserId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private SysUser getOldEntity(SysUserParam param) {
        return this.getById(getKey(param));
    }

    private SysUser getEntity(SysUserParam param) {
        SysUser entity = new SysUser();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
