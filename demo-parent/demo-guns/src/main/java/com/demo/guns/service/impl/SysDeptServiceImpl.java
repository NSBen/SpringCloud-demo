package com.demo.guns.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.guns.core.common.page.LayuiPageFactory;
import com.demo.guns.core.common.page.LayuiPageInfo;
import com.demo.guns.entity.SysDept;
import com.demo.guns.mapper.SysDeptMapper;
import com.demo.guns.model.params.SysDeptParam;
import com.demo.guns.model.result.SysDeptResult;
import  com.demo.guns.service.SysDeptService;

import cn.stylefeng.roses.core.util.ToolUtil;

/**
 * <p>
 * 部门 服务实现类
 * </p>
 *
 * @author 
 * @since 2019-03-21
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {

    @Override
    public void add(SysDeptParam param){
        SysDept entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(SysDeptParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(SysDeptParam param){
        SysDept oldEntity = getOldEntity(param);
        SysDept newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public SysDeptResult findBySpec(SysDeptParam param){
        return null;
    }

    @Override
    public List<SysDeptResult> findListBySpec(SysDeptParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(SysDeptParam param){
        Page pageContext = getPageContext();
        QueryWrapper<SysDept> objectQueryWrapper = new QueryWrapper<>();
        IPage page = this.page(pageContext, objectQueryWrapper);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(SysDeptParam param){
        return param.getDeptId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private SysDept getOldEntity(SysDeptParam param) {
        return this.getById(getKey(param));
    }

    private SysDept getEntity(SysDeptParam param) {
        SysDept entity = new SysDept();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
