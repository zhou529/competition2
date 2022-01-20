package com.zln.competition.service;

import com.zln.competition.bean.SignTable;

import java.util.List;

public interface SignTableService {
    public int insertSignTable(SignTable signTable);
    //    public List<SignTable> queryAll(SignTable SignTable);
    SignTable selectBySignTable(SignTable signTable);

    SignTable selectPayByOpenId(String openid);

    int updateSignPay(String userOpenid, Integer exchangedPay);

    SignTable individualRank(String userOpenId);

    int addSignPayForAns(String userOpenid, Integer exchangedPay);

}
