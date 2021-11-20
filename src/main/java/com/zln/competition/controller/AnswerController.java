package com.zln.competition.controller;

import com.zln.competition.bean.Answer;
import com.zln.competition.bean.User;
import com.zln.competition.service.AnswerService;
import com.zln.competition.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class AnswerController {
    @Autowired
    AnswerService answerService;
    @Autowired
    UserService userService;


    @RequestMapping(value = "/insertAnswer")
    public int insertAnswer(@RequestParam("helpInfo") String helpInfo,
                            @RequestParam("helpPay") String helpPay,
                            HttpServletRequest request) {
        System.out.println("AnswerController的insertAnswer执行了");
        int pay = 0;
        try{
            pay = Integer.parseInt(helpPay);
        }catch (Exception e){
            System.out.println("输入的积分只能是数字");
            return -1;
        }
        ServletContext servletContext = request.getServletContext();
//        String  openid = (String) servletContext.getAttribute("openid");
        User user = (User)  servletContext.getAttribute("user");
        Integer userId = user.getUserId();
        System.out.println("获取到的userId = " + userId);
        Answer answer = new Answer();
        answer.setUserId(userId);
        answer.setAnsPay(pay);
        answer.setAnsInformation(helpInfo);
        int i = answerService.insertAnswer(answer);
        return i;
    }


    @RequestMapping(value = "/selectAllAnswer",method = RequestMethod.POST)
    public List<Answer> selectAllAnswer() {

        List<Answer> answers = answerService.selectAllAnswer();
        System.out.println("answers : " + answers);
        return answers;
    }

    @RequestMapping(value = "/answerSelectByUserId",method = RequestMethod.POST)
    public List<Answer> AnswerSelectByUserId(HttpServletRequest request){
        System.out.println("AnswerController的selectByUserId执行了");
        ServletContext servletContext = request.getServletContext();
        User user1 = (User) servletContext.getAttribute("user");
        System.out.println("user1 : " + user1);
        String openid = user1.getUserOpenid();
        System.out.println("UserController获取到的openId-------------request.getAttribute(\"openid\") ：  " + openid);
        User user = userService.selectByOpenId(openid);
        int userId;
        if(user != null){
            userId = user.getUserId();
            System.out.println(":userId : " + userId ) ;
            List<Answer> answers = answerService.selectByUserId(userId);
            if (answers != null) {
                System.out.println("selectByUserId 的teams ： " + answers);
                return answers;
            }
        }
        return null;
    }
}