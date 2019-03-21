package com.demo.guns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.guns.core.common.page.LayuiPageInfo;
import com.demo.guns.entity.SysTenementType;
import com.demo.guns.model.params.SysTenementTypeParam;
import com.demo.guns.service.SysTenementTypeService;

import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import io.swagger.annotations.ApiOperation;

/**
 * 机构类型控制器
 *
 * @author
 * @Date 2019-03-21 13:27:42
 */
@Controller
@RequestMapping("/sysTenementType")
public class SysTenementTypeController extends BaseController {

	@Autowired
	SysTenementTypeService sysTenementTypeService;

	/**
	 * 新增接口
	 *
	 * @author
	 * @Date 2019-03-21
	 */
	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	@ApiOperation("新增接口")
	@ResponseBody
	public ResponseData addItem(SysTenementTypeParam sysTenementTypeParam) {
		this.sysTenementTypeService.add(sysTenementTypeParam);
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
	public ResponseData editItem(SysTenementTypeParam sysTenementTypeParam) {
		this.sysTenementTypeService.update(sysTenementTypeParam);
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
	public ResponseData delete(SysTenementTypeParam sysTenementTypeParam) {
		this.sysTenementTypeService.delete(sysTenementTypeParam);
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
	public ResponseData detail(SysTenementTypeParam sysTenementTypeParam) {
		SysTenementType detail = this.sysTenementTypeService.getById(sysTenementTypeParam.getTenementTypeId());
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
	@RequestMapping("/list")
	public LayuiPageInfo list(SysTenementTypeParam sysTenementTypeParam) {
		return this.sysTenementTypeService.findPageBySpec(sysTenementTypeParam);
	}

}
