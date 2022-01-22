package com.zln.competition.mapper;

import com.zln.competition.bean.LoginLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface LoginLogMapper {
    int insertLoginLog(LoginLog loginLog);

    List<LoginLog> selectAllLoginLog();

    List<LoginLog> selectAllLoginLogByAdmin(String username);
}
