package com.zln.competition.controller;

import com.zln.competition.bean.ComAdmin;
import com.zln.competition.bean.LoginLog;
import com.zln.competition.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class LoginLogController {
    @Autowired
    LoginLogService loginLogService;

    @RequestMapping(value = "/selectAllLoginLog",method = RequestMethod.POST)
    public List<LoginLog> selectAllLoginLog(){
        System.out.println("LoginLogController的selectAllLoginLog方法执行了");
        List<LoginLog> loginLogs = loginLogService.selectAllLoginLog();
        System.out.println("LoginLogController的selectAllLoginLog方法的返回值loginLogs ： " + loginLogs);
        return loginLogs;
    }

    @RequestMapping(value = "/selectAllLoginLogByAdmin",method = RequestMethod.POST)
    public List<LoginLog> selectAllLoginLogByAdmin(HttpServletRequest request){
        System.out.println("LoginLogController的selectAllLoginLogByAdmin方法执行了");
        HttpSession session = request.getSession();

        ComAdmin loginAdmin = (ComAdmin) session.getAttribute("loginAdmin");
        System.out.println("loginAdmin = " + loginAdmin);
        String username = loginAdmin.getComUsername();
        List<LoginLog> loginLogs = loginLogService.selectAllLoginLogByAdmin(username);
        System.out.println("LoginLogController的selectAllLoginLogByAdmin方法的返回值loginLogs ： " + loginLogs);
        return loginLogs;
    }

}
