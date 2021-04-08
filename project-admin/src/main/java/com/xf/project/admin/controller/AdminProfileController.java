package com.xf.project.admin.controller;

import com.xf.project.framework.util.ResponseUtil;
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


@RestController
@RequestMapping("/admin/profile")
@Validated
public class AdminProfileController {
    private final Log logger = LogFactory.getLog(AdminProfileController.class);



    @RequiresAuthentication
    @GetMapping("/nnotice")
    public Object nNotice() {
//        int count = noticeAdminService.countUnread(getAdminId());
        return ResponseUtil.ok(0);
    }

}
