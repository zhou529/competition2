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

//    @Transactional
    @RequestMapping(value = "/doSign", method = RequestMethod.POST)
    public int doSign(HttpServletRequest request) {
        System.out.println("SignTableController的doSign执行了");
        ServletContext servletContext = request.getServletContext();
//        String  openid = (String) servletContext.getAttribute("openid");
        Users user = (Users) servletContext.getAttribute("user");
        System.out.println("user : " + user);
        String openid = user.getUserOpenid();
        System.out.println("SignTableController的doSign获取到的openid ：" + openid);
//        往签到表中存数据
        SignTable sign = new SignTable();
        sign.setUserOpenid(openid);
        sign.setYear(CalendarUtil.getYear());
        sign.setMonth(CalendarUtil.getMonth());
        sign.setDay(CalendarUtil.getDate());
        System.out.println("sign = " + sign);

        int updateUser = 0;
        //判断是否签到过
        SignTable signTable = signTableService.selectBySignTable(sign);
        System.out.println("signTable = " + signTable);
        if (signTable == null) {
            System.out.println("数据库里没有可以签到");
            //插入数据
            int insertSign = signTableService.insertSignTable(sign);
            System.out.println("insertSign = " + insertSign);
            if (insertSign != 0) {
                Users user1 = new Users();
                user1.setUserOpenid(openid);

                user1.setUserPay(user.getUserPay() + 1);
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
