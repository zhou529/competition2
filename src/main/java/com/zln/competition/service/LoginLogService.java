package com.zln.competition.service;

import com.zln.competition.bean.ComAdmin;
import com.zln.competition.bean.LoginLog;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface LoginLogService {
    public LoginLog UserLogin(HttpServletRequest request, ComAdmin com);

    List<LoginLog> selectAllLoginLog();

    public String getAsTime(Integer ansId) ;

    List<LoginLog> selectAllLoginLogByAdmin(String username);
}
