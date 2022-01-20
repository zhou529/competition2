package com.zln.competition.controller;

import com.zln.competition.bean.Community;
import com.zln.competition.bean.UserInfo;
import com.zln.competition.bean.Users;
import com.zln.competition.service.UserInfoService;
import com.zln.competition.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    UserService userService;



    @RequestMapping(value = "/updateUserInfo")
    public int updateUserInfo(@RequestParam("phoneNumber") String phoneNumber,
                              @RequestParam("userName") String userName,
                              @RequestParam("studentID") String studentID,
                              @RequestParam("IDNumber") String IDNumber,
                              @RequestParam("setMajor") String setMajor,
                              @RequestParam("setSchool") String setSchool,
                              HttpServletRequest request) {
        System.out.println("UserInfoController的insertUSerInfo执行啦");
        ServletContext servletContext = request.getServletContext();
        Users user = (Users) servletContext.getAttribute("user");
        String userOpenid = user.getUserOpenid();

        System.out.println("setSchool = " + setSchool);
        if(setSchool.equals("") || setSchool == null || setSchool.equals("undefined")){
            setSchool = "哈尔滨学院";
        }
        if(setMajor.equals("") || setMajor == null || setMajor.equals("undefined")){
            setMajor = "计算机";
        }
        UserInfo record = new UserInfo();
        record.setUsername(userName);
        record.setStu_id(studentID);
        record.setId_cart(IDNumber);
        record.setUserPhone(phoneNumber);
        record.setUserMajor(setMajor);
        record.setUserSchool(setSchool);
        record.setUserOpenid(userOpenid);

        int insert_is_true = userInfoService.updateUserInfoByUserId(record);

        return insert_is_true;
    }



/*
    @RequestMapping(value = "/updateUserInfoByUserId", method = RequestMethod.POST)
    public int updateUserInfoByUserId(@RequestParam("user_phone") String user_phone,
                                      @RequestParam("user_major") String user_major,
                                      @RequestParam("user_school") String user_school,
                                      HttpServletRequest request) {
        System.out.println("UserInfoController的updateUserInfoByUserId执行啦");
        HttpSession session = request.getSession();
        UserInfo userInfoBySession = (UserInfo) session.getAttribute("userInfo");
        Integer userId = userInfoBySession.getUserId();

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setUserSchool(user_school);
        userInfo.setUserPhone(user_phone);
        userInfo.setUserMajor(user_major);

        int i = userInfoService.updateUserInfoByUserId(userInfo);
        return i;
    }
*/

    @RequestMapping(value = "/selectByOpenId", method = RequestMethod.POST)
    public UserInfo selectByOpenId(HttpServletRequest request) {
        System.out.println("UserInfoController的selectByOpenId执行啦");
        ServletContext servletContext = request.getServletContext();
        Users user = (Users) servletContext.getAttribute("user");
        System.out.println("user = " + user);
        String userOpenid = user.getUserOpenid();
        UserInfo userInfo = userInfoService.selectByOpenId(userOpenid);
        return userInfo;
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    public UserInfo getUserInfo(HttpServletRequest request) {
        System.out.println("UserInfoController的getUserInfo执行啦");
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
//        ComAdmin admin = session.getAttribute("admin");
        System.out.println("UserInfo : " + userInfo.toString());
        return userInfo;
    }

    @RequestMapping(value = "/putUserInfo", method = RequestMethod.POST)
    public void putUserInfo(@RequestParam("user_id") String user_id,
                                      @RequestParam("user_phone") String user_phone,
                                      @RequestParam("user_school") String user_school,
                                      @RequestParam("user_major") String user_major,
                                      HttpServletRequest request) {
        System.out.println("UserInfoController的putUserInfo执行啦");
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(Integer.valueOf(user_id));
        userInfo.setUserMajor(user_major);
        userInfo.setUserPhone(user_phone);
        userInfo.setUserSchool(user_school);
        //获取application对象
        HttpSession session = request.getSession();
        session.setAttribute("userInfo", userInfo);
//        return community;
    }

    @RequestMapping(value = "/selectAllUserInfo", method = RequestMethod.POST)
    public List<UserInfo> selectAllUserInfo() {
        List<UserInfo> userInfos = userInfoService.selectAllUserInfo();
        System.out.println("userInfos : " + userInfos);
        return userInfos;
    }

    @RequestMapping(value = "/deleteByUserIdFromUserAndInfo", method = RequestMethod.POST)
    public int deleteByUserIdFromUserAndInfo(@RequestParam("userId") Integer userId) {
        //        int i1 = 0;
        System.out.println("UserInfoController的deleteByUserIdFromUserAndInfo方法执行啦");
        System.out.println("前台传过来的userId ： " + userId);
        int res1 = userInfoService.deleteByUserId(userId);
        int res2 = userService.deleteByUserIdFromUser(userId);
        System.out.println("ComAdminController的deleteByPrimaryKey方法的返回值res1 = " + res1);
        System.out.println("ComAdminController的deleteByPrimaryKey方法的返回值res2 = " + res2);
        if (res1 != 0 && res2 != 0) {
            return 1;
        }
        return 0;
    }

}
