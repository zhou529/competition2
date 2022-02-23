package com.zln.competition.controller;

import com.zln.competition.bean.Answer;
import com.zln.competition.bean.Users;
import com.zln.competition.sensitive_word_filter.SensitivewordFilter;
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
import java.util.Set;

@RestController
public class AnswerController {
    @Autowired
    AnswerService answerService;
    @Autowired
    UserService userService;


    @RequestMapping(value = "/deleteAnswerByAnsId")
    public int deleteAnswerByAnsId(@RequestParam("ansId") String ansId) {
        System.out.println("AnswerController的deleteAnswerByAnsId执行了");
        int i = answerService.deleteAnswerByAnsId(Integer.valueOf(ansId));
        return i;
    }



    @RequestMapping(value = "/updateAnswerByAnsId")
    public int updateAnswerByAnsId(@RequestParam("ansInformation") String ansInformation,
                            @RequestParam("ansId") String ansId) {
        System.out.println("AnswerController的updateAnswerByAnsId执行了");

        //查找是否包含敏感词
        SensitivewordFilter sensitivewordFilter = new SensitivewordFilter();
        SensitivewordFilter filter = new SensitivewordFilter();
        System.out.println("敏感词的数量：" + sensitivewordFilter.sensitiveWordMap.size());
        System.out.println("待检测语句字数：" + ansInformation.length());
        long beginTime = System.currentTimeMillis();
        Set<String> set = filter.getSensitiveWord(ansInformation, 1);
        long endTime = System.currentTimeMillis();
        System.out.println("语句中包含敏感词的个数为：" + set.size() + "。包含：" + set);
        System.out.println("总共消耗时间为：" + (endTime - beginTime));
        //把敏感词汇替换成*
        String replaceHelpInfo = sensitivewordFilter.replaceSensitiveWord(ansInformation, 1, "*");
        System.out.println("替换之后的语句：" + replaceHelpInfo);
        Answer answer = new Answer();
        answer.setAnsId(Integer.valueOf(ansId));
        answer.setAnsInformation(replaceHelpInfo);
        int i = answerService.updateAnswerByAnsId(answer);
        return i;
    }



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
        //查找是否包含敏感词
        SensitivewordFilter sensitivewordFilter = new SensitivewordFilter();
        SensitivewordFilter filter = new SensitivewordFilter();
        System.out.println("敏感词的数量：" + sensitivewordFilter.sensitiveWordMap.size());
        System.out.println("待检测语句字数：" + helpInfo.length());
        long beginTime = System.currentTimeMillis();
        Set<String> set = filter.getSensitiveWord(helpInfo, 1);
        long endTime = System.currentTimeMillis();
        System.out.println("语句中包含敏感词的个数为：" + set.size() + "。包含：" + set);
        System.out.println("总共消耗时间为：" + (endTime - beginTime));
        //把敏感词汇替换成*
        String replaceHelpInfo = sensitivewordFilter.replaceSensitiveWord(helpInfo, 1, "*");
        System.out.println("替换之后的语句：" + replaceHelpInfo);
        ServletContext servletContext = request.getServletContext();
//        String  openid = (String) servletContext.getAttribute("openid");
        Users user = (Users)  servletContext.getAttribute("user");
        Integer userId = user.getUserId();
        System.out.println("获取到的userId = " + userId);
        Answer answer = new Answer();
        answer.setUserId(userId);
        answer.setAnsPay(pay);
        answer.setAnsInformation(replaceHelpInfo);
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
        Users user1 = (Users) servletContext.getAttribute("user");
        System.out.println("user1 : " + user1);
        String openid = user1.getUserOpenid();
        System.out.println("UserController获取到的openId-------------request.getAttribute(\"openid\") ：  " + openid);
        Users user = userService.selectByOpenId(openid);
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
