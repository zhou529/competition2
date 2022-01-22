package com.zln.competition.service.impl;

import com.zln.competition.bean.Fdback;
import com.zln.competition.mapper.FdbackMapper;
import com.zln.competition.service.FdbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class FdbackServiceImpl implements FdbackService {
    @Autowired
    @Resource
    FdbackMapper fdbackMapper;

    @Override
    public int deleteByPrimaryKey(Integer fdbackId) {
        return fdbackMapper.deleteByPrimaryKey(fdbackId);
    }

    @Override
    public int insert(Fdback record) {
        return fdbackMapper.insert(record);
    }

    @Override
    public int insertSelective(Fdback record) {
        return fdbackMapper.insertSelective(record);
    }

    @Override
    public Fdback selectByPrimaryKey(Integer fdbackId) {
        return fdbackMapper.selectByPrimaryKey(fdbackId);
    }

    @Override
    public int updateByPrimaryKeySelective(Fdback record) {
        return fdbackMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Fdback record) {
        return fdbackMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Fdback> selectAllFdback() {
        return fdbackMapper.selectAllFdback();
    }
}
