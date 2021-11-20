package com.zln.competition.mapper;

import com.zln.competition.bean.SignTable;

import java.util.List;

public interface SignTableMapper {
    public int insertSignTable(SignTable signTable);

    //    public List<SignTable> queryAll(SignTable signTable);
    SignTable selectBySignTable(SignTable signTable);
}
