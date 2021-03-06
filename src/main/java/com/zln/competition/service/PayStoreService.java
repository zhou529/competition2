package com.zln.competition.service;

import com.zln.competition.bean.PayStore;

import java.util.List;

public interface PayStoreService {
    int deleteByPrimaryKey(Integer productId);

    int insert(PayStore record);

    int insertSelective(PayStore record);

    PayStore selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(PayStore record);

    int updateByPayStore(PayStore record);

    List<PayStore> selectPayStoreByLikeProductName(String productName);

    int updateImgById(PayStore record);

    int updateByPrimaryKey(PayStore record);

    List<PayStore> selectAllPayStore();

    int updateExchangeNumber(Integer productId);
}
