package com.zln.competition.mapper;

import com.zln.competition.bean.ComAdmin;
import com.zln.competition.bean.Community;

import java.util.ArrayList;
import java.util.List;

public interface ComAdminMapper {
    /**
     * 登陆操作
     */
    public ComAdmin selectUsernameAndPsw(String comUsername, String comUserpwd);

    //查询多行数据返回一个对象的集合
    public List<ComAdmin> selectAllComAdmin();

    //根据主键删除数据
    public int deleteByPrimaryKey(String comUsername);

    //修改管理员状态
    public int updateComDelOff(String comUsername);
    public int updateComDelOn(String comUsername);

    //添加管理员
    public int insertComAdmin(ComAdmin comAdmin);

    public int updateByComAdmin(ComAdmin comAdmin);

    //根据comUsername查询对象
    public ComAdmin selectByComAdmin(String comUsername);

    public List<ComAdmin> selectComAdminByLikeUsername(String comUsername);

    //编辑管理员信息
    public int updateByComUsername(ComAdmin comAdmin);

    //修改社团信息的时候应修改对应的comName
    public int updateByComId(Integer comId);

    //判断社团名是否存在
    public ComAdmin selectByComName(String comName);


}