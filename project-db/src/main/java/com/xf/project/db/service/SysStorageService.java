package com.xf.project.db.service;

import com.github.pagehelper.PageHelper;

import com.xf.project.db.dao.SysStorageMapper;
import com.xf.project.db.domain.SysStorage;
import com.xf.project.db.domain.SysStorageExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SysStorageService {
    @Autowired
    private SysStorageMapper storageMapper;

    public void deleteByKey(String key) {
        SysStorageExample example = new SysStorageExample();
        example.or().andKeyEqualTo(key);
        storageMapper.logicalDeleteByExample(example);
    }

    public void add(SysStorage storageInfo) {
        storageInfo.setAddTime(LocalDateTime.now());
        storageInfo.setUpdateTime(LocalDateTime.now());
        storageMapper.insertSelective(storageInfo);
    }

    public SysStorage findByKey(String key) {
        SysStorageExample example = new SysStorageExample();
        example.or().andKeyEqualTo(key).andDeletedEqualTo(false);
        return storageMapper.selectOneByExample(example);
    }

    public int update(SysStorage storageInfo) {
        storageInfo.setUpdateTime(LocalDateTime.now());
        return storageMapper.updateByPrimaryKeySelective(storageInfo);
    }

    public SysStorage findById(Integer id) {
        return storageMapper.selectByPrimaryKey(id);
    }

    public List<SysStorage> querySelective(String key, String name, Integer page, Integer limit, String sort, String order) {
        SysStorageExample example = new SysStorageExample();
        SysStorageExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(key)) {
            criteria.andKeyEqualTo(key);
        }
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return storageMapper.selectByExample(example);
    }
}
