package com.zln.competition.controller;

import com.zln.competition.bean.ComAdmin;
import com.zln.competition.bean.Community;
import com.zln.competition.bean.LoginLog;
import com.zln.competition.service.ComAdminService;
import com.zln.competition.service.CommunityService;
import com.zln.competition.service.LoginLogService;
import com.zln.competition.service.impl.LoginLogServiceImpl;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@RestController
@ResponseBody
public class ComAdminController {
    @Autowired
    ComAdminService comAdminService;
    @Autowired
    LoginLogService loginLogService;
    @Autowired
    CommunityService communityService;


    @RequestMapping(value = "/selectComAdminByLikeUsername",method = RequestMethod.POST)
    public List<ComAdmin> selectComAdminByLikeUsername(@RequestParam("comUsername") String comUsername) throws UnsupportedEncodingException {
        System.out.println("ComAdminController的 selectComAdminByLikeUsername方法执行啦");
        String decode = URLDecoder.decode("comUsername", "utf-8");
        decode = "%" + decode + "%";
        System.out.println("decode" + decode);
        List<ComAdmin> comAdmin = comAdminService.selectComAdminByLikeUsername(decode);
        return comAdmin;
    }



    @RequestMapping(value = "/selectByComName",method = RequestMethod.POST)
    public boolean selectByComName(@RequestParam("comName") String comName) {
        System.out.println("ComAdminController的 selectByComName方法执行啦");
        ComAdmin comAdmin = comAdminService.selectByComAdmin(comName);
        if(comAdmin == null){
            return false;
        }
        return true;
    }


    /*public int insertComAdmin(@RequestParam("comUsername") String comUsername,
                              @RequestParam("comName") String comName,
                              @RequestParam("comUserpwd") String comUserpwd){
        ComAdmin comAdmin = new ComAdmin();
        comAdmin.setComUsername(comUsername);
        comAdmin.set
    }
*/

    /**
     * 给修改页面提供对象属性值的方法
     * @param comUsername
     * @param request
     */
    @RequestMapping(value = "/getAdminPutSession",method = RequestMethod.POST)
    public void getAdmin(@RequestParam("comUsername") String comUsername,HttpServletRequest request){
        ComAdmin comAdmin = comAdminService.selectByComAdmin(comUsername);
        //获取application对象
        ServletContext application = request.getServletContext();
        application.setAttribute("admin",comAdmin);
        //前台获取的对象放入session中
        HttpSession session = request.getSession();
        session.setAttribute("admin",comAdmin);
        System.out.println("ComAdminController的getAdmin方法通过用户名获取的comAdmin对象是 ： " + comAdmin);
    }

    /**
     * 修改页面的属性值
     * @param request
     * @return
     */
    @RequestMapping(value = "/getAdminBySession",method = RequestMethod.POST)
    public ComAdmin getAdminBySession(HttpServletRequest request){
        System.out.println("ComAdminController的getAdminBySession方法执行啦！");
        HttpSession session = request.getSession();
        ComAdmin admin = (ComAdmin) session.getAttribute("admin");
//        ComAdmin admin = session.getAttribute("admin");
        System.out.println("admin : " + admin);
        return admin;
    }
    /**
     * 修改管理员信息
//     * @param  comUsername
     * @return
     */
    @RequestMapping(value = "/updateByComUsername",method = RequestMethod.POST)
    public int updateByComUsername(HttpServletRequest request,
                                   @RequestParam("comDel") String comDel,
                                   @RequestParam("comUserpwd") String comUserpwd){
        System.out.println("ComAdminController的updateByComUsername方法执行了");
        HttpSession session = request.getSession();
        ComAdmin admin = (ComAdmin) session.getAttribute("admin");
        Integer comId = admin.getComId();

        ComAdmin comAdmin = new ComAdmin();
        comAdmin.setComId(comId);
        comAdmin.setComDel(Integer.valueOf(comDel));
        comAdmin.setComUserpwd(comUserpwd);

        int i = comAdminService.updateByComUsername(comAdmin);
        System.out.println("ComAdminController的updateByComUsername方法的返回值i ： " + i);
        return i;
    }

        /**
         * 登录功能
         * @param username
         * @param password
         * @param request
         * @return
         */
//    @ResponseBody
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public ComAdmin login(@RequestParam("username") String username,
                          @RequestParam("password") String password, HttpServletRequest request) {
        System.out.println("ComAdminController执行了");
        System.out.println("username : " + username);
        System.out.println("password : " + password);

        HttpSession session = request.getSession();

        ComAdmin login = comAdminService.login(username, password);

        //将前台数据给对象
     /*   ComAdmin comAdmin = new ComAdmin();
        comAdmin.setComUsername(username);
        comAdmin.setComUserpwd(password);*/

//        System.out.println("comAdmin" + comAdmin);
        System.out.println("login" + login);

        if (login != null && login.getComDel()==0) {
            session.setAttribute("loginAdmin", login);
//            添加登录日志
            loginLogService.UserLogin(request, login);
            System.out.println("添加登录日志成功");
            return login;
        }
        return null;
    }

    /**
     * 确定权限
     * @param request
     * @return
     */
//    @ResponseBody
    @RequestMapping(value = "/loginOp.do", method = RequestMethod.POST)
    public ComAdmin loginOp(HttpServletRequest request) {
        System.out.println("确定权限的loginOp方法执行啦");
        HttpSession session = request.getSession();
        ComAdmin admin = (ComAdmin) session.getAttribute("loginAdmin");
        System.out.println("确定权限的admin : " + admin);
        return admin;
    }

    /**
     * 退出功能
     * @param request
     * @return
     */
    @RequestMapping(value = "/isOut.do", method = RequestMethod.POST)
    public boolean isOut(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("loginAdmin");
        return true;
    }

    /**
     * 查询功能
     * @return
     */
    @RequestMapping(value = "/selectAll",method = RequestMethod.POST)
    public List<ComAdmin> selectAllComAdmin(HttpServletRequest request){
        System.out.println("ComAdminController的selectAllComAdmin方法执行啦");
        System.out.println("request : " + request);
        List<ComAdmin> comAdmins = comAdminService.selectAllComAdmin();
        System.out.println("调用service层查询到的comAdmins是 : " + comAdmins);
        HttpSession session = request.getSession();
        session.setAttribute("comAdmins",comAdmins);
        return comAdmins;
    }

    /**
     * 删除功能
     * @param comUsername
     * @return
     */
    @RequestMapping(value = "/deleteByPrimaryKey.do",method = RequestMethod.POST)
    public int deleteByPrimaryKey(@RequestParam("comUsername") String comUsername){
        System.out.println("ComAdminController的deleteByPrimaryKey方法执行啦");
        System.out.println("前台传过来的comUsername ： " + comUsername);
        int i = comAdminService.deleteByPrimaryKey(comUsername);
        System.out.println("ComAdminController的deleteByPrimaryKey方法的返回值i = " + i);
        return i;
    }

    /**
     * 判断用户名是否存在
      * @param comUsername
     * @return
     */
    @RequestMapping(value = "/isExistComAdmin",method = RequestMethod.POST)
    public boolean isExistComAdmin(@RequestParam("comUsername") String comUsername){
        System.out.println("判断管理员的用户名是否存在的方法执行啦");
        ComAdmin comAdmin = comAdminService.selectByComAdmin(comUsername);
        System.out.println("comAdmin = "+ comAdmin);
        //1为不可用，0为可用
        if(comAdmin == null){
            return true;
        }
        return false;
    }



    /**
     * 更改账号状态，0：正常使用，1：不能使用
     * @param comUsername
     * @return
     */
    @RequestMapping(value = "/updateComDelOff.do",method = RequestMethod.POST)
    public int updateComDelOff(@RequestParam("comUsername") String comUsername){
        System.out.println("ComAdminController的updateComDelOn方法执行啦");
        System.out.println("前台传过来的comUsername ： " + comUsername);
        int i = comAdminService.updateComDelOff(comUsername);
        System.out.println("ComAdminController的updateComDel方法的返回值i = " + i);
        return i;
    }

    /**
     * 更改账号状态，0：正常使用，1：不能使用
     * @param comUsername
     * @return
     */
    @RequestMapping(value = "/updateComDelOn.do",method = RequestMethod.POST)
    public int updateComDelOn(@RequestParam("comUsername") String comUsername){
        System.out.println("ComAdminController的updateComDelOn方法执行啦");
        System.out.println("前台传过来的comUsername ： " + comUsername);
        int i = comAdminService.updateComDelOn(comUsername);
        System.out.println("ComAdminController的updateComDel方法的返回值i = " + i);
        return i;
    }

    /**
     * 超级管理员添加管理员 and 注册
     * @param comUsername
     * @param comName
     * @param comUserpwd
     * @return
     */
   /* @Transactional
    @RequestMapping(value = "/insertComAdminAndCommunity.do",method = RequestMethod.POST)
    public int insertComAdminAndCommunity(@RequestParam("comUsername") String comUsername,
                                          @RequestParam("comName") String comName,
                                          @RequestParam("comUserpwd") String comUserpwd){
        System.out.println("ComAdminController的insertComAdminAndCommunity方法执行啦");
        System.out.println("前台传过来的comUsername ： " + comUsername);
        System.out.println("前台传过来的comName ： " + comName);
        System.out.println("前台传过来的comUserpwd ： " + comUserpwd);

        //判断comName是否存在
       if (communityService.selectCommunityByComName(comName) ==null ){
           Community community = new Community();
           ComAdmin comAdmin = new ComAdmin();
           community.setComName(comName);

//           int insertComAdmin = comAdminService.insertComAdmin(comAdmin);
           int insertCommunity = communityService.insertCommunity(community);
           System.out.println("ComAdminController的insertComAdminAndCommunity方法的返回值insertCommunity = " + insertCommunity);
           if(insertCommunity!=0){
               //获取com_id,com_admin引用了community的主键com_id
               Community community1 = communityService.selectCommunityByComName(comName);
               Integer comId = community1.getComId();
//            com_admin引入外键
               System.out.println("community1.getComId() : " + comId);
               comAdmin.setComId(comId);
               comAdmin.setComUsername(comUsername);
               comAdmin.setComUserpwd(comUserpwd);
               comAdmin.setComName(comName);
               System.out.println("要插入到com_admin表中的数据是 " + comName);
               int insertComAdmin = comAdminService.insertComAdmin(comAdmin);
               System.out.println("ComAdminController的insertComAdminAndCommunity方法的返回值insertComAdmin = " + insertComAdmin);
               return insertComAdmin;
           }
       }

        return 0;
    }*/
    @Transactional
    @RequestMapping(value = "/insertComAdminAndCommunity.do",method = RequestMethod.POST)
    public int insertComAdminAndCommunity(@RequestParam("comUsername") String comUsername,
                                          @RequestParam("comName") String comName,
                                          @RequestParam("comUserpwd") String comUserpwd){
        System.out.println("ComAdminController的insertComAdminAndCommunity方法执行啦");
        System.out.println("前台传过来的comUsername ： " + comUsername);
        System.out.println("前台传过来的comName ： " + comName);
        System.out.println("前台传过来的comUserpwd ： " + comUserpwd);

        //判断comName是否存在
        //社团不存在
       if (communityService.selectCommunityByComName(comName) ==null ){
           Community community = new Community();
           ComAdmin comAdmin = new ComAdmin();
           community.setComName(comName);

//           int insertComAdmin = comAdminService.insertComAdmin(comAdmin);
           int insertCommunity = communityService.insertCommunity(community);
           System.out.println("ComAdminController的insertComAdminAndCommunity方法的返回值insertCommunity = " + insertCommunity);
           if(insertCommunity!=0){
               //获取com_id,com_admin引用了community的主键com_id
               Community community1 = communityService.selectCommunityByComName(comName);
               Integer comId = community1.getComId();
//            com_admin引入外键
               System.out.println("community1.getComId() : " + comId);
               comAdmin.setComId(comId);
               comAdmin.setComUsername(comUsername);
               comAdmin.setComUserpwd(comUserpwd);
               comAdmin.setComName(comName);
               System.out.println("要插入到com_admin表中的数据是 " + comName);
               int insertComAdmin = comAdminService.insertComAdmin(comAdmin);
               System.out.println("ComAdminController的insertComAdminAndCommunity方法的返回值insertComAdmin = " + insertComAdmin);
               return insertComAdmin;
           }
       }else{//社团存在
           ComAdmin comAdmin = comAdminService.selectByComName(comName);
           if(comAdmin == null){
               return 1;
           }
       }

        return 0;
    }
}
