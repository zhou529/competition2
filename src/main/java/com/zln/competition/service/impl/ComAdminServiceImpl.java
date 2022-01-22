package com.zln.competition.service.impl;

import com.zln.competition.bean.ComAdmin;
import com.zln.competition.bean.Community;
import com.zln.competition.mapper.ComAdminMapper;
import com.zln.competition.service.ComAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ComAdminServiceImpl implements ComAdminService {

    @Resource
    private ComAdminMapper comAdminMapper;


    @Override
    public int updateByComId(Integer comId){
        int i = comAdminMapper.updateByComId(comId);
        return i;
    }

    @Override
    public int updateByComAdmin(ComAdmin comAdmin){
        int i = comAdminMapper.updateByComAdmin(comAdmin);
        return i;
    }

    @Override
    public ComAdmin selectByComName(String comName){
        ComAdmin comAdmin = comAdminMapper.selectByComName(comName);
        return comAdmin;
    }

    @Override
    public int updateByComUsername(ComAdmin comAdmin){
        int i = comAdminMapper.updateByComUsername(comAdmin);
        return i;
    }


    @Override
    public ComAdmin selectByComAdmin(String comUsername){
        ComAdmin comAdmin = comAdminMapper.selectByComAdmin(comUsername);
        return comAdmin;
    }

    //    @Transactional
    @Override
    public int insertComAdmin(ComAdmin comAdmin){
        int i = comAdminMapper.insertComAdmin(comAdmin);
        System.out.println("ComAdminServiceImpl的insertComAdmin方法的返回值i = " + i);
        return i;
    }

    @Override
    public List<ComAdmin> selectComAdminByLikeUsername(String comUsername){
        return comAdminMapper.selectComAdminByLikeUsername(comUsername);
    }


    @Override
    public int updateComDelOff(String comUsername){
        int i = comAdminMapper.updateComDelOff(comUsername);
        System.out.println("ComAdminServiceImpl的updateComDel方法的返回值i = " + i);
        return i;
    }

    @Override
    public int updateComDelOn(String comUsername) {
        int i = comAdminMapper.updateComDelOn(comUsername);
        System.out.println("ComAdminServiceImpl的updateComDel方法的返回值i = " + i);
        return i;
    }


    @Override
    public int deleteByPrimaryKey(String comUsername){
        int i = comAdminMapper.deleteByPrimaryKey(comUsername);
        System.out.println("ComAdminServiceImpl的deleteByPrimaryKey的返回值i = " + i);
        return i;
    }


    @Override
    public ComAdmin login(String comUsername, String comUserpwd) {


//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ClassPath:applicationContext.xml");
//        ComAdminMapper comAdminMapper = applicationContext.getBean(ComAdminMapper.class);
        System.out.println("comAdminMapper ： " + comAdminMapper);
        return comAdminMapper.selectUsernameAndPsw(comUsername, comUserpwd);

    }

    @Override
    public List<ComAdmin> selectAllComAdmin(){
        System.out.println("selectAllComAdmin方法的comAdminMapper ： " + comAdminMapper);
        List<ComAdmin> comAdmins = comAdminMapper.selectAllComAdmin();
        System.out.println("comAdminService 查询所有的 selectAllComAdmin方法 ： " + comAdmins);
        return comAdmins;
    }

}
