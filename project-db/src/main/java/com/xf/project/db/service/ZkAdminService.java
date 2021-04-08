package com.xf.project.db.service;

import com.github.pagehelper.PageHelper;

import com.xf.project.db.dao.ZkAdminMapper;
import com.xf.project.db.domain.ZkAdmin;
import com.xf.project.db.domain.ZkAdmin.Column;

import com.xf.project.db.domain.ZkAdminExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ZkAdminService {
    private final Column[] result = new Column[]{Column.id, Column.username, Column.avatar, Column.roleIds};
    @Resource
    private ZkAdminMapper adminMapper;

    public List<ZkAdmin> findAdmin(String username) {
        ZkAdminExample example = new ZkAdminExample();
        example.or().andUsernameEqualTo(username).andDeletedEqualTo(false);
        return adminMapper.selectByExample(example);
    }

    public ZkAdmin findAdmin(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    public List<ZkAdmin> querySelective(String username, Integer page, Integer limit, String sort, String order) {
        ZkAdminExample example = new ZkAdminExample();
        ZkAdminExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(username)) {
            criteria.andUsernameLike("%" + username + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return adminMapper.selectByExampleSelective(example, result);
    }

    public int updateById(ZkAdmin admin) {
        admin.setUpdateTime(LocalDateTime.now());
        return adminMapper.updateByPrimaryKeySelective(admin);
    }

    public void deleteById(Integer id) {
        adminMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(ZkAdmin admin) {
        admin.setAddTime(LocalDateTime.now());
        admin.setUpdateTime(LocalDateTime.now());
        adminMapper.insertSelective(admin);
    }

    public ZkAdmin findById(Integer id) {
        return adminMapper.selectByPrimaryKeySelective(id, result);
    }

    public List<ZkAdmin> all() {
        ZkAdminExample example = new ZkAdminExample();
        example.or().andDeletedEqualTo(false);
        return adminMapper.selectByExample(example);
    }
}
