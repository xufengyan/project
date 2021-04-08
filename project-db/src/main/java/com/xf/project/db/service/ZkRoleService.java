package com.xf.project.db.service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.xf.project.db.dao.ZkRoleMapper;
import com.xf.project.db.domain.ZkRole;
import com.xf.project.db.domain.ZkRoleExample;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ZkRoleService {
    @Resource
    private ZkRoleMapper roleMapper;


    public Set<String> queryByIds(Integer[] roleIds) {
        Set<String> roles = new HashSet<String>();
        if(roleIds.length == 0){
            return roles;
        }

        ZkRoleExample example = new ZkRoleExample();
        example.or().andIdIn(Arrays.asList(roleIds)).andEnabledEqualTo(true).andDeletedEqualTo(false);
        List<ZkRole> roleList = roleMapper.selectByExample(example);

        for(ZkRole role : roleList){
            roles.add(role.getName());
        }

        return roles;

    }

    public List<ZkRole> querySelective(String name, Integer page, Integer limit, String sort, String order) {
        ZkRoleExample example = new ZkRoleExample();
        ZkRoleExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return roleMapper.selectByExample(example);
    }

    public ZkRole findById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    public void add(ZkRole role) {
        role.setAddTime(LocalDateTime.now());
        role.setUpdateTime(LocalDateTime.now());
        roleMapper.insertSelective(role);
    }

    public void deleteById(Integer id) {
        roleMapper.logicalDeleteByPrimaryKey(id);
    }

    public void updateById(ZkRole role) {
        role.setUpdateTime(LocalDateTime.now());
        roleMapper.updateByPrimaryKeySelective(role);
    }

    public boolean checkExist(String name) {
        ZkRoleExample example = new ZkRoleExample();
        example.or().andNameEqualTo(name).andDeletedEqualTo(false);
        return roleMapper.countByExample(example) != 0;
    }

    public List<ZkRole> queryAll() {
        ZkRoleExample example = new ZkRoleExample();
        example.or().andDeletedEqualTo(false);
        return roleMapper.selectByExample(example);
    }
}
