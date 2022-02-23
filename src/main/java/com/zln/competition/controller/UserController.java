package com.zln.competition.controller;

import com.alibaba.fastjson.JSON;
import com.zln.competition.bean.Users;
import com.zln.competition.bean.UserInfo;
import com.zln.competition.service.UserInfoService;
import com.zln.competition.service.UserService;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@RestController
@ResponseBody
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserInfoService userInfoService;

    @RequestMapping(value = "/individual_rank", method = RequestMethod.POST)
    public Integer individual_rank(HttpServletRequest request) {
        System.out.println("UserController的individual_rank执行了");
        ServletContext servletContext = request.getServletContext();
        Users user = (Users) servletContext.getAttribute("user");
        System.out.println("user : " + user);
        int userId = user.getUserId();
        System.out.println("userId =" + userId);
//        这里面的userPay是排名，为了图方便
        Users userRank = userService.individualRank(userId);

        System.out.println(" userRank.getUserPay() = " + userRank.getUserPay());
        return userRank.getUserPay();
    }

/*    @RequestMapping(value = "/querySignPay", method = RequestMethod.POST)
    public Integer querySignPay(HttpServletRequest request) {
        System.out.println("UserController的querySignPay执行了");
        ServletContext servletContext = request.getServletContext();
        Users user = (Users) servletContext.getAttribute("user");
        System.out.println("user : " + user);
        int signPay = user.getUserPay();
        System.out.println("signPay =" + signPay);
        return signPay;
    }*/

    @RequestMapping(value = "/queryNickNameAndAvatarUrl", method = RequestMethod.POST)
    public Users queryNickNameAndAvatarUrl(HttpServletRequest request) {
        ServletContext servletContext = request.getServletContext();
        Users user = (Users) servletContext.getAttribute("user");
        System.out.println("昵称头像的user = " + user);
        String userOpenid = user.getUserOpenid();
        return userService.selectByOpenId(userOpenid);
    }




    @RequestMapping("/updateNickNameAndAvatarUrl")
    public int updateNickNameAndAvatarUrl(@RequestParam(name = "nickName") String nickName,
                                          @RequestParam(name = "avatarUrl") String avatarUrl,
                                          HttpServletRequest request) {
        ServletContext servletContext = request.getServletContext();
        Users user = (Users) servletContext.getAttribute("user");
        System.out.println("昵称头像的user = " + user);
        String userOpenid = user.getUserOpenid();
        System.out.println("wexin's nickName = " + nickName);
        System.out.println("wexin's avatarUrl = " + avatarUrl);
        return userService .updateNickNameAndAvatarUrl(nickName,avatarUrl, userOpenid);
    }

    @RequestMapping("/insertUserByOpenId")
    public String getUserInfo(@RequestParam(name = "code") String code, HttpServletRequest request) throws Exception {
//        User user = new User();
//        ServletContext
        ServletContext servletContext = request.getServletContext();
        System.out.println("code :" + code);
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        url += "?appid=wxd48a825d6946f5de";//自己的appid
        url += "&secret=a112ea268d75588c0af883dcd773c30a";//自己的appSecret
        url += "&js_code=" + code;
        url += "&grant_type=authorization_code";
        url += "&connect_redirect=1";
        String res = null;
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // DefaultHttpClient();
        HttpGet httpget = new HttpGet(url);    //GET方式
        CloseableHttpResponse response = null;
        // 配置信息
        RequestConfig requestConfig = RequestConfig.custom()          // 设置连接超时时间(单位毫秒)
                .setConnectTimeout(5000)                    // 设置请求超时时间(单位毫秒)
                .setConnectionRequestTimeout(5000)             // socket读写超时时间(单位毫秒)
                .setSocketTimeout(5000)                    // 设置是否允许重定向(默认为true)
                .setRedirectsEnabled(false).build();           // 将上面的配置信息 运用到这个Get请求里
        httpget.setConfig(requestConfig);                         // 由客户端执行(发送)Get请求
        response = httpClient.execute(httpget);                   // 从响应模型中获取响应实体
        HttpEntity responseEntity = response.getEntity();
        System.out.println("响应状态为:" + response.getStatusLine());
        if (responseEntity != null) {
            res = EntityUtils.toString(responseEntity);
            System.out.println("响应内容长度为:" + responseEntity.getContentLength());
            System.out.println("响应内容为:" + res);
        }
        // 释放资源
        if (httpClient != null) {
            httpClient.close();
        }
        if (response != null) {
            response.close();
        }
        JSONObject jo = JSON.parseObject(res);
//        JSONObject jo = JSONObject.numberToString()
        String openid = jo.getString("openid");
        Users user = new Users(null, openid, null);
//        user.setUserOpenid(openid);
        System.out.println("user : " + user);
        System.out.println("openid : " + openid);
        //查询数据库中是否有这个openid
        Users isExistUser = userService.selectAllUserByOpenid(openid);
        System.out.println("isExistUser = " + isExistUser);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserOpenid(openid);
        if (isExistUser == null) {
            int userInsert = userService.insertUser(user);
            int userInfoInsert = userInfoService.insertUSerInfo(userInfo);
            if(userInsert != 0 && userInfoInsert!=0){
                System.out.println("UserController的insertUser方法的返回值userInsert : " + userInsert);
                System.out.println("UserController的insertUser方法的返回值userInfoInsert : " + userInfoInsert);
                System.out.println("servletContext.setAttribute( user = " + user);
                servletContext.setAttribute("user",user);
                servletContext.setAttribute("openid",openid);
            }
        } else {
            openid = isExistUser.getUserOpenid();
            System.out.println("isExistUser + " + isExistUser);
            servletContext.setAttribute("user",isExistUser);
        }

        return openid;
    }


}
