package com.xf.project.db.service;


import com.xf.project.db.dao.ZkPermissionMapper;
import com.xf.project.db.domain.ZkPermission;
import com.xf.project.db.domain.ZkPermissionExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ZkPermissionService {
    @Resource
    private ZkPermissionMapper permissionMapper;

    public Set<String> queryByRoleIds(Integer[] roleIds) {
        Set<String> permissions = new HashSet<String>();
        if(roleIds.length == 0){
            return permissions;
        }

        ZkPermissionExample example = new ZkPermissionExample();
        example.or().andRoleIdIn(Arrays.asList(roleIds)).andDeletedEqualTo(false);
        List<ZkPermission> permissionList = permissionMapper.selectByExample(example);

        for(ZkPermission permission : permissionList){
            permissions.add(permission.getPermission());
        }

        return permissions;
    }


    public Set<String> queryByRoleId(Integer roleId) {
        Set<String> permissions = new HashSet<String>();
        if(roleId == null){
            return permissions;
        }

        ZkPermissionExample example = new ZkPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andDeletedEqualTo(false);
        List<ZkPermission> permissionList = permissionMapper.selectByExample(example);

        for(ZkPermission permission : permissionList){
            permissions.add(permission.getPermission());
        }

        return permissions;
    }

    public boolean checkSuperPermission(Integer roleId) {
        if(roleId == null){
            return false;
        }

        ZkPermissionExample example = new ZkPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andPermissionEqualTo("*").andDeletedEqualTo(false);
        return permissionMapper.countByExample(example) != 0;
    }

    public void deleteByRoleId(Integer roleId) {
        ZkPermissionExample example = new ZkPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andDeletedEqualTo(false);
        permissionMapper.logicalDeleteByExample(example);
    }

    public void add(ZkPermission litemallPermission) {
        litemallPermission.setAddTime(LocalDateTime.now());
        litemallPermission.setUpdateTime(LocalDateTime.now());
        permissionMapper.insertSelective(litemallPermission);
    }
}
