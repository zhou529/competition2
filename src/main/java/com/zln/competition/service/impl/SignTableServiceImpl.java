package com.zln.competition.service.impl;

import com.zln.competition.bean.SignTable;
import com.zln.competition.mapper.SignTableMapper;
import com.zln.competition.service.SignTableService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SignTableServiceImpl implements SignTableService {
    @Resource
    SignTableMapper signTableMapper;
    @Override
    public int insertSignTable(SignTable signTable) {
        return signTableMapper.insertSignTable(signTable);
    }


    @Override
    public SignTable selectBySignTable(SignTable signTable){
        SignTable signTable1 = signTableMapper.selectBySignTable(signTable);
        return signTable1;
    }

    @Override
    public SignTable selectPayByOpenId(String openid) {
        SignTable signTable = signTableMapper.selectPayByOpenId(openid);
        return signTable;
    }
//    @Override
//    public List<SignTable> queryAll(SignTable signTable){
//        return signTableMapper.queryAll(signTable);
//    }

}
