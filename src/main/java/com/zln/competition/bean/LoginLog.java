package com.zln.competition.bean;

public class LoginLog {
    private Integer logId;
    private String username;
    private String loginTime;
    private String loginIp;

    @Override
    public String toString() {
        return "LoginLog{" +
                "logId=" + logId +
                ", username='" + username + '\'' +
                ", loginTime='" + loginTime + '\'' +
                ", loginIp='" + loginIp + '\'' +
                '}';
    }

    public LoginLog(Integer logId, String username, String loginTime, String loginIp) {
        this.logId = logId;
        this.username = username;
        this.loginTime = loginTime;
        this.loginIp = loginIp;
    }

    public LoginLog() {
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

}
