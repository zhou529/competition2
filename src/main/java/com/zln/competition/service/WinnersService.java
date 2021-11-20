package com.zln.competition.service;

import com.zln.competition.bean.Winners;

import java.util.List;

public interface WinnersService {
    /**
     * 查找所有winners  名人堂中的所有数据
     * @return
     */
    public List<Winners> selectAllWinners();
}
