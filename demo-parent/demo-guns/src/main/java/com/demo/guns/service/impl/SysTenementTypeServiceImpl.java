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
import com.demo.guns.entity.SysTenementType;
import com.demo.guns.mapper.SysTenementTypeMapper;
import com.demo.guns.model.params.SysTenementTypeParam;
import com.demo.guns.model.result.SysTenementTypeResult;
import  com.demo.guns.service.SysTenementTypeService;

import cn.stylefeng.roses.core.util.ToolUtil;

/**
 * <p>
 * 机构类型 服务实现类
 * </p>
 *
 * @author 
 * @since 2019-03-21
 */
@Service
public class SysTenementTypeServiceImpl extends ServiceImpl<SysTenementTypeMapper, SysTenementType> implements SysTenementTypeService {

    @Override
    public void add(SysTenementTypeParam param){
        SysTenementType entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(SysTenementTypeParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(SysTenementTypeParam param){
        SysTenementType oldEntity = getOldEntity(param);
        SysTenementType newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public SysTenementTypeResult findBySpec(SysTenementTypeParam param){
        return null;
    }

    @Override
    public List<SysTenementTypeResult> findListBySpec(SysTenementTypeParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(SysTenementTypeParam param){
        Page pageContext = getPageContext();
        QueryWrapper<SysTenementType> objectQueryWrapper = new QueryWrapper<>();
        IPage page = this.page(pageContext, objectQueryWrapper);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(SysTenementTypeParam param){
        return param.getTenementTypeId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private SysTenementType getOldEntity(SysTenementTypeParam param) {
        return this.getById(getKey(param));
    }

    private SysTenementType getEntity(SysTenementTypeParam param) {
        SysTenementType entity = new SysTenementType();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
