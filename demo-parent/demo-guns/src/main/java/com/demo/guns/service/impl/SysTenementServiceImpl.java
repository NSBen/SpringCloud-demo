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
import com.demo.guns.entity.SysTenement;
import com.demo.guns.mapper.SysTenementMapper;
import com.demo.guns.model.params.SysTenementParam;
import com.demo.guns.model.result.SysTenementResult;
import  com.demo.guns.service.SysTenementService;

import cn.stylefeng.roses.core.util.ToolUtil;

/**
 * <p>
 * 机构 服务实现类
 * </p>
 *
 * @author 
 * @since 2019-03-21
 */
@Service
public class SysTenementServiceImpl extends ServiceImpl<SysTenementMapper, SysTenement> implements SysTenementService {

    @Override
    public void add(SysTenementParam param){
        SysTenement entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(SysTenementParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(SysTenementParam param){
        SysTenement oldEntity = getOldEntity(param);
        SysTenement newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public SysTenementResult findBySpec(SysTenementParam param){
        return null;
    }

    @Override
    public List<SysTenementResult> findListBySpec(SysTenementParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(SysTenementParam param){
        Page pageContext = getPageContext();
        QueryWrapper<SysTenement> objectQueryWrapper = new QueryWrapper<>();
        IPage page = this.page(pageContext, objectQueryWrapper);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(SysTenementParam param){
        return param.getTenementId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private SysTenement getOldEntity(SysTenementParam param) {
        return this.getById(getKey(param));
    }

    private SysTenement getEntity(SysTenementParam param) {
        SysTenement entity = new SysTenement();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
