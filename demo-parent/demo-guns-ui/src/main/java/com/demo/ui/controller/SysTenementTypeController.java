package com.demo.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 机构类型控制器
 *
 * @author 
 * @Date 2019-03-21 10:31:12
 */
@Controller
@RequestMapping("/sysTenementType")
public class SysTenementTypeController {

    private String PREFIX = "/modular/sysTenementType";

    /**
     * 跳转到主页面
     *
     * @author 
     * @Date 2019-03-21
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/sysTenementType.html";
    }

    /**
     * 新增页面
     *
     * @author 
     * @Date 2019-03-21
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/sysTenementType_add.html";
    }

    /**
     * 编辑页面
     *
     * @author 
     * @Date 2019-03-21
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/sysTenementType_edit.html";
    }
}


