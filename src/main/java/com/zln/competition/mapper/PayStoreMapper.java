package com.zln.competition.mapper;

import com.zln.competition.bean.PayStore;

import java.util.List;

public interface PayStoreMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(PayStore record);

    int insertSelective(PayStore record);

    PayStore selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(PayStore record);

    int updateByPayStore(PayStore record);

    int updateByPrimaryKey(PayStore record);

    List<PayStore> selectAllPayStore();

    int updateExchangeNumber(Integer productId);
}
