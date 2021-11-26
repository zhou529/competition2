package com.zln.competition.controller;

import com.zln.competition.bean.Ans_user;
import com.zln.competition.bean.Users;
import com.zln.competition.service.Ans_userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class Ans_userController {
    @Autowired
    Ans_userService ans_userService;

    @RequestMapping(value = "/insertAnsInformation",method = RequestMethod.GET)
    public int insertAnsInformation(@RequestParam("ansInfo") String ansInfo,
                                    @RequestParam("ansId") String ansId,
                                    HttpServletRequest request) {
        System.out.println("Ans_userController的insertAnsInformation方法执行啦");
        System.out.println("前台传过来的ansInfo = " + ansInfo);
        System.out.println("前台传过来的ansId = " + ansId);
        ServletContext servletContext = request.getServletContext();
//        String  openid = (String) servletContext.getAttribute("openid");
        Users user = (Users)  servletContext.getAttribute("user");
        Integer responseUserId = user.getUserId();

        Ans_user ans_user = new Ans_user();
        ans_user.setAnsId(Integer.valueOf(ansId));
        ans_user.setUserId(responseUserId);
        ans_user.setReplyInformation(ansInfo);
        int i = ans_userService.insertAnsInformation(ans_user);

        return i;
    }

    @RequestMapping(value = "/selectByAnsId",method = RequestMethod.GET)
    public List<Ans_user> selectByAnsId(@RequestParam("ansId") String ansId) {
        List<Ans_user> ans_users = ans_userService.selectByAnsId(Integer.valueOf(ansId));
        System.out.println("selectByAnsId :" + ans_users);
        return ans_users;
    }
}
