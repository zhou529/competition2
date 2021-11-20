package com.zln.competition.service.impl;

import com.zln.competition.bean.Winners;
import com.zln.competition.mapper.WinnersMapper;
import com.zln.competition.service.WinnersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WinnerServiceImpl implements WinnersService {
    @Resource
    WinnersMapper winnersMapper;

    public List<Winners> selectAllWinners(){
        List<Winners> winners = winnersMapper.selectAllWinners();
        return winners;
    }

}
