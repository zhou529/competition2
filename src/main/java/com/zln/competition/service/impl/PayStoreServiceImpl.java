package com.zln.competition.service.impl;

import com.zln.competition.bean.PayStore;
import com.zln.competition.mapper.PayStoreMapper;
import com.zln.competition.service.PayStoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PayStoreServiceImpl implements PayStoreService {
    @Resource
    private PayStoreMapper payStoreMapper;

    @Override
    public int deleteByPrimaryKey(Integer productId) {
        return payStoreMapper.deleteByPrimaryKey(productId);
    }

    @Override
    public int insert(PayStore record) {
        return payStoreMapper.insert(record);
    }

    @Override
    public int insertSelective(PayStore record) {
        return payStoreMapper.insertSelective(record);
    }

    @Override
    public PayStore selectByPrimaryKey(Integer productId) {
        return payStoreMapper.selectByPrimaryKey(productId);
    }

    @Override
    public int updateByPrimaryKeySelective(PayStore record) {
        return payStoreMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPayStore(PayStore record) {
        return payStoreMapper.updateByPayStore(record);
    }

    @Override
    public int updateByPrimaryKey(PayStore record) {
        return payStoreMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PayStore> selectAllPayStore() {
        List<PayStore> payStoreList =  payStoreMapper.selectAllPayStore();
        return payStoreList;
    }

    @Override
    public int updateExchangeNumber(Integer productId) {
        return payStoreMapper.updateExchangeNumber(productId);
    }

}
