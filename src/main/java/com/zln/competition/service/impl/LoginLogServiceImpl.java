package com.zln.competition.service.impl;

import com.zln.competition.bean.ComAdmin;
import com.zln.competition.bean.LoginLog;
import com.zln.competition.mapper.LoginLogMapper;
import com.zln.competition.service.LoginLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class LoginLogServiceImpl implements LoginLogService {
    @Resource
    private LoginLogMapper loginLogMapper;

    /**
     * 查询
     * @return
     */
    @Override
    public List<LoginLog> selectAllLoginLog(){
        List<LoginLog> loginLogs = loginLogMapper.selectAllLoginLog();
        System.out.println("loginLogs : " + loginLogs);
        return loginLogs;
    }

    /**
     * 获取账号  时间  ip
     * @param request
     * @param com
     * @return
     */
    @Override
    public LoginLog UserLogin(HttpServletRequest request, ComAdmin com) {


//        System.out.println("LoginLog的LoginLog ： "  + loginLog);
        LoginLog loginLog = new LoginLog();
        System.out.println("LoginLog的LoginLogMapper ： "  + loginLogMapper);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(new java.util.Date());
        //获取ip地址
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        loginLog.setUsername(com.getComName());
        loginLog.setLoginTime(time);
        loginLog.setLoginIp(ip);
        int i = loginLogMapper.insertLoginLog(loginLog);
        System.out.println("i = " + i);
        if(i != 0){
            System.out.println("loginLog : " + loginLog);
            return loginLog;
        }
        return loginLog;
    }


    /**
     * 获取发布问题的时间
     * @param ansId
     * @return
     */
    public String getAsTime(Integer ansId){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(new java.util.Date());
        System.out.println("发布问题的时间time : " + time);
        return time;
    }

}
