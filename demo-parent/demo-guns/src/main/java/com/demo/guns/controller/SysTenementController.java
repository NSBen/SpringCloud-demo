package com.demo.guns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.guns.core.common.page.LayuiPageInfo;
import com.demo.guns.entity.SysTenement;
import com.demo.guns.model.params.SysTenementParam;
import com.demo.guns.service.SysTenementService;

import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import io.swagger.annotations.ApiOperation;


/**
 * 机构控制器
 *
 * @author 
 * @Date 2019-03-21 16:12:06
 */
@Controller
@RequestMapping("/sysTenement")
public class SysTenementController extends BaseController {

    @Autowired
    private SysTenementService sysTenementService;

    /**
     * 新增接口
     *
     * @author 
     * @Date 2019-03-21
     */
    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    @ApiOperation("新增接口")
    @ResponseBody
    public ResponseData addItem(SysTenementParam sysTenementParam) {
        this.sysTenementService.add(sysTenementParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author 
     * @Date 2019-03-21
     */
    @ApiOperation("编辑接口")
    @RequestMapping(value = "/editItem", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData editItem(SysTenementParam sysTenementParam) {
        this.sysTenementService.update(sysTenementParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author 
     * @Date 2019-03-21
     */
    @ApiOperation("删除接口")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData delete(SysTenementParam sysTenementParam) {
        this.sysTenementService.delete(sysTenementParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author 
     * @Date 2019-03-21
     */
    @ApiOperation("查看详情接口")
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData detail(SysTenementParam sysTenementParam) {
        SysTenement detail = this.sysTenementService.getById(sysTenementParam.getTenementId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author 
     * @Date 2019-03-21
     */
    @ApiOperation("查询列表")
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public LayuiPageInfo list(SysTenementParam sysTenementParam) {
        return this.sysTenementService.findPageBySpec(sysTenementParam);
    }

}


