package com.zln.competition.controller;


import com.zln.competition.bean.*;
import com.zln.competition.service.UserClickCommunityService;
import com.zln.competition.service.UserClickRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@ResponseBody
public class UserClickCommunityController {
    @Autowired
    UserClickCommunityService userClickCommunityService;

    @RequestMapping(value = "/community_click", method = RequestMethod.POST)
    public List<UserClickCommunity> community_click(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ComAdmin loginAdmin = (ComAdmin) session.getAttribute("loginAdmin");
        System.out.println("ComAdmin = " + loginAdmin);
        Integer comId = loginAdmin.getComId();
        List<UserClickCommunity> userClickCommunities = userClickCommunityService.community_click(comId);
        return userClickCommunities;
    }

    @RequestMapping(value = "/updateUserClickCommunityNumber")
    public int updateNumber(
            @RequestParam("date") String date,
            @RequestParam("communityId") String communityId,
            HttpServletRequest request) {
        System.out.println("date = " + date);
        System.out.println("communityId = " + communityId);
        //获取comId
        ServletContext servletContext = request.getServletContext();
        Users user = (Users) servletContext.getAttribute("user");
        System.out.println("user = " + user);
        String userOpenid = user.getUserOpenid();

        UserClickCommunity userClickCommunity = new UserClickCommunity();
        userClickCommunity.setOpenid(userOpenid);
        userClickCommunity.setDate(date);
        userClickCommunity.setCommunityId(Integer.valueOf(communityId));
        userClickCommunity.setNumber(1);

        //检查表中是否有这个openid点击过的数据
        UserClickCommunity is_exist = userClickCommunityService.selectByOpenIdAndComId(userOpenid, Integer.valueOf(communityId), date);
        //如果有数据
        if (is_exist != null) {
            System.out.println("有数据，更改number");
            userClickCommunity.setId(is_exist.getId());
            userClickCommunity.setNumber(is_exist.getNumber() + 1);
            userClickCommunity.setDate(date);
            int i = userClickCommunityService.updateByPrimaryKeySelective(userClickCommunity);
            return i;
        }
        System.out.println("没有数据，插入");
        //没有时数据就插入这条数据令number= 1
        int is_insert = userClickCommunityService.insertSelective(userClickCommunity);
        return is_insert;
    }
}
