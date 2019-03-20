package com.demo.guns.modular.system.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.guns.core.common.node.MenuNode;
import com.demo.guns.modular.system.service.UserService;

import io.swagger.annotations.ApiOperation;

@Controller
public class HomeController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {

		// 获取当前用户角色列表
		List<Long> roleList = new ArrayList<>();
		roleList.add(1l);

		List<MenuNode> menus = userService.getUserMenuNodes(roleList);
		model.addAttribute("menus", menus);
		return "/index.html";
	}

	@GetMapping("/health")
	public String health() {
		return "hello consul";
	}
}
