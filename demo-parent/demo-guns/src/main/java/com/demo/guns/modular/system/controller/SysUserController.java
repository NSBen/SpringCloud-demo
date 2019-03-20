package com.demo.guns.modular.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.guns.core.common.page.LayuiPageInfo;
import com.demo.guns.modular.system.entity.SysUser;
import com.demo.guns.modular.system.model.param.SysUserParam;
import com.demo.guns.modular.system.service.SysUserService;

import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import io.swagger.annotations.ApiOperation;

/**
 * 管理员表控制器
 *
 * @author
 * @Date 2019-03-20 11:59:22
 */
@Controller
@RequestMapping("/sysUser")
public class SysUserController extends BaseController {

	@Autowired
	private SysUserService sysUserService;

	/**
	 * 新增接口
	 *
	 * @author
	 * @Date 2019-03-20
	 */
	@ApiOperation("新增接口")
	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData addItem(SysUserParam sysUserParam) {
		this.sysUserService.add(sysUserParam);
		return ResponseData.success();
	}

	/**
	 * 编辑接口
	 *
	 * @author
	 * @Date 2019-03-20
	 */
	@ApiOperation("编辑接口")
	@RequestMapping(value = "/editItem", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData editItem(SysUserParam sysUserParam) {
		this.sysUserService.update(sysUserParam);
		return ResponseData.success();
	}

	/**
	 * 删除接口
	 *
	 * @author
	 * @Date 2019-03-20
	 */
	@ApiOperation("删除接口")
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData delete(SysUserParam sysUserParam) {
		this.sysUserService.delete(sysUserParam);
		return ResponseData.success();
	}

	/**
	 * 查看详情接口
	 *
	 * @author
	 * @Date 2019-03-20
	 */
	@ApiOperation("查看详情接口")
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData detail(@RequestBody SysUserParam sysUserParam) {
		SysUser detail = this.sysUserService.getById(sysUserParam.getUserId());
		return ResponseData.success(detail);
	}

	/**
	 * 查询列表
	 *
	 * @author
	 * @Date 2019-03-20
	 */
	@ApiOperation("查询列表")
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public LayuiPageInfo list(SysUserParam sysUserParam) {
		return this.sysUserService.findPageBySpec(sysUserParam);
	}

}
