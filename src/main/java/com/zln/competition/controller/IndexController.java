package com.zln.competition.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页控制器
 * @author pan_junbiao
 **/
@Controller
public class IndexController
{
    @RequestMapping("/index")
    public String index()
    {
        return "index";
    }
}