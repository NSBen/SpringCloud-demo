package com.demo.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 部门控制器
 *
 * @author 
 * @Date 2019-03-21 10:31:11
 */
@Controller
@RequestMapping("/sysDept")
public class SysDeptController  {

    private String PREFIX = "/modular/sysDept";


    /**
     * 跳转到主页面
     *
     * @author 
     * @Date 2019-03-21
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/sysDept.html";
    }

    /**
     * 新增页面
     *
     * @author 
     * @Date 2019-03-21
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/sysDept_add.html";
    }

    /**
     * 编辑页面
     *
     * @author 
     * @Date 2019-03-21
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/sysDept_edit.html";
    }
}


