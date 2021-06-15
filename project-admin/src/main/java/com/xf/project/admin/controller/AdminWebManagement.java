package com.xf.project.admin.controller;

import com.google.gson.internal.$Gson$Preconditions;
import com.xf.project.admin.annotation.RequiresPermissionsDesc;
import com.xf.project.framework.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xf
 * @version 1.0
 * @date 2021/4/8 11:05
 */
@Api(tags = "16000.博客基本服务")
@RestController
@RequestMapping("/admin/web")
@Validated
public class AdminWebManagement {

    @ApiOperation(value = "查询")
    @RequiresPermissions("admin:web:mangement")
    @GetMapping("/getWebManagement")
    @RequiresPermissionsDesc(menu = {"官网管理", "基本信息管理"}, button = "查询")
    public Object getWebManagement(){
        return ResponseUtil.ok(0);
    }

}
