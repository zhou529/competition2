package com.zln.competition.controller;

import com.zln.competition.bean.Winners;
import com.zln.competition.service.WinnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WinnerController {
    @Autowired
    WinnersService winnersService;

    @RequestMapping(value = "/selectAllWinners",method = RequestMethod.POST)
    public List<Winners> selectAllWinners(){
        System.out.println("WinnerController的selectAllWinners查询功能执行了--------------------------------------------");
        List<Winners> winners = winnersService.selectAllWinners();
        System.out.println("winnwes : " + winners);
        return winners;
    }
}
