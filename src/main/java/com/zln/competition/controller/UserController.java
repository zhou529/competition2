package com.zln.competition.controller;

import com.alibaba.fastjson.JSON;
import com.zln.competition.bean.User;
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

    @RequestMapping("/insertUserByOpenId")
    public String getUserInfo(@RequestParam(name = "code") String code, HttpServletRequest request) throws Exception {
        User user = new User();
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
        user.setUserOpenid(openid);
        System.out.println("openid : " + openid);
        //查询数据库中是否有这个openid
        User user2 = userService.selectAllUserByOpenid(openid);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserOpenid(openid);
        if (user2 == null) {
            int userInsert = userService.insertUser(user);
            int userInfoInsert = userInfoService.insertUSerInfo(userInfo);
            if(userInsert != 0 && userInfoInsert!=0){
                System.out.println("UserController的insertUser方法的返回值userInsert : " + userInsert);
                System.out.println("UserController的insertUser方法的返回值userInfoInsert : " + userInfoInsert);
                servletContext.setAttribute("user",user);
                servletContext.setAttribute("openid",openid);
            }
        } else {
            openid = user2.getUserOpenid();
            servletContext.setAttribute("user",user2);
        }

        return openid;
    }


}