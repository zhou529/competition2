package com.zln.competition.controller;

import com.zln.competition.bean.Team;
import com.zln.competition.bean.UserClickRecommend;
import com.zln.competition.bean.Users;
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
public class UserClickRecommendController {
    @Autowired
    UserClickRecommendService userClickRecommendService;

    @RequestMapping(value = "/updateNumber")
    public int updateNumber(
            @RequestParam("date") String date,
            @RequestParam("recId") String recId,
            HttpServletRequest request){

        //获取comId
        ServletContext servletContext = request.getServletContext();
        Users user = (Users) servletContext.getAttribute("user");
        String userOpenid = user.getUserOpenid();

        UserClickRecommend userClickRecommend = new UserClickRecommend();
        userClickRecommend.setOpenid(userOpenid);
        userClickRecommend.setDate(date);
        userClickRecommend.setRecId(Integer.valueOf(recId));
        userClickRecommend.setNumber(1);

        //检查表中是否有这个openid点击过的数据
        UserClickRecommend is_exist = userClickRecommendService.selectByOpenIdAndRecId(userOpenid, Integer.valueOf(recId));
        //如果有数据
        if(is_exist != null){
            userClickRecommend.setClickId(is_exist.getClickId());
            userClickRecommend.setNumber(is_exist.getNumber()+1);
            int i = userClickRecommendService.updateByPrimaryKeySelective(userClickRecommend);
            return i;
        }
        //没有时数据就插入这条数据令number= 1
        int is_insert = userClickRecommendService.insertSelective(userClickRecommend);
        return is_insert;
    }

}
