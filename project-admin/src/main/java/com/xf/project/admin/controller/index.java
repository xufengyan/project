package com.xf.project.admin.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xf
 * @version 1.0
 * @date 2021/3/27 15:54
 */
@Controller
public class index {

    @RequiresPermissions("test")
    @RequestMapping("/test")
    public String test(){
        return "index";
    }

}
