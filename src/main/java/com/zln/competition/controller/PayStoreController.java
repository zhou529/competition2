package com.zln.competition.controller;

import com.zln.competition.bean.*;
import com.zln.competition.service.PayStoreService;
import com.zln.competition.service.SignTableService;
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
public class PayStoreController {
    @Autowired
    PayStoreService payStoreService;
    @Autowired
    SignTableService signTableService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/selectByPrimaryKey",method = RequestMethod.POST)
    public PayStore selectByPrimaryKey(HttpServletRequest request,
                                           @RequestParam("productId") String productId
                                         ){
        System.out.println("PayStoreController的selectByPrimaryKey方法执行了");
        System.out.println("productId = " + productId);
        PayStore payStore = payStoreService.selectByPrimaryKey(Integer.valueOf(productId));
        HttpSession session = request.getSession();
        session.setAttribute("payStore",payStore);
        System.out.println("PayStoreController的selectByPrimaryKey方法的返回值payStore ： " + payStore);
        return payStore;
    }

    @RequestMapping(value = "/getPayStoreBySession",method = RequestMethod.POST)
    public PayStore getPayStoreBySession(HttpServletRequest request){
        System.out.println("PayStoreController的getPayStoreBySession方法执行了");
        HttpSession session = request.getSession();
        PayStore payStore = (PayStore)session.getAttribute("payStore");
        System.out.println("PayStoreController的getPayStoreBySession方法的返回值payStore ： " + payStore);
        return payStore;
    }



    @RequestMapping(value = "/updateByPrimaryKeySelective",method = RequestMethod.POST)
    public int updateByPrimaryKeySelective(HttpServletRequest request,
                                   @RequestParam("productName") String productName,
                                   @RequestParam("productPay") String productPay,
                                   @RequestParam("productImg") String productImg){
        System.out.println("PayStoreController的updateByPrimaryKeySelective方法执行了");
        HttpSession session = request.getSession();
        PayStore getPayStore = (PayStore)session.getAttribute("payStore");
        Integer productId = getPayStore.getProductId();
        System.out.println("productName = " + productName);
        System.out.println("productPay = " + productPay);
        System.out.println("productImg = " + productImg);
        PayStore payStore = new PayStore();
        payStore.setProductId(productId);
        payStore.setProductName(productName);
        payStore.setExchangedPay(Integer.valueOf(productPay));
        payStore.setProductImg(productImg);
        int is_update = payStoreService.updateByPrimaryKeySelective(payStore);
        System.out.println("PayStoreController的updateByPrimaryKeySelective方法的返回值is_update ： " + is_update);
        return is_update;
    }


    @RequestMapping(value = "/deleteByPrimaryKey",method = RequestMethod.POST)
    public int deleteByPrimaryKey(@RequestParam("productId") String productId){
        System.out.println("PayStoreController的deleteByPrimaryKey方法执行啦");
        System.out.println("前台传过来的productId ： " + productId);
        int i = payStoreService.deleteByPrimaryKey(Integer.valueOf(productId));
        System.out.println("PayStoreController的deleteByPrimaryKey方法的返回值i = " + i);
        return i;
    }

    @RequestMapping(value = "/insertPayStore",method = RequestMethod.POST)
    public int insertPayStore(@RequestParam("productName") String productName,
                              @RequestParam("productPay") String productPay,
                              @RequestParam("productImg") String productImg
    ) {
        System.out.println("PayStoreController的insertPayStore执行啦");
        System.out.println("productName = " + productName);
        System.out.println("productPay = " + productPay);
        System.out.println("productImg = " + productImg);
        PayStore payStore = new PayStore();
        payStore.setProductName(productName);
        payStore.setExchangedPay(Integer.valueOf(productPay));
        payStore.setProductImg(productImg);
        int is_insert = payStoreService.insertSelective(payStore);
        return  is_insert;
    }

    @RequestMapping(value = "/selectAllPayStore",method = RequestMethod.POST)
    public List<PayStore> selectAllPayStore() {
        System.out.println("PayStoreController的selectAllPayStore执行啦");
        List<PayStore> payStores = payStoreService.selectAllPayStore();
        System.out.println("payStores = " + payStores);
        return  payStores;
    }

    @RequestMapping(value = "/selectByPrimaryKey")
    public PayStore selectByPrimaryKey(@RequestParam("productId") String productId) {
        System.out.println("CommunityController的selectByPrimaryKey方法执行啦");
        PayStore payStore = payStoreService.selectByPrimaryKey(Integer.valueOf(productId));
        System.out.println("payStore = " + payStore);
        return payStore;
    }

    @RequestMapping(value = "/exchangedGift")
    public Integer exchangedGift(@RequestParam("productId") String productId,HttpServletRequest request) {
        System.out.println("CommunityController的exchangedGift方法执行啦");
        //        获取用户积分
        ServletContext servletContext = request.getServletContext();
        Users user = (Users) servletContext.getAttribute("user");
        String userOpenid = user.getUserOpenid();
        SignTable sign_table = signTableService.selectPayByOpenId(userOpenid);

        Integer userPay = sign_table.getUser_pay();
        System.out.println("user = " + user);


        PayStore payStore = payStoreService.selectByPrimaryKey(Integer.valueOf(productId));
        Integer exchangedPay = payStore.getExchangedPay();
        System.out.println("payStore = " + payStore);
        if(userPay >= exchangedPay){
            int i = payStoreService.updateExchangeNumber(Integer.valueOf(productId));
            if(i != 0){
                //更改积分 -- sign_table
                int is_update = signTableService.updateSignPay(userOpenid, exchangedPay);
                if(is_update != 0){
                    //先查询 当前积分
                    SignTable update_user = signTableService.selectPayByOpenId(userOpenid);
                    System.out.println("update_user = " + update_user);
                    Integer new_user_pay = update_user.getUser_pay();
                    Users user1 = new Users();
                    user1.setUserOpenid(userOpenid);
                    user1.setUserPay(new_user_pay);
                    System.out.println("要更改积分的user1 = " + user1);
                    int updateUser = userService.updateByOpenid(user1);
                    return  updateUser;
/*                //先查询 当前积分
                    SignTable update_user = signTableService.selectPayByOpenId(userOpenid);
                    System.out.println("update_user = " + update_user);
                    //兑换之后的剩余积分
                    Integer user_pay = update_user.getUser_pay();
                    Users users = new Users();
                    users.setUserPay(user_pay);
                    users.setUserOpenid(userOpenid);
                    //                    更改积分 -- user表
                    int is_update_user = userService.updateByOpenid(users);
                    System.out.println("update_user = " + update_user);
                    if(is_update_user != 0){
                        return 1;
                    }*/
                }
            }
        }
        return 0;
    }
}