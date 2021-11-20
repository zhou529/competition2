package com.zln.competition.service.impl;

import com.zln.competition.bean.Dynamic;
import com.zln.competition.mapper.DynamicMapper;
import com.zln.competition.service.DynamicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DynamicServiceImpl implements DynamicService {
    @Resource
    DynamicMapper dynamicMapper;



    @Override
    public List<Dynamic> selectAllDynamic() {
        List<Dynamic> dynamics = dynamicMapper.selectAllDynamic();
        System.out.println("DynamicServiceImpl的selectAllDynamic方法的返回值dynamics ： " + dynamics);
        return dynamics;
    }

    @Override
    public int addDynamic(Dynamic dynamic){
        int i = dynamicMapper.addDynamic(dynamic);
        return i;
    }

    @Override
    public Dynamic selectDynamicByDynId(Integer dynId) {
        return dynamicMapper.selectDynamicByDynId(dynId);
    }
}
