package com.zln.competition.controller;


import com.zln.competition.bean.Fdback;
import com.zln.competition.bean.Users;
import com.zln.competition.service.FdbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@RestController
public class FdbackController {
    @Autowired
    FdbackService fdbackService;

    @RequestMapping(value = "/insertFdback")
    public int insertFdback(
            @RequestParam("fdbackInformation") String fdbackInformation,
            HttpServletRequest request){
        ServletContext servletContext = request.getServletContext();
        Users user = (Users) servletContext.getAttribute("user");
        Integer userId = user.getUserId();

        Fdback fdback = new Fdback();
        fdback.setUserId(userId);
        fdback.setFdbackInformation(fdbackInformation);
        int i = fdbackService.insertSelective(fdback);
        return i;
    }
}
