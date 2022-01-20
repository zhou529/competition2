package com.zln.competition.controller;


import com.zln.competition.bean.UserClickCommunity;
import com.zln.competition.bean.UserClickRecommend;
import com.zln.competition.bean.Users;
import com.zln.competition.service.UserClickCommunityService;
import com.zln.competition.service.UserClickRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@RestController
@ResponseBody
public class UserClickCommunityController {
    @Autowired
    UserClickCommunityService userClickCommunityService;

    @RequestMapping(value = "/updateUserClickCommunityNumber")
    public int updateNumber(
            @RequestParam("date") String date,
            @RequestParam("communityId") String communityId,
            HttpServletRequest request){

        //获取comId
        ServletContext servletContext = request.getServletContext();
        Users user = (Users) servletContext.getAttribute("user");
        String userOpenid = user.getUserOpenid();

        UserClickCommunity userClickCommunity = new UserClickCommunity();
        userClickCommunity.setOpenid(userOpenid);
        userClickCommunity.setDate(date);
        userClickCommunity.setCommunityId(Integer.valueOf(communityId));
        userClickCommunity.setNumber(1);

        //检查表中是否有这个openid点击过的数据
        UserClickCommunity is_exist = userClickCommunityService.selectByOpenIdAndComId(userOpenid,Integer.valueOf(communityId));
        //如果有数据
        if(is_exist != null){
            userClickCommunity.setId(is_exist.getId());
            userClickCommunity.setNumber(is_exist.getNumber() + 1);
            int i = userClickCommunityService.updateByPrimaryKeySelective(userClickCommunity);
            return i;
        }
        //没有时数据就插入这条数据令number= 1
        int is_insert = userClickCommunityService.insertSelective(userClickCommunity);
        return is_insert;
    }
}
