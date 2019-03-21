package com.demo.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 机构控制器
 *
 * @author 
 * @Date 2019-03-21 10:31:12
 */
@Controller
@RequestMapping("/sysTenement")
public class SysTenementController  {

    private String PREFIX = "/modular/sysTenement";

    /**
     * 跳转到主页面
     *
     * @author 
     * @Date 2019-03-21
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/sysTenement.html";
    }

    /**
     * 新增页面
     *
     * @author 
     * @Date 2019-03-21
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/sysTenement_add.html";
    }

    /**
     * 编辑页面
     *
     * @author 
     * @Date 2019-03-21
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/sysTenement_edit.html";
    }
}


