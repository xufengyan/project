package com.xf.project.admin.shiro;


import com.xf.project.db.domain.SysAdmin;
import com.xf.project.db.service.SysAdminService;
import com.xf.project.db.service.SysPermissionService;
import com.xf.project.db.service.SysRoleService;
import com.xf.project.framework.util.bcrypt.BCryptPasswordEncoder;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Set;

public class AdminAuthorizingRealm extends AuthorizingRealm {

    @Autowired
    private SysAdminService adminService;
    @Autowired
    private SysRoleService roleService;
    @Autowired
    private SysPermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (principals == null) {
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        }

        SysAdmin admin = (SysAdmin) getAvailablePrincipal(principals);
        Integer[] roleIds = admin.getRoleIds();
        Set<String> roles = roleService.queryByIds(roleIds);
        Set<String> permissions = permissionService.queryByRoleIds(roleIds);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setStringPermissions(permissions);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();
        String password = new String(upToken.getPassword());

        if (StringUtils.isEmpty(username)) {
            throw new AccountException("?????????????????????");
        }
        if (StringUtils.isEmpty(password)) {
            throw new AccountException("??????????????????");
        }

        List<SysAdmin> adminList = adminService.findAdmin(username);
        Assert.state(adminList.size() < 2, "????????????????????????????????????");
        if (adminList.size() == 0) {
            throw new UnknownAccountException("??????????????????" + username + "??????????????????");
        }
        SysAdmin admin = adminList.get(0);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(password, admin.getPassword())) {
            throw new UnknownAccountException("??????????????????" + username + "??????????????????");
        }

        return new SimpleAuthenticationInfo(admin, password, getName());
    }

}
