package com.zln.competition.service;

import com.zln.competition.bean.Dynamic;

import java.util.List;

public interface DynamicService {
    public List<Dynamic> selectAllDynamic();
    public int addDynamic(Dynamic dynamic);
    Dynamic selectDynamicByDynId(Integer dynId);
}
