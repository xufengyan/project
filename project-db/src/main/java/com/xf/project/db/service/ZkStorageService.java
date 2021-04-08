package com.xf.project.db.service;

import com.github.pagehelper.PageHelper;

import com.xf.project.db.dao.ZkStorageMapper;
import com.xf.project.db.domain.ZkStorage;
import com.xf.project.db.domain.ZkStorageExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ZkStorageService {
    @Autowired
    private ZkStorageMapper storageMapper;

    public void deleteByKey(String key) {
        ZkStorageExample example = new ZkStorageExample();
        example.or().andKeyEqualTo(key);
        storageMapper.logicalDeleteByExample(example);
    }

    public void add(ZkStorage storageInfo) {
        storageInfo.setAddTime(LocalDateTime.now());
        storageInfo.setUpdateTime(LocalDateTime.now());
        storageMapper.insertSelective(storageInfo);
    }

    public ZkStorage findByKey(String key) {
        ZkStorageExample example = new ZkStorageExample();
        example.or().andKeyEqualTo(key).andDeletedEqualTo(false);
        return storageMapper.selectOneByExample(example);
    }

    public int update(ZkStorage storageInfo) {
        storageInfo.setUpdateTime(LocalDateTime.now());
        return storageMapper.updateByPrimaryKeySelective(storageInfo);
    }

    public ZkStorage findById(Integer id) {
        return storageMapper.selectByPrimaryKey(id);
    }

    public List<ZkStorage> querySelective(String key, String name, Integer page, Integer limit, String sort, String order) {
        ZkStorageExample example = new ZkStorageExample();
        ZkStorageExample.Criteria criteria = example.createCriteria();

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
