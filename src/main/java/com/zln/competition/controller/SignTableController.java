package com.zln.competition.controller;

//import com.alibaba.fastjson.JSONObject;

import com.zln.competition.bean.SignTable;
import com.zln.competition.bean.Users;
import com.zln.competition.service.SignTableService;
import com.zln.competition.service.UserService;
import com.zln.competition.util.CalendarUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@RestController
public class SignTableController {
    @Autowired
    SignTableService signTableService;
    @Autowired
    UserService userService;



    @RequestMapping(value = "/individual_rank", method = RequestMethod.POST)
    public Integer individual_rank(HttpServletRequest request) {
        System.out.println("SignTableController的individual_rank执行了");
        ServletContext servletContext = request.getServletContext();
        Users user = (Users) servletContext.getAttribute("user");
        System.out.println("user : " + user);
        String userOpenid = user.getUserOpenid();
        SignTable signTable = signTableService.individualRank(userOpenid);
        System.out.println("signTable : " + signTable);


//        int userId = user.getUserId();
//        System.out.println("userId =" + userId);
////        这里面的userPay是排名，为了图方便
//        Users userRank = userService.individualRank(userId);
//
//        System.out.println(" userRank.getUserPay() = " + userRank.getUserPay());
        return signTable.getUser_pay();
    }



    @RequestMapping(value = "/querySignPay", method = RequestMethod.POST)
    public Integer querySignPay(HttpServletRequest request) {
        System.out.println("UserController的querySignPay执行了");
        //1. get the only openid
        ServletContext servletContext = request.getServletContext();
        Users user = (Users) servletContext.getAttribute("user");
        String openid = user.getUserOpenid();

        //2. get the date and user_pay
        SignTable sign = signTableService.selectPayByOpenId(openid);
        int signPay = sign.getUser_pay();
        return signPay;
    }


    //    @Transactional
    @RequestMapping(value = "/doSign", method = RequestMethod.POST)
    public int doSign(HttpServletRequest request) {
        /**
         * 1. get the only openid
         * 2. get the date and user_pay
         * 3. calculate the user_pay (set user_pay + 1)
         * 4. save the new record into table for sign and user
         */
        System.out.println("SignTableController的doSign执行了");
        //1. get the only openid
        ServletContext servletContext = request.getServletContext();
        Users user = (Users) servletContext.getAttribute("user");
        String openid = user.getUserOpenid();

        //2. get the date and user_pay
        SignTable pay = signTableService.selectPayByOpenId(openid);
        Integer user_pay = pay.getUser_pay();
        System.out.println("pay = " + pay);
        System.out.println("=======================================");
        System.out.println("user_pay = " + user_pay);


        SignTable sign = new SignTable();
        sign.setUserOpenid(openid);
        sign.setYear(CalendarUtil.getYear());
        sign.setMonth(CalendarUtil.getMonth());
        sign.setDay(CalendarUtil.getDate());

        //判断是否签到过
        int updateUser = 0;
        System.out.println("要检查的sign是否有记录： " + sign);
        SignTable is_exist_sign = signTableService.selectBySignTable(sign);
        System.out.println("is_exist_sign = " + is_exist_sign);

        if (is_exist_sign == null) {
            System.out.println("数据库里没有可以签到");
            //3. calculate the user_pay (set user_pay + 1)
            int new_user_pay = user_pay + 1;
            sign.setUser_pay(new_user_pay);
            //4. save the new record into table for sign and user
            System.out.println("开始insert sign = " + sign);
            int insertSign = signTableService.insertSignTable(sign);
            //success insert into sign ✔
            if (insertSign != 0) {
                Users user1 = new Users();
                user1.setUserOpenid(openid);
                user1.setUserPay(new_user_pay);
                System.out.println("要更改积分的user1 = " + user1);
                updateUser = userService.updateByOpenid(user1);
                System.out.println("updateUser = " + updateUser);
            }
            return updateUser;
        }
        System.out.println("今天签到过啦！！！");
        //今天已经签过到了，啥也不做了
        return 0;

    }
}
