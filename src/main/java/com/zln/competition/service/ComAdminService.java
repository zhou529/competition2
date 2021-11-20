package com.zln.competition.service;

import com.zln.competition.bean.ComAdmin;
import com.zln.competition.bean.Community;

import java.util.ArrayList;
import java.util.List;

public interface ComAdminService {
    /**
     * 登陆操作
     */
    public ComAdmin login(String comUsername, String comUserpwd);

    /**
     * 查询所有comadmin
     * @return
     */
    public List<ComAdmin> selectAllComAdmin();

    /**
     * 根据主键删除数据
     * @param comUsername
     * @return
     */
    public int deleteByPrimaryKey(String comUsername);

    /**
     * 修改管理员状态
     * @param comUsername
     * @return
     */
    public int updateComDelOff(String comUsername);

    public int updateByComAdmin(ComAdmin comAdmin);


    /**
     * 添加管理员
     * @param comAdmin
     * @return
     */
    public int insertComAdmin(ComAdmin comAdmin);

    //根据comUsername查询对象
    public ComAdmin selectByComAdmin(String comUsername);

    //修改管理员信息
    public int updateByComUsername(ComAdmin comAdmin);

    //修改社团信息的时候应修改对应的comName
    public int updateByComId(Integer comId);

    public ComAdmin selectByComName(String comName);

}
