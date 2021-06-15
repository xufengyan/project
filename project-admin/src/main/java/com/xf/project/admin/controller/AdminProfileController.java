package com.xf.project.admin.controller;

import com.xf.project.framework.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;

import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "13000.心跳服务")
@RestController
@RequestMapping("/admin/profile")
@Validated
public class AdminProfileController {
    private final Log logger = LogFactory.getLog(AdminProfileController.class);


    @ApiOperation(value = "检查当期那服务是否有效")
    @RequiresAuthentication
    @GetMapping("/nnotice")
    public Object nNotice() {
//        int count = noticeAdminService.countUnread(getAdminId());
        return ResponseUtil.ok(0);
    }

}
