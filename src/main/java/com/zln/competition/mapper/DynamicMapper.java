package com.zln.competition.mapper;

import com.zln.competition.bean.Dynamic;

import java.util.List;

public interface DynamicMapper {
    public List<Dynamic> selectAllDynamic();
    public int addDynamic(Dynamic dynamic);
    Dynamic selectDynamicByDynId(Integer dynId);
}
